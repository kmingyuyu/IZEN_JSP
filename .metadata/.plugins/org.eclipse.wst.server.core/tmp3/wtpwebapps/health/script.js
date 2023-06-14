function chkForm() {
	var f = document.frm; //form 태그
	
	
	if(f.member_name.value == ''){ //name이 title인 input타입의 값을 가져온다.
		alert("이름을 입력해주세요.");
		return false;
	}
	if(f.member_phone.value == ''){ 
		alert("핸드폰번호를 입력해주세요.");
		return false;
	}
	if(f.member_reg_date.value == ''){ 
		alert("등록 일을 입력해주세요.");
		return false;
	}
	if(f.member_end_date.value == ''){ 
		alert("종료 일을 입력해주세요.");
		return false;
	}
	if(f.member_gender.value == ''){ 
		alert("성별을 입력해주세요.");
		return false;
	}
	if(f.member_age.value == ''){ 
		alert("나이를 입력해주세요.");
		return false;
	}
	if(f.member_height.value == ''){ 
		alert("키를 입력해주세요.");
		return false;
	}
	if(f.member_weight.value == ''){ 
		alert("몸무게를 입력해주세요.");
		return false;
	}
	if(f.member_address.value == ''){ 
		alert("주소를 입력해주세요.");
		return false;
	}

	
	f.submit();
	
}


function chkDelete(member_no){
	const result = confirm("삭제 하시겠습니까?");
	
	
	if(result){
		const url = location.origin;
		location.href = url + "/health/delete?member_no=" + member_no;
	}else{
		false;
	}
}