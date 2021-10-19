function calc1(x, y) {
    var target = document.getElementById("ops").value;
    if(target == "+") {
        result=x+y;
    } else if(target == "-") {
        result = x-y;
    } else if(target == "*") {
        result = x*y;
    } else if(target == "/") {
        if(y==0){
            // document.getElementById("res1").style =
            //     "backgroung-color: red; color: white;"
            document.getElementById("res1").className = "error";
            return "연산 불가";
        } else {
            result = x/y;
        }
    } else if(target == "%") {
        if(y==0){
            document.getElementById("res1").className = "error";
            return "연산 불가";
        } else {
            result = x%y;
        }
    }
    return result;
}


// input 화면에 클릭한 숫자 및 연산부호 나열
function add(ch) {
    // res2 id 요소 값을 불러와 display.value 에 중첩하여 저장
    display = document.getElementById("res2");
    display.value += ch;
}

// 계산 수행
function calc2() {
    /* eval() 함수
      javascript에 내장된 함수로,
      식을 입력 받으면 그 식을 계산해서 결과를 알려준다.
      (식이 아닌 문자열이 들어오면 오류가 발생한다.) */
    var result = eval(display.value);
    display.value = result;
}

// 입력 내용 초기화
function reset() {
    display.value = "";
}

// 입력한 값 뒤에서부터 하나씩 지우기
function back() {
    var len = display.value.length;
    if(len == 0) {
        return;
    } else {
        display.value = display.value.substr(0,len-1);
    }
}