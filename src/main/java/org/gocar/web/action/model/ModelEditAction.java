package org.gocar.web.action.model;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gocar.domain.CarClass;
import org.gocar.domain.Fuel;
import org.gocar.domain.Model;
import org.gocar.domain.Price;
import org.gocar.domain.Transmission;
import org.gocar.domain.Type;
import org.gocar.logic.CarClassService;
import org.gocar.logic.FuelService;
import org.gocar.logic.LogicException;
import org.gocar.logic.PriceService;
import org.gocar.logic.TransmissionService;
import org.gocar.logic.TypeService;
import org.gocar.web.action.ActionException;

public class ModelEditAction extends BaseModelAction{

	private CarClassService carClassService;
	private TypeService typeService;	
	private FuelService fuelService;
	private TransmissionService transmissionService;
	private PriceService priceService;
	
	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public void setFuelService(FuelService fuelService) {
		this.fuelService = fuelService;
	}

	public void setTransmissionService(TransmissionService transmissionService) {
		this.transmissionService = transmissionService;
	}

	public void setCarClassService(CarClassService carClassService) {
		this.carClassService = carClassService;
	}
	
	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		try {
			List<CarClass> carClasses = carClassService.findAll();
			List<Type> types = typeService.findAll();
			List<Fuel> fuels = fuelService.findAll();
			List<Transmission> transmissions = transmissionService.findAll();
			List<Price> prices = priceService.findAll();
			req.setAttribute("carClasses", carClasses);
			req.setAttribute("types", types);
			req.setAttribute("fuels", fuels);
			req.setAttribute("transmissions", transmissions);
			req.setAttribute("prices", prices);
			String id = req.getParameter("id");
			if(id!=null) {
				Model model = getModelService().findById(Long.parseLong(id));
				if(model==null) {
					throw new IllegalArgumentException();
				}
				req.setAttribute("model", model);
			}
			return null;
		} catch (IllegalArgumentException e) {
			throw new ActionException(e, 404);
		}
	}
}
