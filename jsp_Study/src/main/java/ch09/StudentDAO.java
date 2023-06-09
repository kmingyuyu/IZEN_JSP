package ch09;
// model : 데이터베이스와 직접적으로 대화 
// controller에게 데이터를 넘겨준다.

import java.sql.*;
import java.util.*;

public class StudentDAO {
	Connection conn = null; // Connection : 데이터베이스와 연결 담당
	PreparedStatement pstmt; // PreparedStatement : 쿼리문의 실행을 담당
	
	
	
	

	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	
//	                                           호스트이름:포트번호:SID
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	
	
//	db연결 메소드
	public void open() {
		try {
			Class.forName(JDBC_DRIVER); //드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234"); //db연결
//											   연결 url / 접속자 아이디 /접속자 비밀번호
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	db연결 닫는 메소드
	public void close() {
		try {
//			pstmt/conn은 리소스(데이터를 읽고쓰는 객체)이므로 
//			사용후 반드시 닫아주어야 한다.
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	학생 정보를 다 불러오는 메소드
	public ArrayList<Student> getAll() {
		open();  //db 오픈
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select * from student");
			
			
			
//			ResultSet = 데이터베이스 데이터를 받는 역활
			ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행 (select문 사용시)
			
			while(rs.next()) { //한행씩 값이 있는지 없는지 판단한다.
				Student s = new Student();
				
//				Student 객체에 db에서 얻어온 데이터를 담아준다.
				
//				                  컬럼명
				s.setId(rs.getInt("id"));  //number == int
				s.setUniv(rs.getString("univ")); //varchar2 == String
				s.setUsername(rs.getString("username"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
				
			}
			
			
 		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return students;
		
	}
	
	
	
//	학생 정보를 다 입력하는 메소드
	public void insert(Student s) {
		open();
		try {
			pstmt = conn.prepareStatement              //어떤 값이 올지모르므로 ? 로 처리 
					("insert into student values(id_seq.nextval,? ,? ,? ,?)");
//			              번호: ? 1번차례 2번차례 3번차례 4번차례 순서
			pstmt.setString(1, s.getUsername()); // pstmt.setString(값을 넣어줄 위치, 넣어줄 데이터)
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			
			pstmt.executeUpdate(); //executeUpdate :  insert , delete , update 실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	
	
}
