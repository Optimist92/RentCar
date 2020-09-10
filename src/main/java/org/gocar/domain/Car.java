package org.gocar.domain;

public class Car extends Entity{
	private Model model;
	private String regNumberAuto;
	private Integer rented;
	private Integer yearOfIssue;
	private String color;
	private Integer onRepair;
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public String getRegNumberAuto() {
		return regNumberAuto;
	}
	public void setRegNumberAuto(String regNumberAuto) {
		this.regNumberAuto = regNumberAuto;
	}
	public Integer getRented() {
		return rented;
	}
	public void setRented(Integer rented) {
		this.rented = rented;
	}
	public Integer getYearOfIssue() {
		return yearOfIssue;
	}
	public void setYearOfIssue(Integer yearOfIssue) {
		this.yearOfIssue = yearOfIssue;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getOnRepair() {
		return onRepair;
	}
	public void setOnRepair(Integer onRepair) {
		this.onRepair = onRepair;
	}
	
	public String toString() {
		return "Модель: " + model.getCarBrand() + " " + model.getCarModel()+ "/n" +
				"Рег. номер: " + regNumberAuto + "/n" +
				"Год выпуска: " + yearOfIssue + "/n" +
				"Цвет кузова: " + color +"/n" +
				"Арендована: " + rented + "/n" +
				"На ремонте: " + onRepair;
		
	}
}
