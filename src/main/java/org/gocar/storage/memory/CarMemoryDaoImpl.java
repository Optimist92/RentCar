package org.gocar.storage.memory;

import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Car;
import org.gocar.storage.CarDao;

public class CarMemoryDaoImpl implements CarDao{
	
	private List<Car> cars= new ArrayList<Car>();
	private Long lastCreatedId = 0L;
	
	@Override
	public Long create(Car car){
		lastCreatedId++;
		car.setId(lastCreatedId);
		cars.add(car);
		return lastCreatedId;
	}

	@Override
	public Car read(Long id) {
		for(Car car: cars) {
			if(car.getId().equals(id)) {
				return car;
			}
		}
		return null;
	}

	@Override
	public void update(Car car) {
		for(Car car1: cars) {
			if(car1.getId().equals(car.getId())) {
				cars.set(cars.indexOf(car1), car);
				break;
			}
		}
	}

	@Override
	public void delete(Long id){
		for(Car car: cars) {
			if(car.getId().equals(id)) {
				cars.remove(car);
				break;
			}
		}
	}

	@Override
	public List<Car> read() {
		return cars;
	}
	
}
