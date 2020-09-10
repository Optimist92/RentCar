package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Transmission;

public interface TransmissionService {
	List<Transmission> findAll() throws LogicException;

	void save(Transmission transmission) throws LogicException;

	void delete(Long id) throws LogicException;
}
