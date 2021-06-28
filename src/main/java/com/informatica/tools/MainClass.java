package com.informatica.tools;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.informatica.tools.io.file.ILogParser;
import com.informatica.tools.io.file.impl.CsvLogParser;
import com.informatica.tools.models.LogEntity;
import com.informatica.tools.sdk.util.LogType;
import com.opencsv.CSVWriter;
public class MainClass {
	
	public static final String logFile = "C:\\Program Files\\Informatica Cloud Secure Agent\\apps\\process-engine\\logs\\catalina.2021-01-11.log";
	
	public static void main (String...args) throws Exception {
		 ILogParser parser = new CsvLogParser(logFile, LogType.AGENT_CORE_LOG);
		 parser.process();
		 parser.getLogs();
	}


}
