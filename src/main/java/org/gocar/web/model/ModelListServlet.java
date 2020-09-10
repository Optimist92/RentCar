package org.gocar.web.model;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gocar.Factory;
import org.gocar.domain.Model;
import org.gocar.logic.LogicException;
import org.gocar.logic.ModelService;

public class ModelListServlet extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Factory factory = new Factory()) {
			ModelService service = factory.getModelService();
			List<Model> models = service.findAll();
			req.setAttribute("models", models);
			req.getRequestDispatcher("/WEB-INF/jsp/models/list.jsp").forward(req, resp);
		} catch(LogicException e) {
			throw new ServletException(e);
		}
	}
	
}
