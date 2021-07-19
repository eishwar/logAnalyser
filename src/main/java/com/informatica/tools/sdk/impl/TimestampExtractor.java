package com.informatica.tools.sdk.impl;

import java.util.Date;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.informatica.tools.sdk.IHandler;
import com.informatica.tools.sdk.ParserContext;
import com.informatica.tools.sdk.util.exception.ParserException;
import com.informatica.tools.sdk.util.exception.enums.ParserErrorCodes;

public class TimestampExtractor implements IHandler{
	
	Logger log = Logger.getLogger(CsvWriter.class);

	@Override
	public void process(ParserContext context) throws ParserException {
		
		context.getLogEntity().setTimestamp(timestampExtractor(context));
		
	}
	
	Date timestampExtractor(ParserContext context) throws ParserException{
		
		String date = context.getLogLine().substring(0, 40);
		
		try {
			return new SimpleDateFormat(context.getLogType().getDateFormat()).parse(date);
			
			} catch (ParseException e) {
				log.error("Error while extracting timestamp for line : "+context.getLogLine(), e);
				throw new ParserException(ParserErrorCodes.PARSER_004, e);		
		}
		
	}

}
