package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Car;

public interface CarService {
	List<Car> findAll() throws LogicException;

	void save(Car car) throws LogicException;

	void delete(Long id) throws LogicException;
}
