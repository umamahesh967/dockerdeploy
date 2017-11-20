package com.stackroute.deploymentdashboard.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.stackroute.deploymentdashboard.model.ReportModel;

public interface ReportModelCRUDRepository extends CassandraRepository<ReportModel> {
	public ReportModel findByProjectId(String projectid);

}