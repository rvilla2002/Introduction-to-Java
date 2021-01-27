/* The StudentGroup class uses instance variables and goes through the arraylist and uses 
 *algorithms to sort the elements in an arraylist by name or by ID 
 *using various methods.
 *@author Rishi Villa
 *Collaborators: None
 *Teacher Name: Ms.Garg
 *Period 5th
 *Due Date: 2/20/2019
 *
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentGroup 
{
	// Maximum number of students stored in array
	private final static int MAX_NUM_STUDENTS = 200;
	
	// Instance variables
	private Student[] students;	// array of Student objects
	private int numOfStudents;	// number of actual objects in array

	/** Constructs an empty student group with capacity for MAX_NUM_STUDENTS
	 */
	public StudentGroup() 
	{
		students = new Student[MAX_NUM_STUDENTS];
		numOfStudents = 0;
	}
	
	/** Constructs a student group with capacity for MAX_NUM_STUDENTS
	 *  and populates it with the student data found in the given file
	 *  @param fileName name of file containing student data
	 */
	public StudentGroup(String fileName) 
	{
		students = new Student[MAX_NUM_STUDENTS];
		numOfStudents = 0;
		readFile(fileName);
	}


	/*	Finds students using linear search
	 *@param name the name to search for
	 *
	 *@return the student whose name matches, or is null if not found
	 *
	 */
	public Student findByName(String name) 
	{
		String currentName = "";
		for(int i =0; i < students.length; i++){
			if(students[i] != null){
				
				currentName = students[i].getName();
				if(currentName.equalsIgnoreCase(name)){
					return students[i];
				}	
			
			}
				
		}
		
		return null;
	}
	
	/* Sorts students by name in alphabetical order using insertion sort
	 *
	 *
	 */
	public void sortByName() 
	{
		int len = students.length;
		for(int index = 1; index < len; index++){
			if(students[index] != null){
				
				Student currentStu = students[index];
				String currentStuName = currentStu.getName();
				int pos = index;
				
				while(pos > 0 && currentStuName.compareTo(students[pos - 1].getName()) < 0){
					students[pos] = students[pos-1];
					pos--; 
				}
				students[pos] = currentStu;
			}
			
		}
		
	}

	/*	Sorts the students by ID number, using Selection sort
	 */
	public void sortByID() 
	{
		int len = students.length;
		
		for(int index = 0; index + 1 < len; index++){
			if(students[index] != null){
			
			int min = index;
			for(int wow = index+1; wow < len; wow++){
				if(students[wow] != null){
				
					int id = students[wow].compareTo(students[min]);
					if(id < 0){
						min = wow;
						}
				
				
					}
				
				}
				Student tempStu = students[index];
				students[index] = students[min];
				students[min] = tempStu;
			}
		}
		
		
	}

	/*	Find the students with matching ID numbers using
	 *binary search
	 *
	 *@param id is the id number to search for
	 *
	 *@return the student whose id number matches, or null if not found
	 */
	public Student findByID(int id) 
	{
		
		int low = 0;
		int high = numOfStudents;
		while(low <= high){
			
			int middle = (low + high) /2;
			if(students[middle] != null && students[middle].getID() == id){
				return students[middle];
			}
			else if(students[middle] != null && id < students[middle].getID()){
				high = middle - 1;
			}
			else{
				low = middle + 1;
			}
		}
		return null;
	}

	/** Provides the group of students
	 *  @return the group of students as a string
	 */
	@Override
	public String toString() 
	{
		String str = "[";
		for (int index = 0; index < numOfStudents; index++) 
		{
			str += students[index].toString();
			if (index == numOfStudents - 1) 
				str += "]";
			else
				str += ",\n ";
		}
		return str;
	}

	/** Reads student entries from a given file and stores them in the array
	 *  @param fileName name of file containing student data in format
	 *         LAST<space>FIRST<space>ID<space>GPA
	 */
	private void readFile(String fileName) 
	{
		try 
		{
			// Open file for reading
			Scanner scan = new Scanner(new FileReader(fileName));
			
			// Continue reading and adding students until  no more entries
			// Entries are in form LAST<space>FIRST<space>ID<space>GPA
			while (scan.hasNextLine()) 
			{						
				String inputStr = scan.nextLine();
				Scanner strScan = new Scanner(inputStr);
				String lastName = strScan.next();
				String firstName = strScan.next();
				int id = strScan.nextInt();
				double gpa = strScan.nextDouble();

				Student stu = new Student(lastName, firstName, id, gpa);
				students[numOfStudents] = stu;
				numOfStudents++;
			}
			scan.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		} 
		catch (Exception e) 
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		}
	}
}

