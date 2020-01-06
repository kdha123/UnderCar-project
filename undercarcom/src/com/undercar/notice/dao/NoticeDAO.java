package com.undercar.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.undercar.notice.dto.NoticeDTO;
import com.undercar.util.db.DBUtil;
import com.undercar.util.page.PageObject;
import com.undercar.util.page.SearchCondition;

public class NoticeDAO {
	
	// 1. 공지사항 리스트
	public List<NoticeDTO> list(PageObject pageObject) throws Exception{
		
		System.out.println("NoticeDAO.list().pageObject: " + pageObject);
		
		List<NoticeDTO> list = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select no, title, startDate, endDate from notice ";
//		sql += " where startDate < SYSDATE and endDate > SYSDATE ";			
		sql += SearchCondition.getSearchSQLWithWhere(pageObject);
		sql += " order by no desc ";		
		sql = " select rownum rnum,  no, title, to_char(startDate, 'yyyy-mm-dd') startDate, to_char(endDate, 'yyyy-mm-dd') endDate " + " from( " + sql + " ) ";
		sql = " select * " + " from( " + sql + " ) " + " where rnum between ? and ? ";
		System.out.println("NoticeDAO.list().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
		pstmt.setInt(idx++, pageObject.getStartRow());
		pstmt.setInt(idx++, pageObject.getEndRow());
		
		ResultSet rs = pstmt.executeQuery();

		if (rs != null) {
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<NoticeDTO>();
				
					NoticeDTO dto = new NoticeDTO();
					dto.setNo(rs.getInt("no"));
					dto.setTitle(rs.getString("title"));
					dto.setStartDate(rs.getString("startDate"));
					dto.setEndDate(rs.getString("endDate"));

					list.add(dto);
				}
			}

		DBUtil.close(con, pstmt, rs);

		System.out.println("NoticeDAO.list().list: " + list);
		
		return list;
	}
	
	public Integer getTotalRow(PageObject pageObject) throws Exception {

		System.out.println("NoticeDAO.getTotalRow(): ");

		int totalRow = 0;

		Connection con = DBUtil.getConnection();

		String sql = " select count(*) cnt from notice ";
		sql += SearchCondition.getSearchSQLWithWhere(pageObject);
		System.out.println("NoticeDAO.getTotalRow().sql: " + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);

		ResultSet rs = pstmt.executeQuery();

		if (rs != null && rs.next()) {
			totalRow = rs.getInt("cnt");
		}
		
		DBUtil.close(con, pstmt, rs);

		System.out.println("NoticeDAO.getTotalRow().totalRow: " + totalRow);

		return totalRow;
	}
	
	//2. 공지사항 상세보기
	public NoticeDTO view(int no) throws Exception{
		
		System.out.println("NoticeDAO.view().no: " + no);
		
		NoticeDTO dto = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select no, title, content, " 
				+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
				+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
				+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, fileName " 
				+ " from notice where no = ? ";
		System.out.println("NoticeDAO.view().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();

		if (rs != null) {
			while (rs.next()) {
					dto = new NoticeDTO();
					dto.setNo(rs.getInt("no"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setStartDate(rs.getString("startDate"));
					dto.setEndDate(rs.getString("endDate"));
					dto.setWriteDate(rs.getString("writeDate"));
					dto.setFileName(rs.getString("fileName"));
				}
			}

		DBUtil.close(con, pstmt, rs);

		System.out.println("NoticeDAO.view().dto: " + dto);
		
		return dto;
	}
	
	// 3. 공지사항 글쓰기
	public Integer write(NoticeDTO dto) throws Exception{
		
		System.out.println("NoticeDAO.write().dto: " + dto);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " insert into notice(no, title, content, fileName) " 
				+ " values(notice_seq.nextval, ?, ?, ?) ";		
		System.out.println("NoticeDAO.write().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getFileName());
		
		int result = pstmt.executeUpdate(); 
		
		System.out.println("공지사항 글쓰기 성공");
		
		DBUtil.close(con, pstmt);
		
		return result;
	}
	
	// 4. 공지사항 수정
	public Integer update(NoticeDTO dto) throws Exception{
		
		System.out.println("NoticeDAO.update().dto: " + dto);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " update notice set title = ?, content = ?, startDate = ?, endDate = ?, fileName = ? where no = ? ";
		System.out.println("NoticeDAO.update().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getStartDate());
		pstmt.setString(4, dto.getEndDate());
		pstmt.setString(5, dto.getFileName());
		pstmt.setInt(6, dto.getNo());
		
		int result = pstmt.executeUpdate();
	
		System.out.println("공지사항 글수정 성공");
		
		DBUtil.close(con, pstmt);	
		
		return result;
	}
	
	// 5. 공지사항 삭제
	public Integer delete(int no) throws Exception{
		
		System.out.println("NoticeDAO.delete().no: " + no);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " delete from notice where no = ? ";
		System.out.println("NoticeDAO.delete().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		int result = pstmt.executeUpdate();
	
		System.out.println("공지사항 글삭제 성공");
		
		DBUtil.close(con, pstmt);
		
		return result;
		
	}
	
}

