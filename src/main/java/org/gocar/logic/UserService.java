package org.gocar.logic;

import org.gocar.domain.User;

public interface UserService {
	User authenticate(String login, String password) throws LogicException;
}
