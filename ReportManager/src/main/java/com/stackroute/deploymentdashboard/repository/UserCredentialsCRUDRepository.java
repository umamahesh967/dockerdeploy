package com.stackroute.deploymentdashboard.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.stackroute.deploymentdashboard.model.UserCredentials;

public interface UserCredentialsCRUDRepository extends CassandraRepository<UserCredentials> {

}