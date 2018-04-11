package primalgo;

public class Graph {
	private static int size = 6;
	private static int INF = Integer.MAX_VALUE;
	private static int[][] holdDist = new int[size][size];
	public Graph(){
		
	}	
	//Floyd-Warshall’s Algorithm
	public void floyd(int[][] a){
		int i, j, k;

		for(i = 0; i < size; i++){	//copy original martix to holdDist array
			for(j = 0; j < size; j++){
				holdDist[i][j] = a[i][j];
			}
		}
		//loops through matrix 
		for(k = 0; k < size; k++){
			for(i = 0; i < size; i++){
				for(j = 0; j < size; j++){
					if(holdDist[i][k] + holdDist[k][j] < holdDist[i][j]){ //find the shortest dist
						holdDist[i][j] = holdDist[i][k] + holdDist[k][j];
						print(holdDist);//prints each step as it loops throught
					}
				}
			}
		}
	}
	public void print(int[][] dist){	//print method for holdDist array
		for(int row = 0; row < holdDist.length; row++){
			for(int col = 0; col < holdDist[row].length; col++){
				System.out.print(holdDist[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
