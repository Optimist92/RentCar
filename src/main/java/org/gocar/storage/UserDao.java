package org.gocar.storage;

import org.gocar.domain.User;

public interface UserDao extends Dao<User> {
	User read(String login, String password) throws DaoException;
}
