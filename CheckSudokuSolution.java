package sudoku;

import java.util.Scanner;

/**
 *  
 * @author alexjasper
 */

public class CheckSudokuSolution {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] grid = readASolution();
        
        System.out.println(isValid(grid) ? "Valid Solution" : "Invalid");
 }              
    /**
     * read a sudoku solution repeatedly
     * @return 
     */          
    public static int[][] readASolution(){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a sudoku puzzle solution");
        int[][] grid = new int[9][9];
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
            grid[i][j] = input.nextInt();
            } 
        }
        
        return grid;
        
        
    }
  
    /**
     * an array which checks the if the row contains the numbers 1-9
     */
    public static boolean is1To9(int[] list){
        //copy our array 
        int[] temp = new int[list.length];
        System.arraycopy(list,0, temp,0, list.length);
        
        //sort the array in ascending order
        java.util.Arrays.sort(temp);

        for(int i = 0; i < 9; i++){
            //if the first element in the array does not equal 1, we return false
            if (temp[i] != i+1){
            return false;
            }
           
        }
        
         return true;
    }
    /**
     * The method is going to consist of all of the calculations to determine
     * if the sudoku is valid. We need to check all the rows, and all the columns
     * @param grid
     * @return 
     */
    public static boolean isValid(int[][] grid){
        
        /**
         * Firstly, validate the rows and columns
         */
        
        //check rows
        for(int i = 0; i < 9; i++){
            if (!is1To9(grid[i])){
              return false;  
            }
            
        }
        
        //check column
        for(int j = 0; j < 9; j++){
            
            //declare new array
            int[] column = new int[9];
            
            //fill the column array
            for(int i = 0; i < 9; i++){
                column[i] = grid[i][j];
            }
                if (!is1To9(column)){
                 return false;
            }
            
        }
        
        /**
         * create code which checks the elements of each cell
         */
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                
                //starting element in the 3x3 box
                int k = 0;
                int[] list = new int[9];
                for(int row = i * 3; row < i*3+3; row++){
                    for (int column = j * 3; column < j * 3+3; column++){
                      list[k++] = grid[row][column];
                 }
                }
                
                if(!is1To9(list)){
                    return false;
                }
            }
      
        }
  //it is a valid sudoku puzzle      
        return true;
  
    }
}
