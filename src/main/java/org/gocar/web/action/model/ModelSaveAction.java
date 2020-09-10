package org.gocar.web.action.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gocar.domain.CarClass;
import org.gocar.domain.Fuel;
import org.gocar.domain.Model;
import org.gocar.domain.Price;
import org.gocar.domain.Transmission;
import org.gocar.domain.Type;
import org.gocar.logic.LogicException;
import org.gocar.web.action.ActionException;

public class ModelSaveAction extends BaseModelAction {

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		try {
			String id = req.getParameter("id");
			
			String carClass = req.getParameter("carClass");
			
			String type = req.getParameter("type");
			
			String carBrand = req.getParameter("carBrand");
			if(carBrand == null || carBrand.isBlank()) {
				throw new IllegalArgumentException();
			}
			
			String carModel = req.getParameter("carModel");
			if(carModel == null || carModel.isBlank()) {
				throw new IllegalArgumentException();
			}
			
			
			String transmission = req.getParameter("transmission");
			
			String fuel = req.getParameter("fuel");
			
			String avgFuelCons = req.getParameter("avgFuelCons");
			
			
			String power = req.getParameter("power");
			
			
			String capacity = req.getParameter("capacity");
			
			
			String yearsOfProduction = req.getParameter("yearsOfProduction");
			if(yearsOfProduction == null || yearsOfProduction.isBlank()) {
				throw new IllegalArgumentException();
			}
			
			String cost1 = req.getParameter("cost1");
			if(cost1 == null || cost1.isBlank()) {
				throw new IllegalArgumentException();
			}
			
			String cost4 = req.getParameter("cost4");
			if(cost4 == null || cost4.isBlank()) {
				throw new IllegalArgumentException();
			}
			
			String cost8 = req.getParameter("cost8");
			if(cost8 == null || cost8.isBlank()) {
				throw new IllegalArgumentException();
			}
			
			Model model = new Model();
			if(id != null) {
				model.setId(Long.parseLong(id));
			}
			
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
			if(model.getAvgFuelCons() <= 0) {
				throw new IllegalArgumentException();
			}
			model.setPower(Integer.parseInt(power));
			if(model.getPower() <= 0) {
				throw new IllegalArgumentException();
			}
			model.setCapacity(Integer.parseInt(capacity));
			if(model.getCapacity() <= 0) {
				throw new IllegalArgumentException();
			}
			model.setYearsOfProduction(yearsOfProduction);
			getModelService().save(model);
			
			Price price = new Price();
			if(id != null) {
				price.setId(Long.parseLong(id));
			}
			
			price.setCost1(Long.parseLong(cost1));
			price.setCost4(Long.parseLong(cost4));
			price.setCost8(Long.parseLong(cost8));
			
			getPriceService().save(price);
			
			return new Result("/models/list");
		} catch (IllegalArgumentException e) {
			throw new ActionException(e, 400);
		}
	}

}
