package com.data.extraction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataCleaner {
	
	private File ParkFile;

	public File getParkFile() {
		return ParkFile;
	}

	public void setParkFile(File parkFile) {
		ParkFile = parkFile;
	}
	
	void transformData() {
		
		FileReader reader=null;
		BufferedReader bufferReader=null;
		File resultFile=null;
		FileWriter writter=null;
		BufferedWriter bufferWritter=null;
	
		try {
			reader=new FileReader(ParkFile);
			bufferReader=new BufferedReader(reader);
			resultFile=new File("file3.csv");
			 if (resultFile.exists()){
				 resultFile.delete();
			 }
			writter=new FileWriter(resultFile);
			bufferWritter=new BufferedWriter(writter);
			//int size=columnNumberToSeperate.length;
			String line;
			while((line=bufferReader.readLine())!=null) {
				
				String data[]=line.split(",");
				for(int i = 0;i<data.length;i++) {
					
					if(i==5) {
						
						String rowData=data[5].trim();
						String tranfomedCell;
						
						if(rowData.contains("Less than")) {
							
							
							tranfomedCell=rowData.replace("Less than ", "LT");
							bufferWritter.write(tranfomedCell);
							bufferWritter.write(",");	
							
						}
						else if(rowData.equals("Single Tent")) {
							
							bufferWritter.write("ST");
							bufferWritter.write(",");	
							
						}
						else {
							bufferWritter.write(data[i]);
							bufferWritter.write(",");	
						}
					}
					else {
						bufferWritter.write(data[i].trim());
						bufferWritter.write(",");	
					}
					
					
		
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

		
		
		
	}

}
