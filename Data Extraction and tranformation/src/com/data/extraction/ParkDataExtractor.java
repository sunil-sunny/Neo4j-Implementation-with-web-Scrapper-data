package com.data.extraction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParkDataExtractor {
	
	private File mainFile;

	public File getMainFile() {
		return mainFile;
	}

	public void setMainFile(File mainFile) {
		this.mainFile = mainFile;
	}
	
	File getParkData() {
		
		FileReader reader=null;
		BufferedReader bufferReader=null;
		File resultFile=null;
		FileWriter writter=null;
		BufferedWriter bufferWritter=null;
	
		try {
			reader=new FileReader(mainFile);
			bufferReader=new BufferedReader(reader);
			resultFile=new File("file1.csv");
			 if (resultFile.exists()){
				 resultFile.delete();
			 }
			writter=new FileWriter(resultFile);
			bufferWritter=new BufferedWriter(writter);
			bufferWritter.write(bufferReader.readLine().trim());
			String row;
			while((row=bufferReader.readLine())!=null) {
				
				String data[]=row.split(",");
				//System.out.println(data[2]);
				if(data[2].trim().equals("CANADA")) {
					//System.out.println("writting canda file");
					bufferWritter.newLine();
					bufferWritter.write(row.trim());
				}
				
			}
			
			bufferReader.close();
			bufferWritter.close();
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return resultFile;
		
	}

}
