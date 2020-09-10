package org.gocar.storage;

import java.util.List;

import org.gocar.domain.Type;

public interface TypeDao extends Dao<Type>{
	List<Type> read() throws DaoException;
}
