package com.informatica.tools.sdk;

import java.io.IOException;

import com.informatica.tools.sdk.util.exception.ParserException;

public interface IHandler {
	public void process(ParserContext context) throws ParserException;

}
