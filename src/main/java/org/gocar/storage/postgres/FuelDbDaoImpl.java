package org.gocar.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Fuel;
import org.gocar.storage.DaoException;
import org.gocar.storage.FuelDao;


public class FuelDbDaoImpl implements FuelDao{
	private Connection c;

	public void setConnection(Connection c) {
		this.c = c;
	}

	@Override
	public Long create(Fuel fuel) throws DaoException {
		String sql = "INSERT INTO \"fuel\"(\"name\") VALUES (?)";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setString(1, fuel.getName());
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
	public Fuel read(Long id) throws DaoException {
		String sql = "SELECT \"name\" FROM \"fuel\" WHERE \"id\" = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, id);
			r = s.executeQuery();
			Fuel fuel = null;
			if(r.next()) {
				fuel = new Fuel();
				fuel.setId(id);
				fuel.setName(r.getString("name"));
			}
			return fuel;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void update(Fuel fuel) throws DaoException {
		String sql = "UPDATE \"fuel\" SET \"name\" = ? WHERE \"id\" = ?";
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, fuel.getName());
			s.setLong(2, fuel.getId());
			s.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sql = "DELETE FROM \"fuel\" WHERE \"id\" = ?";
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
	public List<Fuel> read() throws DaoException {
		String sql = "SELECT \"id\", \"name\" FROM \"fuel\"";
		Statement s = null;
		ResultSet r = null;
		try {
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<Fuel> fuels = new ArrayList<>();
			while(r.next()) {
				Fuel fuel = new Fuel();
				fuel.setId(r.getLong("id"));
				fuel.setName(r.getString("name"));
				fuels.add(fuel);
			}
			return fuels;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}
}
