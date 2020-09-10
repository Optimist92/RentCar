<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:page title="Вход в систему" css="/login.css">
	<c:if test="${not empty param.message}">
		<div class="message">${param.message}</div>
	</c:if>
	<c:url var="loginUrl" value="/login.html"/>
	<form action="${loginUrl}" id="autoriz" method="post">
		<h1>Вход</h1>
		<fieldset id="inputs">
			<input id="login" name="login" placeholder="Логин" autofocus="" required="" type="text">   
			<input id="password" name="password" placeholder="Пароль" required="" type="password">
		</fieldset>
		<fieldset id="actions">
			<input id="submit" value="Войти" type="submit">
			<a href="">Забыли пароль?</a><a href="">Регистрация</a>
		</fieldset>
	</form>
</u:page>