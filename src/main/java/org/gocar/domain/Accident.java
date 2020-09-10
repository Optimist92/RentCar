package org.gocar.domain;

import java.util.Date;

public class Accident extends Entity{
	private Date dateAccident;
	private Car car;
	private String damageComm;
	private Integer repairCost;
	
	public Date getDateAccident() {
		return dateAccident;
	}
	public void setDateAccident(Date dateAccident) {
		this.dateAccident = dateAccident;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getDamageComm() {
		return damageComm;
	}
	public void setDamageComm(String damageComm) {
		this.damageComm = damageComm;
	}
	public Integer getRepairCost() {
		return repairCost;
	}
	public void setRepairCost(Integer repairCost) {
		this.repairCost = repairCost;
	}
	
}
