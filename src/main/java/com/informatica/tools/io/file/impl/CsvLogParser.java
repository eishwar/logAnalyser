package com.informatica.tools.io.file.impl;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import com.informatica.tools.io.file.ILogParser;
import com.informatica.tools.models.LogEntity;
import com.informatica.tools.sdk.IOrchestrator;
import com.informatica.tools.sdk.ParserContext;
import com.informatica.tools.sdk.impl.CsvWriter;
import com.informatica.tools.sdk.impl.LogExtractor;
import com.informatica.tools.sdk.impl.LogLevelChecker;
import com.informatica.tools.sdk.impl.TaskOrchestrator;
import com.informatica.tools.sdk.impl.TimestampExtractor;
import com.informatica.tools.sdk.util.LogType;
import com.informatica.tools.sdk.util.exception.ParserException;
import com.opencsv.CSVWriter;

public class CsvLogParser implements ILogParser {
	
	private final String csvFilePath;
	private LogType logType;
	
	private List<LogEntity> logs;
	
	public CsvLogParser(String csvFilePath, LogType logType) {
		this.csvFilePath = csvFilePath;
		this.logType = logType;
	}
	public void process() throws ParserException {
		 
		File logFile = new File(ClassLoader.getSystemResource(csvFilePath).getFile());
		IOrchestrator orchestrator = new TaskOrchestrator();		
		orchestrator.addHandler(new LogExtractor());
		orchestrator.addHandler(new LogLevelChecker());
		orchestrator.addHandler(new TimestampExtractor());
		ParserContext context = ParserContext.builder().inputFile(logFile)
				.logType(logType).build();
		orchestrator.process(context);
		CsvWriter csvWriter = new CsvWriter();
		csvWriter.writeCSVFile(context.getLogEntities(), ClassLoader.getSystemResource(csvFilePath).getFile());
		this.logs = context.getLogEntities();
	}

	

	public List<LogEntity> getLogs() {
		return this.logs;
	}

	

}
