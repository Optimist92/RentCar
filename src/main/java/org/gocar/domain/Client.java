package org.gocar.domain;

import java.util.Date;

public class Client extends Entity {
	private User user;
	private String name;
	private String surname;
	private String email;
	private String address;
	private String passport;
	private Date birthday;
	private String phone;
	private Integer countOfOrders;
	private Integer accident;
	private String driverLicNumber;
	private Discount clientDiscount;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getCountOfOrders() {
		return countOfOrders;
	}
	public void setCountOfOrders(Integer countOfOrders) {
		this.countOfOrders = countOfOrders;
	}
	public Integer getAccident() {
		return accident;
	}
	public void setAccident(Integer accident) {
		this.accident = accident;
	}
	public String getDriverLicNumber() {
		return driverLicNumber;
	}
	public void setDriverLicNumber(String driverLicNumber) {
		this.driverLicNumber = driverLicNumber;
	}
	public Discount getClientDiscount() {
		return clientDiscount;
	}
	public void setClientDiscount(Discount clientDiscount) {
		this.clientDiscount = clientDiscount;
	}
	
}
