package programming_assignment_3;



import java.util.*;
import java.lang.*;
import java.io.*;
/*
 * Brendan Smith
 * Program 3
 * 
 * Kruskal's algorithm
 */


public class crustysAlgorithm {
	
    public static int minValue(int[][] matrix) {
        int inf = 500;
        int least = -1;
        int minimum = matrix[0][0];
        for(int i = 0; i < matrix.length; i++) {
        		for(int j = 0; j < matrix[i].length; j++) {
        			if(matrix[i][j] < minimum ) {
        				minimum = matrix[i][j];
        			}
        		}
        }
        return minimum;
        
    }
 // Influenced by: https://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/  
	public class Forest
	{
	    // A class to represent a graph edge
	    public class Edge implements Comparable<Edge>
	    {
	        int source, destination, weight;
	 
	        // Comparator function used for sorting edges 
	        // based on their weight
	        public int compareTo(Edge compareEdge)
	        {
	            return this.weight-compareEdge.weight;
	        }
	    };
	 
	    // A class to represent a branch for merge-find
	    public class branch
	    {
	        int rank, parent;
	    };
	 
	    int V, E;    // V-> no. of vertices & E->no.of edges
	    Edge edge[]; // collection of all edges
	 
	    // Creates a graph with V vertices and E edges
	    Forest(int v, int e)
	    {
	        V = v;
	        E = e;
	        edge = new Edge[E];
	        for (int i=0; i<e; ++i)
	            edge[i] = new Edge();
	    }
	 
	    // A utility function to find set of an element i
	    // (uses path compression technique)
	    int search(branch branches[], int i)
	    {
	        // find root and make root as parent of i (path compression)
	        if (branches[i].parent != i)
	            branches[i].parent = search(branches, branches[i].parent);
	 
	        return branches[i].parent;
	    }
	 
	    // A function that does union of two sets of a and b
	    // (uses merge by rank)
	    void mergeBranches(branch branches[], int a, int b)
	    {
	        int aRoot = search(branches, a);
	        int bRoot = search(branches, b);
	 
	        // Attach smaller rank tree under root of high rank tree
	        // (merge by Rank)
	        if (branches[aRoot].rank < branches[bRoot].rank)
	            branches[aRoot].parent = bRoot;
	        else if (branches[aRoot].rank > branches[bRoot].rank)
	            branches[bRoot].parent = aRoot;
	 
	        // If ranks are same, then make one as root and increment
	        // its rank by one
	        else
	        {
	            branches[bRoot].parent = aRoot;
	            branches[aRoot].rank++;
	        }
	    }
	 
	    // The main function to construct MST using Kruskal's algorithm
	    void MST()
	    {
	        Edge result[] = new Edge[V];  // Tnis will store the resultant MST
	        int e = 0;  // An index variable, used for result[]
	        int i = 0;  // An index variable, used for sorted edges
	        for (i=0; i<V; ++i)
	            result[i] = new Edge();
	 
	        // Step 1:  Sort all the edges in non-decreasing order of their
	        // weight.  If we are not allowed to change the given graph, we
	        // can create a copy of array of edges
	        Arrays.sort(edge);
	 
	        // Allocate memory for creating V subsets
	        branch branches[] = new branch[V];
	        for(i=0; i<V; ++i)
	            branches[i]=new branch();
	 
	        // Create V subsets with single elements
	        for (int v = 0; v < V; ++v)
	        {
	            branches[v].parent = v;
	            branches[v].rank = 0;
	        }
	 
	        i = 0;  // Index used to pick next edge
	 
	        // Number of edges to be taken is equal to V-1
	        while (e < V - 1)
	        {
	            // Step 2: Pick the smallest edge. And increment 
	            // the index for next iteration
	            Edge next_edge = new Edge();
	            next_edge = edge[i++];
	 
	            int a = search(branches, next_edge.source);
	            int b = search(branches, next_edge.destination);
	 
	            // If including this edge does't cause cycle,
	            // include it in result and increment the index 
	            // of result for next edge
	            if (a != b)
	            {
	                result[e++] = next_edge;
	                mergeBranches(branches, a, b);
	            }
	            // Else discard the next_edge
	        }
	 
	        // print the contents of result[] to display
	        // the built MST
	        System.out.println("The edges of the minimum spanning tree are ");
	        for (i = 0; i < e; ++i)
	            System.out.println(result[i].source +" -- " + 
	                   result[i].destination+" == " + result[i].weight);
	    }
	}
}
