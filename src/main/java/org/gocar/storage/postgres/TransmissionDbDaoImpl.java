package org.gocar.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Transmission;
import org.gocar.storage.DaoException;
import org.gocar.storage.TransmissionDao;


public class TransmissionDbDaoImpl implements TransmissionDao{
	private Connection c;

	public void setConnection(Connection c) {
		this.c = c;
	}

	@Override
	public Long create(Transmission transmission) throws DaoException {
		String sql = "INSERT INTO \"transmission\"(\"name\") VALUES (?)";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setString(1, transmission.getName());
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
	public Transmission read(Long id) throws DaoException {
		String sql = "SELECT \"name\" FROM \"transmission\" WHERE \"id\" = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, id);
			r = s.executeQuery();
			Transmission transmission = null;
			if(r.next()) {
				transmission = new Transmission();
				transmission.setId(id);
				transmission.setName(r.getString("name"));
			}
			return transmission;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void update(Transmission transmission) throws DaoException {
		String sql = "UPDATE \"transmission\" SET \"name\" = ? WHERE \"id\" = ?";
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, transmission.getName());
			s.setLong(2, transmission.getId());
			s.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sql = "DELETE FROM \"transmission\" WHERE \"id\" = ?";
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
	public List<Transmission> read() throws DaoException {
		String sql = "SELECT \"id\", \"name\" FROM \"transmission\"";
		Statement s = null;
		ResultSet r = null;
		try {
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<Transmission> transmissions = new ArrayList<>();
			while(r.next()) {
				Transmission transmission = new Transmission();
				transmission.setId(r.getLong("id"));
				transmission.setName(r.getString("name"));
				transmissions.add(transmission);
			}
			return transmissions;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}
}
