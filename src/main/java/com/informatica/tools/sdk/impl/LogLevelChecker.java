package com.informatica.tools.sdk.impl;

import com.informatica.tools.sdk.IHandler;
import com.informatica.tools.sdk.ParserContext;

public class LogLevelChecker implements IHandler {

	@Override
	public void process(ParserContext context) {
		context.getLogEntity().setErrorLevel(identifyLogLevel(context.getLogLine()));		
	}
	
	private String identifyLogLevel(String logLine) {
		if (logLine.contains("ERROR")) {
			return "ERROR";
		}
		else if (logLine.contains("WARN"))
		{
			return "WARN";
		}
		else {
			return "INFO";
		}
		
	}

}
