package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Car;
import org.gocar.domain.Model;
import org.gocar.storage.CarDao;
import org.gocar.storage.DaoException;
import org.gocar.storage.ModelDao;

public class CarServiceImpl implements CarService{

	private CarDao carDao;
	private ModelDao modelDao;
	
	
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public void setModelDao(ModelDao modelDao) {
		this.modelDao = modelDao;
	}

	@Override
	public List<Car> findAll() throws LogicException {
		try {
			List<Car> cars = carDao.read();
			for(Car car : cars) {
				Model model = car.getModel();
				model = modelDao.read(model.getId());
				car.setModel(model);
			}
			return cars;
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Car car) throws LogicException {
		try {
			if(car.getId() == null) {
				Long id = carDao.create(car);
				car.setId(id);
			} else {
				carDao.update(car);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void delete(Long id) throws LogicException {
		try {
			carDao.delete(id);
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

}
