package org.gocar.storage.memory;

import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Fuel;
import org.gocar.storage.DaoException;
import org.gocar.storage.FuelDao;

public class FuelMemoryDaoImpl implements FuelDao{
	
	private List<Fuel> fuels = new ArrayList<Fuel>();
	private Long lastCreatedId = 0L;
	
	@Override
	public Long create(Fuel fuel) throws DaoException {
		lastCreatedId++;
		fuel.setId(lastCreatedId);
		fuels.add(fuel);
		return lastCreatedId;
	}

	@Override
	public Fuel read(Long id) throws DaoException {
		for (Fuel fuel: fuels) {
			if(fuel.getId().equals(id)) {
				return fuel;
			}
		}
		return null;
	}

	@Override
	public void update(Fuel fuel) throws DaoException {
		for (Fuel fuel1: fuels) {
			if(fuel.getId().equals(fuel1.getId())) {
				fuels.set(fuels.indexOf(fuel1), fuel);
				break;
			}
		}
		
	}

	@Override
	public void delete(Long id) throws DaoException {
		for (Fuel fuel: fuels) {
			if(fuel.getId().equals(id)) {
				fuels.remove(fuel);
				break;
			}
		}
	}

	@Override
	public List<Fuel> read() throws DaoException {
		return fuels;
	}
	
}
