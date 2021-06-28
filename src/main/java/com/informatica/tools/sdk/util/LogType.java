package com.informatica.tools.sdk.util;

import lombok.Getter;

public enum LogType {
	
	AGENT_CORE_LOG("yyyy-MM-dd HH:mm:ss,SSS z"),
	TOMCAT_LOG("yyyy-MM-dd HH:mm:ss,SSS z"),
	SESSION_LOG("yyyy-MM-dd HH:mm:ss.SSS"),
	CATALINA_LOG("dd-MMM-yyyy HH:mm:ss.SSS z"),
	ACCESS_LOG("dd/MMM/yyyy:HH:mm:ss z"),
	POSTGRES_LOG("yyyy-MM-dd HH:mm:ss z");
	
	@Getter
	private String dateFormat;
	
	LogType(String string) {
		this.dateFormat = string;
	}

}
