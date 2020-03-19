import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutputLab {
	public static void main(String[] args) {
		
		try {
			
			FileInputStream inFile = new FileInputStream("src/input.csv");
			Scanner inStream = new Scanner(inFile);
			
			inStream.useDelimiter(",|\\n");
			
			String input[] = new String[16];   // Storing all inputs into a string array so that we have less variables to deal with
			String temporary = "";				// Using a temporary string to make all of the first character of the inputs upper case 
			
			for(int i = 0; i < input.length; i++) {
				
				temporary = inStream.next();
				
				if(temporary.equalsIgnoreCase("id")) {			// ID does not need to be changed and should just be stored into the array
					input[i] = temporary;
				}
				else {
					temporary = temporary.substring(0,1).toUpperCase() + temporary.substring(1).toLowerCase();
					input[i] = temporary;
				}
			}
			
			
			FileOutputStream outFile = new FileOutputStream ("src/output.txt");
			PrintWriter outFileStream = new PrintWriter(outFile);
			
			for(int i = 0; i < input.length; i++) { 			// Iterating over each position in the array
				switch(i) {
					case 0: 				// First column are all 5 spaces
					case 4:
					case 8:
					case 12:
						outFileStream.printf("%-5s| ", input[i]);
						break;
						
					case 1:
						outFileStream.printf("%-3s| ", input[i]);		// From the sample, salary does not appear to be right justified, so ID has a space after it
						break;
						
					case 5:												// Salary column is right justified, so there is no space after the ID
					case 9:
					case 13:
						outFileStream.printf("%-3s|", input[i]);
						break;
					
					case 2:
						outFileStream.printf("%-7s| ", input[i]);		
						break;	
						
					case 6: 
					case 10:
					case 14:
						outFileStream.printf("%7s | ", input[i]);
						break;
						
					case 3:
						outFileStream.printf("%-16s %n", input[i]);						// Only after years (which is in input[3] does the formatted line come after
						outFileStream.printf("-----+----+--------+-----------------");
						outFileStream.println();
						break;
						
					case 7:
					case 11:
					case 15:
						outFileStream.printf("%-16s %n", input[i]);
						break;
	
				}
				
			}
			
			outFileStream.flush();
			outFile.close();
			inStream.close();
		}
		
		catch(FileNotFoundException e) {
			System.out.println(e.getClass() + " " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getClass() + " " + e.getMessage());
		}
	}
}
