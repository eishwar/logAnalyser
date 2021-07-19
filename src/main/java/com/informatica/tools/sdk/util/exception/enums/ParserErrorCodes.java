package com.informatica.tools.sdk.util.exception.enums;

import lombok.Getter;

public enum ParserErrorCodes {
	
	
	
	PARSER_001("Exception occured while processing Log file: {}."),
	PARSER_002("Input file in not available."),
	PARSER_003("Error while creating CSV file"),
	PARSER_004("Error while extracting timestamp");
	
	@Getter
	private String errorMessage;

	ParserErrorCodes(String string) {
		this.errorMessage = string;
	}
	
	 

}
