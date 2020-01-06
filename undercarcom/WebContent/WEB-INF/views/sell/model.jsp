<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<option selected="selected">모델를 선택하세요.</option>
<c:forEach items="${model }" var="model">
	<option>${model.model }</option>
</c:forEach>
