package org.gocar.storage;

import java.util.List;

import org.gocar.domain.Car;

public interface CarDao extends Dao<Car>{
	List<Car> read() throws DaoException;
}
