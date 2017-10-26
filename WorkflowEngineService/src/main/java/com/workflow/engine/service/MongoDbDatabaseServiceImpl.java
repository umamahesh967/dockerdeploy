package com.workflow.engine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.engine.model.ModelForJenkins;
import com.workflow.engine.repository.WorkflowCRUDRepository;

@Service
public class MongoDbDatabaseServiceImpl implements DatabaseService {
	@Autowired
	private WorkflowCRUDRepository repoObject;
	
	@Override
	public List<ModelForJenkins> read() {
		List<ModelForJenkins> usercredentialsList = (List<ModelForJenkins>) repoObject.findAll();
		return usercredentialsList;
	}

}
