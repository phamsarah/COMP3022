
public class Hello {
	public static void main(String[] args){
	
		System.out.println("phamsarah:PhamSarah");
		
		int count = 0;
		int countFive = 0;
		for(int i = 0; i < 100; i++){
			count++;
			countFive++;
			
			if(i == 99)
				System.out.print(count);
			
			else if((countFive % 5) != 0)
			 System.out.print(count);
			
			else
			  System.out.println(count);
			  
			 
			}
		}
}
