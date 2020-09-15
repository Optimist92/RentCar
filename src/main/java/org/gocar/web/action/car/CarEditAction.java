package org.gocar.web.action.car;

import org.gocar.domain.*;
import org.gocar.logic.LogicException;
import org.gocar.logic.ModelService;
import org.gocar.web.action.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CarEditAction extends BaseCarAction {
    private ModelService modelService;
    

    @Override
    public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
        try {
            List<Model> models = modelService.findAll();
            req.setAttribute("models", models);
            String id = req.getParameter("id");
            if(id!=null) {
                Car car = getCarService().findById(Long.parseLong(id));
                if(car==null) {
                    throw new IllegalArgumentException();
                }
                req.setAttribute("car", car);
            }
            return null;
        } catch (IllegalArgumentException e) {
            throw new ActionException(e, 404);
        }
    }
}
