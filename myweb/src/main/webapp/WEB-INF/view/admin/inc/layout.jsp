<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지 - 메인</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="${request.getContext() }/css/reset.css">
    <link rel="stylesheet" href="${request.getContext() }/css/admin/header.css">
    <link rel="stylesheet" href="${request.getContext() }/css/admin/admin-main.css">
    <link rel="stylesheet" href="${request.getContext() }/css/admin/mainstyle.css">
</head>
<body>
    <!-- header -->
    <tiles:insertAttribute name="header"/>
    <!-- header -->

	<!-- main -->
    <tiles:insertAttribute name="main"/>
    <!-- main -->
</body>
</html>