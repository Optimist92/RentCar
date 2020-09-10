package org.gocar.storage.memory;

import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Price;
import org.gocar.storage.PriceDao;

public class PriceMemoryDaoImpl implements PriceDao {
	
	private List<Price> prices= new ArrayList<Price>();
	private Long lastCreatedId = 0L;
	
	@Override
	public Long create(Price price) {
		lastCreatedId++;
		price.setId(lastCreatedId);
		prices.add(price);
		return lastCreatedId;
	}
	
	@Override
	public Price read(Long id) {
		for(Price price: prices) {
			if(price.getId().equals(id)) {
				return price;
			}
		}
		return null;
	}
	
	@Override
	public void update(Price price) {
		for(Price price1: prices) {
			if(price1.getId().equals(price.getId())) {
				prices.set(prices.indexOf(price1), price);
				break;
			}
		}
	}
	
	@Override
	public void delete(Long id) {
		for(Price price: prices) {
			if(price.getId().equals(id)) {
				prices.remove(price);
				break;
			}
		}
	}
	
	@Override
	public List<Price> read() {
		return prices;
	}
}
