package com.stackroute.deploymentdashboard.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.workflow.engine.exception.FileGenerationException;
import com.workflow.engine.exception.InternalUnixCommandException;
import com.workflow.engine.exception.JgitInternalException;

@Service
public class WorkflowService {
	private String build;
	private String test;
	private String run;
	private String compile;
	
	public void init_commands(String bld,String tst,String rn, String comp) {
		 build = bld;
		 test = tst;
		 run = rn;
		 compile =comp;
	}
	// place to service
	public void createJenkinsFile(File jenkinsFile_path_new, HashMap<String,String> cmds) throws FileGenerationException {
		BufferedWriter writer = null;
		FileWriter fw = null;
		
		System.out.println("build value : " + build );
		System.out.println("run value : " + run );
		System.out.println("compile value : " + compile );
			try {
	
				fw = new FileWriter(jenkinsFile_path_new);
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
						{writer.close();}
					if (fw != null)
						{fw.close();}
				} catch (IOException ex) {
					ex.printStackTrace();
	
				}
			}
	}
	
	/*
	 * create the file on the given path.handles all the exceptions as well.
	 * */
	public void createfile(File path) throws FileGenerationException {
		/* create the dir first */

		String workingDir = System.getProperty("user.dir");
		 System.out.println("Current working directory : " + workingDir);
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
	
	
    // replace to service
    public void deleteFolder(File folder_path) throws InternalUnixCommandException {
		if (folder_path.exists()) {
			runUnixCommand("rm -rf " + folder_path);
		}
    }
    
    //replace to service
    public boolean cloing_repo(String repo_url, File cloning_path) throws JgitInternalException {
        Git git;
		try {
			git = Git.cloneRepository()
					  .setURI( repo_url )
					  .setDirectory( cloning_path )
					  .setCloneAllBranches( true )
					  .call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new JgitInternalException(e.getMessage());
			
		}
		return true;
    }
 
}
