package ch07;

import java.util.regex.Pattern;

public class Member {
	private String email;
	private String phone;
	
	//이메일 정규식
	public static final String pattern1 = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		  
	//전화번호 정규식
	public static final String pattern2 = "(02|010)-\\d{3,4}-\\d{4}";

//	이메일 유효성 검사
	public boolean checkEmail(String email) {
		if(Pattern.matches(pattern1, email)) {
			return true;
		}else {
			return false;
		}
		
	}
	
//	핸드폰번호 유효성 검사
	public boolean checkPhone(String phone) {
		if(Pattern.matches(pattern2, phone)) {;
			return true;
		}else {
			return false;
		}
	}
	
	public String result() {
		if(checkEmail(email) && checkPhone(phone)) {
			return "환영합니다 ! ";
		}
		
		return "유효성 검사에 통과하지 못했습니다." ;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
