package com.kafkaobject.kafka.service;





import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafkaobject.model.ProduceModel;
import com.kafkaobject.model.ProjectInfo;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.JobWithDetails;
//import com.stackroute.application.exception.ModelNotFoundException;
//import com.stackroute.application.exception.ModelVariableNotFoundException;
import com.kafkaobject.exception.*;


@Component
public class JenkinsService {
	
//	@Autowired
	ProduceModel produceModel = new ProduceModel();
	
	private String jobName;
	
	//we have taken a list of ManualModels.
//	As if the consumer data increases the list will be able to handle it.
private List<ProjectInfo> storage = new ArrayList<ProjectInfo>();
	
	public void put(ProjectInfo message)  throws ModelNotFoundException,ModelVariableNotFoundException, URISyntaxException, IOException{

		if(message == null) throw new ModelNotFoundException("Message is empty");
		if(message.getProjectId()==null) throw new ModelVariableNotFoundException("Please enter valid pid");
		if(message.getClonedPath()==null) throw new ModelVariableNotFoundException("Please enter valid path");
		if(message.getRepoUrl()==null) throw new ModelVariableNotFoundException("Please enter valid url");
//		if(message.getTimeSpan()!=null) throw new ModelVariableNotFoundException("Please ensure that you are sending data without time span");
		
		storage.add(message);//Adds the message to the list
		// sets the project-id of the message in produceManualModel in order to send
		// data to kafaka
//		produceModel.setProjectID(message.getProjectID()); 
		
		
		
		//here "ankur" is the username and "Monday123" is the password for jenkins server
	JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080"), "ankur", "Monday123");
		
		String url=message.getRepoUrl(); //git or svn url comes from here
//		String url="https://github.com/spidervamsi/jenkinsTest";
		
		
		// @TODO This should come from a config as a template
		String config="<?xml version='1.0' encoding='UTF-8'?>\n" + 
                "<flow-definition plugin=\"workflow-job@2.15\">\n" + 
                "  <actions/>\n" + 
                "  <description></description>\n" + 
                "  <keepDependencies>false</keepDependencies>\n" + 
                "  <properties/>\n" + 
                "  <definition class=\"org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition\" plugin=\"workflow-cps@2.41\">\n" + 
                "    <scm class=\"hudson.plugins.git.GitSCM\" plugin=\"git@3.6.0\">\n" + 
                "      <configVersion>2</configVersion>\n" + 
                "      <userRemoteConfigs>\n" + 
                "        <hudson.plugins.git.UserRemoteConfig>\n" + 
                "          <url>"+url+"</url>\n" + 
                "        </hudson.plugins.git.UserRemoteConfig>\n" + 
                "      </userRemoteConfigs>\n" + 
                "      <branches>\n" + 
                "        <hudson.plugins.git.BranchSpec>\n" + 
                "          <name>*/master</name>\n" + 
                "        </hudson.plugins.git.BranchSpec>\n" + 
                "      </branches>\n" + 
                "      <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>\n" + 
                "      <submoduleCfg class=\"list\"/>\n" + 
                "      <extensions/>\n" + 
                "    </scm>\n" + 
                "    <scriptPath>Jenkinsfile</scriptPath>\n" + 
                "    <lightweight>true</lightweight>\n" + 
                "  </definition>\n" + 
                "  <triggers/>\n" + 
                "  <disabled>false</disabled>\n" + 
                "</flow-definition>";
		
		
//				//sets the jobName as "job"+project-id. So that every builds name is different
		String jobName="job"+message.getProjectId();
		this.jobName=jobName;
		
		jenkins.createJob(jobName,config,true);
		
		JenkinsTrigger jenkinsTrigger = new JenkinsTrigger();
		jenkinsTrigger.timed(jobName,message.getTimeStamp() );
		
		
		
	
    //Now create the time and schedule it


    //Use this if you want to execute it once
    
    

	
//	       JobWithDetails job= jenkins.getJob(jobName);
//	          job.build(true);
//		System.out.println(jenkins.getJobs());
//		try {
//			jenkins.createJob(jobName, config,true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //creates the job
////	
	}
	
	public List<ProjectInfo> getManualModel() {
		
		return storage;
	}

//	public ProduceModel get() throws IOException, URISyntaxException {
//		//here "ankur" is the username and "Monday123" is the password for jenkins server
//		JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080/jenkins/"), "ankur", "Monday123");
//		
//		if(this.jobName==null) throw new ModelVariableNotFoundException("Please give valid jobName");
//       
//		JobWithDetails y=jenkins.getJob(this.jobName);//Gets the job details of a "jobName"
//        if(y==null)throw new ModelVariableNotFoundException("Please wait for jenkinis");        
//             String buildResult="failed"; //by default we consider the build is failed
//             
//        if(y.hasLastSuccessfulBuildRun())// if the build is success
//        	buildResult="success"; // the we change the buildResult to success
//		
//		
//		produceModel.setBuildSuccess(buildResult); //sets the buidlResult in produceMannualModel
//		return  produceModel;
//	}


}

