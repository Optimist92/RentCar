package org.gocar.web.action.model;


import org.gocar.logic.ModelService;
import org.gocar.logic.PriceService;
import org.gocar.web.action.Action;

public abstract class BaseModelAction implements Action{
	private ModelService modelService;
	private PriceService priceService;
	
	public PriceService getPriceService() {
		return priceService;
	}

	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;
	}

	public ModelService getModelService() {
		return modelService;
	}
	
	public void setModelService(ModelService modelService) {
		this.modelService=modelService;
	}

}
