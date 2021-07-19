package com.informatica.tools.sdk.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;

import com.informatica.tools.models.LogEntity;
import com.informatica.tools.sdk.IHandler;
import com.informatica.tools.sdk.ParserContext;
import com.informatica.tools.sdk.util.LineSeparator;
import com.informatica.tools.sdk.util.exception.ParserException;
import com.informatica.tools.sdk.util.exception.enums.ParserErrorCodes;
import com.opencsv.CSVWriter;

public class CsvWriter {

	Logger log = Logger.getLogger(CsvWriter.class);
	
	public void writeCSVFile(List<LogEntity> entities, String filePath) throws ParserException {
		writeCSVFile(filePath.replace(".log", ".csv"), entities);
	
	}
	
	private void writeCSVFile(String path, List<LogEntity> entities) throws ParserException {
        File csvFile = new File(path);
		FileWriter logFilewriter;
		try {
			logFilewriter = new FileWriter(csvFile);
		
			CSVWriter CSVWriter = new CSVWriter(logFilewriter);
	    	for (LogEntity logEntity : entities) {
	    	
	    		String[] csvLine = {logEntity.getLineNumber(), logEntity.getErrorLevel(), logEntity.getTimestamp().toString(), logEntity.getLogStatement()};
	    		CSVWriter.writeNext(csvLine);
	    	}
	    	CSVWriter.close();
		} catch (IOException e) {
			log.error("Error while creating CSV file ", e);
			throw new ParserException(ParserErrorCodes.PARSER_003, e);
		}

	}
}
