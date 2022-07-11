<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">
	<h2>회원 정보 수정</h2>
	<input type="hidden" id="id" value="${principal.user.id}" />
	<div class="form-group">
		<label for="username">Username:</label> <input type="username" value="${principal.user.username}"
			class="form-control" id="username" placeholder="Enter username" readonly>
	</div>
	<div class="form-group">
		<label for="password">Password:</label> <input type="password" value="${principal.user.username}"
			class="form-control" id="password" placeholder="Enter password to new password">
	</div>
	<div class="form-group">
		<label for="email">Email:</label> <input type="email" value="${principal.user.email}"
			class="form-control" id="email" placeholder="Enter email to new password">
	</div>

	</form>

	<button id="btn-update" class="btn btn-primary">회원수정 완료</button>

</div>

<%-- ( / ) 를하면 static 폴더를 찾는다.? --%>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
