package com.team1601.FRC_2016.AutonomousMode;

import java.util.ArrayList;

public class AutonomousControl {
private static AutonomousControl instance;

public static AutonomousControl getInstance(){
	if(instance == null){
		instance = new AutonomousControl();
	}
	return instance;
}
private int autonMode;
private AutonomousMode activeMode;
private int autonDelay;
private long autonStartTime;

private boolean running;
private ArrayList<AutonomousMode> autonModes;

private int currIndex;
private Action[] commands;

private AutonomousControl(){
	  this.autonMode = 0;
      this.autonDelay = 0;
      this.currIndex = 0;
      
      this.autonModes = new ArrayList<>();
      
      /*
       * Insert Modes Here
       */
}

public void initialize() {
    
    
    this.currIndex = 0;
    this.running = true;

    
    // initialize auton in runCycle
    this.activeMode = (AutonomousMode)this.autonModes.get(this.autonMode);
    this.commands = this.activeMode.getMode();
   

    this.autonStartTime = System.currentTimeMillis();
    
}

public void runCycle() {
    // haven't initialized list yet
    long timeElapsed = System.currentTimeMillis() - this.autonStartTime;
    if(timeElapsed > this.getAutonDelayLength() && this.running) {
         // start waiting commands
            while(this.currIndex < this.commands.length) {
                this.currIndex++;
           
        }
        // calculate call for all running commands
       execute();
    } 


}

public void execute(){
	for(int i = 0; i < commands.length; i++) {
        // if that component has a command running
        if(commands[i] != null) {
            // run command
            
            boolean done = commands[i].runCommand();
            // finished, so remove
            if(done) {
                commands[i] = null;
            }
        }
    }
}

public void stop() {
    this.running = false;
}

public long getAutonDelayLength() {
    return (long)(this.autonDelay * 500);
}
}
