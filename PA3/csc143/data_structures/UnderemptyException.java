package csc143.data_structures;
/**
 *This class is the exception for an under filled exception. Extends DataStructureException
 *@author Dan Jinguji
 *@version PA3 - Stack/Queue Link List CSC143
 */
public class UnderemptyException extends DataStructureException{
    public UnderemptyException(String msg){
        super(msg);
    }
}