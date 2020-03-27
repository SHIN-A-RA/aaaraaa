package com.yedam.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.dev.Employee;

	public class BoardDAO {
	Connection conn = null;
	public BoardDAO(){
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn=DriverManager.getConnection(url,user,pass);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			} catch (ClassNotFoundException e) {
		
				e.printStackTrace();
		}
	
	}
	public List<Board> getBoardList(){
		String sql = "select * from board";
		List<Board>list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board bor = new Board();
				bor.setBoardNo(rs.getInt("board_no"));
				bor.setContent(rs.getString("content"));
				bor.setWriter(rs.getString("writer"));
				bor.setDate(rs.getString("create_date"));
				list.add(bor);
			}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void insertBoard(Board bor) {
		String sql = "insert into board "
					+"values( (select nvl(max(board_no),0)+1 from board)"
				+ ",? , ? , sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bor.getContent());
			pstmt.setString(2, bor.getWriter());
			
			pstmt.executeUpdate();
			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt+"건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Board getBoardInfo(int boardNo) {
		String sql ="select board_no, content, writer, create_date from board\r\n" + 
				"where board_no = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Board bor = new Board();
				bor.setBoardNo(rs.getInt("board_no"));
				bor.setContent(rs.getString("content"));
				bor.setWriter(rs.getString("writer"));
				bor.setDate(rs.getString("create_date"));
			
				return bor;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
