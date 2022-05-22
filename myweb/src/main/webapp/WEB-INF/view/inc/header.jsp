<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<header>
        <div class="header_left">
            <form name="root_search-frm" class="header_left-search">
                <div class="header_left-column">Links</div>
                <div class="header_left-column">
                        <i class="fas fa-search"></i>
                        <input class="search_input invisible" type="text" >
                        <select class="select_search invisible">
                            <option value="G">G</option> 
                            <option value="N">N</option> 
                            <option value="Y">Y</option> 
                        </select>
                </div>
            </form>
        </div>          <!-- end header_left -->


        <div class="header_right">
            <div class="header_right-column add_icon invisible">
                <button><i class="fa-solid fa-plus"></i></button>
                <p>Add</p>
            </div>
            <div class="header_right-column">
                <div class="header_right-column-weather test">
                    <i class="fa-solid fa-cloud"></i>
                    <span>17˚</span>
                    <div>Jungnang-gu</div>
                </div>
            </div>
        </div>
    </header>