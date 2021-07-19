package com.informatica.tools.sdk.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.informatica.tools.models.LogEntity;
import com.informatica.tools.sdk.IHandler;
import com.informatica.tools.sdk.IOrchestrator;
import com.informatica.tools.sdk.ParserContext;
import com.informatica.tools.sdk.util.LineSeparator;
import com.informatica.tools.sdk.util.exception.ParserException;
import com.informatica.tools.sdk.util.exception.enums.ParserErrorCodes;

public class TaskOrchestrator implements IOrchestrator {
	
	private Logger log = Logger.getLogger(TaskOrchestrator.class);
	
	private List<IHandler> handlers;
	
	public TaskOrchestrator() {
		this.handlers = new ArrayList<>();
	}
	
	@Override
	public void process(ParserContext context) throws ParserException {

		if (context.getInputFile() == null) {
			log.error("Input file is not available");
			throw new ParserException(ParserErrorCodes.PARSER_002);
		}
		            
		LineSeparator lineSeparator = new LineSeparator(context.getInputFile());
		List<String> logList = lineSeparator.getLogList();
		List<LogEntity> processedList = new ArrayList<LogEntity>(); 
		Integer linenumber = 1;
		for (String line: logList) {
			context.setLogEntity(createLogEntity(linenumber.toString()));
			context.setLogLine(line);
			for(IHandler handler: handlers) {
				handler.process(context);
			}
			
			linenumber++;
			processedList.add(context.getLogEntity());
		}
		context.setLogEntities(processedList);
	}

	@Override
	public void addHandler(IHandler handler) {
		this.handlers.add(handler);
	}

	private LogEntity createLogEntity(String lineNumber) {
		return LogEntity.builder().lineNumber(lineNumber).build(); 
	}
}
 