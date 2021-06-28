package com.informatica.tools.sdk.impl;

import com.informatica.tools.sdk.IHandler;
import com.informatica.tools.sdk.ParserContext;
import com.informatica.tools.sdk.util.exception.ParserException;

public class LogExtractor implements IHandler {

	@Override
	public void process(ParserContext context) throws ParserException {
		context.getLogEntity().setLogStatement(context.getLogLine());;

	}

}
