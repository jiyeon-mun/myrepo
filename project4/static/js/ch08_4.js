function formValid(f) {
    // 숫자인지 판별하는 정규 표현식
    var re = new RegExp("^[0-9]{4}$"); 
    var test2 = f.id_test2;
    var isValid = false;

    // 검사성공(true 반환)
    if(re.exec(test2.value)!=null) {
        // 작업할 내용 없음
        isValid = true;
    }
    // 검사실패(false 반환)
    if(!isValid) {
        test2.value = "";
        test2.setAttribute("placeholder", "4자리 숫자로 입력!");
    }
    return isValid;
}