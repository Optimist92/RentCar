package org.gocar.web.action.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gocar.domain.Model;
import org.gocar.logic.LogicException;

public class ModelListAction extends BaseModelAction{

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		List<Model> models = getModelService().findAll();
		req.setAttribute("models", models);
		return null;
	}
}
