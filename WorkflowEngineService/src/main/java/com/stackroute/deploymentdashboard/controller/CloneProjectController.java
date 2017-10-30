package com.stackroute.deploymentdashboard.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.deploymentdashboard.messenger.ReportingServiceProducer;
//import com.stackroute.deploymentdashboard.messenger.ReportingServiceProducer;
import com.stackroute.deploymentdashboard.model.ModelForJenkins;
import com.stackroute.deploymentdashboard.service.WorkflowService;
import com.workflow.engine.exception.FileGenerationException;
import com.workflow.engine.exception.InternalUnixCommandException;
import com.workflow.engine.exception.JgitInternalException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/*
 * 
 * This class responsible for cloning , creating jenkinsfile
 * and putting it into the cloned_repo folder as well as save the
 * same jenkins file in JenkinsFolder for future use.
 * 
 * Internally it uses the mongo db for the commands table and put the path
 * of the project in one table.
 * 
 * returns
 * -------
 * Also create model with project id, version id, build id, 
 * path of the cloned_repo attributes.
 * 
 * input
 * ------
 * URL, list of commands (run , build , test, comiple)
 * 
 * 
 * */

@RequestMapping("v1/workflow")
@Api(
		value="gitclone", 
		description=
			"Cloning the git repo (gitlab or github) into the newly " + 
			"created cloned_repo folder in working  directory with generated " + 
			"jenkinsfile using the commands given."
)
@RestController
public class CloneProjectController {
	
	 @Autowired
	 ReportingServiceProducer producer;
	// TODO: these values from properties file or db
	@Value("${build: mvn build}")
	private String build;
	
	@Value("${test}")
	private String test;
	
	@Value("${run}")
	private String run;
	
	@Value("${compile}")
	private String compile;
	
	// service
	private WorkflowService workflowService = new WorkflowService();
	
//    @Autowired
//    ReportingServiceProducer producer;
    
	// TODO : get from db 
	private String project_url = "https://github.com/Shekharrajak/Trigger-Jenkins-Server"; 
	private String project_url1 = "https://github.com/Shekharrajak/PipelineExecution";
	
	/*
	 * This method is created to send data to kafka.
	 * It clones the git url into cloned_repo folder of the working directory.
	 * Generates the jenkinsfile using given commands.
	 * Put the jenkinsfile into JenkinsFolder and copy the same into cloned_repo folder.
	 * 
	 * */
    @ApiOperation(value = "Clone the git repo url and put jenkins file into cloned_repo ",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully cloned the repo and jenkinsfile done"),
            @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping("/returnToKafka")
	public ResponseEntity<String> returnToKafka() 
			throws InternalUnixCommandException, 
			JgitInternalException, 
			FileGenerationException {
			workflowService.init_commands(build, test, run, compile);
    	
    	//workflowService.init_commands(build, test, run, compile);

		// remove the present /cloned_repo folder
    	//workflowService.deleteFolder(cloned_repo_path);
//		
//		// clone the repo 
    	//workflowService.cloing_repo(project_url1, cloned_repo_path);
//		
		// generate jenkins file
    	//generateJenkinsFile();
    	System.out.println("gene jenkin..");
		
		
		ModelForJenkins model = new ModelForJenkins(111);
		// send to the kafka
		
		producer.send(model);
		return ResponseEntity.ok("Repo cloned and Jenkinsfile is put into the cloned-repo");
	}
    
	/*
	 * helpful link : http://www.codeaffine.com/2015/11/30/jgit-clone-repository/
	 * */
	/*
	 * Clone the git url into cloned_repo folder of the working directory.
	 * */
	private File cloned_repo_path = new File("./cloned_repo"); 
	
    @ApiOperation(value = "Clone the git repo url ",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully cloned the repo"),
            @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@RequestMapping("/clone")
	public ResponseEntity<String> cloneIt() throws InternalUnixCommandException, JgitInternalException {
		
		
		// remove the present /cloned_repo folder
    	workflowService.deleteFolder(cloned_repo_path);
    	workflowService.cloing_repo(project_url1, cloned_repo_path);
        return ResponseEntity.ok("done cloning..");

	}

	/*
	 * Generate jenkinfile from the given commands into the jenkinsFolder
	 * in the working direcotry.
	 * Also copy the same file into cloned_repo folder
	 * 
	 * */
	private File jenkinsfile_path = new File("./jenkinsFolder/Jenkinsfile"); 
	
	@ApiOperation(value = "Clone the git repo url ",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(
            	code = 200, 
            	message = 
            	   "Successfully generated the Jenkinsfile and put into the cloned_repo folder"),
            @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	
	@RequestMapping("/generateJenkinsfile")
	public Object generateJenkinsFile() throws FileGenerationException {
		workflowService.init_commands(build, test, run, compile);
		System.out.println("creating file" + jenkinsfile_path);
		workflowService.createfile(jenkinsfile_path);
		
		System.out.println("generating jenkins file");
		workflowService.createJenkinsFile(jenkinsfile_path);
		
		File Jenkinsfile_in_repo = new File("./cloned_repo/Jenkinsfile"); 
		workflowService.copyJenkinsfileToRepo(Jenkinsfile_in_repo, jenkinsfile_path);
		return jenkinsfile_path;
	
	}

	/*
	 * Clone from the git clone command. (Currently it is not in use)
	 * */
	@ApiOperation(
			value = "Clone the git repo url  using git command ",
			response = Iterable.class,
			hidden = true)
	@RequestMapping("/cloneFromGitCommand")
	public Object cloneItFromGitCommand() {
        StringBuffer output = new StringBuffer("the cloned output is : ") ; 
        try {
        	// git should be installed in system
        		String target = new String("git clone " + project_url);
        		//String target = new String("mkdir stackOver");
		        Runtime rt = Runtime.getRuntime();
		        Process proc = rt.exec(target);
		        proc.waitFor();

		        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		        String line = "";                       
		        while ((line = reader.readLine())!= null) {
		                output.append(line + "\n");
		        }
//		        System.out.println("### " + output);
		        return output;
		} catch (Throwable t) {
		        t.printStackTrace();
		      
		}
		return output;

	}
//	@RequestMapping("/doAll")
//	public Object doIt() {
//		
//        return git;
//
//	}
}
