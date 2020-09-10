package org.gocar.storage.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Option;
import org.gocar.storage.DaoException;
import org.gocar.storage.OptionDao;

public class OptionDbDaoImpl implements OptionDao{
	private Connection c;

	public void setConnection(Connection c) {
		this.c = c;
	}
	
	@Override
	public Long create(Option option) throws DaoException {
		String sql = "INSERT INTO \"option\"(\"air_cond\", \"power_windows\", \"seat_heating\", \"wheel_heating\", \"parking_sensors\", \"cruise_control\", \"CD/MP3/AUX/iPod/USB\", \"bluetooth\", \"leather_interior\" ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			s.setInt(1, option.getAirCond());
			s.setInt(2, option.getPowerWindows());
			s.setInt(3, option.getSeatHeating());
			s.setInt(4, option.getWheelHeating());
			s.setInt(5, option.getParkingSensors());
			s.setInt(6, option.getCruiseControl());
			s.setInt(7, option.getInOutMedia());
			s.setInt(8, option.getBluetooth());
			s.setInt(9, option.getLeatherInterior());
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
	public Option read(Long id) throws DaoException {
		String sql = "SELECT \"air_cond\", \"power_windows\", \"seat_heating\", \"wheel_heating\", \"parking_sensors\", \"cruise_control\", \"CD/MP3/AUX/iPod/USB\", \"bluetooth\", \"leather_interior\" FROM \"option\" WHERE \"id\" = ?";
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setLong(1, id);
			r = s.executeQuery();
			Option option = null;
			if(r.next()) {
				option = new Option();
				option.setId(id);
				option.setAirCond(r.getInt("air_cond"));
				option.setPowerWindows(r.getInt("power_windows"));
				option.setSeatHeating(r.getInt("seat_heating"));
				option.setWheelHeating(r.getInt("wheel_heating"));
				option.setParkingSensors(r.getInt("parking_sensors"));
				option.setCruiseControl(r.getInt("cruise_control"));
				option.setInOutMedia(r.getInt("CD/MP3/AUX/iPod/USB"));
				option.setBluetooth(r.getInt("bluetoth"));
				option.setLeatherInterior(r.getInt("leather_interior"));
				
			}
			return option;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void update(Option option) throws DaoException {
		String sql = "UPDATE \"option\" SET \"air_cond\" = ?, \"power_windows\" = ?, \"seat_heating\" = ?, \"wheel_heating\" = ?, \"parking_sensors\" = ?, \"cruise_control\" = ?, \"CD/MP3/AUX/iPod/USB\", \"bluetooth\", \"leather_interior\" = ? WHERE \"id\" = ?";
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setInt(1, option.getAirCond());
			s.setInt(2, option.getPowerWindows());
			s.setInt(3, option.getSeatHeating());
			s.setInt(4, option.getWheelHeating());
			s.setInt(5, option.getParkingSensors());
			s.setInt(6, option.getCruiseControl());
			s.setInt(7, option.getInOutMedia());
			s.setInt(8, option.getBluetooth());
			s.setInt(9, option.getLeatherInterior());
			s.setLong(10, option.getId());
			s.executeUpdate();
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { s.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void delete(Long id) throws DaoException {
		String sql = "DELETE FROM \"option\" WHERE \"id\" = ?";
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
	public List<Option> read() throws DaoException {
		String sql = "SELECT \"id\", \"air_cond\", \"power_windows\", \"seat_heating\", \"wheel_heating\", \"parking_sensors\", \"cruise_control\", \"CD/MP3/AUX/iPod/USB\", \"bluetooth\", \"leather_interior\" FROM \"option\"";
		Statement s = null;
		ResultSet r = null;
		try {
			s = c.createStatement();
			r = s.executeQuery(sql);
			List<Option> options = new ArrayList<>();
			while(r.next()) {
				Option option = new Option();
				option.setId(r.getLong("id"));
				option.setAirCond(r.getInt("air_cond"));
				option.setPowerWindows(r.getInt("power_windows"));
				option.setSeatHeating(r.getInt("seat_heating"));
				option.setWheelHeating(r.getInt("wheel_heating"));
				option.setParkingSensors(r.getInt("parking_sensors"));
				option.setCruiseControl(r.getInt("cruise_control"));
				option.setInOutMedia(r.getInt("CD/MP3/AUX/iPod/USB"));
				option.setBluetooth(r.getInt("bluetooth"));
				option.setLeatherInterior(r.getInt("leather_interior"));
				options.add(option);
			}
			return options;
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
		}
	}
}
