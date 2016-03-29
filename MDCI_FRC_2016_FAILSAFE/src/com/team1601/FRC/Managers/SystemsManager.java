package com.team1601.FRC.Managers;

import java.io.IOException;

import com.team1601.FRC_2016.Utilities.RIOTextFile;

public class SystemsManager {
RIOTextFile file = new RIOTextFile("Test.txt");
private static SystemsManager manager = new SystemsManager();
public static SystemsManager getInstance(){
	return manager;
}
private SystemsManager(){
	// Exist to prevent use anywhere else.
}

public void read(){
	
			try {
				file.readFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		


}

public boolean getDriveBaseStatus(){
	return file.getDataAtElement(0);
}

public boolean getArmBaseStatus(){
	return file.getDataAtElement(1);
}

public boolean getCameraBaseStatus(){
	return file.getDataAtElement(2);
}

public boolean getClimbBaseStatus(){
	return file.getDataAtElement(3);
}

public boolean getAutoBaseStatus(){
	return file.getDataAtElement(4);
}
}
