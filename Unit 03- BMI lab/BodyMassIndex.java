// add your 6-item heading here 
/** The body mass index outputs a BMI value from users input
 *It also tells you if your BMI is considered nornal
 *@author: Rishi Villa
 *Collaborators:None
 *Teacher:Ms.Garg
 *Period: 5
 *Due date: 9/19
 */
// any imports go here
import java.util.Scanner;
public class BodyMassIndex 
{
	// Define constants for unit conversions
	public static final double CM_M = 100.0;
	public static final double P_KG = 0.453592;
	public static final double I_CM = 2.54;
	
	
	// Do not make any changes to the main!
	public static void main(String[] args) 
	{
		// 80-point version
		// Input user's weight and height in metric units and calculate BMI
		calculateMetricBMI();
		System.out.println();
		
		// 100-point version
		// Input user's weight and height in imperial units and calculate BMI
		calculateImperialBMI();
		System.out.println();
	}
	
	
	/** 
	 */
	public static void calculateMetricBMI()
	{
		// complete for 80 pt version
		// calculates the BMI and prompts the user for input
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your weight in kilograms:");
     	final int weight = scan.nextInt();	
	    System.out.println();
		scan.nextLine();
		System.out.print("Enter your height in centimeters:");
		final int height = scan.nextInt();
		System.out.println();
		scan.nextLine();
		
	    final double bmiMetric = getBMI(weight, height);
		System.out.println("A body mass index of 20 - 25 is considered \"normal\"");
		System.out.printf("Your BMI is %.2f \n", bmiMetric);
	} 
		
	
	/** the getMbi method gives the BMI from the input
	 */ 
	public static double getBMI(int weightKG, int heightCM)
	{
		// complete for 80 pt version
		// calculates BMI from the input
		final double bmiMetric = weightKG/Math.pow(heightCM/100.0,2);
		return bmiMetric;
	}
	
	/** 
	 */
	public static void calculateImperialBMI()
	{
		// complete for 100 pt version
		// Uses the BMI formula to calculate the imperial BMI from the given input
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your weight in pounds : ");
		final int WEIGHT1 = scan.nextInt();
		System.out.println();
		System.out.print("Enter your height in inches :");
		final int HEIGHT1 = scan.nextInt();
		System.out.println();
		int newWeight = convertPoundsToKG(WEIGHT1);
		int newHeight = convertInchesToCM(HEIGHT1);
		final double BMI = getBMI(newWeight, newHeight);
		
		System.out.println("A body mass index of 20-25 is considered \"normal\"");
		System.out.printf("Your BMI is: %.2f \n", BMI);
		
	}
	
	/** the converpoundstoKg method converts the pounds to KGS
	 */
	public static int convertPoundsToKG(int numPounds)
	{
		// complete for 100 pt version
		//Multiplies the user input by the constant conversion factor and rounds it up
		int newKG = (int)Math.round(numPounds*P_KG);
		return newKG;
	}
	
	/** The convertInchestoCM method converts the user input from inches to cm.
	 */
	public static int convertInchesToCM(int numInches)
	{
		// complete for 100 pt version
		//Mutliplies the user input by the constant conversion factor and rounds it .
		int newCM = (int)Math.round(numInches*I_CM);
		return newCM;
	}
}