package org.gocar.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Price;
import org.gocar.storage.DaoException;
import org.gocar.storage.PriceDao;


public class PriceDbDaoImpl implements PriceDao{
	private Connection c;

	public void setConnection(Connection c) {
		this.c = c;
	}
	
	@Override
	public Long create(Price price) throws DaoException {
		String sql = "INSERT INTO \"price\"(\"cost1\", \"cost4\", \"cost8\") VALUES (?, ?, ?)";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setLong(1, price.getCost1());
			s.setLong(2, price.getCost4());
			s.setLong(3, price.getCost8());
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
	public Price read(Long id) throws DaoException {
		String sql = "SELECT \"cost1\", \"cost4\", \"cost8\" FROM \"price\" WHERE \"id\" = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, id);
			r = s.executeQuery();
			Price price = null;
			if(r.next()) {
				price = new Price();
				price.setId(id);
				price.setCost1(r.getLong("cost1"));
				price.setCost4(r.getLong("cost4"));
				price.setCost8(r.getLong("cost8"));
			}
			return price;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void update(Price price) throws DaoException {
		String sql = "UPDATE \"price\" SET \"cost1\" = ?, \"cost4\" = ?, \"cost8\" = ? WHERE \"id\" = ?";
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, price.getCost1());
			s.setLong(2, price.getCost4());
			s.setLong(3, price.getCost8());
			s.setLong(4, price.getId());
			s.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sql = "DELETE FROM \"price\" WHERE \"id\" = ?";
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
	public List<Price> read() throws DaoException {
		String sql = "SELECT \"id\", \"cost1\", \"cost4\", \"cost8\" FROM \"price\"";
		Statement s = null;
		ResultSet r = null;
		try {
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<Price> prices = new ArrayList<>();
			while(r.next()) {
				Price price = new Price();
				price.setId(r.getLong("id"));
				price.setCost1(r.getLong("cost1"));
				price.setCost4(r.getLong("cost4"));
				price.setCost8(r.getLong("cost8"));
				prices.add(price);
			}
			return prices;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}
}
