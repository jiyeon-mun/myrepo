function addMenu(title) {
    var aTag = document.createElement("a");
    aTag.innerText = title;
    aTag.href = "#";

    var liTag = document.createElement("li");
    liTag.className = "menu-item";
    liTag.appendChild(aTag);

    document.getElementsByClassName("side-menu")[0].appendChild(liTag);

    document.getElementById("id_add_menu").value = "";
    document.getElementById("id_add_menu").focus();
}