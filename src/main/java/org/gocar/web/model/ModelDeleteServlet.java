package org.gocar.web.model;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gocar.Factory;
import org.gocar.domain.CarClass;
import org.gocar.domain.Fuel;
import org.gocar.domain.Model;
import org.gocar.domain.Transmission;
import org.gocar.domain.Type;
import org.gocar.logic.LogicException;
import org.gocar.logic.ModelService;

public class ModelDeleteServlet extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String carClass = req.getParameter("carClass");
			String type = req.getParameter("type");
			String carBrand = req.getParameter("carBrand");
			if(carBrand==null || carBrand.isBlank()) {
				throw new IllegalArgumentException();
			}
			String carModel = req.getParameter("carModel");
			if(carModel==null || carModel.isBlank()) {
				throw new IllegalArgumentException();
			}
			String transmission = req.getParameter("transmission");
			String fuel = req.getParameter("fuel");
			String avgFuelCons = req.getParameter("avgFuelCons");
			if(avgFuelCons==null || avgFuelCons.isBlank()) {
				throw new IllegalArgumentException();
			}
			String power = req.getParameter("power");
			if(power==null || power.isBlank()) {
				throw new IllegalArgumentException();
			}
			String capacity = req.getParameter("capacity");
			if(capacity==null || capacity.isBlank()) {
				throw new IllegalArgumentException();
			}
			String yearsOfProduction = req.getParameter("years_of_production");
			if(yearsOfProduction==null || yearsOfProduction.isBlank()) {
				throw new IllegalArgumentException();
			}
			Model model = new Model();
			model.setCarClass(new CarClass());
			model.getCarClass().setId(Long.parseLong(carClass));
			model.setType(new Type());
			model.getType().setId(Long.parseLong(type));
			model.setCarBrand(carBrand);
			model.setCarModel(carModel);
			model.setTransmission(new Transmission());
			model.getTransmission().setId(Long.parseLong(transmission));
			model.setFuel(new Fuel());
			model.getFuel().setId(Long.parseLong(fuel));
			model.setAvgFuelCons(Double.parseDouble(avgFuelCons));
			model.setPower(Integer.parseInt(power));
			model.setCapacity(Integer.parseInt(capacity));
			model.setYearsOfProduction(yearsOfProduction);
			try(Factory factory = new Factory()) {
				ModelService service = factory.getModelService();
				service.save(model);
				resp.sendRedirect(req.getContextPath() + "/models/list.html");
			} catch(LogicException e) {
				throw new ServletException(e);
			}
		} catch (IllegalArgumentException e) {
			resp.sendError(400);
		}
	}
	
}
