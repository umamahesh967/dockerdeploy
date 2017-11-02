package com.kafkaobject.kafka.service;





import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
		if(message.getPid()==null) throw new ModelVariableNotFoundException("Please enter valid pid");
		if(message.getPath()==null) throw new ModelVariableNotFoundException("Please enter valid path");
		if(message.getUrl()==null) throw new ModelVariableNotFoundException("Please enter valid url");
//		if(message.getTimeSpan()!=null) throw new ModelVariableNotFoundException("Please ensure that you are sending data without time span");
		
		storage.add(message);//Adds the message to the list
		// sets the project-id of the message in produceManualModel in order to send
		// data to kafaka
		produceModel.setPid(message.getPid()); 
		
		
		
		//here "ankur" is the username and "Monday123" is the password for jenkins server
	JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080"), "ankur", "Monday123");
		
		String url=message.getUrl(); //git or svn url comes from here
//		String url="https://github.com/spidervamsi/jenkinsTest";
		
		
		
//		// String config is the xml configuration data read by jenkins server		
//		String config="<?xml version='1.0' encoding='UTF-8'?>\n" + 
//				"<project>\n" + 
//				"  <actions/>\n" + 
//				"  <description>taken</description>\n" + 
//				"  <keepDependencies>false</keepDependencies>\n" + 
//				"  <properties/>\n" + 
//				"  <scm class=\"hudson.plugins.git.GitSCM\" plugin=\"git@3.6.0\">\n" + 
//				"    <configVersion>2</configVersion>\n" + 
//				"    <userRemoteConfigs>\n" + 
//				"      <hudson.plugins.git.UserRemoteConfig>\n" + 
//				"        <url>"+url+"</url>\n" + 
//				"      </hudson.plugins.git.UserRemoteConfig>\n" + 
//				"    </userRemoteConfigs>\n" + 
//				"    <branches>\n" + 
//				"      <hudson.plugins.git.BranchSpec>\n" + 
//				"        <name>*/master</name>\n" + 
//				"      </hudson.plugins.git.BranchSpec>\n" + 
//				"    </branches>\n" + 
//				"    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>\n" + 
//				"    <submoduleCfg class=\"list\"/>\n" + 
//				"    <extensions/>\n" + 
//				"  </scm>\n" + 
//				"  <canRoam>true</canRoam>\n" + 
//				"  <disabled>false</disabled>\n" + 
//				"  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>\n" + 
//				"  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" + 
//				"  <authToken>trick</authToken>\n" + 
//				"  <triggers>\n" + 
//				"    <hudson.triggers.SCMTrigger>\n" + 
//				"      <spec>* * * * *</spec>\n" + 
//				"      <ignorePostCommitHooks>false</ignorePostCommitHooks>\n" + 
//				"    </hudson.triggers.SCMTrigger>\n" + 
//				"  </triggers>\n" + 
//				"  <concurrentBuild>false</concurrentBuild>\n" + 
//				"  <builders/>\n" + 
//				"  <publishers/>\n" + 
//				"  <buildWrappers/>\n" + 
//				"</project>\n" + 
//				"\n" + 
//				"\n" + 
//				"";
//		
		String configold = 
				"<?xml version='1.0' encoding='UTF-8'?>\n"+
				"<org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject plugin=\"workflow-multibranch@2.16\">\n"+
		  		"<actions/>\n"+
		  		"<description>taken</description>\n"+
		  		"<properties>\n"+
		  		"<org.jenkinsci.plugins.pipeline.modeldefinition.config.FolderConfig plugin=\"pipeline-model-definition@1.2.2\">\n"+
		  		"<dockerLabel></dockerLabel>\n"+
		  		"<registry plugin=\"docker-commons@1.9\"/>\n"+
		  		"</org.jenkinsci.plugins.pipeline.modeldefinition.config.FolderConfig>\n"+
		  		"</properties>\n"+
		  		"<folderViews class=\"jenkins.branch.MultiBranchProjectViewHolder\" plugin=\"branch-api@2.0.14\">\n"+
		  		"<owner class=\"org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject\" reference=\"../..\"/>\n"+
		  		"</folderViews>\n"+
		  		"<healthMetrics>\n"+
		  		"<com.cloudbees.hudson.plugins.folder.health.WorstChildHealthMetric plugin=\"cloudbees-folder@6.2.1\">\n"+
		  		"<nonRecursive>false</nonRecursive>\n"+
		  		"</com.cloudbees.hudson.plugins.folder.health.WorstChildHealthMetric>\n"+
		  		"</healthMetrics>\n"+
		  		"<icon class=\"jenkins.branch.MetadataActionFolderIcon\" plugin=\"branch-api@2.0.14\">\n"+
		  		"<owner class=\"org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject\" reference=\"../..\"/>\n"+
		  		"</icon>\n"+
		  		"<orphanedItemStrategy class=\"com.cloudbees.hudson.plugins.folder.computed.DefaultOrphanedItemStrategy\" plugin=\"cloudbees-folder@6.2.1\">\n"+
		  		"<pruneDeadBranches>true</pruneDeadBranches>\n"+
		  		"<daysToKeep>-1</daysToKeep>\n"+
		  		"<numToKeep>-1</numToKeep>\n"+
		  		"</orphanedItemStrategy>\n"+
		  		"<triggers/>\n"+
		  		"<disabled>false</disabled>\n"+
		  		"<sources class=\"jenkins.branch.MultiBranchProject$BranchSourceList\" plugin=\"branch-api@2.0.14\">\n"+
		  		"<data>\n"+
		  		"<jenkins.branch.BranchSource>\n"+
		        "<source class=\"jenkins.plugins.git.GitSCMSource\" plugin=\"git@3.6.0\">\n"+
		        "<id>b31d2736-d3b6-4ee3-8363-4262b6330c0</id>\n"+
		        "<remote>"+url+"</remote>\n"+
		        "<credentialsId></credentialsId>\n"+
		        "<traits><jenkins.plugins.git.traits.BranchDiscoveryTrait/></traits>\n"+
		        "</source>\n"+
		        "<strategy class=\"jenkins.branch.DefaultBranchPropertyStrategy\">\n"+
		        "<properties class=\"empty-list\"/>\n"+
		        "</strategy>\n"+
		        "</jenkins.branch.BranchSource>\n"+
		        "</data>\n"+
		        "<owner class=\"org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject\" reference=\"../..\"/>\n"+
		        "</sources>\n"+
		        "<factory class=\"org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory\">\n"+
		        "<owner class=\"org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject\" reference=\"../..\"/>\n"+
		        "<scriptPath>Jenkinsfile</scriptPath>\n"+
		        "</factory>\n"+
		        "</org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject>";
		
		String confignew =  
				"<?xml version='1.0' encoding='UTF-8'?>\n" + 
				"<maven2-moduleset plugin=\"maven-plugin@3.0\">\n" + 
				"  <actions/>\n" + 
				"  <description></description>\n" + 
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
				"  <triggers/>\n" + 
				"  <concurrentBuild>false</concurrentBuild>\n" + 
				"  <rootModule>\n" + 
				"    <groupId>com.cloudbees.manticore</groupId>\n" + 
				"    <artifactId>example</artifactId>\n" + 
				"  </rootModule>\n" + 
				"  <aggregatorStyleBuild>true</aggregatorStyleBuild>\n" + 
				"  <incrementalBuild>false</incrementalBuild>\n" + 
				"  <ignoreUpstremChanges>false</ignoreUpstremChanges>\n" + 
				"  <ignoreUnsuccessfulUpstreams>false</ignoreUnsuccessfulUpstreams>\n" + 
				"  <archivingDisabled>false</archivingDisabled>\n" + 
				"  <siteArchivingDisabled>false</siteArchivingDisabled>\n" + 
				"  <fingerprintingDisabled>false</fingerprintingDisabled>\n" + 
				"  <resolveDependencies>false</resolveDependencies>\n" + 
				"  <processPlugins>false</processPlugins>\n" + 
				"  <mavenValidationLevel>-1</mavenValidationLevel>\n" + 
				"  <runHeadless>false</runHeadless>\n" + 
				"  <disableTriggerDownstreamProjects>false</disableTriggerDownstreamProjects>\n" + 
				"  <blockTriggerWhenBuilding>true</blockTriggerWhenBuilding>\n" + 
				"  <settings class=\"jenkins.mvn.DefaultSettingsProvider\"/>\n" + 
				"  <globalSettings class=\"jenkins.mvn.DefaultGlobalSettingsProvider\"/>\n" + 
				"  <reporters/>\n" + 
				"  <publishers/>\n" + 
				"  <buildWrappers/>\n" + 
				"  <prebuilders/>\n" + 
				"  <postbuilders/>\n" + 
				"  <runPostStepsIfResult>\n" + 
				"    <name>FAILURE</name>\n" + 
				"    <ordinal>2</ordinal>\n" + 
				"    <color>RED</color>\n" + 
				"    <completeBuild>true</completeBuild>\n" + 
				"  </runPostStepsIfResult>\n" + 
				"</maven2-moduleset>";
		
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
		String jobName="job"+message.getPid();
		this.jobName=jobName;
		
		jenkins.createJob(jobName,config,true);
	
	       JobWithDetails job= jenkins.getJob(jobName);
	          job.build(true);
		System.out.println(jenkins.getJobs());
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

