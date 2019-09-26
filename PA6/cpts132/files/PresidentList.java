package cpts132.files;

import java.io.*;
/**
 *This class will take the president.txt and rearrange it
 *@author James Dansie
 *@version PA6 - Presidents Standard Level
 */
public class PresidentList{
    /**
     *This field stores the data as an array
     */
    public String[][] data;
    /**
     *This constructs the array. 4 columns of interest and 45 input points
     */
    public PresidentList(){
        data = new String[45][4];
    }
    /**
     *This method reads the input and stores it in the array field
     *@param inFile the stream object to read from
     *@throws IOException throws an exception if the i/o is wrong
     */
    public void input(BufferedReader inFile) throws IOException{
        int row = 0;
        String line = inFile.readLine();
        while(line != null){
            String[] parts = line.split("\t");
            data[row][0] = parts[0];
            data[row][1] = parts[1];
            data[row][2] = parts[2];
            data[row][3] = parts[3];
            line = inFile.readLine();
            row++;
        }
        inFile.close();
    }
    /**
     *This method reads data to an output file with the format for the minimum submission
     *@param outFile the stream object to write to
     *@throws IOException throws an exception if the i/o is wrong
     */
    public void minOut(BufferedWriter outFile) throws IOException{
        for(int row = 0; row < data.length; row++){
            String output = String.format("%s %s was president from %s to %s.", 
            data[row][1], data[row][0], data[row][2], data[row][3]);
            outFile.write(output);
            outFile.newLine(); 
        }
        outFile.close();
    }
    /**
     *This method reorganizes the data to be alphabetized by last name
     */
    public void stdOut(){
        java.util.Arrays.sort(data, new java.util.Comparator<String[]>(){
            @Override
            public int compare(String[] entry1, String[] entry2){
                //entry1[0] refers to the first column, use entry[2] to refer to 
                //the third column (inaguration date).
                String a1 = entry1[0];
                String a2 = entry2[0];
                return a1.compareTo(a2);
            }
        });
    }
    /**
     *This is the main body of the application
     *@param args string arguements are ignored
     *@throws IOException throws an exception if i/o are wrong
     */
    public static void main(String[] args) throws IOException{
        PresidentList prez = new PresidentList();

        String sourceFilename = "presidents.txt";
        BufferedReader inFile = new BufferedReader(new FileReader(sourceFilename));
        prez.input(inFile);
        
        String destFilename = "same_order.txt";
        BufferedWriter outFile = new BufferedWriter(new FileWriter(destFilename));
        prez.minOut(outFile);
        
        String destStd = "last_name.txt";
        BufferedWriter outFileStd = new BufferedWriter(new FileWriter(destStd));
        prez.stdOut();
        prez.minOut(outFileStd);
        
        //debugging code
//         System.out.println(prez.data[0][0]);
//         System.out.println(prez.data[0][1]);
//         System.out.println(prez.data[0][2]);
//         System.out.println(prez.data[0][3]);
//        System.out.println(java.util.Arrays.deepToString(prez.data));
    }
}