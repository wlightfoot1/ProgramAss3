/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primalgo;

import java.util.*;
/**
 *
 * @author v17m935
 */

class Edges{
    int x,y,value;//value is the weight of the edge and x & y are the index within our matrix
}



public class Kruskal {
   
    
    private int Vsize = 6;//size of our matrix edge
    private int EdgeList[] = new int[Vsize-1];
     //////////////////////////////////////////////////////////////
    public Kruskal(){
        
    }//empty constuctor for Kruskal
     
    
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
     
    void CountEdges(int matrix[][], int parent[]){
        
        for(int i =0; i < matrix.length; i++){
            for(int j =0; j< matrix[i].length;j++){
                if(matrix[i][j]!=0 && matrix[i][j] != 500){
                    for(int n =0; n < EdgeList.length; n++){
                        EdgeList[n] = matrix[i][parent[i]];//assigns the value of the non zero or infinity edge to the list of known edges
                    }//end of for
                }//end of if
                else{
                    
                }//end of else
            }//end of for
        }//end of for
        
    }//end of count edges
     
     //////////////////////////////////////////////////////////////
     
    void KurskAlgo(int Matrix[][]){

        int Path[] = new int[Vsize-1];//creates a new array that is the size of the path
        
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
        
         CountEdges(Matrix, parent);//calls the count edges method to sort our edgelist
         

//Number of Vertices = Vsize
        for(int j = 0; j < Vsize - 1; j++){
            int Min = FindMin(Value, Visted);//returns and assigns the minimum value by calling the FindMin method
            
            //say we visted the vertex
            Visted[Min] = true;
            
                //update values and parent array for the vertices of the picked
                for(int p = 0; p < Vsize; p++){
                    if(Matrix[Min][p]!=0 && Matrix[Min][p] < Value[p] && Matrix[Min][p] != parent[p]){
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

}
