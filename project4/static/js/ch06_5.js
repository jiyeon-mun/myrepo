function f1() {
    var x = document.getElementById("var1").value;
    // 변수 x 값의 자료형 확인 : string 형
    // 즉, .value 를 통해 가져온 값은 string 형임을 알 수 있다.
    console.log(document.getElementById("res1").innerHTML = typeof(x));
    if (x % 2 == 0) {
        document.getElementById("res1").innerHTML = "짝수 입니다.";
    } else {
        document.getElementById("res1").innerHTML = "홀수 입니다.";
    }
}

function f2() {
    // .value 로 가져온 값은 string 형이므로 case 값을 문자열로 변화시키든
    // 가져온 x 값을 정수형으로 변화시키든 해야한다.(형 변환)
    var x = document.getElementById("var2").value; // x 는 string 자료형
    switch (Number(x)) { // switch 문 내에서만 형 변환
        case 1 : // 정수
            document.getElementById("res2").innerHTML = "1 입니다.";
            break;
        case 2 :
            document.getElementById("res2").innerHTML = "2 입니다.";
            break;
        default:
            document.getElementById("res2").innerHTML = "1 또는 2가 아닙니다.";
    }
}

function f3() {
    document.getElementById("res3").innerHTML = "";
    x = document.getElementById("var3").value;
    for(var i = 0; i < x; i++) {
        document.getElementById("res3").innerHTML += i;
    }
}

function f4() {
    document.getElementById("res4").innerHTML = "";
    x = document.getElementById("var4").value;
    var i = 0;
    while(i < x) {
        document.getElementById("res4").innerHTML += i;
        i++;
    }
}

function f5() {
    var obj = {a: 1, b: 2, c: 3, d: 4}
    for(var name in obj) {
                                                  // 속성명         속성값
        document.getElementById("res5").innerHTML += name + ": " + obj[name] + "<br>"
    }
}

function f6() {
    var obj = [1, 2, 3, 4]
    for(var v of obj) {
        document.getElementById("res6").innerHTML += v + "<br>"
    }
}