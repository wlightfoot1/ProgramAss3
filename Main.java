package outLab3.lightfoot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Westin Lightfoot
 * Program 3
 * 
 * In the input text file I ignored the first line, (A,B,C,D,E,F)
 * Used INF(500) for the palce of "*" in my input file
 * 
 * 
 */

public class Main {
	static int[][] matrix = new int[6][6];
	public static void print(){ //prints 2D Array Matrix
		System.out.println("Initial Matrix\n");
		System.out.println("A\tB\tC\tD\tE\tF");
		for(int row = 0; row < matrix.length; row++){
			for(int col = 0; col < matrix[row].length; col++){
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println("*******************************"
				+ "**************");
	}

	public static void main(String[] args) throws IOException{
		Graph call = new Graph();
		try{
			BufferedReader readInput = new BufferedReader(new FileReader("folder/adj graph.txt"));
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
		call.floyd(matrix); //passing the matrix to floyd's 
	}
}