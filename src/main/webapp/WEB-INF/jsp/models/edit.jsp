<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<c:choose>
	<c:when test="${not empty model}">
		<c:set var="title" value="Редактирование модели &laquo;${model.carBrand} ${model.carModel}&raquo;"/>
	</c:when>
	<c:otherwise>
		<c:set var="title" value="Добавление новой модели"/>
		<jsp:useBean id="model" class="org.gocar.domain.Model"/>
	</c:otherwise>
</c:choose>


<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title></title>
			<c:url var="mainCssUrl" value="/main.css"/>
			<link rel="stylesheet" href="${mainCssUrl}" type="text/css">
			<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@400;700&family=Balsamiq+Sans:ital,wght@0,400;0,700;1,400;1,700&family=Caveat:wght@400;700&family=Lobster&family=Marck+Script&family=Neucha&family=Noto+Sans:ital,wght@0,400;0,700;1,400;1,700&family=Oswald:wght@200;300;400;500;600;700&family=Pacifico&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Yanone+Kaffeesatz:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
		</head>
		<body>
			<header>
				<div class="header-up">
					<div class="header-left">
						<c:url var="mainLogo" value="/images/logo.png"/>
						<a href="/rentauto" class="logo">
				            <img src="${mainLogo}" alt="На главную" title="На главную" width="300" height="50">
						</a>
					</div>
					<div class="header-center">
						<div class="address">
							<div class="address_img">
								<c:url var="mainAddress" value="/images/compass.png"/>
								<img src="${mainAddress}" alt="Адрес" width="40" height="40">
							</div>
							<div>
		                		<a href="https://yandex.by/maps/154/vitebsk/house/Z0kYdARlT0MAQFtvfX10eXlmYQ==/?ll=30.235666%2C55.158555&utm_medium=mapframe&utm_source=maps&z=16">Витебск<br> ул.Петруся Бровки д.50</a>
		                    </div>
		            	</div>
		                <div class="clock">
		                	<div class="clock_img">
		                		<c:url var="mainClock" value="/images/clock.png"/>
		                		<img src="${mainClock}" alt="Время работы" width="40" height="40">
		                	</div>
		                	<p>Часы работы:<br>10:00 - 20:00</p>
		                </div>
						<div class="mob_number">
							<div class="mob_img">
								<c:url var="mainMobile" value="/images/mobile.png"/>
								<img src="${mainMobile}" alt="Телефон" width="40" height="40">
							</div>
							<div class="mob_info">
								<div class="label">
									<strong>Tel. / Viber</strong>
								</div>
				            	<div class="phone">
				            		<a href="tel:+375298225566"> +375(29)822-55-66</a>
								</div>
							</div>
						</div>
					</div>
					<div class="header-right">
						<div class="login_button"><a href="#">Войти</a></div>
						<form>
						    <div class="search">
							     <input type="search" placeholder="поиск по автомобилям" name="q">
							     <input type="submit" value="">
						    </div>
					    </form>
					</div>
				</div>
				<div class="header-down">
					<ul class="list">
						<li><a href="models/list.html">Автомобили</a></li>
						<li><a href="#">Условия проката</a></li>
						<li><a href="#">Тарифы</a></li>
						<li><a href="#">Скидки</a></li>
						<li><a href="#">О компании</a></li>
						<li><a href="#">Новости</a></li>
						<li><a href="#">Отзывы</a></li>
						<li><a href="#">Контакты</a></li>
					</ul>
				</div>
			</header>
			<h1>${title}</h1>
			<c:url var="saveUrl" value="/models/save.html"/>
			<form action="${saveUrl}" method="post" class="form">
				<c:if test="${not empty model.id}">
					<input type="hidden" name="id" value="${model.id}">
				</c:if>
		
				<label class="form__label" for="carClass">Класс авто:</label>
				<select class="form__text-input" id="carClass" name="carClass">
					<c:forEach var="carClass" items="${carClasses}">
						<c:choose>
							<c:when test="${carClass.id == model.carClass.id}">
								<c:set var="selected" value="selected"/>
							</c:when>
							<c:otherwise>
								<c:remove var="selected"/>
							</c:otherwise>
						</c:choose>
						<option value="${carClass.id}" ${selected}>${carClass.name}</option>
					</c:forEach>
				</select>
				<br>
				<br>
				<label class="form__label" for="carBrand">Название производителя:</label>
				<input class="form__text-input" type="text" id="carBrand" name="carBrand" value="${model.carBrand}">
				<br>
				<br>
				<label class="form__label" for="carModel">Название модели:</label>
				<input class="form__text-input" type="text" id="carModel" name="carModel" value="${model.carModel}">
				<br>
				<br>
				<label class="form__label" for="type">Тип авто:</label>
				<select class="form__text-input" id="type" name="type">
					<c:forEach var="type" items="${types}">
						<c:choose>
							<c:when test="${type.id == model.type.id}">
								<c:set var="selected" value="selected"/>
							</c:when>
							<c:otherwise>
								<c:remove var="selected"/>
							</c:otherwise>
						</c:choose>
						<option value="${type.id}" ${selected}>${type.name}</option>
					</c:forEach>
				</select>
				<br>
				<br>
				<label class="form__label" for="fuel">Тип топлива:</label>
				<select class="form__text-input" id="fuel" name="fuel">
					<c:forEach var="fuel" items="${fuels}">
						<c:choose>
							<c:when test="${fuel.id == model.fuel.id}">
								<c:set var="selected" value="selected"/>
							</c:when>
							<c:otherwise>
								<c:remove var="selected"/>
							</c:otherwise>
						</c:choose>
						<option value="${fuel.id}" ${selected}>${fuel.name}</option>
					</c:forEach>
				</select>
				<br>
				<br>
				<label class="form__label" for="transmission">Коробка передач:</label>
				<select class="form__text-input" id="transmission" name="transmission">
					<c:forEach var="transmission" items="${transmissions}">
						<c:choose>
							<c:when test="${transmission.id == model.transmission.id}">
								<c:set var="selected" value="selected"/>
							</c:when>
							<c:otherwise>
								<c:remove var="selected"/>
							</c:otherwise>
						</c:choose>
						<option value="${transmission.id}" ${selected}>${transmission.name}</option>
					</c:forEach>
				</select>
				<br>
				<br>
				<label class="form__label" for="avgFuelCons">Средний расход топлива:</label>
				<input class="form__text-input" type="text" id="avgFuelCons" name="avgFuelCons" value="${model.avgFuelCons}">
				<br>
				<br>
				<label class="form__label" for="power">Мощность:</label>
				<input class="form__text-input" type="text" id="power" name="power" value="${model.power}">
				<br>
				<br>
				<label class="form__label" for="capacity">Объём двигателя:</label>
				<input class="form__text-input" type="text" id="capacity" name="capacity" value="${model.capacity}">
				<br>
				<br>
				<label class="form__label" for="yearsOfProduction">Годы выпуска модели:</label>
				<input class="form__text-input" type="text" id="yearsOfProduction" name="yearsOfProduction" value="${model.yearsOfProduction}">
				<br>
				<br>
				<label class="form__label" for="cost1">1-3 дня</label>
				<input class="form__text-input" type="text" id="cost1" name="cost1" value="${model.price.cost1}">
				<br>
				<br>
				<label class="form__label" for="cost4">4-7 дня</label>
				<input class="form__text-input" type="text" id="cost1" name="cost4" value="${model.price.cost4}">
				<br>
				<br>
				<label class="form__label" for="cost8">Более 8 дней</label>
				<input class="form__text-input" type="text" id="cost8" name="cost8" value="${model.price.cost8}">
				<br>
				<br>
				<button class="form__button" type="submit">Сохранить</button>
				<br>
				<c:url var="listUrl" value="/models/list.html"/>
				<button class="form__button" type="button" ><a class="form__button" href="${listUrl}">Отмена</a></button>
			</form>
		</body>
	</html>
	
	


