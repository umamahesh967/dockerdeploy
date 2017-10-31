package com.stackroute.application.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.stackroute.application.exception.ModelNotFoundException;
import com.stackroute.application.exception.ModelVariableNotFoundException;
import com.stackroute.application.model.ManualModel;
import com.stackroute.application.model.ProduceManualModel;

@Component
public class ServiceManual {
	
	
	ProduceManualModel produceManualModel=new ProduceManualModel(); 
	
	private String jobName;
	
	//we have taken a list of ManualModels.
//	As if the consumer data increases the list will be able to handle it.
private List<ManualModel> storage = new ArrayList<ManualModel>();
	
	public void put(ManualModel message) throws ModelNotFoundException,ModelVariableNotFoundException, URISyntaxException, IOException{

		if(message == null) throw new ModelNotFoundException("Message is empty");
		if(message.getProjectID()==null) throw new ModelVariableNotFoundException("Please enter valid pid");
		if(message.getCloned_path()==null) throw new ModelVariableNotFoundException("Please enter valid path");
		if(message.getRepo_url()==null) throw new ModelVariableNotFoundException("Please enter valid url");
		if(message.getTimeStamp()!=null) throw new ModelVariableNotFoundException("Please ensure that you are sending data without time span");
		
		storage.add(message);//Adds the message to the list
		// sets the project-id of the message in produceManualModel in order to send
		// data to kafaka
		produceManualModel.setPid(message.getProjectID()); 
		
		
		
		//here "vamsi" is the username and "vamsi123" is the password for jenkins server
	JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080"), "vamsi", "vamsi123");
		
		String url=message.getRepo_url(); //git or svn url comes from here
//		String url="https://github.com/spidervamsi/jenkinsTest";
		
		
		
		// String config is the xml configuration data read by jenkins server		
		String config="<?xml version='1.0' encoding='UTF-8'?>\n" + 
				"<project>\n" + 
				"  <actions/>\n" + 
				"  <description>taken</description>\n" + 
				"  <keepDependencies>false</keepDependencies>\n" + 
				"  <properties/>\n" + 
				"  <scm class=\"hudson.plugins.git.GitSCM\" plugin=\"git@3.6.0\">\n" + 
				"    <configVersion>2</configVersion>\n" + 
				"    <userRemoteConfigs>\n" + 
				"      <hudson.plugins.git.UserRemoteConfig>\n" + 
				"        <url>"+url+"</url>\n" + 
				"      </hudson.plugins.git.UserRemoteConfig>\n" + 
				"    </userRemoteConfigs>\n" + 
				"    <branches>\n" + 
				"      <hudson.plugins.git.BranchSpec>\n" + 
				"        <name>*/master</name>\n" + 
				"      </hudson.plugins.git.BranchSpec>\n" + 
				"    </branches>\n" + 
				"    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>\n" + 
				"    <submoduleCfg class=\"list\"/>\n" + 
				"    <extensions/>\n" + 
				"  </scm>\n" + 
				"  <canRoam>true</canRoam>\n" + 
				"  <disabled>false</disabled>\n" + 
				"  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>\n" + 
				"  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" + 
				"  <authToken>trick</authToken>\n" + 
				"  <triggers>\n" + 
				"    <hudson.triggers.SCMTrigger>\n" + 
				"      <spec>* * * * *</spec>\n" + 
				"      <ignorePostCommitHooks>false</ignorePostCommitHooks>\n" + 
				"    </hudson.triggers.SCMTrigger>\n" + 
				"  </triggers>\n" + 
				"  <concurrentBuild>false</concurrentBuild>\n" + 
				"  <builders/>\n" + 
				"  <publishers/>\n" + 
				"  <buildWrappers/>\n" + 
				"</project>\n" + 
				"\n" + 
				"\n" + 
				"";
		
		//sets the jobName as "job"+project-id. So that every builds name is different
		String jobName="job"+message.getProjectID();
		this.jobName=jobName;
		jenkins.createJob(jobName, config,true); //creates the job
	
	}
	
	public List<ManualModel> getManualModel() {
		
		return storage;
	}

	public ProduceManualModel get() throws IOException, URISyntaxException, ModelVariableNotFoundException {
		//here "vamsi" is the username and "vamsi123" is the password for jenkins server
		JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080"), "vamsi", "vamsi123");
		
		if(this.jobName==null) throw new ModelVariableNotFoundException("Please give valid jobName");
       
		JobWithDetails y=jenkins.getJob(this.jobName);//Gets the job details of a "jobName"
        if(y==null)throw new ModelVariableNotFoundException("Please wait for jenkinis");        
             String buildResult="failed"; //by default we consider the build is failed
             
        if(y.hasLastSuccessfulBuildRun())// if the build is success
        	buildResult="success"; // the we change the buildResult to success
		
        
		produceManualModel.setBuildSuccess(buildResult); //sets the buidlResult in produceMannualModel
		return  produceManualModel;
	}


}
