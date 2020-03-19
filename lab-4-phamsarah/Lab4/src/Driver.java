import java.util.Scanner;
public class Driver {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int miles = 0;
		int gallons = 0;
		final int MAX = 50;
		int [] totalMiles = new int[MAX];
		int [] totalGallons = new int[MAX];
		int i = 0;
		int sumOfMiles = 0, sumOfGallons = 0;
		
	do{
		try{
			miles = getMiles(scnr);
			gallons = getGallons(scnr);
			
			if(miles > 0 && gallons > 0)
			{
				totalMiles[i] = miles; 
				totalGallons[i] = gallons;
				i++;
			}
			
		}
		
		catch(NegativeNumberException foo)
		{
			System.out.println(foo.getMessage());
		}
		
		catch(Exception e){
			break;
		}
		
		System.out.println("---------------------- " );
	}while(true);
		
	System.out.print("Average miles per gallon: (");
		
		for(int j = 0; j < i; j++){
			System.out.print(totalMiles[j]);
			sumOfMiles = sumOfMiles + totalMiles[j];
			
			if(totalMiles[j + 1] > 0)
				System.out.print(" + ");
			
			else {
				System.out.print(")/(");
				for(j = 0; j < i; j++) {
					System.out.print(totalGallons[j]);
					sumOfGallons = sumOfGallons + totalGallons[j];
					
					if(totalGallons[j + 1] > 0)
						System.out.print(" + ");
					else {
						
						int milesPerGal = sumOfMiles/sumOfGallons;
						System.out.print(") = " + milesPerGal);
					}
				}
			}
		}
		
		
		
	}
	
	public static int getMiles(Scanner scnr) throws NegativeNumberException{
		System.out.print("Enter miles driven on this tank :");
		int input = scnr.nextInt();
		checkIsPositive(input);
		return input;
	}
	
	public static int getGallons(Scanner scnr) throws NegativeNumberException{
		System.out.print("Enter number of gallons: ");
		int input = scnr.nextInt();
		checkIsPositive(input);
		return input;
	}
	
	private static void checkIsPositive(int input) throws NegativeNumberException{
		if(input < 0){
			throw new NegativeNumberException("Negative value detected - my exception");
		}
	}
	
}
