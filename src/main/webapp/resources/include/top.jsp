<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- 상단 인클루드 -->
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	
	<!-- 추가한 부트부분 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	

	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/main.css" />
	<noscript><link rel="stylesheet" href="<%=request.getContextPath() %>/resources/assets/css/noscript.css" /></noscript>
	
</head>
	
<!-- 기존 바디 위치 -->

<!-- Wrapper -->
	<div id="wrapper">
	<!-- 상단영역 줄이기 위해 헤더속성 제거 -->
		<!-- Header -->
		<!-- he -->
<!-- 					<header id="header" class="alt"> -->
<!-- 						<span class="logo"><img src="images/logo.svg" alt="" /></span> -->
				<!-- 메인 로고 이미지 -->
				<div align="center">
					<a href="#"><!-- ★★이미지클릭시 home으로 가기. home요청명 적기 -->
						<img src="<%=request.getContextPath() %>/resources/images/schooline_logo.png" width="600px" alt="스쿨라인 로고" />
					</a>
				</div>
				<!-- 글 안적을거같으니 일단 주석처리 -->
<!-- 						<p>Just another free, fully responsive site template<br /> -->
<!-- 						built by <a href="https://twitter.com/ajlkn">@ajlkn</a> for <a href="https://html5up.net">HTML5 UP</a>.</p> -->
<!-- 					</header> -->
<div>
		<!-- Nav -->
<!-- 			<nav id="nav"  class="alt"> -->
			<nav id="nav">
				<ul>
					<!-- ■ 각 페이지에 맞는 요청명 삽입할것 -->
					<li><a href=""><h3>강의실</h3></a></li>
					<li><a href=""><h3>일정</h3></a></li>
					<li><a href=""><h3>공부방</h3></a></li>
					<li><a href=""><h3>계정</h3></a></li>
				</ul>
			</nav><br /><br />
			
</div>