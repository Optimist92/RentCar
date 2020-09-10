package org.gocar.storage;

import java.util.List;

import org.gocar.domain.Option;

public interface OptionDao extends Dao<Option>{
	List<Option> read() throws DaoException;
}
