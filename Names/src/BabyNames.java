/* java code to find baby names in file and print the stats*/

import java.util.*;
import java.awt.*;
import java.io.*;

public class BabyNames {

	// method to search the text file for inputted name
	public static String search(Scanner inputfile, String inputName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("output.txt");			

		while(inputfile.hasNextLine()) {
			String listName = inputName.toLowerCase();
			String listline = inputfile.nextLine();
			String lowercaseLine = listline.toLowerCase();
			
			if(lowercaseLine.indexOf(listName) == 0 && lowercaseLine.charAt(listName.length()) == ' ') {
				int year = 1920;
				int start = listName.length();
				int end =  start+1;


				while(end != lowercaseLine.length()){
					if(lowercaseLine.charAt(end) == ' '){
						String sub = lowercaseLine.substring(start,end);
						String result = String.valueOf(year) + ": " + sub; 
						System.out.println(year + ": " + sub);
						writer.println(result);
						year = year + 10;
						start = end;
					}

					end++;
				}
				String sub = lowercaseLine.substring(start,end); 
				String result = String.valueOf(year) + ": " + sub; 
				System.out.println(year + ": " + sub);
				writer.println(result);
				writer.close();
				return listline;
			}
		}
		return "";
	}


	//main method
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("** Popularity of a baby name since year 1920 **");
		System.out.println();
		System.out.print("Name? ");
		Scanner console = new Scanner(System.in);
    	String name = (console.next());

		Scanner names = new Scanner(new File("1.txt"));
		String found = search(names, name);
		if (found.length() == 0) {
			System.out.println("not found.");
		} 
		System.out.println("null");
	}
	


}

/*
1)

** Popularity of a baby name since year 1920 **
output.txt
Name? samir
1920:  0
1930:  0
1940:  0
1950:  0
1960:  0
1970:  0
1980:  920
1990:  0
2000:  798

2)
** Popularity of a baby name since year 1920 **

Name? ayush
not found.


3)
** Popularity of a baby name since year 1920 **
output.txt
Name? sam
1920:  99
1930:  131
1940:  168
1950:  236
1960:  278
1970:  380
1980:  467
1990:  408
2000:  466

*/