package csc143.data_structures;
/**
 *This class is the exception for an over fill exception. Extends DataStructureException
 *@author Dan Jinguji
 *@version PA3 - Stack/Queue Link List CSC143
 */
public class OverfillException extends DataStructureException{
    public OverfillException(String msg){
        super(msg);
    }
}