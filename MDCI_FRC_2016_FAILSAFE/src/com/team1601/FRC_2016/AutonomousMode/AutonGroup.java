package com.team1601.FRC_2016.AutonomousMode;

import java.util.ArrayList;

public class AutonGroup {
	private ArrayList<Action> actions;
	
	public AutonGroup(){
		actions = new ArrayList<>();
	}
	
	public void addAction(Action action){
		actions.add(action);
	}
	public Action[] getAutoActionList(){
		//actions.add(new AutoStop());
		Action[] compiledList = new Action[actions.size()];
		compiledList = this.actions.toArray(compiledList);
		return compiledList;
	}
}
