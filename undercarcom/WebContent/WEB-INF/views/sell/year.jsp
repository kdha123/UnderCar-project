<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<option>년식을 선택하세요</option>
<c:forEach items="${carmodel }" var="model">
	<option>${model.year }</option>
</c:forEach>