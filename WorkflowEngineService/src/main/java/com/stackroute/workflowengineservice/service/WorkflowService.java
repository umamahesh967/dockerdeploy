package com.stackroute.workflowengineservice.service;

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
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.workflowengineservice.exception.FileGenerationException;
import com.stackroute.workflowengineservice.exception.InternalUnixCommandException;
import com.stackroute.workflowengineservice.exception.JgitInternalException;

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
	public void createFile(File path) throws FileGenerationException {
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
    public Git cloning_repo(String repo_url, File cloning_path) throws JgitInternalException {
    	
        Git git;
        System.out.println("clongin started via cloning_repo..");
		try {
			git = Git.cloneRepository()
					  .setURI( repo_url )
					  .setDirectory( cloning_path )
					  .setCloneAllBranches( true )
					  .call();
			System.out.println("clongin done via cloning_repo..");
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new JgitInternalException(e.getMessage());
			
		}
		return git;
    }
	public void git_commit(Git git, String msg) throws NoHeadException, NoMessageException, UnmergedPathsException, ConcurrentRefUpdateException, WrongRepositoryStateException, GitAPIException {
		// TODO Auto-generated method stub
		git.commit().setMessage(msg ).call();
	}
    
    /*
     * 
     * pushing using jgit : https://github.com/eclipse/jgit/blob/master/org.eclipse.jgit/src/org/eclipse/jgit/api/PushCommand.java
     *
    public void add_in_git() {
    	try (Git git = new Git(repository)) {
            // create the file
            File myfile = new File(repository.getDirectory().getParent(), "testfile");
            if(!myfile.createNewFile()) {
                throw new IOException("Could not create file " + myfile);
            }

            // Stage all files in the repo including new files
            git.add().addFilepattern(".").call();

           
        }
    }
    
    public void commit_in_git() {
    	try (Git git = new Git(repository)) {
	    	// and then commit the changes.
	        git.commit()
	                .setMessage("Commit jenkinsfile")
	                .call();
	
	        // Stage all changed files, omitting new files, and commit with one command
	        git.commit()
	                .setAll(true)
	                .setMessage("Commit changes to all files")
	                .call();
	
	
	        System.out.println("Committed all changes to repository at " + repository.getDirectory());
    
    	}
    }
    
    public void open_gir_repo() {
        // now open the resulting repository with a FileRepositoryBuilder
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        try (Repository repository = builder.setGitDir(repoDir)
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build()) {
            System.out.println("Having repository: " + repository.getDirectory());

            // the Ref holds an ObjectId for any type of object (tree, commit, blob, tree)
            Ref head = repository.exactRef("refs/heads/master");
            System.out.println("Ref of refs/heads/master: " + head);
        }
    }
    
    public static Repository createNewRepository() throws IOException {
        // prepare a new folder
        File localPath = File.createTempFile("TestGitRepository", "");
        if(!localPath.delete()) {
            throw new IOException("Could not delete temporary file " + localPath);
        }

        // create the directory
        Repository repository = FileRepositoryBuilder.create(new File(localPath, ".git"));
        repository.create();

        return repository;
    }
    
    private static File createSampleGitRepo() throws IOException, GitAPIException {
        try (Repository repository = createNewRepository()) {
            System.out.println("Temporary repository at " + repository.getDirectory());

            // create the file
            File myfile = new File(repository.getDirectory().getParent(), "testfile");
            if(!myfile.createNewFile()) {
                throw new IOException("Could not create file " + myfile);
            }

            // run the add-call
            try (Git git = new Git(repository)) {
                git.add()
                        .addFilepattern("testfile")
                        .call();


                // and then commit the changes
                git.commit()
                        .setMessage("Added testfile")
                        .call();
            }

            System.out.println("Added file " + myfile + " to repository at " + repository.getDirectory());

            return repository.getDirectory();
        }
    }
    */
}
