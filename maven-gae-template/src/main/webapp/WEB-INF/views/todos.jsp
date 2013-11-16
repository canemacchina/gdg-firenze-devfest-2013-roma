<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    <title>I miei Todo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    </head>
  	<body>
		<div class="container">
			<div class="col-lg-12">
				<h1>I miei Todo</h1>
			</div>
			<div class="col-lg-12">
				<c:forEach var="todo" items="${it}">
					<div class="col-lg-4 col-lg-offset-4">
						<h2>${todo.title}</h2>
						<p>${todo.text}</p>
						<input type="checkbox" checked="${todo.completed}">
					</div>
					<hr class="col-lg-12" />
				</c:forEach>
			</div>
		</div>
  	</body>
</html>