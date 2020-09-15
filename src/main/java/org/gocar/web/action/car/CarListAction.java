package org.gocar.web.action.car;

import org.gocar.domain.Car;
import org.gocar.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CarListAction extends BaseCarAction {

    @Override
    public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
        List<Car> cars = getCarService().findAll();
        req.setAttribute("cars", cars);
        return null;
    }
}
