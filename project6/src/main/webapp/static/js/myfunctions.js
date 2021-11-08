/**
 * 
 */
window.onload = function() {
	var monthElement = document.getElementsByName("month"); // name이 month인 객체를 모두 배열로 가져온다.
	for(var element of monthElement) { // 배열로 가져오므로 요소 하나씩 접근하기 위해 for문 사용
		for(var i=1; i<=12; i++) {
			var option = document.createElement("option"); // html에 option 요소 생성 (select 내)
			option.value = i;
			option.innerText = i + "월";
			element.append(option);
		}
	}
}