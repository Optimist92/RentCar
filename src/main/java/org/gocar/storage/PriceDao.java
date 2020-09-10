package org.gocar.storage;

import java.util.List;

import org.gocar.domain.Price;

public interface PriceDao extends Dao<Price>{
	List<Price> read() throws DaoException;
}
