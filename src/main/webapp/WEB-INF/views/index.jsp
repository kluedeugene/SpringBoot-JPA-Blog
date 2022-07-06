<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp" %>


<div class="container">

<%-- m-2 -> 마진값 --%>
<%--request 정보가 넘어올때 jstl에서 boards를 받아주는 식 ${} --%>
    <c:forEach var="board" items="${boards}">
        <div class="card m-2" >
            <div class="card-body">
                <h4 class="card-title">${board.title}</h4>
<%--                <p class="card-text">${board.content}</p>--%>
                <a href="#" class="btn btn-primary">상세보기</a>
            </div>
        </div>

    </c:forEach>


</div>
<br/>
<%@ include file="layout/footer.jsp" %> 
