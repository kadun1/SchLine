<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- 강의실 왼쪽메뉴 선택바 -->
<style>
#icon {
	font-size: 25px;
	text-align: left;
}
</style>
<div id="main" class="container-fluid">
	<div class="row content">
		<div class="col-sm-2 sidenav">
				<br />
				<div class="list-group">
					<a href="#" class="list-group-item">
						<i class="fas fa-chalkboard" id="icon">&nbsp&nbsp</i>
						<span style="text-align: center;">코스</span>
					</a>
					<a href="#" class="list-group-item">
						<i class="fa fa-archive" id="icon">&nbsp&nbsp</i>
						<span style="text-align: center;">종합과제함</span>
					</a>
				</div>
				<br />
	</div>
<!-- 내용입력부분. 클래스속성 건드리지말것 -->
<div class="col-lg-10">
<div class="container">
	