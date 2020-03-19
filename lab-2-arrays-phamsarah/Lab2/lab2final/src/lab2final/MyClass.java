package lab2final;

public class MyClass {
	public static int[][] repeat(int[] foo)
	{
		int i = 0;
		int[][] expandedArray;
			expandedArray = new int[foo.length][];
			
			
		for(i = 0; i < foo.length; i++){
			expandedArray[i] = new int[foo[i]];
			
			for(int j = 0; j < foo[i]; j++){
				expandedArray[i][j] = foo[i];
			}
		}
		
		return expandedArray;
	}
	
	
	public static void main(String[] args){
		int foo[] = {2, 4, 3, 1};
		
		int repeatedArray[][] = MyClass.repeat(foo);
		int j = 0;
		int i = 0;
		
		
		System.out.print("{");
		for(i = 0; i < foo.length; i++){	
			
			System.out.print("{");
			
			for(j = 0; j < foo[i]; j++){  // for - each loop does not work in this scenario
				
				System.out.print(repeatedArray[i][j]);
				
				if(j < foo[i] - 1)
					System.out.print(",");
			}
			System.out.print("}");
			if (i < foo.length - 1)
				System.out.print(",");
			
		}
		System.out.print("}");
		

	}
}
