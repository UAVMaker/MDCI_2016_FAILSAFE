package com.team1601.FRC_2016.AutonomousMode;

public abstract class Action {
    private long timeout = -1;
    private long startTime = -1;
    
    public Action(long timeout){
    this.timeout = timeout;
    }
    public Action(){
    this(-1);
    }
    
    public abstract boolean calculate();
    public abstract void override();
    
    public boolean runCommand() {
    	if(this.startTime < 0) {
    		this.startTime = System.currentTimeMillis();
    	}
    	
    	boolean done = this.calculate();
    	long timePassed = System.currentTimeMillis() - this.startTime;
    	
    	if(this.timeout > 0 && timePassed > this.timeout) {
    		System.out.println("TIME OUT OCCURED " + this.getClass().getName());
    		this.override();
    		return true;
    	} else if(done) {
    		return true;  	
    	} else {
    		return false;
    	}
    }
    

    

}
