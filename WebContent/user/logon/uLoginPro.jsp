<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:if test="${check == 1}">
		<c:set var="num" value="${num}" scope="session" />
		<c:set var="name" value="${name}" scope="session"/>
	</c:if>