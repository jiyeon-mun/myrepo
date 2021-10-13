x=10; // 전역 변수
console.log(x);
func1();
console.log(x);

function func1() {
    x=20; // 변수 x 를 전역 변수로 간주하여 값 할당
    console.log(x);
}

var y=30;
console.log(y);
func2();
console.log(y);

function func2() {
    var y = 40; // 지역 변수
    z=50
    console.log(y);
    console.log(z);
}

function f1() {
    document.getElementById("res1").innerHTML = typeof("문자열")
}