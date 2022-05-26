console.log("nav-script connected!");
const cofNav = document.querySelector("#cof-nav");
cofNav.onclick = function(e){
    if(e.target.nodeName != "SPAN") {
        return;
    }
    console.log("span 입니다.");
    let configList = e.target.nextElementSibling;
    if(configList.classList.contains("js-display")) {
        configList.classList.remove("js-display");
    } else {
        configList.classList.add("js-display");
    }
}