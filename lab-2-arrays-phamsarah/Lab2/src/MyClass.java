
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
		
		for(int i = 0; i < foo.length; i++){
			
			
			for(j = 0; j < foo[i]; j++){
				
				System.out.println(repeatedArray[i][j]);
			}
		}
		
	}
}
