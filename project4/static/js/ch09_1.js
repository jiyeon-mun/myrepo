// window.onload
// javascript 가 문서가 준비된 상황 이후에 발동하도록만 한다면 문서 앞에 선언해도 상관 없도록
window.onload = function() {
    initial();
}

function initial() {
    var accordion = document.getElementsByClassName("accordion")[0]; // div class="accordion"
    var accordion_items = accordion.querySelectorAll(".accordion-item"); // [li.accordion-item, li.accordion-item, li.accordion-item]
    for(var item of accordion_items) {
        var title = item.querySelector(".accordion-title");
        // addEventListener(): document 특정요소(id,class,tag 등)의 event를 등록할 때 사용
        title.addEventListener("click",
            function(e) {
                var src = e.target;
                var isOpend = src.getAttribute("class").indexOf("active") == -1 ? false : true;
                for(var other of accordion_items) {
                    other.querySelector(".accordion-title").classList.remove("active");
                    other.querySelector(".accordion-content").classList.remove("open");
                }

                if(isOpend) {
                    src.classList.remove("active");
                    src.nextElementSibling.classList.remove("open");
                } else {
                    src.classList.add("active");
                    src.nextElementSibling.classList.add("open");
                }
            }
        );
    }
} 