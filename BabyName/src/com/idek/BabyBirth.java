package com.idek;

import org.apache.commons.csv.*;
import edu.duke.*;
//import java.io.File;
//import java.text.DecimalFormat;

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
	
public int getRank(String name , String gender , int year){
		
	    System.out.println("entered get rank");
		String fileName = "C:\\Users\\ASUS DESKtop\\Documents\\BabyInformation\\yob" + String.valueOf(year) + "short.csv";
		
		int rank = 0;
		FileResource fr = new FileResource(fileName);
		for(CSVRecord rec : fr.getCSVParser(false)){
			
			if(!rec.get(1).equals(gender))
			   continue;
			
			rank = rank + 1;
			if(rec.get(0).equals(name)){
				
				System.out.println("exitting get rank");
				
				return rank;
			}
			
		}
		System.out.println("exitting get rank");
		return -1;
		
	}

public String getName(int year , int rank , String gender){
	
	String fileName = "C:\\Users\\ASUS DESKtop\\Documents\\BabyInformation\\yob" + String.valueOf(year) + "short.csv";
	FileResource fr = new FileResource(fileName);
	int currRank = 0;
	for(CSVRecord rec : fr.getCSVParser(false)){
		
		if(!rec.get(1).equals(gender))
		   continue;
		currRank = currRank + 1;
		if(currRank == rank)
			return rec.get(0);
		
		}
	
	return "NO NAME";
	
	
    }

 public void WhatIsNameInYear(String name , int year , int newYear , String gender){
	
	int rank = getRank(name , gender , year);
	String newName = getName(newYear , rank , gender);
	if(newName.equals("NO NAME"))
	   newName = "Unspecified";
	
	System.out.println(name + " born in " + year + " would be named " + newName + " if " + (gender == "M" ? "he" : "she") + " was born in " + newYear);
	
	
	}
 
 
   public void testWhatIsNameInYear(){
	   WhatIsNameInYear("Isabella" , 2012 , 2014, "F");
	  
	   
   }


   public void testGetName(){
	   
	 System.out.println(getName(2012 , 2 , "M"));  
	 System.out.println(getName(2012 , 3 , "F")); 
	 System.out.println(getName(2012 , 10 , "M"));  
   }
   
   public void testGetRank(){
		
		System.out.println(getRank("Mason" , "M" , 2012));
		System.out.println(getRank("Mason" , "F" , 2012));

	}
	

	public void testTotalBirths(){
		
		 FileResource fr = new FileResource();
		 totalBirths(fr);
		
	}	
	
	
	public void testClassMethods(){
	
		testTotalBirths();	
		testGetRank();
		testGetName();
		testWhatIsNameInYear();
	
		}	
	
}
