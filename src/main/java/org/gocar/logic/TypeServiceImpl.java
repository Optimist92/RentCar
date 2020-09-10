package org.gocar.logic;

import java.util.List;

import org.gocar.domain.Type;
import org.gocar.storage.DaoException;
import org.gocar.storage.TypeDao;

public class TypeServiceImpl implements TypeService{
	
	private TypeDao typeDao;
	
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	@Override
	public List<Type> findAll() throws LogicException {
		try {
			return typeDao.read();
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Type type) throws LogicException {
		try {
			if(type.getId() == null) {
				Long id = typeDao.create(type);
				type.setId(id);
			} else {
				typeDao.update(type);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void delete(Long id) throws LogicException {
		try {
			typeDao.delete(id);
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}
	
}
