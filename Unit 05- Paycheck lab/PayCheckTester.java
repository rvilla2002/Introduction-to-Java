
  

/**
 *Paycheck Tester Class
 *The Paycheck Tester Class uses the variables from the paycheck class.
 * @author Rishi Villa
 * Collaborators: None
 * Teacher Name:Ms. Garg
 * Period: 5
 * Due Date: 10-29-2018
 */
 
  
import java.util.Scanner;

public class PayCheckTester 
{
	public static void main(String[] args) 
	{
		// Input name and type of worker
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter employee's name: ");
		String name = scan.nextLine();
		
		System.out.print("Enter M (Manager) or S (Sales Clerk): ");
		String type = scan.next();
		System.out.println();
		
		boolean manager = type.equalsIgnoreCase("m");
		
		// Declare and instantiate a Paycheck object
		PayCheck employee = new PayCheck(name, manager);
		
		// Set the hours and sales. Display the expected wage
		changeHoursAndSales(scan, employee);
		displayWages(employee);
		
		// Change the hours and sales. Display the expected wage
		changeHoursAndSales(scan, employee);
		displayWages(employee);
		
		
	}
	
	/** Updates worker's weekly hours and sales with information
	 *  input by the user
	 *  @param scan the Scanner to use to get input from user
	 *  @param worker the Paycheck to update
	 */
	public static void changeHoursAndSales(Scanner scan, PayCheck worker)
	{
		System.out.print("Enter total number of hours worked: ");
		double hours = scan.nextDouble();
		
		System.out.print("Enter total sales generated: ");
		double sales = scan.nextDouble();
		System.out.println();
		
		// Update PayCheck object's hours and sales
		worker.setHours(hours);
		worker.setSales(sales);
	}
	
	public static void displayWages(PayCheck worker)
	{	
		if (worker.isManager())
			System.out.print("Manager " + worker.getName() + ": " + worker.getHours() + " hours");
		else
			System.out.print("Sales Clerk " + worker.getName() + ": " + worker.getHours()
				 + " hours");
		
		System.out.printf(", $%.2f in sales\n", worker.getSales());
		System.out.printf ("Total wages: $%.2f\n\n", worker.calcWages());
	}
}


