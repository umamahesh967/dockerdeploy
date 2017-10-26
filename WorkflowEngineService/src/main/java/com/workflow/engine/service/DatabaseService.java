package com.workflow.engine.service;

import java.util.List;

import com.workflow.engine.model.ModelForJenkins;

public interface DatabaseService {
	List<ModelForJenkins> read();
}
