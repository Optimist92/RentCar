<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:page title="Список моделей" mainMenu="true">
	<c:url var="deleteUrl" value="/models/delete.html"/>
	<form action="${deleteUrl}" method="post" class="tables">
		<div class="listModels">
			<table border="1">
				<tr>
					<th></th>
					<th>Класс</th>
					<th>Марка</th>
					<th>Модель</th>
					<th>Коробка передач</th>
					<th>Тип кузова</th>
					<th>Вид топлива</th>
					<th>Средний расход топлива</th>
					<th>Мощность(л.с)</th>
					<th>Объём двигателя(см^3)</th>
					<th>Годы выпуска модели</th>
					<th>Цена за 1-3 дня</th>
					<th>Цена за 4-7 дней</th>
					<th>Цена за 8 и более дней</th>
					<th></th>
				</tr>
				<c:forEach var="model" items="${models}" >
					<tr>
						<td><input type="checkbox" name="id" value="${model.id}"></td>
						<td>${model.carClass.name}</td>
						<td>${model.carBrand}</td>
						<td>${model.carModel}</td>
						<td>${model.transmission.name}</td>
						<td>${model.type.name}</td>
						<td>${model.fuel.name}</td>
						<td>${model.avgFuelCons}</td>
						<td>${model.power}</td>
						<td>${model.capacity}</td>
						<td>${model.yearsOfProduction}</td>
						<td>${model.capacity}</td>
						<td>${model.price.cost1}</td>
						<td>${model.price.cost4}</td>
						<td>${model.price.cost8}</td>
						<c:url var="editUrl" value="/models/edit.html">
							<c:param name="id" value="${model.id}"/>
						</c:url>
					<td><a href="${editUrl}" class="form__button">Редактировать</a></td>
					</tr>
				</c:forEach>
			</table>
			<c:url var="editUrl" value="/models/edit.html"/>
			<a href="${editUrl}" class="form__button">Добавить</a>
			<button type="submit" class="form__button_danger">Удалить</button>
		</div>
	</form>
</u:page>
