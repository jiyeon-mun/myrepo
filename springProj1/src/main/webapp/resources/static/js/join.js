//input 입력값이 없으면 빨간색 입력값 요구 오류 문구 출력
function joinCheck(f) {
	if(!f.username.value) {
		f.username.classList.add("is-invalid");
		f.username.nextElementSibling.classList.add("invalid-feedback");
		f.username.nextElementSibling.innerText = "필수 입력입니다.";
		f.username.addEventListener("blur", isExists);
	}
	
	if(!f.password.value) {
		f.password.classList.add("is-invalid");
		f.password.nextElementSibling.classList.add("invalid-feedback");
		f.password.nextElementSibling.innerText = "필수 입력입니다.";
		f.password.addEventListener("blur", isExists);
	}
	
	if(!f.passchk.value) {
		f.passchk.classList.add("is-invalid");
		f.passchk.nextElementSibling.classList.add("invalid-feedback");
		f.passchk.nextElementSibling.innerText = "필수 입력입니다.";
		f.passchk.addEventListener("blur", isExists);
	}

	if(!f.email1.value) {
		f.email1.classList.add("is-invalid");
		f.email1.nextElementSibling.classList.add("invalid-feedback");
		f.email1.nextElementSibling.innerText = "필수 입력입니다.";
		f.email1.addEventListener("blur", isExists);
	}
	
	if(!f.email2.value) {
		f.email2.classList.add("is-invalid");
		f.email2.nextElementSibling.classList.add("invalid-feedback");
		f.email2.nextElementSibling.innerText = "필수 입력입니다.";
		f.email2.addEventListener("blur", isExists);
	}
	
	if(!f.birthday.value) {
		f.birthday.classList.add("is-invalid");
		f.birthday.nextElementSibling.classList.add("invalid-feedback");
		f.birthday.nextElementSibling.innerText = "필수 선택입니다.";
		f.birthday.addEventListener("blur", isExists);
	}
}
//input 입력값 작성시 빨간 오류 문구 삭제
function isExists(e) {
	if(e.target.value) {
		e.target.classList.remove("is-invalid");
		e.target.nextElementSibling.classList.remove("invalid-feedback");
		e.target.nextElementSibling.innerText = "";
		e.target.removeEventListener("blur", isExists);
	}
}

var stTime, edTime; //입력 시간의 간격이 1초 이상일 때만 전달할 수 있도록

// 아이디 중복체크(AJAX)
function checkUsername(e) {
	if(!stTime) {
		stTime = new Date().getTime();
	} else {
		edTime = new Date().getTime();
	}
	
	if(stTime && edTime) {
		var t = edTime - stTime;
		stTime = edTime;
		edTime = undefined;
	}
	
	if(t < 1000 && !(e.KeyCode === 13)) {
		return;
	} else {
		$.ajax({
			url: "./join/duplexUsername",
			type: "get",
			dataType: "json",
			data: {
				username: e.target.value
			},
			success: function(data) {
				if(data.state === "success") {
					e.target.classList.remove("is-invalid");
					e.target.nextElementSibling.classList.remove("invalid-feedback");
					e.target.classList.add("is-valid");
					e.target.nextElementSibling.classList.add("valid-feedback");
					e.target.nextElementSibling.innerText = data.msg;
				} else if(data.state === "fail") {
					e.target.classList.remove("is-valid");
					e.target.nextElementSibling.classList.remove("valid-feedback");
					e.target.classList.add("is-invalid");
					e.target.nextElementSibling.classList.add("invalid-feedback");
					e.target.nextElementSibling.innerText = data.msg;
				}
			}
		});
	}
}

// 패스워드 유효성 체크
function isValidPass(v) {
	if(!stTime) {
		stTime = new Date().getTime();
	} else {
		edTime = new Date().getTime();
	}
	
	if(stTime && edTime) {
		var t = edTime - stTime;
		stTime = edTime;
		edTime = undefined;
	}
	
	if(t < 1000 && !(e.KeyCode === 13)) {
		return;
	} else {
		var RegExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{6,20}$/;
		var pwd = document.getElementById("id_password");
		
		if(!RegExp.test(pwd.value)) {
			v.target.classList.remove("is-valid");
			v.target.nextElementSibling.classList.remove("valid-feedback");
			v.target.classList.add("is-invalid");
			v.target.nextElementSibling.classList.add("invalid-feedback");
			v.target.nextElementSibling.innerText = "6~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.\n사용 가능한 특수문자: @ $ ! % * # ? &";
		} else {
			v.target.classList.remove("is-invalid");
			v.target.nextElementSibling.classList.remove("invalid-feedback");
			v.target.classList.add("is-valid");
			v.target.nextElementSibling.classList.add("valid-feedback");
			v.target.nextElementSibling.innerText = "유효한 비밀번호 입니다.";	
		}
		
	}
}

// 패스워드 동일 체크
function passConfirm(c) {
	var password = document.getElementById("id_password");
	var passchk = document.getElementById("id_passchk");
	
	if(password.value == passchk.value) {
		c.target.classList.remove("is-invalid");
		c.target.nextElementSibling.classList.remove("invalid-feedback");
		c.target.classList.add("is-valid");
		c.target.nextElementSibling.classList.add("valid-feedback");
		c.target.nextElementSibling.innerText = "패스워드가 일치합니다.";
	} else {
		c.target.classList.remove("is-valid");
		c.target.nextElementSibling.classList.remove("valid-feedback");
		c.target.classList.add("is-invalid");
		c.target.nextElementSibling.classList.add("invalid-feedback");
		c.target.nextElementSibling.innerText = "패스워드가 일치하지 않습니다.";
	}
}

function regEvent() {
	var username = document.getElementById("id_username");
	username.addEventListener("keyup", checkUsername); // 입력할 때마다, 엔터키 누를 때 전달
	username.addEventListener("blur", checkUsername); // 포거스 아웃할 때 전달
	
	var password = document.getElementById("id_password");
	password.addEventListener("keyup", isValidPass);
	password.addEventListener("blur", isValidPass); 
	
 	var passchk = document.getElementById("id_passchk");
	passchk.addEventListener("keyup", passConfirm);
	passchk.addEventListener("blur", passConfirm);
}