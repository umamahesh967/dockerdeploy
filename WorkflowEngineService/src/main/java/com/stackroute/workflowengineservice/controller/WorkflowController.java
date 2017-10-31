package com.stackroute.workflowengineservice.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.workflowengineservice.messenger.ReportingServiceProducer;
import com.stackroute.workflowengineservice.model.JenkinsJob;
import com.stackroute.workflowengineservice.model.WorkflowJenkinsJob;
import com.stackroute.workflowengineservice.model.WorksetupJob;
import com.stackroute.workflowengineservice.service.WorkflowService;
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
public class WorkflowController {
	
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
	@Autowired
	private WorkflowService workflowService;// = new WorkflowService();
	
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
    @RequestMapping(value="/returnToKafka", method = RequestMethod.POST)
	public ResponseEntity<String> returnToKafka(@RequestBody WorksetupJob model) 
			throws InternalUnixCommandException, 
			JgitInternalException, 
			FileGenerationException, IOException {
    	
    	workflowService.init_commands(build, test, run, compile);

    	String pid = model.getPid();
    	String url = model.getUrl();
    	String timespan = model.getTimespan();
    	List<String> list_cmd = model.getList_cmd();
    	
    	System.out.println("url === " + url);
    	for(String s:list_cmd) {
    		System.out.println(s);
    	}
		// remove the present /cloned_repo folder
    	workflowService.deleteFolder(cloned_repo_path);
//		
//		// clone the repo 
    	// replace project_url1 with url
    	workflowService.cloing_repo(project_url1, cloned_repo_path);
    	System.out.println("cloning done..");	

    	WorkflowJenkinsJob workflowForJenkins = new WorkflowJenkinsJob(list_cmd);
		// generate jenkins file
    	generateJenkinsFile(workflowForJenkins);
    	System.out.println("gene jenkin..");
		
		JenkinsJob modelJenkins = new JenkinsJob("11312", 
				"some path", 
				"https://github.com/Shekharrajak/PipelineExecution", "4th");
		// send to the kafka
		
		producer.send(modelJenkins);
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
	
	@RequestMapping(value="/generateJenkinsfile", method = RequestMethod.POST)
	public Object generateJenkinsFile(@RequestBody WorkflowJenkinsJob workflows) throws FileGenerationException, IOException {
		workflowService.init_commands(build, test, run, compile);
		System.out.println("creating file" + jenkinsfile_path);
		workflowService.createfile(jenkinsfile_path);
		
		System.out.println("generating jenkins file");
		System.out.println("generating jenkins file"+ workflows.getCmds());
		Properties properties= new Properties();
		String resourceName = "mvn_commands.properties"; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			properties.load(resourceStream);
		}
//		System.out.println(properties.stringPropertyNames());
		HashMap<String,String> hm_cmds=new HashMap<String,String>();  
		for (String key : properties.stringPropertyNames()) {
		    String value = properties.getProperty(key);
		    hm_cmds.put(key, value);
		}
		// just printing properties file
		System.out.println("generating jenkins file+++++");
		 Iterator it = hm_cmds.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		    System.out.println("generating jenkins file========");
		workflowService.createJenkinsFile(jenkinsfile_path, hm_cmds);
		
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
