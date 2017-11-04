package com.stackroute.workflowengineservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.workflowengineservice.controller.WorkflowController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkflowEngineServiceApplicationTest {

	// create controller to check it is present in the main application
	@Autowired
    private WorkflowController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
