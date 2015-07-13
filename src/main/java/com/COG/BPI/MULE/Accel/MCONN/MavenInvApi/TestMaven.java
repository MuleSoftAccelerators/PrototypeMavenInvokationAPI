package com.COG.BPI.MULE.Accel.MCONN.MavenInvApi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collections;

import org.apache.maven.plugin.surefire.report.FileReporter;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationOutputHandler;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.InvokerLogger;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.apache.maven.shared.invoker.PrintStreamHandler;
import org.apache.maven.shared.invoker.PrintStreamLogger;
import org.apache.maven.shared.invoker.SystemOutHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class TestMaven {

    public static void main(String[] args) {
    	
    	try {
    	
	    	InvocationRequest request = new DefaultInvocationRequest();
	    	request.setPomFile( new File( "/Users/girishreddy/Documents/workspace/MySpring/pom.xml" ) );
	    	request.setGoals( Collections.singletonList( "package" ) );
	    	PrintStream out=new PrintStream("/Users/girishreddy/Documents/Learn/COG_Learning/report.txt");
			InvocationOutputHandler outputHandler= new PrintStreamHandler(out,true);
			request.setOutputHandler(outputHandler);
	    
	    	
	    	
	    	Invoker invoker = new DefaultInvoker();
    	File mvnhome= new File ("/Users/girishreddy/Documents/Learn/COG_Learning/apache-maven-3.2.5");
		invoker.setMavenHome(mvnhome);
		
	
		invoker.setOutputHandler(outputHandler);
		InvokerLogger log = invoker.getLogger();
		log.setThreshold(4);
			invoker.setLogger(log);
			
		InvocationResult result=	invoker.execute( request );
	
		
		/*File reportsDirectory=new File ("/Users/girishreddy/Documents/Learn/COG_Learning/");
		FileReporter report = new FileReporter(reportsDirectory, ".txt");
			
			
		PrintStreamLogger ps= 	(PrintStreamLogger) invoker.getLogger();*/
	
		System.out.println(result.getExitCode());
		
		
			
		} catch (MavenInvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
