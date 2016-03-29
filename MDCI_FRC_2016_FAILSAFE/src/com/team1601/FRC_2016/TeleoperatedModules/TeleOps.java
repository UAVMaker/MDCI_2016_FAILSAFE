package com.team1601.FRC_2016.TeleoperatedModules;

import java.util.ArrayList;

import com.team1601.FRC_2016.Interface.TeleopMode;

public class TeleOps {
private static TeleOps tele;
private ArrayList<TeleopMode> modules;
public static TeleOps getInstance(){
	if(tele == null){
		tele = new TeleOps();
	}
	return tele;
}

private TeleOps(){
	modules = new ArrayList<TeleopMode>();
	
	//modules.add(e);
}

public void runCycles(){
	for(TeleopMode t : modules){
		t.calculate();
	}
}

public void disable(){
	for(TeleopMode t : modules ){
		t.disable();
	}
}
}
