package org.gocar.storage;

import java.util.List;

import org.gocar.domain.CarClass;

public interface CarClassDao extends Dao<CarClass>{
	List<CarClass> read() throws DaoException;
}
