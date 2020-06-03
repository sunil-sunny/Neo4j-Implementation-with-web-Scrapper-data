package com.data.extraction;

import java.io.File;

public class DataManipulatorMain {

	public static void main(String[] args) {

		File file=new File("DNR_Camping_Parks_Reservation_Data_2016.csv");
		
		ParkDataExtractor parkDataExtractor=new ParkDataExtractor();
		parkDataExtractor.setMainFile(file);
		File ParkDataFile=parkDataExtractor.getParkData();
		ColumnDataCleaner columnDataExtractor=new ColumnDataCleaner();
		columnDataExtractor.setParkFile(ParkDataFile);
		File columnExtractedFile=columnDataExtractor.transformData();
		DataCleaner dataCleaner=new DataCleaner();
		dataCleaner.setParkFile(columnExtractedFile);
		dataCleaner.transformData();
		
		
		
		
	}

}
