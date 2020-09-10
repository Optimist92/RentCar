package org.gocar.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Car;
import org.gocar.domain.Model;
import org.gocar.storage.CarDao;
import org.gocar.storage.DaoException;

public class CarDbDaoImpl implements CarDao{
	private Connection c;

	public void setConnection(Connection c) {
		this.c = c;
	}

	@Override
	public Long create(Car car) throws DaoException {
		String sql = "INSERT INTO \"car\"(\"model_id\", \"reg_number_auto\", \"rented\", \"year_of_issue\", \"color\", \"on_repair\" VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setLong(1, car.getModel().getId());
			s.setString(2, car.getRegNumberAuto());
			s.setInt(3, car.getRented());
			s.setInt(4, car.getYearOfIssue());
			s.setString(5, car.getColor());
			s.setInt(6, car.getOnRepair());
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
	public Car read(Long id) throws DaoException {
		String sql = "SELECT \"model_id\", \"reg_number_auto\", \"rented\", \"year_of_issue\", \"color\", \"on_repair\" FROM \"car\" WHERE \"id\" = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, id);
			r = s.executeQuery();
			Car car = null;
			if(r.next()) {
				car = new Car();
				car.setId(id);
				car.setModel(new Model());
				car.getModel().setId(r.getLong("model_id"));
				car.setRegNumberAuto(r.getString("reg_number_auto"));
				car.setYearOfIssue(r.getInt("year_of_issue"));
				car.setRented(r.getInt("rented"));
				car.setColor(r.getString("color"));
				car.setOnRepair(r.getInt("on_repair"));
			}
			return car;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void update(Car car) throws DaoException {
		String sql = "UPDATE \"car\" SET \"model_id\" = ?, \"reg_number_auto\" = ?, \"rented\" = ?, \"year_of_issue\" = ?, \"color\" = ?, \"on_repair\" = ? WHERE \"id\" = ?";
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, car.getModel().getId());
			s.setString(2, car.getRegNumberAuto());
			s.setInt(3, car.getRented());
			s.setInt(4, car.getYearOfIssue());
			s.setString(5, car.getColor());
			s.setInt(6, car.getOnRepair());
			s.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
		}
		
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sql = "DELETE FROM \"car\" WHERE \"id\" = ?";
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
	public List<Car> read() throws DaoException {
		String sql = "SELECT \"id\", \"model_id\", \"reg_number_auto\", \"rented\", \"year_of_issue\", \"color\", \"on_repair\" FROM \"car\"";
		Statement s = null;
		ResultSet r = null;
		try {
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<Car> cars = new ArrayList<>();
			while(r.next()) {
				Car car = new Car();
				car.setId(r.getLong("id"));
				car.setModel(new Model());
				car.getModel().setId(r.getLong("model_id"));
				car.setRegNumberAuto(r.getString("reg_number_auto"));
				car.setRented(r.getInt("rented"));
				car.setYearOfIssue(r.getInt("year_of_issue"));
				car.setColor(r.getString("color"));
				car.setOnRepair(r.getInt("on_repair"));
				cars.add(car);
			}
			return cars;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}
	
	
}
