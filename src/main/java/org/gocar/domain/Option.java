package org.gocar.domain;

public class Option extends Entity {
	private Integer airCond;
	private Integer powerWindows;
	private Integer seatHeating;
	private Integer wheelHeating;
	private Integer parkingSensors;
	private Integer cruiseControl;
	private Integer inOutMedia;
	private Integer bluetooth;
	private Integer leatherInterior;
	public Integer getAirCond() {
		return airCond;
	}
	public void setAirCond(Integer airCond) {
		this.airCond = airCond;
	}
	public Integer getPowerWindows() {
		return powerWindows;
	}
	public void setPowerWindows(Integer powerWindows) {
		this.powerWindows = powerWindows;
	}
	public Integer getSeatHeating() {
		return seatHeating;
	}
	public void setSeatHeating(Integer seatHeating) {
		this.seatHeating = seatHeating;
	}
	public Integer getWheelHeating() {
		return wheelHeating;
	}
	public void setWheelHeating(Integer wheelHeating) {
		this.wheelHeating = wheelHeating;
	}
	public Integer getParkingSensors() {
		return parkingSensors;
	}
	public void setParkingSensors(Integer parkingSensors) {
		this.parkingSensors = parkingSensors;
	}
	public Integer getCruiseControl() {
		return cruiseControl;
	}
	public void setCruiseControl(Integer cruiseControl) {
		this.cruiseControl = cruiseControl;
	}
	public Integer getInOutMedia() {
		return inOutMedia;
	}
	public void setInOutMedia(Integer inOutMedia) {
		this.inOutMedia = inOutMedia;
	}
	public Integer getBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(Integer bluetooth) {
		this.bluetooth = bluetooth;
	}
	public Integer getLeatherInterior() {
		return leatherInterior;
	}
	public void setLeatherInterior(Integer leatherInterior) {
		this.leatherInterior = leatherInterior;
	}
	
	@Override
	public String toString() {
		return "Опции: " + airCond + " / " + powerWindows + " / " + seatHeating + " / " + wheelHeating + " / " +
				parkingSensors + " / " + cruiseControl + " / " + inOutMedia + " / " + bluetooth + " / " + leatherInterior;
	}
}
