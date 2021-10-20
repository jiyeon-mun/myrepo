function hiddenPass(element) {
    var c = element.checked;
    if(c == true) {
        document.getElementById("id_pass").type = "text";
    } else {
        document.getElementById("id_pass").type = "password";
    }
}

function requiredItem(element) {
    var v = element.value;
    if(v == "") {
        element.setAttribute("class",
            element.getAttribute("class") + " error"
        );
        var lbl = document.createElement("label");
        lbl.innerText = "필수 입력입니다.";
        lbl.setAttribute("class", "error-msg");
        lbl.id = "lbl-1";
        element.after(lbl);
    } else {
        element.setAttribute("class", "text-input");
        document.getElementById("lbl-1").remove();
    }
}