package test;

import java.sql.*;
import java.util.*;

public class CustomerDAO {

	Connection conn = null;
	PreparedStatement prst ;
	
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	public void open () {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"test", "test1234");
			System.out.println(" open 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" open 실패");
		}
	}
	
	public void close() {
		try {
			conn.close();
			prst.close();
			System.out.println(" close 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" close 실패");
		}
	};
 	
	
	public ArrayList<Customer> getAll(){
		open ();
		ArrayList<Customer> customer = new ArrayList<>();
		
		try {
			prst = conn.prepareStatement("select * from regist");
			
			ResultSet result = prst.executeQuery();
			
			
			while (result.next()) {
				Customer re = new Customer();
				
				re.setId(result.getString("id"));
				re.setName(result.getString("name"));
				re.setAddress(result.getString("address"));
				re.setGrade(result.getString("grade"));
				re.setPhone(result.getString("phone"));
				
				customer.add(re);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return customer;
	};
	
	public void insert(Customer r) {
		open();
		try {
			prst = conn.prepareStatement("insert into regist values(id_seq.nextval ,? ,? , ?, ? ) ");
			prst.setString(1, r.getName() );
			prst.setString(2, r.getAddress() );
			prst.setString(3, r.getGrade() );
			prst.setString(4, r.getPhone() );
			
			prst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
}
