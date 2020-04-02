package search_engine;

import java.util.Arrays;
import java.util.Comparator;

public class sort {
	public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
                        
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] < entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
	
	 public static void main(String args[]) 
	    { 
	        int matrix[][] = { { 1, 8 }, 
	                           { 11, 5 }, 
	                           { 3, 3 }, 
	                           { 4, 0} }; 
	        // Sort this matrix by 3rd Column 
	        int col = 2; 
	        sortbyColumn(matrix, col - 1); 
	  
	        // Display the sorted Matrix 
	        for (int i = 0; i < matrix.length; i++) { 
	            for (int j = 0; j < matrix[i].length; j++) 
	                System.out.print(matrix[i][j] + " "); 
	            System.out.println(); 
	        } 
	        
	        String s="1.txt";
	        System.out.println(s.split(".txt")[0]);
	    } 
	
	
}
