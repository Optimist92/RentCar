package org.gocar.storage.memory;

import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Option;
import org.gocar.storage.OptionDao;

public class OptionMemoryDaoImpl implements OptionDao{
	private List<Option> options= new ArrayList<Option>();
	private Long lastCreatedId = 0L;
	
	@Override
	public Long create(Option option) {
		lastCreatedId++;
		option.setId(lastCreatedId);
		options.add(option);
		return lastCreatedId;
	}

	@Override
	public Option read(Long id) {
		for(Option option: options) {
			if(option.getId().equals(id)) {
				return option;
			}
		}
		return null;
	}

	@Override
	public void update(Option option) {
		for(Option option1: options) {
			if(option1.getId().equals(option.getId())) {
				options.set(options.indexOf(option1), option);
				break;
			}
		}
	}

	@Override
	public void delete(Long id) {
		for(Option option: options) {
			if(option.getId().equals(id)) {
				options.remove(option);
				break;
			}
		}
	}

	@Override
	public List<Option> read() {
		return options;
	}

}
