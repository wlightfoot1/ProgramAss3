package primalgo;

public class Graph {
	private static int size = 6;
	private static int INF = Integer.MAX_VALUE;
	private static int[][] holdDist = new int[size][size];
	public Graph(){
		
	}
	
	//Prims Algorithm
	public void prims(int[][] matrix){
		
	}
	
	//Kruskal’s Algorithm
	
	//Floyd-Warshall’s Algorithm
	public void floyd(int[][] a){
		int i, j, k;

		for(i = 0; i < size; i++){
			for(j = 0; j < size; j++){
				holdDist[i][j] = a[i][j];
			}
		}
		for(k = 0; k < size; k++){
			for(i = 0; i < size; i++){
				for(j = 0; j < size; j++){
					if(holdDist[i][k] + holdDist[k][j] < holdDist[i][j]){
						holdDist[i][j] = holdDist[i][k] + holdDist[k][j];
						print(holdDist);
					}
				}
			}
		}
		//print(holdDist);
	}
	public void print(int[][] dist){
		for(int row = 0; row < holdDist.length; row++){
			for(int col = 0; col < holdDist[row].length; col++){
				System.out.print(holdDist[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
