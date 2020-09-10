package org.gocar.domain;

public class Price extends Entity{
	private Long cost1;
	private Long cost4;
	private Long cost8;
	
	public Long getCost1() {
		return cost1;
	}
	public void setCost1(Long cost1) {
		this.cost1 = cost1;
	}
	public Long getCost4() {
		return cost4;
	}
	public void setCost4(Long cost4) {
		this.cost4 = cost4;
	}
	public Long getCost8() {
		return cost8;
	}
	public void setCost8(Long cost8) {
		this.cost8 = cost8;
	}
	
	@Override
	public String toString() {
		return  "Цена за 1-3 дня: " + (cost1/100.0) + " руб/сут. ;/n" +
				"Цена за 4-7 дней: " + (cost4/100.0) + " руб/сут. ;/n" +
				"Цена за 8 и более дней: " + (cost8/100.0) + " руб/сут. ;";
	}
	
}
