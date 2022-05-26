<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<nav id="cof-nav">
		<c:forEach var="parentMenu" items="${navList}">								<!-- 메뉴 생성 -->
			<div class="list-label">
				<span>${parentMenu.name }</span>
				<ul class="config-list">
					<c:forEach var="menuList" items="${parentMenu.menuList }">
						<li><a href="/admin/config/${menuList.property }">${menuList.name }</a></li>	
					</c:forEach>
				</ul>
			</div>
		</c:forEach>																<!-- 메뉴 생성 -->
            <div class="list-label">
                <!-- <span>명언</span>
                <ul class="config-list">
                    <li><a href="https://www.naver.com/">명언 목록  </a></li>
                    <li>명언 추가</li>
                    <li>명언 삭제</li>
                </ul> -->
            </div>
            <div class="list-label">
                <span>배경 이미지</span>
                <ul class="config-list">
                    <li>명언 목록2</li>
                    <li>명언 추가2</li>
                    <li>명언 삭제2</li>
                </ul>
            </div>
        </nav>
