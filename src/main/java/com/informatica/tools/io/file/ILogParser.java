package com.informatica.tools.io.file;

import java.util.List;

import com.informatica.tools.models.LogEntity;
import com.informatica.tools.sdk.util.exception.ParserException;

public interface ILogParser {
	
	public void process() throws ParserException;
	
	public List<LogEntity> getLogs();

}
