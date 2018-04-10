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
 * 4/9/2018
 */



//public class PrimAlgo {
//    //main class
//   
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        
//        
//         //declaring files
//        String filenameCSV = (".\\src\\Input\\StarWarsPlanets.csv");
//
//        String[] wordReader;
//
//        try {
//            //BufferedReader that reads in input file
//            BufferedReader br = new BufferedReader(new FileReader(filenameCSV));
//
//            String line = null;
//            int splitLength = 0;
//            
//           
//            
//            //while loop to read in text of input file line by line
//            while ((line = br.readLine()) != null) {
//
//                String[] spliter = line.split(",");
//                int[] splitINT = new int[spliter.length];
//                String[] splitName = new String[spliter.length];
//
//                for (int count = 0; count < spliter.length; count++) {
//                    System.out.println(spliter[count] + " ");//prints the contents of the file on seperate lines
//                    if (count % 2 == 0) {
//                        splitINT[count] = Integer.parseInt(spliter[count]);//assigns the numbers to an int array
//                    }//end of if
//                    else {
//                        splitName[count] = spliter[count];//assigns the planet names to a string array
//                    }//end of else
//                }//end of for loop
//                
//            } // end while
//            br.close(); //closing files
//
//        } catch (IOException x) {
//            System.out.println("File Not Found");
//        }
//        
//    }//end of static maain
//    
//}//end of prim algo class

//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////

 class PrimAlgo{
//create the graph - move buffered reader here?
    
    public PrimAlgo(){
    
    }//creates an empty constructor so we can call methods from Prim algo
    
    private int Vsize = 6;//size of our matrix edge
    
    
    int FindMin(int Value[], Boolean VerticeVist[]){
    
        int least = Value[1], least_index = 1;//asigns least to the first value of the array to check for min
        
        for(int i = 0; i < Vsize; i++){
            if(Value[i] < least && VerticeVist[i] == false){
                least = Value[i];//assigns minimum value to least
                least_index = i;//assigns the location of the index of least
            }//end of if
        }//end of for loop
        
        return least_index;//returns the min value
    }//end of find min method
    
    
    void Algo(int Matrix[][]){
        
        int parent[] = new int[Vsize];//creates aan array to store parent vertices
        
        int Value[] = new int[Vsize];//create a new array to hold the values of edges
        
        Boolean Visted[] = new Boolean[Vsize];
        
        for(int i = 0; i <Vsize; i++){
            Value[i] = 500;
            Visted[i] = false;
               //assigns our default infinite value to the keys before we change those values
        }//end of for loop
        
        //Eliminate all loops and Parallel Edges so first Vertices must have 0 value to itself
        Value[0] = 0;//This shall be the value of our first vertex
        parent[0] = -1;//This is root has no parent only children
        
        
        //Number of Vertices = Vsize
        for(int j = 0; j < Vsize; j++){
            int excludedMin = FindMin(Value, Visted);//returns and assigns the minimum value by calling the FindMin method
            
            //say we visted the vertex
            Visted[excludedMin] = true;
            
                //update values and parent array for the vertices of the picked
                for(int p = 0; p < Vsize; p++){
                    if(Matrix[excludedMin][p]!=0 && Matrix[excludedMin][p] < Value[p] && Visted[p] == false){
                        parent[p] = excludedMin;
                        Value[p] =  Matrix[excludedMin][p];
                    }//end of if statement
                }//end of for loop
                
        }//end of for loop
                
      PrintPrim(parent, Vsize, Matrix);//calls the print method to print the algorithim after it is done running  
    }//end of algo method
    
    void PrintPrim(int parent[], int num ,int matrix[][]){
        System.out.println("Edges    Weights");
        for(int i =1; i < Vsize; i++){
            System.out.println(parent[i] + " - " + i + "   "+ matrix[i][parent[i]]);
        }//end of for loop
    }//end of PrintPrim
    
    
}//end of graph class

