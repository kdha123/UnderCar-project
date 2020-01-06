<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<option>등급을 선택 하세요</option>
<c:forEach items="${cargrade }" var="cargrade">
	<option>${cargrade.grade }</option>
</c:forEach>