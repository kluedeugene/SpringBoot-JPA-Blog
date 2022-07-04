<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/loginProc", method="POST">
		<div class="form-group">
			<label for="username">Username</label>
			 <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
		</div>
				
		<div class="form-group">
			<label for="password">Password</label>
			 <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
	
	<button id="btn-login" class="btn btn-primary">로그인</button>
<%-- 로그인버튼을 FORM안에 넣었으니 누르면 SUBMIT이 된다. 
			username, password 두개의 name 값을 가지고 /auth/loginProc로 이동한다.
			UserApiController에 loginProc를 만들지 않았으나, 스프링시큐리티가 이 요청을 가로채기할것이기때문에 
			작성하지 않는다.
--%>
	</form>

</div>

<%@ include file="../layout/footer.jsp"%>

