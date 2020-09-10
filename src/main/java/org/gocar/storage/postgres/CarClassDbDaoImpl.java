package org.gocar.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.CarClass;
import org.gocar.storage.CarClassDao;
import org.gocar.storage.DaoException;

public class CarClassDbDaoImpl implements CarClassDao{
	private Connection c;

	public void setConnection(Connection c) {
		this.c = c;
	}

	@Override
	public Long create(CarClass carClass) throws DaoException {
		String sql = "INSERT INTO \"class\"(\"name\") VALUES (?)";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setString(1, carClass.getName());
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
	public CarClass read(Long id) throws DaoException {
		String sql = "SELECT \"name\" FROM \"class\" WHERE \"id\" = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, id);
			r = s.executeQuery();
			CarClass carClass = null;
			if(r.next()) {
				carClass = new CarClass();
				carClass.setId(id);
				carClass.setName(r.getString("name"));
			}
			return carClass;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void update(CarClass carClass) throws DaoException {
		String sql = "UPDATE \"class\" SET \"name\" = ? WHERE \"id\" = ?";
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, carClass.getName());
			s.setLong(2, carClass.getId());
			s.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sql = "DELETE FROM \"class\" WHERE \"id\" = ?";
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
	public List<CarClass> read() throws DaoException {
		String sql = "SELECT \"id\", \"name\" FROM \"class\"";
		Statement s = null;
		ResultSet r = null;
		try {
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<CarClass> carClasses = new ArrayList<>();
			while(r.next()) {
				CarClass carClass = new CarClass();
				carClass.setId(r.getLong("id"));
				carClass.setName(r.getString("name"));
				carClasses.add(carClass);
			}
			return carClasses;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}
	
}
