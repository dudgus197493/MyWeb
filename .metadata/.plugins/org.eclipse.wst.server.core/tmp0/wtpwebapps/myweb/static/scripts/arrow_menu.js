function fn_TodoAct() {
    const arrow_menu = document.querySelector(".Todo-arrow_menu");
    let classes = arrow_menu.classList;
    if(classes.contains("js-act")) {
        classes.remove("js-act");
    } else {
        classes.add("js-act");
    }
    console.log("process completed!");
}

