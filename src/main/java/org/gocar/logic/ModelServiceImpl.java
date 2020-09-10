package org.gocar.logic;

import java.util.List;

import org.gocar.domain.CarClass;
import org.gocar.domain.Fuel;
import org.gocar.domain.Model;
import org.gocar.domain.Price;
import org.gocar.domain.Transmission;
import org.gocar.domain.Type;
import org.gocar.storage.CarClassDao;
import org.gocar.storage.DaoException;
import org.gocar.storage.FuelDao;
import org.gocar.storage.ModelDao;
import org.gocar.storage.PriceDao;
import org.gocar.storage.TransmissionDao;
import org.gocar.storage.TypeDao;

public class ModelServiceImpl implements ModelService{
	
	private ModelDao modelDao;
	private CarClassDao carClassDao;
	private TypeDao typeDao;
	private FuelDao fuelDao;
	private TransmissionDao transmissionDao;
	private PriceDao priceDao;
	
	public void setFuelDao(FuelDao fuelDao) {
		this.fuelDao = fuelDao;
	}

	public void setTransmissionDao(TransmissionDao transmissionDao) {
		this.transmissionDao = transmissionDao;
	}

	public void setModelDao (ModelDao modelDao) {
		this.modelDao = modelDao;
	}

	public void setCarClassDao (CarClassDao carClassDao) {
		this.carClassDao = carClassDao;
	}

	public void setPriceDao(PriceDao priceDao) {
		this.priceDao = priceDao;
	}

	public void setTypeDao (TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	@Override
	public List<Model> findAll() throws LogicException {
		try {
			List<Model> models = modelDao.read();
			for(Model model: models) {
				Type type = model.getType();
				type = typeDao.read(type.getId());
				model.setType(type);
				CarClass carClass = model.getCarClass();
				carClass = carClassDao.read(carClass.getId());
				model.setCarClass(carClass);
				Fuel fuel = model.getFuel();
				fuel = fuelDao.read(fuel.getId());
				model.setFuel(fuel);
				Transmission transmission = model.getTransmission();
				transmission = transmissionDao.read(transmission.getId());
				model.setTransmission(transmission);
				Price price = model.getPrice();
				price=priceDao.read(price.getId());
				model.setPrice(price);
			}
			return models;
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}
	
	@Override
	public Model findById(Long id) throws LogicException {
		try {
			Model model = modelDao.read(id);
			if(model != null) {
				Type type = model.getType();
				type = typeDao.read(type.getId());
				model.setType(type);
				CarClass carClass = model.getCarClass();
				carClass = carClassDao.read(carClass.getId());
				model.setCarClass(carClass);
				Fuel fuel = model.getFuel();
				fuel = fuelDao.read(fuel.getId());
				model.setFuel(fuel);
				Transmission transmission = model.getTransmission();
				transmission = transmissionDao.read(transmission.getId());
				model.setTransmission(transmission);
				Price price = model.getPrice();
				price=priceDao.read(price.getId());
				model.setPrice(price);
			}
			return model;
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Model model) throws LogicException {
		try {
			if(model.getId() == null) {
				Long id = modelDao.create(model);
				model.setId(id);
			} else {
				modelDao.update(model);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
		
	}

	@Override
	public void delete(List<Long> ids) throws LogicException {
		try {
			for(Long id : ids) {
				modelDao.delete(id);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
		
	}
	
}
