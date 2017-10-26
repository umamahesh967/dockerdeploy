package com.Project.Management.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Management.domains.*;
import com.Project.Management.repository.*;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository productrepository;


	
	
	public ProjectRepository getProjectrepository() {
		return productrepository;
	}

	public void setProjectrepository(ProjectRepository productrepository) {
		this.productrepository = productrepository;
	}

	public Project add(Project product) {
		
		productrepository.save(product);
		return product;
	}
	
	public Project getByid(String id){
		
		Project product =productrepository.findOne(id);
		return product;
		
	}
	
	public Project updateProject(Project product) {
		productrepository.save(product);
		return product;
	}
	
	public void deleteProject(String id) {
		productrepository.delete(id);
	}
	
	public List<Project> getAll(){
		List<Project> product=new ArrayList<>();
		productrepository.findAll().forEach(product::add);
		return product;
	}

}
