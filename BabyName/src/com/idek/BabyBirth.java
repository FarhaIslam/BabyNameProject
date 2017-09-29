package com.idek;

import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;

public class BabyBirth {
  
	public static void main(String[] args){
	    
		BabyBirth births = new BabyBirth();
	    births.testClassMethods();
		
	 }
	
	public void printNames(){
		
		FileResource fr =new FileResource();
		for(CSVRecord rec : fr.getCSVParser(false)){
			
			int numBorn = Integer.parseInt(rec.get(2));
			if(numBorn <= 100){
				
				System.out.println("Name :" + rec.get(0) + ", Gender :" + rec.get(1) + ", Num born" + rec.get(2));
				
			}
		
		}	
		
	}
	
	public void totalBirths(FileResource fr){
		 
		 int totalBirths = 0;
		 int maleBirths = 0;
		 int femaleBirths = 0;
		 for(CSVRecord rec : fr.getCSVParser(false)){
			 
			  int numBorn = Integer.parseInt(rec.get(2));
			  if(rec.get(1).equals("M"))
				  maleBirths += numBorn;
			  else
				  femaleBirths += numBorn;
			  
		     }
		 totalBirths = maleBirths + femaleBirths;
		 System.out.println("Total births :" +totalBirths);
		 System.out.println("Total maleBirths :" + maleBirths);
		 System.out.println("Total femalebirths :" +femaleBirths);
		
	}
	public void testTotalBirths(){
		
		 FileResource fr = new FileResource();
		 totalBirths(fr);
		
	}	
	public void testClassMethods(){
		
	testTotalBirths();	
	
	}	
	
	
}
