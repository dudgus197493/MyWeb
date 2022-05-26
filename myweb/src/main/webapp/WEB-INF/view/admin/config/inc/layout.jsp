<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>설정 페이지 - 루트</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="${request.getContext() }/css/reset.css">
    <link rel="stylesheet" href="${request.getContext() }/css/admin/header.css">						<!-- 관리자페이지 공통 header -->
    <link rel="stylesheet" href="${request.getContext() }/css/admin/config/config-nav.css">				<!-- 관리자페이지 공통 nav -->
    <link rel="stylesheet" href="${request.getContext() }/css/js.css">									<!-- 프로젝트 공통 js를 이용한 response css -->
    <link rel="stylesheet" href="${request.getContext() }/css/admin/config/config-layout.css">			<!-- 관리자페이지 공통 레이아웃 -->
</head>
<body>
    <!-- header -->
    <tiles:insertAttribute name="header"/>
    <!-- header -->
    
    <div class="flex-box">
    <!-- nav -->
    <tiles:insertAttribute name="aside"/>    
	<!-- nav -->
	
	
    <!-- main -->
    <tiles:insertAttribute name="main"/>   
	<!-- main -->
    </div>
    <script src="/scripts/config/nav-active.js"></script>
</body>
</html>