package org.gocar.storage.memory;

import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.CarClass;
import org.gocar.storage.CarClassDao;

public class CarClassMemoryDaoImpl implements CarClassDao{
	private List<CarClass> carClasses = new ArrayList<CarClass>();
	private Long lastCreatedId = 0L;
	
	@Override
	public Long create(CarClass carClass) {
		lastCreatedId++;
		carClass.setId(lastCreatedId);
		carClasses.add(carClass);
		return lastCreatedId;
	}

	@Override
	public CarClass read(Long id) {
		for(CarClass carClass: carClasses) {
			if(carClass.getId().equals(id)) {
				return carClass;
			}
		}
		return null;
	}

	@Override
	public void update(CarClass carClass) {
		for(CarClass carClass1: carClasses) {
			if(carClass1.getId().equals(carClass.getId())) {
				carClasses.set(carClasses.indexOf(carClass1), carClass);
				break;
			}
		}
		
	}

	@Override
	public void delete(Long id) {
		for(CarClass carClass: carClasses) {
			if(carClass.getId().equals(id)) {
				carClasses.remove(carClass);
				break;
			}
		}
	}

	@Override
	public List<CarClass> read() {
		return carClasses;
	}

}
