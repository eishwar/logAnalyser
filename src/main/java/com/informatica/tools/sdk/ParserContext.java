package com.informatica.tools.sdk;

import java.io.File;
import java.util.List;

import com.informatica.tools.models.LogEntity;
import com.informatica.tools.sdk.util.LogType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParserContext {
	List<LogEntity> logEntities;
	String logLine;
    File inputFile;
    LogEntity logEntity;
    LogType logType;
}
