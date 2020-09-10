package org.gocar.storage.memory;

import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Transmission;
import org.gocar.storage.DaoException;
import org.gocar.storage.TransmissionDao;

public class TransmissionMemoryDaoImpl implements TransmissionDao {
	
	private List<Transmission> transmissions = new ArrayList<Transmission>();
	private Long lastCreatedId = 0L;

	@Override
	public Long create(Transmission transmission) throws DaoException {
		lastCreatedId++;
		transmission.setId(lastCreatedId);
		transmissions.add(transmission);
		return lastCreatedId;
	}

	@Override
	public Transmission read(Long id) throws DaoException {
		for(Transmission transmission: transmissions) {
			if(transmission.getId().equals(id)) {
				return transmission;
			}
		}
		return null;
	}

	@Override
	public void update(Transmission transmission) throws DaoException {
		for(Transmission transmission2: transmissions) {
			if(transmission2.getId().equals(transmission.getId())) {
				transmissions.set(transmissions.indexOf(transmission2), transmission);
				break;
			}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		for(Transmission transmission: transmissions) {
			if(transmission.getId().equals(id)) {
				transmissions.remove(transmission);
				break;
			}
		}
	}

	@Override
	public List<Transmission> read() throws DaoException {
		return transmissions;
	}

}
