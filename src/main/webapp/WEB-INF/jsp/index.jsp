<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:page mainMenu="true">
	<div class="slider">
    		<div class="slider__wrapper">
      			<div class="slider__items">
       				<div class="slider__item">
          				<img class="img-fluid" src="images/elantra_slider.jpg" alt="c1">
        			</div>
       				<div class="slider__item">
          				<img class="img-fluid" src="images/tiguan_slider.jpg" alt="c2">
        			</div>
        			<div class="slider__item">
          				<img class="img-fluid" src="images/elantra2_slider.jpg" alt="c3">
        			</div>
        			<div class="slider__item">
          				<img class="img-fluid" src="images/hun_slider.jpg" alt="c4">
        			</div>
     			</div>
    		</div>
		<a class="slider__control slider__control_prev" href="#" role="button"></a>
		<a class="slider__control slider__control_next" href="#" role="button"></a>
		</div>
		<script src="scripts/slider.js"></script>
		<div class="wrapper">
			<div class="items">
				<div class="item">
					<div class="item-img">
						<img src="images/plus1.png" alt="Простая аренда">
					</div>
					<div class="desc">
						<div class="heading"><p>Простая аренда</p></div>
						<p>Оформите заявку прямо на сайте</p>
					</div>
				</div>
				<div class="item">
					<div class="item-img">
						<img src="images/plus2.png" alt="Безопасные автомобили">
					</div>
					<div class="desc">
						<div class="heading"><p>Безопасные автомобили</p></div>
						<p>Новые застрахованные автомобили,
						 своевременное прохождение ТО,
						 защита двигателя у всех автомобилей</p>
					</div>
				</div>
				<div class="item">
					<div class="item-img">
						<img src="images/plus3.png" alt="GPS">
					</div>
					<div class="desc">
						<div class="heading"><p>GPS навигатор и детское кресло</p></div>
						<p>Бесплатная аренда</p>
					</div>
				</div>
				<div class="item">
					<div class="item-img">
						<img src="images/plus4.png" alt="Доставка">
					</div>
					<div class="desc">
						<div class="heading"><p>Доставка автомобилей в срок</p></div>
						<p>Вам не нужно куда-то ехать</p>
					</div>
				</div>
				<div class="item">
					<div class="item-img">
						<img src="images/plus5.png" alt="Мы находимся в разных регионах">
					</div>
					<div class="desc">
						<div class="heading"><p>Мы находимся в разных регионах</p></div>
						<p>Возврат автомобиля в любом нашем филиале</p>
					</div>
				</div>
				<div class="item">
					<div class="item-img">
						<img src="images/plus6.png" alt="Сигнализация и автопрогрев">
					</div>
					<div class="desc">
						<div class="heading"><p>Сигнализация и автопрогрев</p></div>
						<p>У всех автомобилей</p>
					</div>
				</div>
			</div>
		</div>
</u:page>