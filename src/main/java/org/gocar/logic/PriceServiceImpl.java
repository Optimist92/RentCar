package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Price;
import org.gocar.storage.DaoException;
import org.gocar.storage.PriceDao;

public class PriceServiceImpl implements PriceService{
	
	private PriceDao priceDao;
	
	public void setPriceDao(PriceDao priceDao) {
		this.priceDao = priceDao;
	}

	@Override
	public List<Price> findAll() throws LogicException {
		try {
			return priceDao.read();
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Price price) throws LogicException {
		try {
			if(price.getId() == null) {
				Long id = priceDao.create(price);
				price.setId(id);
			} else {
				priceDao.update(price);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}
	
	@Override
	public Price findById(Long id) throws LogicException {
		try {
			return priceDao.read(id);
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	/*@Override
	public void delete(Long id) throws LogicException {
		try {
			typeDao.delete(id);
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}*/
	
}
