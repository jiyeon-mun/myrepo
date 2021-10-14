function f1() {
    var n = document.getElementById("v1").value;
    var arr1 = new arr1ay();

    if (n < 1 || n > 19) {
        document.getElementById("alert1").className = "error";
        return; // 값 반환 후 함수 종료
    } else {
        document.getElementById("alert1").className = "hidden";
    }

    // 결과값 배열에 저장
    for(var i = 1; i <= 19; i++) {
        arr1[i - 1] = n * i;
    }
    
    var col = 0; // 테이블 열. 0부터 시작
    document.getElementById("res1").innerHTML = "";

    var s = "";
    s += "<table border='1'><tr>"; // 테이블 행
    for(var i = 0; i < 19; i++) {
        // 테이블 한 칸에 저장되는 내용
        s += "<td>" + n + " x " + (i + 1) + " = " + arr1[i] + "</td>";
        // 하나의 행에 대해서 5열 마다 개행
        if(col % 5 == 4) {
            s += "</tr><tr>";
        }
        col++;
    }
    s += "</table>";
    document.getElementById("res1").innerHTML = s;
}

function f2() {
    var arr2 = new Array(6);

    for(var i=0; i<arr2.length; i++) {
        var r1 = Math.floor(Math.random()*45)+1;
        // 배열 내 r1 랜덤값이 없으면 indexOf 의 반환값으로 -1 을 리턴한다.
        if (arr2.indexOf(r1) == -1) {
            arr2[i] = r1;
        } else { // 생성한 랜덤값이 배열 내 존재하는 중복값의 경우
            i--; // 랜덤 생성 다시
        }
    }
    document.getElementById("res2").innerHTML = arr2.join(' ');

    // 정렬 적용
    /* arr2.sort(); 사용 시 문자열 정렬로 인한 오류로
     정수 정렬을 위한 정렬함수를 따로 만들어 사용한다.
     x,y 는 arr2 배열에 저장된 값에 대한 인덱스를 의미 */
    arr2.sort(function(x, y) { // sort() 괄호 안에 한 번에 정리 및 정의
        return x - y; // 오름차순
        // return y - x; // 내림차순
    });

    var s = "";
    var lotcolor = ["num1to10", "num11to20", "num21to30", "num31to40", "num41to45"]; // 클래스 객체 배열
    for(var n of arr2) {
        /* javascript 에서 / 연산자는 소수점을 포함한 몫의 결과값을 반환한다.
        정수 몫의 값을 구하기 위해서는 parseInt() 또는 Math.floor() 함수를 이용해라 */

        // 클래스를 저장한 객체 배열을 이용한 풀이로 lotcolor[index] 는 클래스명.
        // span 의 class 명을 .lot, .num1to10, ... 으로 css 에서 호출한다.
        s += "<span class = 'lot " + lotcolor[Math.floor((n - 1) / 10)] + "'>"
            + n + "</span>";

        // switch 문 이용 풀이
        /* switch(Math.floor((n-1)/10)) {
            case 0:
                s += "<span class='num1to10'>" + n + "</span>";
                break;
            case 1:
                s += "<span class='num11to20'>" + n + "</span>";
                break;
            case 2:
                s += "<span class='num21to30'>" + n + "</span>";
                break;
            case 3:
                s += "<span class='num31to40'>" + n + "</span>";
                break;
            case 4:
                s += "<span class='num41to45'>" + n + "</span>";
                break;
        } */
    }
    document.getElementById("res2").innerHTML = s;
}