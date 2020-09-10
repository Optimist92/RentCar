package org.gocar.web.action;

import org.gocar.logic.LogicException;

public class ActionException extends LogicException{
	private int code;

	public ActionException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
