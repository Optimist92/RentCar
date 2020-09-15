package org.gocar.web.action.car;

import org.gocar.logic.LogicException;
import org.gocar.web.action.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CarDeleteAction extends BaseCarAction {
    @Override
    public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
        String idsString[] = req.getParameterValues("id");
        if(idsString != null) {
            try {
                List<Long> ids = new ArrayList<>(idsString.length);
                for(String id : idsString) {
                    ids.add(Long.parseLong(id));
                }
                getCarService().delete(ids);
            } catch(NumberFormatException e) {
                throw new ActionException(e, 400);
            }
        }
        return new Result("/cars/list");
    }
}
