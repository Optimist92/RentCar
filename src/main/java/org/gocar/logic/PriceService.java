package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Price;

public interface PriceService {
	List<Price> findAll() throws LogicException;

	void save(Price price) throws LogicException;
	
	Price findById (Long id) throws LogicException;

	//void delete(Long id) throws LogicException;
}
