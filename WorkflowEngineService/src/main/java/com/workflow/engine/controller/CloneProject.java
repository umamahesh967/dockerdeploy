package com.workflow.engine.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RequestMapping("/workflow")
@Api(
		value="gitclone", 
		description=
			"Cloning the git repo (gitlab or github) into the newly " + 
			"created cloned_repo folder in working  directory with generated " + 
			"jenkinsfile using the commands given."
)
@RestController
public class CloneProject {
	@Value("${build: default value something}")
	private String build;
	
	@Value("${test}")
	private String test;
	
	@Value("${run}")
	private String run;
	
	@Value("${compile}")
	private String compile;

	
	private String project_url = "https://github.com/Shekharrajak/Trigger-Jenkins-Server"; 
	private String project_url1 = "https://github.com/Shekharrajak/PipelineExecution";

	
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
	public Object cloneIt() throws InternalUnixCommandException, JgitInternalException {
		
		
		// remove the present /cloned_repo folder
		if (cloned_repo_path.exists()) {
			runUnixCommand("rm -rf " + cloned_repo_path);
		}
		
		
        Git git;
		try {
			git = Git.cloneRepository()
					  .setURI( project_url1 )
					  .setDirectory( cloned_repo_path )
					  .setCloneAllBranches( true )
					  .call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new JgitInternalException(e.getMessage());
			
		}
//        Git git_open = Git.open( new F‌ile( "/path/to/repo/.git" ) );

        return git;

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
            @ApiResponse(code = 200, message = "Successfully cloned the repo"),
            @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	
	@RequestMapping("/generateJenkinsfile")
	public Object generateJenkinsFile() throws FileGenerationException {
		createfile(jenkinsfile_path);
		BufferedWriter writer = null;
		FileWriter fw = null;

			try {
	
				fw = new FileWriter(jenkinsfile_path);
				writer = new BufferedWriter(fw);
				 StringBuilder sb = new StringBuilder();
		          writer.append("pipeline {\n");
		          writer.append("        agent { docker any }\n");
		          writer.append("        stages {\n");
		          writer.append("            steps {\n");


		              if(build != null)
		              {
		                  writer.append("              sh '"+ build +"' \n");
		              }
		              if(compile != null)
		              {
		                  writer.append("              sh '"+ compile +"' \n");
		              }
		              
		              if(test != null)
		              {
		                  writer.append("              sh '"+ test +"' \n");
		              }
		              
		              if(run != null)
		              {
		                  writer.append("              sh '"+ run +"' \n");
		              }
		          writer.append("                       }\n");
		          writer.append("               }\n");
		          writer.append("         }\n");
		    	
				System.out.println("Done");
	
			} catch (IOException e) {
	
//				e.printStackTrace();
				System.out.println("Unable to generate files and folder.");
	
				throw new FileGenerationException(e.getMessage());
			} finally {
	
				try {
	
					if (writer != null)
						writer.close();
	
					if (fw != null)
						fw.close();
	
				} catch (IOException ex) {
	
					ex.printStackTrace();
	
				}
	
			}
			File Jenkinsfile_in_repo = new File("./cloned_repo/Jenkinsfile"); 
			copyJenkinsfileToRepo(Jenkinsfile_in_repo, jenkinsfile_path);
			return jenkinsfile_path;
	
	}
	
	/*
	 * create the file on the given path.handles all the exceptions as well.
	 * */
	public void createfile(File path) throws FileGenerationException {
		/* create the dir first */

		// if the directory does not exist, create it
		if (!path.exists()) {
		    System.out.println("creating directory: " + path.getName());
		    boolean result = false;

		    try{
				if (!path.getParentFile().exists()) {
					path.getParentFile().mkdirs();
				}
					
				if (!path.exists()) {
					path.createNewFile();
				}
				path.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        //handle it
		    	throw new FileGenerationException(se.getMessage());
		    } 
		    catch(IOException e) {
		    	throw new FileGenerationException(e.getMessage());
		    }
		    if(result) {    
		        System.out.println("DIR created");  
		    }
		}
	}
	
	/*
	 * copying the jenkinfile from the JenkinsFolder to the cloned_repo 
	 * folder.
	 * 
	 * */
	public void copyJenkinsfileToRepo(File JenkinsfileInRepo, File jenkinsfilePath) throws FileGenerationException {
		/*
		try {
			
		    FileUtils.copyFile(jenkinsfile_path, Jenkinsfile_in_repo);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		*/
	    FileInputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(jenkinsfilePath);
	        os = new FileOutputStream(JenkinsfileInRepo);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    }catch(IOException e) {
	    	throw new FileGenerationException(e.getMessage());
	    } finally {
	    	try {
	    		 is.close();
	 	        os.close();
	    	}
	    	catch(IOException e) {
	    		throw new FileGenerationException(e.getMessage());
	    	}
	       
	    }
	}
	
	/*
	 * Run the given `cmd` unix command.
	 * 
	 * */
	public boolean runUnixCommand(String cmd) throws InternalUnixCommandException {
        try {
//            String target = new String("./test.sh");
            //String target = new String("mkdir stackOver");
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd);
            proc.waitFor();
            StringBuffer output = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = "";                       
            while ((line = reader.readLine())!= null) {
                    output.append(line + "\n");
            }
            System.out.println("### " + output);
            return true;
	    } catch (Throwable t) {
	            t.printStackTrace();
	            throw new InternalUnixCommandException(t.getMessage());
	    }
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
