package org.gocar.storage.memory;

import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Type;
import org.gocar.storage.DaoException;
import org.gocar.storage.TypeDao;

public class TypeMemoryDaoImpl implements TypeDao {
	private List<Type> types = new ArrayList<Type>();
	private Long lastCreatedId = 0L;

	@Override
	public Long create(Type type) throws DaoException {
		lastCreatedId++;
		type.setId(lastCreatedId);
		types.add(type);
		return lastCreatedId;
	}

	@Override
	public Type read(Long id) throws DaoException {
		for(Type type: types) {
			if(type.getId().equals(id)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public void update(Type type) throws DaoException {
		for(Type type1: types) {
			if(type1.getId().equals(type.getId())) {
				types.set(types.indexOf(type1), type);
				break;
			}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		for(Type type: types) {
			if(type.getId().equals(id)) {
				types.remove(type);
				break;
			}
		}
	}

	@Override
	public List<Type> read() throws DaoException {
		return types;
	}

}
