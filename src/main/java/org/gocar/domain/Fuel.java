package org.gocar.domain;

public class Fuel extends Entity{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] " + name;
	}
}