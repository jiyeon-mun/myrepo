document.write("<h1 id='title1'>웹 브라우저 화면에 출력</h1>"); // 웹 개발자 모드에서 보이지 않음
console.log("브라우저 콘솔에 출력");

function changeTitle() {
    document.getElementById('title1').innerHTML="태그의 요소를 선택 후 내용 삽입";
}

function activeInput() {
    // prompt 창에 입력한 값 콘솔창에 반환
    var userInput = window.prompt("사용자 입력 프롬프트 활성화");
    console.log(userInput);
    document.getElementsByTagName("title1").innerHTML = userInput
}

function changeValue() {
    // input 입력내용 h1 태그 내용 변경
    var userInput = document.getElementById("user_input").value;
    document.getElementById("title1").innerHTML = userInput;
}