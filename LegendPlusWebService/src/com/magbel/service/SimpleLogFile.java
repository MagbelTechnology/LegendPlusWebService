package com.magbel.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Logger;

public class SimpleLogFile {
	 Properties prop = new Properties();
	 FileInputStream input = null;
	 File file;
	 static Logger logger;
	
	public SimpleLogFile()
    {
		
    }

	
		
	public void setup(String message) {
	   
	    file = new File("C:\\Property\\FixedAsset.properties");
        
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
        try {
			prop.load(input);
		} catch (IOException e) {
			e.getMessage();
		}
        
        String UPLOAD_FOLDER = prop.getProperty("logFile");
	 		 
     // create our destination folder, if it not exists
        try {
            createFolderIfNotExists(UPLOAD_FOLDER);
        } catch (SecurityException se) {
       	 System.out.println("Can not create destination folder on server...");
        }
        
        LocalDate date = LocalDate.now();
		String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		 String uploadedFileLocation = UPLOAD_FOLDER + formattedDate +"_WebserviceLog"+ ".txt";
		 
		 try {
			 BufferedWriter writer = new BufferedWriter(new FileWriter(uploadedFileLocation, true));
			 LocalDateTime currentDateTime = LocalDateTime.now();
			 String format = currentDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
			 //writer.append("************************** WEBSERVICE LOGS ****************************");
			 writer.append(format + " : ");
			 writer.append(message+"\n");
			 writer.close();
		   
	 }catch(IOException  e){
		 e.getMessage();
	 }
		 
		

	  }

	
	
	
	  private static void createFolderIfNotExists(String dirName)
	            throws SecurityException {
	        File theDir = new File(dirName);
	        if (!theDir.exists()) {
	            theDir.mkdir();
	        }
	    }



	public void setup(boolean message) {
file = new File("C:\\Property\\LegendPlus.properties");
        
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
        try {
			prop.load(input);
		} catch (IOException e) {
			e.getMessage();
		}
        
        String UPLOAD_FOLDER = prop.getProperty("logFile");
	 		 
     // create our destination folder, if it not exists
        try {
            createFolderIfNotExists(UPLOAD_FOLDER);
        } catch (SecurityException se) {
       	 System.out.println("Can not create destination folder on server...");
        }
        
        LocalDate date = LocalDate.now();
		String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		 String uploadedFileLocation = UPLOAD_FOLDER + formattedDate +"_WebserviceLog"+ ".txt";
		 
		 try {
			 BufferedWriter writer = new BufferedWriter(new FileWriter(uploadedFileLocation, true));
			 LocalDateTime currentDateTime = LocalDateTime.now();
			 String format = currentDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
			 //writer.append("************************** WEBSERVICE LOGS ****************************");
			 writer.append(format + " : ");
			 writer.append(message+"\n");
			 writer.close();
		   
	 }catch(IOException  e){
		 e.getMessage();
	 }
		
	}

}
