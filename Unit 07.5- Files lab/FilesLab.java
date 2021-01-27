/*
 @author: Rishi Villa
 Collaborators:None
 @Teacher : Ms.Garg
 @Due date : 12/13/2018
 Period: 5th period
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesLab 
{
	public static void main(String[] args) 
	{
		try
		{
			// run 70-point version
			processIntegers("test1.txt", "output1.txt");
			System.out.println();
			
			// run 85-point version
			testLines("test2a.txt", "output2a.txt");
			
			// run 85-point version
			testLines("test2b.txt", "output2b.txt");
			System.out.println();
			
			// run 100-point version - good data
			extractSubstrings("test3a.txt", "output3a.txt");		
			
			// run 100-point version - bad data
			extractSubstrings("test3b.txt", "output3b.txt");		
			System.out.println();
		}
		catch (Exception exc)
		{
			System.out.println("Error opening file: " + exc.getMessage());
		}
	}
	
	public static void processIntegers(String inFile, String outFile) throws FileNotFoundException
	{
		File inputFile = new File(inFile);
		Scanner scan = new Scanner(inputFile);
		
		int dataSets = scan.nextInt();
		String ignore = scan.nextLine();
		
		PrintWriter outputFile = new PrintWriter(outFile);
		
		for (int k = 0; k < dataSets; k++)
		{
			String line = scan.nextLine();
			Scanner read = new Scanner(line);
			
			int lesser = read.nextInt();
			int	greater = lesser;
			
			while (read.hasNextInt())
			{
				int num = read.nextInt();
				if (num < lesser)
					lesser = num;
				if (num > greater)
					greater = num;				
			}
			outputFile.println(lesser + "  " + greater);
		}

		scan.close();
		outputFile.close();
	
		
		System.out.println("lesserest and greaterst integers from " + inFile 
			+ " written to " + outFile);
	}
	
	public static void testLines(String inFile, String outFile) throws FileNotFoundException
	{
		File inputFile = new File(inFile);
		Scanner scan = new Scanner(inputFile);
		
		PrintWriter outputFile = new PrintWriter(outFile);
		
		String key = scan.next();
		String ignore = scan.nextLine();
		
		while(scan.hasNextLine())
		{
			int track = 0;
			String line = scan.nextLine();
			Scanner read = new Scanner(line);
			
			while(read.hasNext())
			{
				String word = read.next();
				
				if(key.equalsIgnoreCase(word)&& track == 0)
				{
					outputFile.println(line);
					track++;
				}	
			}		
		}
		scan.close();
		outputFile.close();

		System.out.println("Lines from " + inFile + " written to " + outFile);
	}
	
	public static void extractSubstrings(String inFile, String outFile) throws FileNotFoundException
	{
		File inputFile = new File(inFile);
		Scanner scan = new Scanner(inputFile);
		
		PrintWriter outputFile = new PrintWriter(outFile);
		while(scan.hasNextLine())
		{
			int index1 = scan.nextInt();
			int index2 = scan.nextInt();

			String line = scan.nextLine().trim();
			
			try
			{
				String subPart = ":" + getSubstring(index1, index2, line) + ":";
				outputFile.println(subPart);
			}
			catch(IllegalArgumentException exception)
			{
				outputFile.println("Error in file " + inFile + ": " + exception.getMessage());
			}
		}
				
		scan.close();
		outputFile.close();
		
		System.out.println("Requested substrings from " + inFile + " written to " + outFile);
	}
	
	private static String getSubstring(int index1, int index2, String text)
	{
		boolean part1 = (index1 < 0 || index2 < 0);
		boolean part2 = (index2 < index1);
		boolean part3 = (index1 > text.length() || index2 > text.length());
		
		if(part1 || part2 || part3)
		{
			throw new IllegalArgumentException("Invalid indexes [" + index1 
				+ ", " + index2 + ") for \"" + text + "\"");
		}
		
		String result = text.substring(index1, index2);
		return result;
	}
}
