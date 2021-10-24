// // window.onload
// // javascript 가 문서가 준비된 상황 이후에 발동하도록만 한다면 문서 앞에 선언해도 상관 없도록
// window.onload = function() {
//     initial();
// }

$(document).ready(function(){
    initial()
});

// jquery 로 변경
function initial() {
    var accordion = $(".accordion").eq(0);
    var accordion_items = accordion.find(".accordion-item");

    // for each...
    accordion_items.each(
        function(idx,item){
            // console.log(item); // DOM 객체; find() 사용불가
            // console.log($(item)); // Jquery 객체; find() 사용가능
            var title = $(item).find(".accordion-title");
            title.on("click",
                function(e){
                    var src = $(e.target); // accordion-title
                    var isOpend = src.is(".active"); // accordion-title 에서 active 클래스 존재 시 true
                    //     accordion-list
                    src.parent().parent().find(".accordion-title").removeClass("active"); // active 비활성화
                    src.parent().parent().find(".accordion-content").removeClass("open"); // open 비활성화

                    if(isOpend) { // true
                        src.removeClass("active");
                        src.next().removeClass("open"); // src.next() => accordion-content
                    } else { // false
                        src.addClass("active");
                        src.next().addClass("open");
                    }
                }
            );
        }
    );
}

// 기존 javascript 코드
// function initial() {
//     var accordion = document.getElementsByClassName("accordion")[0]; // div class="accordion"
//     var accordion_items = accordion.querySelectorAll(".accordion-item"); // [li.accordion-item, li.accordion-item, li.accordion-item]
//     for(var item of accordion_items) {
//         var title = item.querySelector(".accordion-title");
//         // addEventListener(): document 특정요소(id,class,tag 등)의 event를 등록할 때 사용
//         title.addEventListener("click",
//             function(e) {
//                 var src = e.target; // div class = "accordion-title"
//                 var isOpend = src.getAttribute("class").indexOf("active") == -1 ? false : true;
//                 for(var other of accordion_items) {
//                     other.querySelector(".accordion-title").classList.remove("active");
//                     other.querySelector(".accordion-content").classList.remove("open");
//                 }

//                 if(isOpend) {
//                     src.classList.remove("active");
//                     src.nextElementSibling.classList.remove("open");
//                 } else {
//                     src.classList.add("active");
//                     src.nextElementSibling.classList.add("open");
//                 }
//             }
//         );
//     }
// }