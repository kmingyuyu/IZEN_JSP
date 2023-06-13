package DAO;

import java.sql.*;
import java.util.*;
import DO.*;

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
	
//	회원 정보 가져오기
	public ArrayList<Member> getList() throws SQLException{
		Connection conn = open();
		
		ArrayList<Member> memberList = new ArrayList<>();
		
		String sql = 
				"select member_no , member_name , member_phone ,to_char(member_reg_date , 'yyyy-mm-dd') member_reg_date , to_char(member_end_date , 'yyyy-mm-dd') member_end_date from member";
		PreparedStatement pstmt = conn.prepareStatement(sql); //쿼리문 등록
		ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행
		
		try(conn; pstmt; rs;) {
			while(rs.next()) {
				Member member = new Member();
				member.setMember_no(rs.getInt("member_no"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_phone(rs.getString("member_phone"));
				member.setMember_reg_date(rs.getString("member_reg_date"));
				member.setMember_end_date(rs.getString("member_end_date"));
				
				memberList.add(member);
				
			}
		} 
				
		return memberList;
		
	}
	
//	회원 정보 조회
	public Member getView(int member_no) throws SQLException {
		Connection conn = open();
		Member m = new Member();
		String sql = "SELECT member_no , member_name , member_phone , member_reg_date  , member_end_date , member_gender ,"
				+ " member_address ,member_age , member_height , member_weight , member_img , member_exercise from MEMBER where member_no= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, member_no);
		ResultSet rs = pstmt.executeQuery();
		try(conn; pstmt; rs; ) {
			while(rs.next()) {
				m.setMember_no(rs.getInt("member_no"));
				m.setMember_name(rs.getString("member_name"));
				m.setMember_phone(rs.getString("member_phone"));
				m.setMember_reg_date(rs.getString("member_reg_date"));
				m.setMember_end_date(rs.getString("member_end_date"));
				m.setMember_gender(rs.getString("member_gender"));
				m.setMember_address(rs.getString("member_address"));
				m.setMember_age(rs.getInt("member_age"));
				m.setMember_height(rs.getInt("member_height"));
				m.setMember_weight(rs.getInt("member_weight"));
				m.setMember_img(rs.getString("member_img"));
				m.setMember_exercise(rs.getString("member_exercise"));
			}
		} catch (Exception e) {
		}
		
		return m;
	}
	
	
	
	
	
	
//	회원추가
	public void registration(Member m) throws Exception {
		Connection conn = open();
		String sql = " insert into member values (member_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt;) {
			
			
			pstmt.setString(1, m.getMember_name());
			pstmt.setString(2, m.getMember_phone());
			pstmt.setString(3, m.getMember_reg_date());
			pstmt.setString(4, m.getMember_end_date());
			pstmt.setString(5, m.getMember_gender());
			pstmt.setString(6, m.getMember_address());
			pstmt.setInt(7, m.getMember_age());
			pstmt.setInt(8, m.getMember_height());
			pstmt.setInt(9, m.getMember_weight());
			pstmt.setString(10, m.getMember_img());
			pstmt.setString(11, m.getMember_exercise());
			
			
			
			pstmt.executeUpdate();
			
		} 
	}
	
	public void memberEdit(int member_no) throws SQLException {
		Member m = new Member();
		Connection conn = open();
		String sql = "SELECT member_no , member_name , member_phone , member_reg_date  , member_end_date , member_gender ,"
				+ " member_address ,member_age , member_height , member_weight , member_img , member_exercise from MEMBER where member_no= ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		
		try(conn; pstmt;) {
			
		} catch (Exception e) {
		}
	}
	
	
}
