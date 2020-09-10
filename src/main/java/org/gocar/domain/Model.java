package org.gocar.domain;

public class Model extends Entity{
	private CarClass carClass;
	private String carBrand;
	private String carModel;
	private Transmission transmission;
	private Type type;
	private Fuel fuel;
	private Double avgFuelCons;
	private Integer power;
	private Integer capacity;
	private String yearsOfProduction;
	private Price price;
	
	
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public CarClass getCarClass() {
		return carClass;
	}
	public void setCarClass(CarClass carClass) {
		this.carClass = carClass;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Transmission getTransmission() {
		return transmission;
	}
	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getYearsOfProduction() {
		return yearsOfProduction;
	}
	public void setYearsOfProduction(String yearsOfProduction) {
		this.yearsOfProduction = yearsOfProduction;
	}
	public Double getAvgFuelCons() {
		return avgFuelCons;
	}
	public void setAvgFuelCons(Double avgFuelCons) {
		this.avgFuelCons = avgFuelCons;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "]" + " / " + carClass + " / " + carBrand + " / " + carModel + " / " + transmission +
				" / " + type + " / " + fuel + " / " + avgFuelCons + " / " + power + " / " + capacity + " / " + yearsOfProduction;
	}
}
