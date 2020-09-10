package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Fuel;


public interface FuelService {
	List<Fuel> findAll() throws LogicException;

	void save(Fuel fuel) throws LogicException;

	void delete(Long id) throws LogicException;
}
