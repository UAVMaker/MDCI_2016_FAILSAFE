package com.team1601.FRC_2016.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RIOTextFile {
	/**
	 * This class provide a file reader. It takes the file from the RIO and
	 * reads it out.
	 */
	private boolean[] booleansFromTextFile = new boolean[6];
	private File file;
	private FileReader inputFileReader = null;
	private BufferedReader bufferReader = null;

	public RIOTextFile(String URL) {
		try {
			file = new File(URL);
			inputFileReader = new FileReader(file);
			bufferReader = new BufferedReader(inputFileReader);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public void readFile() throws IOException {
		int i =0;
		int indexVal;
		while(true){
			String currentLine = bufferReader.readLine();
			
			if(currentLine == null){
				break;
			}
			indexVal = currentLine.indexOf("On");
			
			
			if(indexVal == -1){booleansFromTextFile[i] = false;}
			else{booleansFromTextFile[i] = true;}
			i++;
		}
		}
	

	public boolean getDataAtElement(int i) {
		return booleansFromTextFile[i];
	}

}