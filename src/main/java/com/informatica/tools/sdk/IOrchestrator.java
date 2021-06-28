package com.informatica.tools.sdk;

import com.informatica.tools.sdk.util.exception.ParserException;

public interface IOrchestrator {

	public void process(ParserContext context) throws ParserException;
	public void addHandler(IHandler handler);
}
