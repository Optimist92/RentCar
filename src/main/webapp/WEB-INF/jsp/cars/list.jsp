<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:page title="Список автомобилей" mainMenu="true">
	<c:url var="deleteUrl" value="/cars/delete.html"/>
	<form action="${deleteUrl}" method="post" class="tables">
		<div class="listCars">
			<table border="1">
				<tr>
					<th></th>
					<th>Рег номер</th>
					<th>Цвет</th>
					<th></th>
				</tr>
				<c:forEach var="car" items="${cars}" >
					<tr>
						<td><input type="checkbox" name="id" value="${car.id}"></td>
						<td>${car.regNumberAuto}</td>
						<td>${car.color}</td>
						<c:url var="editUrl" value="/cars/edit.html">
							<c:param name="id" value="${car.id}"/>
						</c:url>
						<td><a href="${editUrl}" class="form__button">Редактировать</a></td>
					</tr>
				</c:forEach>
			</table>
			<c:url var="editUrl" value="/cars/edit.html"/>
			<a href="${editUrl}" class="form__button">Добавить</a>
			<button type="submit" class="form__button_danger">Удалить</button>
		</div>
	</form>
</u:page>
