package org.gocar.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gocar.Factory;
import org.gocar.domain.Car;
import org.gocar.logic.CarService;
import org.gocar.logic.LogicException;

public class CarListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Factory factory = new Factory()) {
			CarService service = factory.getCarService();
			List<Car> cars = service.findAll();
			req.setAttribute("cars", cars);
			req.getRequestDispatcher("/WEB-INF/jsp/cars/list.jsp").forward(req, resp);
		} catch(LogicException e) {
			throw new ServletException(e);
		}
	}
	
}
