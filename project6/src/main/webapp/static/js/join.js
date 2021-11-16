/*
 	'패스워드'와 '패스워드 확인'이 동일한지 체크한다. 
 */

window.onload = function() {			// 이벤트 등록     focus를 잃는 순간
	document.getElementById("id_pass2").addEventListener("blur", passwordCheck);
}

function passwordCheck() {
	var password = document.getElementById("id_pass1");
	if(this.value === password.value) {
		this.nextElementSibling.firstChild.innerText = "올바른 입력값 입니다."
	} else {
		this.nextElementSibling.firstChild.innerText = "패스워드를 다시 확인 하세요."
	}
}