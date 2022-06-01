<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="${request.getContext() }/css/admin/config/root/list.css">
		<main>
            <form class="quote-search">
                <input id="quote-search_input" type="text" placeholder="검색">
                <select id="search-options">
                    <option value="1">키워드</option>
                    <option value="2">카테고리</option>
                    <option value="3">출처인</option>
                </select>
            </form>
            <div id="quote-sort">
                <span id="quote-count">3개</span>
                <select id="sort-options">
                    <option value="1" selected>정렬기준</option>
                    <option value="2">오름차순[ENG]</option>
                    <option value="3">내림차순[ENG]</option>
                    <option value="4">오름차순[KOR]</option>
                    <option value="5">내림차순[KOR]</option>
                </select>
            </div>
                <ul id="quote-list">
                	<template>
                		<li class="quote">
	                        <span class="quote-number">1.</span>
	                        <div class="quote-content">
	                            <span class="content-eng">
	                            	<i class="fa-solid fa-quote-left"></i>
									<span class="content"></span>
	                            </span>
	                            <span class="content-kor">
	                            	<span class="content"></span>	
	                                <i class="fa-solid fa-quote-right"></i>
	                            </span>
	                            <span class="source"><!-- source --></span>
	                        </div>
	                        <span class="quote-del">x</span>
                    	</li>	
					</template>
                	<c:forEach var="quote" items="${quoteList }">
                	</c:forEach>
                    <!-- <li class="quote">
                        <span class="quote-number">1.</span>
                        <div class="quote-content">
                            <span class="content-eng"><i class="fa-solid fa-quote-left"></i>
                                There is an immeasurable distance between late and too late.</span>
                            <span class="content-kor">늦은 것과 매우 늦은 것 사이에는 측정할 수 없을 만큼의 거리가 놓여 있다.
                                <i class="fa-solid fa-quote-right"></i></span>
                            <span class="source">Og Mandino</span>
                        </div>
                        <span class="quote-del">x</span>
                    </li> -->
                    <!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->
                </ul>  
        </main>
        <script src="/scripts/config/root/quotelist-data.js"></script>