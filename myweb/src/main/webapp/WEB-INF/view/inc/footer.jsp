<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<footer>
        <div class="tmp"></div>
        <div class="quote">
            <p class="eng">${quote.engContent }</p>
            <div class="hide_p"><p class="kor">${quote.korContent }</p>
                <p class="source">- ${quote.source } -</p></div>
                
        </div>
        <div class="toDo">
            <template>
                <li class="Todo_list">
                    <input type="checkbox">
                    <span>Add New Todo</span>    
                </li>
            </template>
            <!-- <span>Todo</span> -->
            <button onclick="fn_TodoAct()">Todo</button>
            <div class="Todo-arrow_menu">
                <div class="Todo-arrow_menu-row">
                    <span>Today</span>    
                </div>
                <div class="Todo-arrow_menu-row">
                    <ul class="Todo_lists">
                                                
                    </ul>
                </div>
                <div class="Todo-arrow_menu-row">
                    <form name="toDo_frm">
                        <input class="Todo_input" type="text" placeholder="New Todo">
                    </form>
                </div>
            </div>
        </div>
    </footer>