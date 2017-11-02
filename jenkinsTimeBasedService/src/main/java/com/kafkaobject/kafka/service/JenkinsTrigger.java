package com.kafkaobject.kafka.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.scheduling.annotation.Scheduled;

import com.kafkaobject.model.ProjectInfo;
import com.offbytwo.jenkins.JenkinsServer;

public class JenkinsTrigger {
	private String jobName;
	
	public void timeTrigger(ProjectInfo message) throws URISyntaxException, IOException {
JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080/jenkins/"), "ankur", "Monday123");
		
		String url=message.getUrl(); //git or svn url comes from here
//		String url="https://github.com/spidervamsi/jenkinsTest";
		
		
		
//		// String config is the xml configuration data read by jenkins server		
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
//		
		//sets the jobName as "job"+project-id. So that every builds name is different
		String jobName="job"+message.getPid();
		this.jobName=jobName;
		
		jenkins.createJob(jobName,config,true);
		
		
	}
}
