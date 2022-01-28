function loginCheck(f) {
	var res1, res2;
	res1 = existsVal(f.username, "아이디를 입력하세요.");
	res2 = existsVal(f.password, "비밀번호를 입력하세요.");
	
	if(res1 && res2) {
		f.submit();
	}
}

function invalid(element, msg) {
	element.classList.add("is-invalid");
	element.nextElementSibling.classList.add("invalid-feedback");
	element.nextElementSibling.innerText = msg;
	return false;
}

function valid(element, msg) {
	element.classList.remove("is-invalid");
	element.nextElementSibling.classList.remove("invalid-feedback");
	element.nextElementSibling.innerText = msg;
	return true;
}

function existsVal(element, msg) {
	var result = false;
	if(!(element instanceof HTMLElement)) {
		element = element.target;
	}
	if(element.value) {
		result = valid(element, "");
		element.removeEventListener("blur", existsVal);
	} else {
		result = invalid(element, msg);
		element.addEventListener("blur", existsVal);
	}
	return result;
}

