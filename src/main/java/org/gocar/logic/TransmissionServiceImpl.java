package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Transmission;
import org.gocar.storage.DaoException;
import org.gocar.storage.TransmissionDao;

public class TransmissionServiceImpl implements TransmissionService{
	
	private TransmissionDao transmissionDao;
	
	public void setTransmissionDao(TransmissionDao transmissionDao) {
		this.transmissionDao = transmissionDao;
	}

	@Override
	public List<Transmission> findAll() throws LogicException {
		try {
			return transmissionDao.read();
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Transmission transmission) throws LogicException {
		try {
			if(transmission.getId() == null) {
				Long id = transmissionDao.create(transmission);
				transmission.setId(id);
			} else {
				transmissionDao.update(transmission);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void delete(Long id) throws LogicException {
		try {
			transmissionDao.delete(id);
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}
	
}
