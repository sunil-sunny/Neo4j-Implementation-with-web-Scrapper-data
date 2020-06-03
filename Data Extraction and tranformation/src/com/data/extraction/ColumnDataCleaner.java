package com.data.extraction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ColumnDataCleaner {
	
	private File ParkFile;

	public File getParkFile() {
		return ParkFile;
	}

	public void setParkFile(File parkFile) {
		ParkFile = parkFile;
	}
	
	File transformData() {
		
		FileReader reader=null;
		BufferedReader bufferReader=null;
		File resultFile=null;
		FileWriter writter=null;
		BufferedWriter bufferWritter=null;
	
		try {
			reader=new FileReader(ParkFile);
			bufferReader=new BufferedReader(reader);
			resultFile=new File("file2.csv");
			writter=new FileWriter(resultFile);
			 if (resultFile.exists()){
				 resultFile.delete();
			 }
			bufferWritter=new BufferedWriter(writter);
			int[] columnNumberToSeperate= {0,1,5,6,7,8};
			//int size=columnNumberToSeperate.length;
			String line;
			while((line=bufferReader.readLine())!=null) {
				
				String data[]=line.split(",");
				for(Integer i:columnNumberToSeperate) {
				
						bufferWritter.write(data[i].trim());
						bufferWritter.write(",");	
		
				}
				bufferWritter.newLine();
				
			}
			
			bufferReader.close();
			bufferWritter.close();
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return resultFile;

		
		
		
	}

}
