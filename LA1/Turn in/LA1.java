/**
 * This class pritns my LA1 info from the canvas discussion thread. It will 
 * also take an input argument and return a prompt.
 * 
 * @version LA1: Class tools
 * @author James Dansie
 */
public class LA1 {
	/**
	 * Prints my LA1 info from the discussion thread. It will also take an input
	 * argument, and return a prompt. 
	 * 
	 * @param args Input argument
	 */
	public static void main(String[] args) {
		//Prints my name
		System.out.println("James Dansie");
		//Prints my fact
		System.out.println("The island of Borneo is shared by three countries.");
		//Handles agrs. Checks for length, then content.
		if(args.length == 0)
			System.out.println("No command-line arguments given.");
		else if(args.length == 1 && "OOP".equals(args[0]))
			System.out.println("The command-line arguemnts say \"OOP\".");
		else if(args.length == 2 && "CS".equals(args[0]) && "143".equals(args[1]))
			System.out.println("The command-line arguements say \"CS 143\".");
		else
			System.out.println("The command-line arguments are not recognized.");

	}

}
