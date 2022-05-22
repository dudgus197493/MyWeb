const toDo = document.querySelector(".toDo"),
        toDoLists = toDo.querySelector(".Todo_lists"),
        toDoForm = toDo.querySelector("form[name='toDo_frm']"),
        toDoInput = toDo.querySelector(".Todo_input"),
        template = toDo.querySelector("template");

toDoForm.onsubmit = function(e){
    e.preventDefault();

    let cloneNode = document.importNode(template.content, true);
    span = cloneNode.querySelector("span");
    span.textContent = toDoInput.value;
    toDoLists.append(cloneNode);
    toDoInput.value = "";
}

