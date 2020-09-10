package org.gocar.storage;

import java.util.List;

import org.gocar.domain.Model;

public interface ModelDao extends Dao<Model>{
	List<Model> read() throws DaoException;
}
