package org.gocar.storage;

import java.util.List;

import org.gocar.domain.Fuel;

public interface FuelDao extends Dao<Fuel>{
	List<Fuel> read() throws DaoException;
}
