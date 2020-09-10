package org.gocar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.gocar.logic.CarClassService;
import org.gocar.logic.CarClassServiceImpl;
import org.gocar.logic.CarService;
import org.gocar.logic.CarServiceImpl;
import org.gocar.logic.FuelService;
import org.gocar.logic.FuelServiceImpl;
import org.gocar.logic.LogicException;
import org.gocar.logic.ModelService;
import org.gocar.logic.ModelServiceImpl;
import org.gocar.logic.PriceService;
import org.gocar.logic.PriceServiceImpl;
import org.gocar.logic.TransmissionService;
import org.gocar.logic.TransmissionServiceImpl;
import org.gocar.logic.TypeService;
import org.gocar.logic.TypeServiceImpl;
import org.gocar.logic.UserService;
import org.gocar.logic.UserServiceImpl;
import org.gocar.storage.CarClassDao;
import org.gocar.storage.CarDao;
import org.gocar.storage.FuelDao;
import org.gocar.storage.ModelDao;
import org.gocar.storage.PriceDao;
import org.gocar.storage.TransmissionDao;
import org.gocar.storage.TypeDao;
import org.gocar.storage.UserDao;
import org.gocar.storage.postgres.CarClassDbDaoImpl;
import org.gocar.storage.postgres.CarDbDaoImpl;
import org.gocar.storage.postgres.FuelDbDaoImpl;
import org.gocar.storage.postgres.ModelDbDaoImpl;
import org.gocar.storage.postgres.PriceDbDaoImpl;
import org.gocar.storage.postgres.TransmissionDbDaoImpl;
import org.gocar.storage.postgres.TypeDbDaoImpl;
import org.gocar.storage.postgres.UserDbDaoImpl;
import org.gocar.web.action.Action;
import org.gocar.web.action.LoginAction;
import org.gocar.web.action.LogoutAction;
import org.gocar.web.action.MainAction;
import org.gocar.web.action.model.ModelEditAction;
import org.gocar.web.action.model.ModelListAction;
import org.gocar.web.action.model.ModelSaveAction;
import org.gocar.web.action.model.ModelDeleteAction;

public class Factory implements AutoCloseable {
	
	private Map<String, ActionFactory> actions = new HashMap<>();
	{
		ActionFactory mainActionFactory = () -> getMainAction();
		actions.put("/", mainActionFactory);
		//actions.put("/index", mainActionFactory);
		actions.put("/login", () -> getLoginAction());
		actions.put("/logout", () -> getLogoutAction());
		actions.put("/models/list", () -> getModelListAction());
		actions.put("/models/edit", () -> getModelEditAction());
		actions.put("/models/save", () -> getModelSaveAction());
		actions.put("/models/delete", () -> getModelDeleteAction());
	}

	public Action getAction(String url) throws LogicException {
		ActionFactory factory = actions.get(url);
		if(factory != null) {
			return factory.getInstance();
		}
		return null;
	}

	private Action mainAction = null;
	public Action getMainAction() {
		if(mainAction == null) {
			mainAction = new MainAction();
		}
		return mainAction;
	}

	private Action loginAction = null;
	public Action getLoginAction() throws LogicException {
		if(loginAction == null) {
			LoginAction loginActionImpl = new LoginAction();
			loginAction = loginActionImpl;
			loginActionImpl.setUserService(getUserService());
		}
		return loginAction;
	}

	private Action logoutAction = null;
	public Action getLogoutAction() {
		if(logoutAction == null) {
			logoutAction = new LogoutAction();
		}
		return logoutAction;
	}
	

	private Action modelListAction = null;
	public Action getModelListAction() throws LogicException {
		if(modelListAction == null) {
			ModelListAction modelListActionImpl = new ModelListAction();
			modelListAction = modelListActionImpl;
			modelListActionImpl.setModelService(getModelService());
			modelListActionImpl.setPriceService(getPriceService());
		}
		return modelListAction;
	}

	
	private Action modelEditAction = null;
	public Action getModelEditAction() throws LogicException {
		if(modelEditAction == null) {
			ModelEditAction modelEditActionImpl = new ModelEditAction();
			modelEditAction = modelEditActionImpl;
			modelEditActionImpl.setModelService(getModelService());
			modelEditActionImpl.setCarClassService(getCarClassService());
			modelEditActionImpl.setTransmissionService(getTransmissionService());
			modelEditActionImpl.setTypeService(getTypeService());
			modelEditActionImpl.setFuelService(getFuelService());
			modelEditActionImpl.setPriceService(getPriceService());
		} 
		return modelEditAction;
	}
	
	private Action modelSaveAction = null;
	public Action getModelSaveAction() throws LogicException {
		if(modelSaveAction == null) {
			ModelSaveAction modelSaveActionImpl = new ModelSaveAction();
			modelSaveAction = modelSaveActionImpl;
			modelSaveActionImpl.setModelService(getModelService());
		}
		return modelSaveAction;
	}

	private Action modelDeleteAction = null;
	public Action getModelDeleteAction() throws LogicException {
		if(modelDeleteAction == null) {
			ModelDeleteAction modelDeleteActionImpl = new ModelDeleteAction();
			modelDeleteAction = modelDeleteActionImpl;
			modelDeleteActionImpl.setModelService(getModelService());
		}
		return modelDeleteAction;
	}
	
	private CarClassService carClassService = null;
	public CarClassService getCarClassService() throws LogicException {
		if(carClassService == null) {
			CarClassServiceImpl service = new CarClassServiceImpl();
			carClassService = service;
			service.setCarClassDao(getCarClassDao());
		}
		return carClassService;
	}
	
	private TypeService typeService = null;
	public TypeService getTypeService() throws LogicException {
		if(typeService == null) {
			TypeServiceImpl service = new TypeServiceImpl();
			typeService = service;
			service.setTypeDao(getTypeDao());
		}
		return typeService;
	}
	
	private FuelService fuelService = null;
	public FuelService getFuelService() throws LogicException {
		if(fuelService == null) {
			FuelServiceImpl service = new FuelServiceImpl();
			fuelService = service;
			service.setFuelDao(getFuelDao());;
		}
		return fuelService;
	}
	
	private TransmissionService transmissionService = null;
	public TransmissionService getTransmissionService() throws LogicException {
		if(transmissionService == null) {
			TransmissionServiceImpl service = new TransmissionServiceImpl();
			transmissionService = service;
			service.setTransmissionDao(getTransmissionDao());
		}
		return transmissionService;
	}
	
	private ModelService modelService = null;
	public ModelService getModelService() throws LogicException {
		if(modelService == null) {
			ModelServiceImpl service = new ModelServiceImpl();
			modelService = service;
			service.setModelDao(getModelDao());
			service.setTypeDao(getTypeDao());
			service.setCarClassDao(getCarClassDao());
			service.setTransmissionDao(getTransmissionDao());
			service.setFuelDao(getFuelDao());
			service.setPriceDao(getPriceDao());
		}
		return modelService;
	}
	
	private CarService carService = null;
	public CarService getCarService() throws LogicException {
		if(carService == null) {
			CarServiceImpl service = new CarServiceImpl();
			carService = service;
			service.setCarDao(getCarDao());
			service.setModelDao(getModelDao());
		}
		return carService;
	}
	
	private PriceService priceService = null;
	public PriceService getPriceService() throws LogicException {
		if(priceService == null) {
			PriceServiceImpl service = new PriceServiceImpl();
			priceService = service;
			service.setPriceDao(getPriceDao());
		}
		return priceService;
	}
	
	private UserService userService = null;
	public UserService getUserService() throws LogicException {
		if(userService == null) {
			UserServiceImpl service = new UserServiceImpl();
			userService = service;
			service.setUserDao(getUserDao());
		}
		return userService;
	}
	
	private FuelDao fuelDao = null;
	public FuelDao getFuelDao() throws LogicException {
		if(fuelDao == null) {
			FuelDbDaoImpl fuelDaoImpl = new FuelDbDaoImpl();
			fuelDao = fuelDaoImpl;
			fuelDaoImpl.setConnection(getConnection());
		}
		return fuelDao;
	}
	
	private PriceDao priceDao = null;
	public PriceDao getPriceDao() throws LogicException {
		if(priceDao == null) {
			PriceDbDaoImpl priceDaoImpl = new PriceDbDaoImpl();
			priceDao = priceDaoImpl;
			priceDaoImpl.setConnection(getConnection());
		}
		return priceDao;
	}
	
	private TransmissionDao transmissionDao = null;
	public TransmissionDao getTransmissionDao() throws LogicException {
		if(transmissionDao == null) {
			TransmissionDbDaoImpl transmissionDaoImpl = new TransmissionDbDaoImpl();
			transmissionDao = transmissionDaoImpl;
			transmissionDaoImpl.setConnection(getConnection());
		}
		return transmissionDao;
	}
	
	private CarDao carDao = null;
	public CarDao getCarDao() throws LogicException {
		if(carDao == null) {
			CarDbDaoImpl carDaoImpl = new CarDbDaoImpl();
			carDao = carDaoImpl;
			carDaoImpl.setConnection(getConnection());
		}
		return carDao;
	}
	
	private ModelDao modelDao = null;
	public ModelDao getModelDao() throws LogicException {
		if(modelDao == null) {
			ModelDbDaoImpl modelDaoImpl = new ModelDbDaoImpl();
			modelDao = modelDaoImpl;
			modelDaoImpl.setConnection(getConnection());
		}
		return modelDao;
	}
	
	private TypeDao typeDao = null;
	public TypeDao getTypeDao() throws LogicException {
		if(typeDao == null) {
			TypeDbDaoImpl typeDaoImpl = new TypeDbDaoImpl();
			typeDao = typeDaoImpl;
			typeDaoImpl.setConnection(getConnection());
		}
		return typeDao;
	}
	private CarClassDao carClassDao= null;
	public CarClassDao getCarClassDao() throws LogicException {
		if(carClassDao == null) {
			CarClassDbDaoImpl carClassDaoImpl = new CarClassDbDaoImpl();
			carClassDao = carClassDaoImpl;
			carClassDaoImpl.setConnection(getConnection());
		}
		return carClassDao;
	}
	
	private UserDao userDao = null;
	public UserDao getUserDao() throws LogicException {
		if(userDao == null) {
			UserDbDaoImpl userDaoImpl = new UserDbDaoImpl();
			userDao = userDaoImpl;
			userDaoImpl.setConnection(getConnection());
		}
		return userDao;
	}

	private Connection connection = null;
	public Connection getConnection() throws LogicException {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost/rent", "root", "root");
			} catch(SQLException e) {
				throw new LogicException(e);
			}
		}
		return connection;
	}

	@Override
	public void close() {
		try { connection.close(); } catch(Exception e) {}
	}
	
	private static interface ActionFactory {
		Action getInstance() throws LogicException;
	}
}
