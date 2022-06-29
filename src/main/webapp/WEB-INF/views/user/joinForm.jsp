<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">
	<h2>Stacked form</h2>
	<%-- <form action="/user/join" method="POST">  예전방식--%>
	<div class="form-group">
		<label for="username">Username:</label> <input type="username"
			class="form-control" id="username" placeholder="Enter username">
	</div>
	<div class="form-group">
		<label for="password">Password:</label> <input type="password"
			class="form-control" id="password" placeholder="Enter password">
	</div>
	<div class="form-group">
		<label for="email">Email:</label> <input type="email"
			class="form-control" id="email" placeholder="Enter email">
	</div>

	</form>

	<button id="btn-save" class="btn btn-primary">회원가입완료</button>

</div>

<%-- ( / ) 를하면 static 폴더를 찾는다.? --%>
<script src="/blog/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
