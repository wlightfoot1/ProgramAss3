package programming_assignment_3;
import java.util.*;
import java.lang.*;
import java.io.*;

public class prim {
	// A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
	// The program is for adjacency matrix representation of the graph
	 
	    // Number of vertices in the graph
	    int V = 6;
	 
	    // A utility function to find the vertex with minimum key
	    // value, from the set of vertices not yet included in MST
	    int minKey(int key[], Boolean mstSet[])
	    {
	        // Initialize min value
	        int min = Integer.MAX_VALUE, min_index=-1;
	 
	        for (int i = 0; i < V; i++)
	            if (mstSet[i] == false && key[i] < min)
	            {
	                min = key[i];
	                min_index = i;
	            }
	 
	        return min_index;
	    }
}
