<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="css" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="mainMenu" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Rent Car
			<c:if test="${not empty title}">:: ${title}</c:if>
		</title>
		<c:url var="mainCssUrl" value="/main.css"/>
		<link rel="stylesheet" href="${mainCssUrl}" type="text/css">
		<c:if test="${not empty css}">
			<c:url var="cssAdd" value="${css}"/>
			<link rel="stylesheet" href="${cssAdd}" type="text/css">
		</c:if>
		<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@400;700&family=Balsamiq+Sans:ital,wght@0,400;0,700;1,400;1,700&family=Caveat:wght@400;700&family=Lobster&family=Marck+Script&family=Neucha&family=Noto+Sans:ital,wght@0,400;0,700;1,400;1,700&family=Oswald:wght@200;300;400;500;600;700&family=Pacifico&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Yanone+Kaffeesatz:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
	</head>
	<body>
		<header>
			<div class="header-up">
				<div class="header-left">
					<a href="/" class="logo">
						<c:url var="logo" value="/images/logo.png"/>
			            <img src="${logo}" alt="На главную" title="На главную" width="300" height="50">
					</a>
				</div>
				<div class="header-center">
					<div class="address">
						<div class="address_img">
							<c:url var="address_img" value="/images/compass.png"/>
							<img src="${address_img}" alt="Адрес" width="40" height="40">
						</div>
						<div>
	                		<a href="https://yandex.by/maps/154/vitebsk/house/Z0kYdARlT0MAQFtvfX10eXlmYQ==/?ll=30.235666%2C55.158555&utm_medium=mapframe&utm_source=maps&z=16">Витебск<br> ул.Петруся Бровки д.50</a>
	                    </div>
	                </div>
	                <div class="clock">
	                	<div class="clock_img">
	                		<c:url var="clock_img" value="/images/clock.png"/>
	                		<img src="${clock_img}" alt="Время работы" width="40" height="40">
	                	</div>
	                	<p>Часы работы:<br>10:00 - 20:00</p>
	                </div>
					<div class="mob_number">
						<div class="mob_img">
							<c:url var="mob_img" value="/images/mobile.png"/>
							<img src="${mob_img}" alt="Телефон" width="40" height="40">
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
					<c:choose>
						<c:when test="${not empty sessionUser}">
							<c:url var="logoutUrl" value="/logout.html"/>
							<div class="login_button"><a href="${logoutUrl}">Выйти</a></div>
						</c:when>
						<c:otherwise>
							<c:url var="loginUrl" value="/login.html"/>
							<div class="login_button"><a href="${loginUrl}">Войти</a></div>
						</c:otherwise>
					</c:choose>
					<form>
					    <div class="search">
						     <input type="search" placeholder="поиск по автомобилям" name="q">
						     <input type="submit" value="">
					    </div>
				    </form>
				</div>
			</div>
			<c:if test="${not empty mainMenu}"><u:mainMenu/></c:if>
		</header>
		<c:if test="${not empty title}"><h1 class="titles">${title}</h1></c:if>
		<jsp:doBody/>
		<footer><div class="container"></div>
		</footer>
	</body>
</html>