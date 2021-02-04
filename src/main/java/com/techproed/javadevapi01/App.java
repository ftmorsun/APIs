package com.techproed.javadevapi01;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
 public final class App 
{
	private String name;
	private static String address;
	
	//accessor/getter method
    public String getName() {
		return name;
	}


	public void setName(String name) {
		name = name;
	}

	//accessor/getter method
	public static String getAddress() {
		return address;
	}


	public static void setAddress(String address) {
		App.address = address;
	}


	public static void main( String[] args )
    {
    	//you have to create object from this class;
    	//say();
    	Scanner scan = new Scanner(System.in);
    	String choice;
    	
    	do {
    		System.out.println("Not ");
    		choice= scan.nextLine();
    	
    	}while(!choice.equals(""));
    		
    	
    	
 
    }
}
