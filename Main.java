package outLab3.lightfoot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	static String[][] matrix = new String[7][6];
	static int[][] matrix2 = new int[6][6];
	static char[] key = {'A', 'B', 'C', 'D', 'E', 'F'};
	public static void print(){ //prints 2D Array Matrix
		System.out.println("Matrix\n" + "-----------");
		System.out.println("A B C D E F");
		for(int row = 0; row < matrix2.length; row++){
			for(int col = 0; col < matrix2[row].length; col++){
				System.out.print(matrix2[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException{
		try{
			BufferedReader readInput = new BufferedReader(new FileReader("folder/matrix.txt"));
			String line = null;
			System.out.println("**File Found**\n");
			String[] data;
			for(int row = 0; row < matrix2.length; row++){			//Storing file matrix to a 2D Array
				line = readInput.readLine();
				data = line.split(",");
				
				for(int col = 0; col < matrix2[row].length; col++){
					int val = Integer.parseInt(data[col]);
					matrix2[row][col] = val;
				}
			}
			readInput.close();	
			} catch(FileNotFoundException e){
				System.out.println("**File Not Found**");
			}
		print();
	}
}