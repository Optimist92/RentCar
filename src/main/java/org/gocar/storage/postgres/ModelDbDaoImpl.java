package org.gocar.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.CarClass;
import org.gocar.domain.Fuel;
import org.gocar.domain.Model;
import org.gocar.domain.Price;
import org.gocar.domain.Transmission;
import org.gocar.domain.Type;
import org.gocar.storage.DaoException;
import org.gocar.storage.ModelDao;

public class ModelDbDaoImpl implements ModelDao{
	private Connection c;

	public void setConnection(Connection c) {
		this.c = c;
	}
	
	@Override
	public Long create(Model model) throws DaoException {
		String sql = "INSERT INTO \"model\"(\"class_id\", \"make_of_car\", \"model_of_car\", \"transmission_id\", \"type_id\", \"fuel_id\", \"avg_fuel_cons\", \"power\", \"capacity\", \"years_of_production\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setLong(1, model.getCarClass().getId());
			s.setString(2, model.getCarBrand());
			s.setString(3, model.getCarModel());
			s.setLong(4, model.getTransmission().getId());
			s.setLong(5, model.getType().getId());
			s.setLong(6, model.getFuel().getId());
			s.setDouble(7, model.getAvgFuelCons());
			s.setInt(8, model.getPower());
			s.setInt(9, model.getCapacity());
			s.setString(10, model.getYearsOfProduction());
			s.executeUpdate();
			r = s.getGeneratedKeys();
			r.next();
			return r.getLong(1);
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
			try { r.close(); } catch(Exception e) {}
		}
	}

	@Override
	public Model read(Long id) throws DaoException {
		String sql = "SELECT \"class_id\", \"make_of_car\", \"model_of_car\", \"transmission_id\", \"type_id\", \"fuel_id\", \"avg_fuel_cons\", \"power\", \"capacity\", \"years_of_production\" FROM \"model\" WHERE \"id\" = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, id);
			r = s.executeQuery();
			Model model = null;
			if(r.next()) {
				model = new Model();
				model.setId(id);
				model.setPrice(new Price());
				model.getPrice().setId(id);
				model.setCarClass(new CarClass());
				model.getCarClass().setId(r.getLong("class_id"));
				model.setCarBrand(r.getString("make_of_car"));
				model.setCarModel(r.getString("model_of_car"));
				model.setTransmission(new Transmission());
				model.getTransmission().setId(r.getLong("transmission_id"));
				model.setType(new Type());
				model.getType().setId(r.getLong("type_id"));
				model.setFuel(new Fuel());
				model.getFuel().setId(r.getLong("fuel_id"));
				model.setAvgFuelCons(r.getDouble("avg_fuel_cons"));
				model.setPower(r.getInt("power"));
				model.setCapacity(r.getInt("capacity"));
				model.setYearsOfProduction(r.getString("years_of_production"));
			}
			return model;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void update(Model model) throws DaoException {
		String sql = "UPDATE \"model\" SET \"class_id\" = ?, \"make_of_car\" = ?, \"model_of_car\" = ?, \"transmission_id\" = ?, \"type_id\" = ?, \"fuel_id\" = ?, \"avg_fuel_cons\" = ?, \"power\" = ?, \"capacity\" = ?, \"years_of_production\" = ? WHERE \"id\" = ?";
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, model.getCarClass().getId());
			s.setString(2, model.getCarBrand());
			s.setString(3, model.getCarModel());
			s.setLong(4, model.getTransmission().getId());
			s.setLong(5, model.getType().getId());
			s.setLong(6, model.getFuel().getId());
			s.setDouble(7, model.getAvgFuelCons());
			s.setInt(8, model.getPower());
			s.setInt(9, model.getCapacity());
			s.setString(10, model.getYearsOfProduction());
			s.setLong(11, model.getId());
			s.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sql = "DELETE FROM \"model\" WHERE \"id\" = ?";
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, id);
			s.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public List<Model> read() throws DaoException {
		String sql = "SELECT \"id\", \"class_id\", \"make_of_car\", \"model_of_car\", \"transmission_id\", \"type_id\", \"fuel_id\", \"avg_fuel_cons\", \"power\", \"capacity\", \"years_of_production\" FROM \"model\" ORDER BY \"id\"";
		Statement s = null;
		ResultSet r = null;
		try {
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<Model> models = new ArrayList<>();
			while(r.next()) {
				Model model = new Model();
				model.setId(r.getLong("id"));
				model.setPrice(new Price());
				model.getPrice().setId(r.getLong("id"));
				model.setCarClass(new CarClass());
				model.getCarClass().setId(r.getLong("class_id"));
				model.setCarBrand(r.getString("make_of_car"));
				model.setCarModel(r.getString("model_of_car"));
				model.setTransmission(new Transmission());
				model.getTransmission().setId(r.getLong("transmission_id"));
				model.setType(new Type());
				model.getType().setId(r.getLong("type_id"));
				model.setFuel(new Fuel());
				model.getFuel().setId(r.getLong("fuel_id"));
				model.setAvgFuelCons(r.getDouble("avg_fuel_cons"));
				model.setPower(r.getInt("power"));
				model.setCapacity(r.getInt("capacity"));
				model.setYearsOfProduction(r.getString("years_of_production"));
				models.add(model);
			}
			return models;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}
}
