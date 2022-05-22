<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <main>
        <div class="main_row">
            <div class="main_row-side am-pm">Have to add AM/PM</div>
            <div class="main_row-clock"><p>00:00</p></div>
            <div class="main_row-side relative_wrapper">
                <button class="clock_button"><i class="fa-solid fa-ellipsis"></i></button>
                <ul class="clock-arrow_menu">
                    <li class="clock_switch-wrapper">
                        <input type="checkbox" id="clock_switch">
                        <label for="clock_switch" class="clock_switch-label">
                            <span class="onf_label">24-hour clock</span>
                            <span class="onf_btn-wrapper">
                                <span class="onf_btn"></span>
                            </span>
                        </label>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main_row">
            <span class="main_row-hello">Good morning!, Tonic.</span>
        </div>
        <div class="main_row">
            <form class="main_row-form" action="">
                <label for="command_input"></label>
                    Enter the command you want!
                <input id="command_input" type="text" placeholder="Enter the command...">
            </form>
        </div>
    </main>