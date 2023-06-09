package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import DO.Member;

public class HealthDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public Connection open () {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"test", "test1234");
			System.out.println(" open 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" open 실패");
		}
		
		return conn;
	}
	
	public ArrayList<Member> getList() throws SQLException{
		Connection conn = open();
		
		ArrayList<Member> memberList = new ArrayList<>();
		
		String sql = "select member_no , member_name , member_gender , member_age , member_img from member";
		PreparedStatement pstmt = conn.prepareStatement(sql); //쿼리문 등록
		ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행
		
		try(conn; pstmt; rs; ) {
			while(rs.next()) {
				Member member = new Member();
				
				member.setMember_no(rs.getInt("member_no"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_age(rs.getInt("member_age"));
				member.setMember_img(rs.getString("member_img"));
				
				memberList.add(member);
				
			}
		} 
				
		return memberList;
		
	}
	
	
	
}
