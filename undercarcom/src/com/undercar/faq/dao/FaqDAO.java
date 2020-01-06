package com.undercar.faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.undercar.faq.dto.FaqDTO;
import com.undercar.util.db.DBUtil;
import com.undercar.util.page.PageObject;
import com.undercar.util.page.SearchCondition;

public class FaqDAO {

	public List<FaqDTO>list(PageObject pageObject) throws Exception{
		
		List<FaqDTO> list =null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select no, title  "
				+ " from faq ";
				
				sql += SearchCondition.getSearchSQLWithWhere(pageObject);
				sql += " order by no desc";		
				
				sql ="select rownum rnum, no, title"
						+" from( " +sql +") ";
				sql="select * "
						+" from( " +sql +")"
						+" where rnum between ? and ?";
		
		System.out.println("FaqDAO.list().sql" + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
		pstmt.setInt(idx++, pageObject.getStartRow());
		pstmt.setInt(idx++, pageObject.getEndRow());
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				if(list == null)
					list = new ArrayList<FaqDTO>();
				
				FaqDTO dto = new FaqDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				
				list.add(dto);
			}
		}//if end
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("faq리스트 "+list);
		
		
		return list;
		
		
	}//리스트 끝
	
public int getTotalRow(PageObject pageObject) throws Exception{
		
		System.out.println("faqDAO.getTotalRow");
		
		int totalRow = 0;
		
		Connection con = DBUtil.getConnection();
		String sql = "select count(*) cnt from faq";
		sql += SearchCondition.getSearchSQLWithWhere(pageObject);

		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println("faqDAO.getTotal().sql"+sql);
		int idx = 1;
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs != null && rs.next()) {
			totalRow = rs.getInt("cnt");
		} // end of if(rs != null && rs.next())
		
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("faqDAO.getTotalRow(0.totalRow"+totalRow);
		
		return totalRow;
	} // end of view()
	
	public FaqDTO view (int no) throws Exception{
		
		System.out.println("faq"+no);
		FaqDTO dto = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select q.no, q.title, q.content,m.name "
				+ " from faq q, member m where q.no = ?";//일반조건
	
	System.out.println("FaqDAO view sql "+sql);
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	pstmt.setInt(1, no);
	
	ResultSet rs = pstmt.executeQuery();
	
	if(rs != null && rs.next()) {
		dto = new FaqDTO();
		
		dto.setNo(rs.getInt("no"));
		dto.setTitle(rs.getString("title"));
		dto.setContent(rs.getString("content"));
	}
	DBUtil.close(con, pstmt, rs);
	
	System.out.println("faqDAOlist dto" +dto);
	
	return dto;
	
	}//뷰끝
	
  public int write(FaqDTO dto) throws Exception{
	  
	  System.out.println("faqDAO.write.dto"+dto);
	  
	  Connection con = DBUtil.getConnection();
	  
	  String sql = " insert into faq(no, title, content) "
				+ " values(faq_seq.nextval, ?, ?) ";
		System.out.println("FaqDAO.write().sql:"+sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		
		int result = pstmt.executeUpdate();
		
		System.out.println("질문하기 성공");
		
		DBUtil.close(con, pstmt);
		return result;
	  
  }//글쓰기 끝
  
  
  
  
  public int update(FaqDTO dto) throws Exception{
		
		System.out.println("FaqDAO.update().dto:" + dto);
		Connection  con = DBUtil.getConnection();
		String sql = " update faq set title = ?, content = ? "					
				+ " where no = ? ";
		System.out.println("FaqDAO.update().sql:"+sql);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setInt(3, dto.getNo());
		int result = pstmt.executeUpdate();
		if(result > 0 )
		System.out.println("글수정 성공");
		else System.out.println("글수정이 되지 않았습니다. -글번호를 확인하세요");
		DBUtil.close(con, pstmt);
		return result;
	} // end of update()	
public Object delete(int no) throws Exception{
	
	System.out.println("FaqDAO.delete().dto:" + no);
	
Connection con = DBUtil.getConnection();
	String sql = " delete from faq  "
			  + " where no = ? ";
	System.out.println("FaqDAO.delete().sql:"+sql);
	PreparedStatement pstmt = con.prepareStatement(sql);

	pstmt.setInt(1, no);
	int result = pstmt.executeUpdate();
	if(result > 0 )
	System.out.println("글삭제 성공");
	else
		System.out.println("글삭제가 되지 않았습니다. -글번호를 확인해주세요");
	DBUtil.close(con, pstmt);
	
	return result;
} // end of delete()
}// dao끝