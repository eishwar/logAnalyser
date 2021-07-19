package com.informatica.tools.models;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class LogEntity {
	Date timestamp;
	String logStatement;
	String errorLevel;
	String lineNumber;	
}
