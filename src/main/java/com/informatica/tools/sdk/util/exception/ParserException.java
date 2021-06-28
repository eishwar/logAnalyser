package com.informatica.tools.sdk.util.exception;

import com.informatica.tools.sdk.util.exception.enums.ParserErrorCodes;

public class ParserException extends Exception {
	
	public ParserException(ParserErrorCodes error) {
		super(error.getErrorMessage());
	}
	
    public ParserException(ParserErrorCodes error, Throwable t) {
		super(error.getErrorMessage(), t);
	}

    public ParserException(ParserErrorCodes error, Throwable t, String...args) {
    	super(String.format(error.getErrorMessage(), args), t);
	}
    
    public ParserException(ParserErrorCodes error, String...args) {
    	super(String.format(error.getErrorMessage(), args));
	}
}
