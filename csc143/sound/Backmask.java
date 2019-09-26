package csc143.sound;

//This is how I originally called the data structures
//import csc143.data_structures.*;
import java.io.*;
import java.util.Scanner;
/**
 *This class will backmask a given DAT file
 *@author James Dansie
 *@version LA9 - Stack and Queue Use, Backmasking - Check submission
 */
public class Backmask{
    /**
     *This field stores the two line header of the file.
     */
    private String[] header;
    /**
     *This queue stores the time stamp of the data
     */
    private UnboundedQueue_Array<String> time;
    /**
     *This stack stores the sound data
     */
    private UnboundedStack_Array<String> data;
    /**
     *Parameterless constructor
     */
    public Backmask(){
        header = new String[2];
        time = new UnboundedQueue_Array<String>();
        data = new UnboundedStack_Array<String>();
    }
    /**
     *This method reads the input from the DAT
     *@param inFile this is the buffered reader of the DAT input file
     *@throws IOException throws an error if it can't read the file
     */
    public void input(BufferedReader inFile)throws IOException{
        int row = 0;
        String line = inFile.readLine();
        while(line != null){
            //the first two lines are the header
            if(row <=1){
                header[row] = line;
            }
            //everything else is data
            else{
                Scanner readLine = new Scanner(line);
                while(readLine.hasNext()){
                    time.enqueue(readLine.next());
                    data.push(readLine.next());
                }
            }
            line = inFile.readLine();
            row++;
        }
        inFile.close();
    }
    /**
     *This method writes the output file. It uses the stack to reverse the 
     *sound data, and the queue to keep the time in the same order
     *@param outFile buffered writer output
     *@throws IOException throws an error if it can't write the file
     *@throws UnderemptyException throws an error if the data is already empty
     */
    public void output(BufferedWriter outFile)throws IOException, UnderemptyException{
        //first two lines are the header
        for(int row = 0; row < header.length; row++){
            outFile.write(header[row]);
            outFile.newLine(); 
        } 
        //everything else is data
        while(data.hasItems()){
            String output = String.format("   %s   %s", 
            time.dequeue(), data.pop());
            outFile.write(output);
            outFile.newLine(); 
        }
        outFile.close();
    }
    /**
     *The main section of the application
     *@param args accepts two arguements. The first is the input file, the second is the output file
     *@throws UnderemptyException throws an error if the data is already empty
     */
    public static void main(String[] args) throws UnderemptyException{
        //remember to accept args inputs for file name
        Backmask back = new Backmask();
        
        if(args.length != 2){
            System.err.println("Wrong number of inputs");
        }
        try{
            String sourceFilename = args[0];
            BufferedReader stuffIn = new BufferedReader(new FileReader(sourceFilename));
            back.input(stuffIn);
            
            String destFilename = args[1];
            BufferedWriter outFile = new BufferedWriter(new FileWriter(destFilename));
            back.output(outFile);
        }catch(IOException e){
            System.err.println("Cannot read either the input or output");
        }
        
    }
}