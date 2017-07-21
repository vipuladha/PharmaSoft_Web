package web.pharmasoft.util;

import org.apache.log4j.Logger;

/**
 * 
 * Utility class containing methods to log info, debug, error, etc... 
 * @author INDUSA
 * @version 1.0, Mar 1, 2015
 * TODO
 * <P>
 * Change and Defect Correction History:
 * <P>
 * Version Date Programmer Description
 * <P>
 * *******************************************************************************
 * <P>
 * 
 */
public class LoggerUtils {
	
	public static Logger debugLog = Logger.getLogger("debugLogger");	
	
	public static void info(String msg){
		debugLog.info(msg);
	}
	
	public static void debug(String msg){
		debugLog.debug(msg);
	}
	
	public static void error(String msg){
		debugLog.error(msg);
	}
	
	public static void error(String msg, Exception e){
		debugLog.error(msg, e);
	}	
}
