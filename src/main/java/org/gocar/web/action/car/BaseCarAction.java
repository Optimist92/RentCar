package org.gocar.web.action.car;

import org.gocar.logic.CarService;
import org.gocar.web.action.Action;

public abstract class BaseCarAction implements Action {
    private CarService carService;

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

}
