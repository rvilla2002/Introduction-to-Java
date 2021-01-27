/* This program inouts the speed of the driver and if he was in a school zone and calculates the 
* cost of the speeding ticket.
*
*@author: Rishi Villa
*Collaborators: None
*Teacher's Name : Ms.Garg
*Period 5
*Due Date: 10/17/2018
*/

import java.util.Scanner;

public class SpeedingTicket 

{
	/** Define your static constants here */
	public static final int MIN_COST = 50;
	public static final int STAND_RATE = 7;
	public static final int SCHOOL_RATE = 15;
	public static final int EXCESSIVE_SPEED = 30;
	public static final int EXCESSIVE_SPEED_COST = 175;
				

	public static void main(String[] args) 
	{
		/*This block of the code declares the scanner and takes keyboard input for the driver's 
		*name
		*/
		Scanner input = new Scanner(System.in);
		System.out.print("Enter driver's name : ");
		String name = input.nextLine();
		
		//This block of code takes in keyboard input for the driver's speed
		
		System.out.print("Enter driver's speed: ");
		int driverSpeed = input.nextInt();
		
		//This block of code takes keyboard input takes the official speed limit
		
		System.out.print("Enter the speed limit: ");
		int speedLimit = input.nextInt();
		input.nextLine();
		
		/*This prompts the user if the driver was in a school zone and takes keyboard input of yes or no
		 */
		 
		 System.out.print("Was driver in a school zone? ");
		 String zoneDetection = input.nextLine();
		 System.out.println();
		 
		 //This declares the value of the ticket cost by using the calcTicket method
		 
		 int ticketCost = calcTicket(driverSpeed, speedLimit,zoneDetection);
		 
		 /*This block of code prints out the statements of speed, limit and if the driver
		  * was in a school zone or not using printf statement
		  */
		  
		  
		 System.out.printf("Speed traveled:%4d\n", driverSpeed);
		 System.out.printf("Speed limit:%7d\n", speedLimit);
		 System.out.printf("In school zone:%4s\n", zoneDetection);
		 System.out.println(name + " owes $" + ticketCost);
		 
		 System.out.println();
		  
		 
	
	
	
	
	
	
	
	
		
		
	}

	/** 
	 *This method uses if/else statements to calculate the total cost using values
	 *from variables that were previously declared
	 */ 
	public static int calcTicket(int speedDriving, int speedLimit, String schoolZone)
	{
	
		int cost = MIN_COST;
		int speedExcess = speedDriving - speedLimit;
		
	
		 if (schoolZone.equalsIgnoreCase("Yes"))
		 {
		 	cost = cost + speedExcess * (SCHOOL_RATE);
		 }
		else
		{
			cost = cost + speedExcess * (STAND_RATE);
		}
		if(speedExcess > EXCESSIVE_SPEED)
		{
			cost = cost + EXCESSIVE_SPEED_COST;
		}
		return cost;
	}
}		