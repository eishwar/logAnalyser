package com.informatica.tools;

import com.informatica.tools.io.file.ILogParser;
import com.informatica.tools.io.file.impl.CsvLogParser;
import com.informatica.tools.sdk.util.LogType;

public class MainClass {
	
	public static final String logFile = "catalina.2021-04-28.log";
	public static void main (String...args) throws Exception {
		 ILogParser parser = new CsvLogParser(logFile, LogType.CATALINA_LOG);
		 parser.process();
		 parser.getLogs();
	}


}
