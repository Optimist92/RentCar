package org.gocar.logic;

import java.util.List;

import org.gocar.domain.CarClass;
import org.gocar.storage.CarClassDao;
import org.gocar.storage.DaoException;

public class CarClassServiceImpl implements CarClassService{
	
	private CarClassDao carClassDao;
	
	public void setCarClassDao(CarClassDao carClassDao) {
		this.carClassDao = carClassDao;
	}

	@Override
	public List<CarClass> findAll() throws LogicException {
		try {
			return carClassDao.read();
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(CarClass carClass) throws LogicException {
		try {
			if(carClass.getId() == null) {
				Long id = carClassDao.create(carClass);
				carClass.setId(id);
			} else {
				carClassDao.update(carClass);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void delete(Long id) throws LogicException {
		try {
			carClassDao.delete(id);
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

}
