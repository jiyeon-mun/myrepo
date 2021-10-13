function getId() {
    console.log(document.getElementById("username"));
    // 중복되는 아이디명 사용하는 경우 첫번째 요소만 찾는다.
    console.log(document.getElementById("password"));
}

function getName() {
    // 배열로 저장됨.
    console.log(document.getElementsByName("username")[0]);
    // 중복되는 네임 속성을 구분하기 위해 인덱스 이용하여 접근해라.
    console.log(document.getElementsByName("password"));
    console.log(document.getElementsByName("password")[0]);
    console.log(document.getElementsByName("password")[1]);
}

function getTagName() {
    // 모든 태그 요소들에 대한 정보를 가져오기 때문에 인덱스를 이용하여 원하는 요소 정보만을 가져온다.
    console.log(document.getElementsByTagName("input"));
    console.log(document.getElementsByTagName("input")[6]);
    console.log(document.getElementsByTagName("input")[7]);
    console.log(document.getElementsByTagName("input")[8]);
}

function getClass() {
    console.log(document.getElementsByClassName("input-form"));
    console.log(document.getElementsByClassName("input-form")[0]);
    console.log(document.getElementsByClassName("input-form")[1]);
    console.log(document.getElementsByClassName("input-form")[2]);
}

function getSelector() {
    // 중복의 CSS 선택자들 중 처음 요소에 대해서만 찾는다.

    // 태그명
    console.log(document.querySelector("input"));
    console.log(document.querySelector("input").value);
    // id
    console.log(document.querySelector("#password"));
    console.log(document.querySelector("#password").value);
    // 클래스명
    console.log(document.querySelector(".input-form"));
    console.log(document.querySelector(".input-form").value);
}

function getSelectorAll() {
    console.log(document.querySelectorAll("input"));
    console.log(document.querySelectorAll("#password"));
    console.log(document.querySelectorAll(".input-form"));
}