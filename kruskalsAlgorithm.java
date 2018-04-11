package programming_assignment_3;

public class kruskalsAlgorithm {
	public static void main(String[] args) {
		int [][] matrix = new int[6][6];
		int [] parent = new int [6];
		int numberofEdges = 0;
		int n, x, y, a=0, b=0, sum = 0, min;
		
		
	}
}
	/*public static void main(String[] args) {
		  int[][] matrix = new int [6][6];
		  int [] parent = new int [6];
		  int noOfEdges=1;
		  int n, u=0, v=0, min, total=0;
		  int x,y;
		  //System.out.print("Enter the total no. nodes : ");
		  //n = nextInt();
		  //System.out.println("Enter the adjacency matrix :");
		  for(int i=0; i<n ; ++i){
		   parent[i]=0;
		   for(int j=0; j<n; ++j)
		   {
		    matrix[i][j] = nextInt();
		    if(matrix[i][j]==0)
		     matrix[i][j] = 99999;
		   }
		  }
		  while(noOfEdges < n)
		  {
		   min = 99999;
		   for(int i=0; i<n; ++i)
		    for(int j=0; j<n; ++j)
		     if(matrix[i][j]<min){
		      min = matrix[i][j];
		      u=i;
		      v=j;
		     }
		//The correction I made
		   x=u; y=v;
		   while(parent[x]!=0)
		    x = parent[x];
		   
		   while(parent[y]!=0)
		    y = parent[y];
		   
		   if(x!=y){
		    noOfEdges++;
		    System.out.println("Edge found (" + u + "," + v + ") of weight " + min);
		    total += min;
		    parent[v] = u;
		   }
		   matrix[u][v] = matrix[v][u] = 99999;
		  }
	}
}
*/
