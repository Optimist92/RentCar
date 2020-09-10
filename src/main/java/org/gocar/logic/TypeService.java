package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Type;

public interface TypeService {
	List<Type> findAll() throws LogicException;

	void save(Type type) throws LogicException;

	void delete(Long id) throws LogicException;
}
