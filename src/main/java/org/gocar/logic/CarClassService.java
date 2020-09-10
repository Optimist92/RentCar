package org.gocar.logic;

import java.util.List;

import org.gocar.domain.CarClass;

public interface CarClassService {
	List<CarClass> findAll() throws LogicException;

	void save(CarClass carClass) throws LogicException;

	void delete(Long id) throws LogicException;
}
