package com.team1601.FRC_2016.Utilities;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

class Log {
    	private final Logger logger;

    	public Log(String className){
    		logger = Logger.getLogger(className);
      	  logger.setLevel(Level.ALL);
          logger.setUseParentHandlers(false);
          ConsoleHandler ch = new ConsoleHandler();
          ch.setLevel(Level.ALL);
          logger.addHandler(ch);
    	}
    	public void logSevere(String message){
    		logger.log(Level.SEVERE, message);
    	}
    	public void logWarning(String message){
    		logger.log(Level.WARNING, message);
    	}
    	public void logInfo(String message){
    		logger.log(Level.INFO, message);
    	}
    	public void logConfig(String message){
    		logger.log(Level.CONFIG, message);
    	}
    	public void logFine(String message){
    		logger.log(Level.FINE, message);
    	}
    	public void logFiner(String message){
    		logger.log(Level.FINER, message);
    	}
    	public void logFinest(String message){
    		logger.log(Level.FINEST, message);
    	}

    	
    }