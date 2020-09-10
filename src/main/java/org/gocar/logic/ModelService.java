package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Model;

public interface ModelService {
	List<Model> findAll() throws LogicException;
	
	Model findById (Long id) throws LogicException;

	void save(Model model) throws LogicException;

	void delete(List<Long> ids) throws LogicException;
}
