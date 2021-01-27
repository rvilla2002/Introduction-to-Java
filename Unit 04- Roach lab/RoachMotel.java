/**
 * The roach mtel class calls and displays the Roach population in the kitchen and the lab
 *It also displays the population in both places
 *@author RIshi Villa
 *Collaborators: None
 *Teacher Name : Ms.Garg
 *Period : 5
 *Due date : 10/1/18
import java.util.Scanner;

public class RoachMotel 
{
	public static void main(String[] args) 
	{
		/*
		 * 70-point version
		 */

		// Using the default constructor, declare and instantiate a 
		// RoachPopulation object to represent the roach population 
		// in the computer lab. 
		// Display the initial population using the accessor method.
		RoachPopulation computerlab = new RoachPopulation();
		System.out.println("My lab has an initial population of:" + computerlab.getRoaches() + "roaches.\n");



		// Using the starting population provided by the user and 1-parameter
		// constructor, declare and instantiate a RoachPopulation object to
		// represent the roach population in your kitchen. 
		// Display initial population using the accessor method.
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter starting population of the kitchen (an integer): ");
		int initialPopulation = scan.nextInt();
		RoachPopulation kitchenRoach = new RoachPopulation();
		System.out.println("My kitchen has an initial population of " + kitchenRoach.getRoaches() + "roaches. \n");



		/*
		 * 85-point version
		 */

		// Wait for the kitchen population to double and display the results
		System.out.println("Waiting for population of kitchen to grow....");
		kitchenRoach.waitForDoubling();
		System.out.println("Kitchen now has " + kitchenRoach.getRoaches() + " roaches. \n");




		// Wait for the lab population to double and display the results
		System.out.println("Waiting for lab population to grow");
		computerlab.waitForDoubling();
		System.out.println("Lab now has " + computerlab.getRoaches() + " roaches. \n");
		




		/*
		 * 100-point version (uncomment section below)
		 */

		// Spray insecticide in the kitchen and display the results
		System.out.print("Enter strength of kitchen insecticide used (ex, 22.75): ");
		double kitchenSpray = scan.nextDouble();
		int kitchenDead = kitchenRoach.spray(kitchenSpray);
		System.out.println("My kitchen now has " + (kitchenRoach.getRoaches()-kitchenDead)+"roaches after killed" + kitchenDead + "roaches.\n");



		// Spray insecticide in the lab and display the results
		System.out.print("Enter strength of lab insecticide used (ex, 22.75): ");
		double labSpray = scan.nextDouble();
		int labDeaths = computerlab.spray(labSpray);
		System.out.println("Lab now has " + (computerlab.getRoaches()-labDeaths) + " roaches after killing" + labDeaths + "roaches. \n");


		
	}
}
		
		