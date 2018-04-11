/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primalgo;

import java.util.*;
import java.io.*;


//necessary import for program
/**
 *
 * @author Benjamin Naylor Lab Partners Brendan Smith, Westin Lightfoot
 * Date 4/9/2018
 * OverView Example of Prims Algorithim
 * 
 *Citations
 * ForGeeks, Geeks. “Greedy Algorithms | Set 5 (Prim's Minimum Spanning Tree (MST)).” GeeksforGeeks, GeeksforGeeks, 20 June 2017, www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/.
 */


//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////

 class PrimAlgo{
//create the graph - move buffered reader here?
    
    public PrimAlgo(){
    
    }//creates an empty constructor so we can call methods from Prim algo
    
    private int Vsize = 6;//size of our matrix edge
    
    //////////////////////////////////////////////////////////////
    int FindMin(int Value[], Boolean VerticeVist[]){
    
        int least = 800;
        int least_index = 0;//asigns least to the first value of the array to check for min
        
        for(int i = 0; i < Vsize; i++){
            if(Value[i] < least && VerticeVist[i] == false){
                least = Value[i];//assigns minimum value to least
                least_index = i;//assigns the location of the index of least
            }//end of if
        }//end of for loop
        
        return least_index;//returns the min value
    }//end of find min method
    
    //////////////////////////////////////////////////////////////
    
    void Algo(int Matrix[][]){
        
        int parent[] = new int[Vsize];//creates aan array to store parent vertices
        
        int Value[] = new int[Vsize];//create a new array to hold the values of edges
        
        Boolean Visted[] = new Boolean[Vsize];//creates a boolean array to check if we visited the vertices
        
        for(int i = 0; i < Vsize; i++){
            Value[i] = 500;
            Visted[i] = false;
               //assigns our default infinite value to the keys before we change those values
        }//end of for loop
        
        //Eliminate all loops and Parallel Edges so first Vertices must have 0 value to itself
        Value[0] = 0;//This shall be the value of our first vertex
        parent[0] = 0;//This is root has no parent only children
        
        
        //Number of Vertices = Vsize
        for(int j = 0; j < Vsize - 1; j++){
            int Min = FindMin(Value, Visted);//returns and assigns the minimum value by calling the FindMin method
            
            //say we visted the vertex
            Visted[Min] = true;
            
                //update values and parent array for the vertices of the picked
                for(int p = 0; p < Vsize; p++){
                    if(Matrix[Min][p]!=0 && Matrix[Min][p] < Value[p] && Visted[p] == false){
                        parent[p] = Min;
                        Value[p] =  Matrix[Min][p];
                    }//end of if statement
                }//end of for loop
                
        }//end of for loop
                
      PrintPrim(parent, Vsize, Matrix);//calls the print method to print the algorithim after it is done running  
    }//end of algo method
    
    //////////////////////////////////////////////////////////////
    void PrintPrim(int parent[], int num ,int matrix[][]){
        System.out.println("Edges    Weights");
        
        int total =0;
        for(int i =1; i < Vsize; i++){
            System.out.println(parent[i] + " - " + i + "      "+ matrix[i][parent[i]]);
            
            total = total + matrix[i][parent[i]];
        }//end of for loop
        
        System.out.println("The Total of the minimum pathway is "+ total);//prints out the total of the traveled pathway
    }//end of PrintPrim
    
    
}//end of prim algo class

