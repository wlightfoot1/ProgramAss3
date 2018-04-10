





package primalgo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Westin Lightfoot
 * Program 3
 * 
 * In the input text file I ignored the first line, (A,B,C,D,E,F)
 * Used "*" for the INF in my input file
 * 
 * 
 */

public class Main {
	static int[][] matrix = new int[6][6];
	
	//static char[] key = {'A', 'B', 'C', 'D', 'E', 'F'};
	public static void print(){ //prints 2D Array Matrix
		System.out.println("Matrix\n" + "-----------");
		System.out.println("A B C D E F");
		for(int row = 0; row < matrix.length; row++){
			for(int col = 0; col < matrix[row].length; col++){
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException{
		Graph call = new Graph();//creates a new instance of the Graph 
                PrimAlgo newPrim = new PrimAlgo();//creates a new instance of the Prim Algo
                
		try{
			BufferedReader readInput = new BufferedReader(new FileReader(".\\src\\Input\\matrix.txt"));
			String line = null;
			System.out.println("**File Found**\n");
			String[] data;
			for(int row = 0; row < matrix.length; row++){			//Storing file matrix to a 2D Array
				line = readInput.readLine();
				data = line.split(",");
				for(int col = 0; col < matrix[row].length; col++){
					if(data[col].equals("*")){
						int INF = 500;
						matrix[row][col] = INF;
					} else{
						int val = Integer.parseInt(data[col]);
						matrix[row][col] = val;
					}
				}
			}
			readInput.close();	
			} catch(FileNotFoundException e){
				System.out.println("**File Not Found**");
			}
		print();
		//call.floyd(matrix);
                
                System.out.println("Run Prim");
                newPrim.Algo(matrix);//calls the algo method
                 System.out.println("End of Prim");
                
                
	}
}