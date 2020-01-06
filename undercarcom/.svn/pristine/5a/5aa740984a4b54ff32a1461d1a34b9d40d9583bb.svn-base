package com.undercar.event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.undercar.event.dto.EventDTO;
import com.undercar.util.db.DBUtil;
import com.undercar.util.page.PageObject;

public class EventDAO {
	
	// 1. 이벤트 리스트
	public List<EventDTO> list(PageObject pageObject) throws Exception{
		
		System.out.println("EventDAO.list().pageObject: " + pageObject);
		
		List<EventDTO> list = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select no, title, repImage, "
				+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
				+ " to_char(endDate, 'yyyy-mm-dd') endDate "
				+ " from event order by no desc ";
		sql = " select rownum rnum,  no, title, repImage, startDate, endDate " + " from( " + sql + " ) ";
		sql = " select * " + " from( " + sql + " ) " + " where rnum between ? and ? ";
		System.out.println("EventDAO.list().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, pageObject.getStartRow());
		pstmt.setInt(2, pageObject.getEndRow());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				if(list == null)
					list = new ArrayList<EventDTO>();
				
				EventDTO dto = new EventDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setRepImage(rs.getString("repImage"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				
				list.add(dto);
			}
		}
		
		DBUtil.close(con, pstmt, rs);

		System.out.println("EventDAO.list().list: " + list);
		
		return list;		
		
	}
	
	// 2. 이벤트 상세보기
	public EventDTO view(int no) throws Exception{
		
		System.out.println("EventDAO.view().no: " + no);
		
		EventDTO dto = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select no, title, image, repImage, "
				+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
				+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
				+ " to_char(winnerDate, 'yyyy-mm-dd') winnerDate "
				+ " from event where no = ? ";
		System.out.println("EventDAO.view().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs != null) {
			while (rs.next()) {
					dto = new EventDTO();
					dto.setNo(rs.getInt("no"));
					dto.setTitle(rs.getString("title"));
					dto.setImage(rs.getString("image"));
					dto.setRepImage(rs.getString("repImage"));
					dto.setStartDate(rs.getString("startDate"));
					dto.setEndDate(rs.getString("endDate"));
					dto.setWinnerDate(rs.getString("winnerDate"));
				}
			}

		DBUtil.close(con, pstmt, rs);

		System.out.println("EventDAO.view().dto: " + dto);
		
		return dto;
	}
	
	// 3. 이벤트 글쓰기
	public Integer write(EventDTO dto) throws Exception{
		
		System.out.println("EventDAO.write().dto: " + dto);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " insert into event(no, title, image, repImage) "
				+ " values(event_seq.nextval, ?, ?, ?) ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getImage());
		pstmt.setString(3, dto.getRepImage());
		
		int result = pstmt.executeUpdate();
		
		System.out.println("이벤트 글쓰기 성공");
		
		DBUtil.close(con, pstmt);
		
		return result;
		
	}
	
	// 4. 이벤트 수정
	public Integer update(EventDTO dto) throws Exception{
		
		System.out.println("EventDAO.update().dto: " + dto);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " update event set title = ?, image = ?, repImage = ?, startDate = ?, endDate = ? where no = ? ";
		System.out.println("EventDAO.update().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getImage());
		pstmt.setString(3, dto.getRepImage());
		pstmt.setString(4, dto.getStartDate());
		pstmt.setString(5, dto.getEndDate());
		pstmt.setInt(6, dto.getNo());
		
		int result = pstmt.executeUpdate();
		
		System.out.println("이벤트 글수정 성공");
		
		DBUtil.close(con, pstmt);
		
		return result;
		
	}
	
	// 5. 이벤트 삭제
	public Integer delete(int no) throws Exception{
		
		System.out.println("EventDAO.delete().no: " + no);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " delete from event where no = ? ";
		System.out.println("EventDAO.delete().sql: " + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		int result = pstmt.executeUpdate();
		
		System.out.println("이벤트 글삭제 성공");
		
		DBUtil.close(con, pstmt);
		
		return result;
		
	}
	
	

}
