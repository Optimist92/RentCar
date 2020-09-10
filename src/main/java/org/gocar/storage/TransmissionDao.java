package org.gocar.storage;

import java.util.List;

import org.gocar.domain.Transmission;

public interface TransmissionDao extends Dao<Transmission>{
	List<Transmission> read() throws DaoException;
	
}
