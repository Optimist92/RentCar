package org.gocar.web.model;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gocar.Factory;
import org.gocar.domain.CarClass;
import org.gocar.domain.Fuel;
import org.gocar.domain.Model;
import org.gocar.domain.Price;
import org.gocar.domain.Transmission;
import org.gocar.domain.Type;
import org.gocar.logic.CarClassService;
import org.gocar.logic.FuelService;
import org.gocar.logic.LogicException;
import org.gocar.logic.ModelService;
import org.gocar.logic.PriceService;
import org.gocar.logic.TransmissionService;
import org.gocar.logic.TypeService;

public class ModelEditServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Factory factory = new Factory()) {
			CarClassService carClassservice = factory.getCarClassService();
			TypeService typeService = factory.getTypeService();
			FuelService fuelService = factory.getFuelService();
			TransmissionService transmissionService = factory.getTransmissionService();
			List<CarClass> carClasses = carClassservice.findAll();
			List<Type> types = typeService.findAll();
			List<Fuel> fuels = fuelService.findAll();
			List<Transmission> transmissions = transmissionService.findAll();
			req.setAttribute("carClasses", carClasses);
			req.setAttribute("types", types);
			req.setAttribute("fuels", fuels);
			req.setAttribute("transmissions", transmissions);
			String id = req.getParameter("id");
			if(id!=null) {
				ModelService modelService = factory.getModelService();
				Model model = modelService.findById(Long.parseLong(id));
				if(model==null) {
					throw new IllegalArgumentException();
				}
				req.setAttribute("model", model);
			}
			String priceId = req.getParameter("price_id");
			if(priceId!=null) {
				PriceService priceService = factory.getPriceService();
				Price price = priceService.findById(Long.parseLong(id));
				if(price==null) {
					throw new IllegalArgumentException();
				}
				req.setAttribute("price", price);
			}
			req.getRequestDispatcher("/WEB-INF/jsp/models/edit.jsp").forward(req, resp);
		
		} catch(LogicException e) {
			throw new ServletException(e); 
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} 
	}
	
}
