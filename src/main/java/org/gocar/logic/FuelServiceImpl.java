package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Fuel;
import org.gocar.storage.DaoException;
import org.gocar.storage.FuelDao;

public class FuelServiceImpl implements FuelService{
	private FuelDao fuelDao;
	
	public void setFuelDao(FuelDao fuelDao) {
		this.fuelDao = fuelDao;
	}

	@Override
	public List<Fuel> findAll() throws LogicException {
		try {
			return fuelDao.read();
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Fuel fuel) throws LogicException {
		try {
			if(fuel.getId() == null) {
				Long id = fuelDao.create(fuel);
				fuel.setId(id);
			} else {
				fuelDao.update(fuel);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void delete(Long id) throws LogicException {
		try {
			fuelDao.delete(id);
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}
}
