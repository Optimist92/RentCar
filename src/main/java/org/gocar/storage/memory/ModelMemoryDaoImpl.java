package org.gocar.storage.memory;

import java.util.ArrayList;
import java.util.List;

import org.gocar.domain.Model;
import org.gocar.storage.ModelDao;

public class ModelMemoryDaoImpl implements ModelDao {

	private List<Model> models= new ArrayList<Model>();
	private Long lastCreatedId = 0L;
	
	@Override
	public Long create(Model model) {
		lastCreatedId++;
		model.setId(lastCreatedId);
		models.add(model);
		return lastCreatedId;
	}
	
	@Override
	public Model read(Long id) {
		for(Model model: models) {
			if(model.getId().equals(id)) {
				return model;
			}
		}
		return null;
	}
	
	@Override
	public void update(Model model) {
		for(Model model1: models) {
			if(model1.getId().equals(model.getId())) {
				models.set(models.indexOf(model1), model);
				break;
			}
		}
		
	}
	
	@Override
	public void delete(Long id) {
		for(Model model: models) {
			if(model.getId().equals(id)) {
				models.remove(model);
				break;
			}
		}
	}
	
	@Override
	public List<Model> read() {
		return models;
	}
	
	

}
