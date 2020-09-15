package org.gocar.web.action.car;

import org.gocar.domain.Car;
import org.gocar.domain.Model;
import org.gocar.logic.LogicException;
import org.gocar.web.action.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarSaveAction extends BaseCarAction{
    @Override
    public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
        try {
            String id = req.getParameter("id");
            String model = req.getParameter("model");
            String regNumberAuto = req.getParameter("regNumberAuto");
            if(regNumberAuto == null || regNumberAuto.isBlank()) {
                throw new IllegalArgumentException();
            }
            String yearOfIssue = req.getParameter("yearOfIssue");
            if(yearOfIssue == null || yearOfIssue.isBlank()) {
                throw new IllegalArgumentException();
            }
            String color = req.getParameter("color");
            String rented = req.getParameter("rented");
            if(rented == null || rented.isBlank()) {
                throw new IllegalArgumentException();
            }
            String onRepair = req.getParameter("onRepair");
            if(onRepair == null || onRepair.isBlank()) {
                throw new IllegalArgumentException();
            }

            Car car = new Car();
            if(id != null) {
                car.setId(Long.parseLong(id));
            }
            car.setModel(new Model());
            car.getModel().setId(Long.parseLong(model));
            car.setColor(color);
            car.setRegNumberAuto(regNumberAuto);
            car.setYearOfIssue(Integer.parseInt(yearOfIssue));
            if(1990 <= car.getYearOfIssue() && car.getYearOfIssue() <= 2021) {
                throw new IllegalArgumentException();
            }
            car.setOnRepair(Integer.parseInt(onRepair));
            if(0 != car.getOnRepair() || car.getOnRepair() != 1) {
                throw new IllegalArgumentException();
            }
            car.setRented(Integer.parseInt(rented));
            if(0 != car.getRented() && car.getRented() != 1) {
                throw new IllegalArgumentException();
            }
            getCarService().save(car);

            return new Result("/cars/list");

        } catch (IllegalArgumentException e) {
            throw new ActionException(e, 400);
        }
    }
}
