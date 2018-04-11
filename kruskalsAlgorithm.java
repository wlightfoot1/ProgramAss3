package programming_assignment_3;


public class kruskalsAlgorithm {
	public static void main(String[] args) {
		int [][] matrix = new int[6][6];
		int [] parent = new int [6];
		int numberofEdges = 0;
		int n, x, y, a=0, b=0, sum = 0, min;
		
		
	}

/*
 * Brendan Smith
 * Program 3
 * Kruskal's Algorithm
 */

//find minimum value in the matrix
//go to the next value/node (iterate through matrix)
//compare to next value to see if a cycle is created
//if it is not a cycle-> add to the minimum spanning tree
//if it is a cycle-> do nothing and move to next value/node
//go through all nodes and print edges of MST

//NOTE: if the parent contains itself then it is indeed a cycle
//a parent is all the nodes in the list prior to the current node

public class kruskalsAlgorithm {
    public static int numVertices = 6;
    
    public static int getMinValue(int[][] matrix) {
        int minimum = 99999;
        int minIndex = 0;
        for(int i = 0; i < numVertices; i++) {
        		for(int j = 0; j < matrix[i].length; j++) {
        			if(matrix[i][j] < minimum ) {
        				minimum = matrix[i][j];
        				minIndex = j;
        			}
        		}
        }
        System.out.print("Min value: "+ minimum);
        return minIndex; 
    }
    public static int getNextValue(int[][] matrix) {
    		for(int i = 0; i < numVertices; i++) {
    			
    		}
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
