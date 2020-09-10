package org.gocar.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gocar.domain.Role;
import org.gocar.domain.User;
import org.gocar.logic.LogicException;

public class MainAction implements Action{
	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			User user = (User)session.getAttribute("sessionUser");
			if(user != null) {
				switch(user.getRole()) {
					case ADMIN: return new Result("/login");
					case CLIENT: return new Result("/login");
					case MANAGER: return new Result("/models/list");
					case OPERATOR: return new Result("/login");
					default: throw new EnumConstantNotPresentException(Role.class, user.getRole().toString());
				}
			}
		}
		return new Result("/index");
	}
}
