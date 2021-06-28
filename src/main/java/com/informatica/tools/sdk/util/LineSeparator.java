package com.informatica.tools.sdk.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.informatica.tools.sdk.util.exception.enums.ParserErrorCodes;
import com.informatica.tools.sdk.util.exception.ParserException;

public class LineSeparator {
	
	private File inputFile;
	Logger log = Logger.getLogger(LineSeparator.class);
	
	
	public LineSeparator(File inputfile) {
		this.inputFile=inputfile;
	}
	
	
	public List<String> getLogList() throws ParserException {
        
		List<String> logLines = new ArrayList<String>();
		
		try{
			Scanner scanFile = new Scanner(inputFile);
			String line = "";
			
	        while (scanFile.hasNextLine()) {
	        	
	        	String scannerline=scanFile.nextLine();
	        	
	            if (containsTimestamp(scannerline)) {
	        		if(!StringUtils.isBlank(line)) {
	        			logLines.add(line);	        			
	        		}	        		
	        		line = scannerline;	        		
	        	} else {
	        		line = line + scannerline;
	        	}	        	
	        }
	        if (!StringUtils.isBlank(line)) {
	        	logLines.add(line);
	        }
	        scanFile.close();
	        	
		} catch (Exception e) {
			log.error(String.format("Exception occured while processing Log file: {}", inputFile.getName()), e);
			throw new ParserException(ParserErrorCodes.PARSER_001, e, inputFile.getName());
		}
	    
		return logLines;   	
	}
	
	private boolean containsTimestamp(String line) {
		
		if(line.matches("^[0-3][0-9]-[A-Z][a-z][a-z]-[1-2][0-9][0-9][0-9]\s[0-9][0-9]:[0-9][0-9]:[0-9][0-9].*"))
			return true;
		else
			return false;		
	}
}
