import java.util.Scanner;

public class Sheks {
	public static void main (String[] args) {
    	Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String str = scan.nextLine();
        scan.close();

	    boxAroundString(str);
	}

	public static void boxAroundString(String str) {
	    int len = str.length();
	    
	    for (int i = 0; i < len + 4; i++) {
	        System.out.print("*");
	    }
	   
	    System.out.println("");
	    System.out.print("*");
	 
	    for (int i = 0; i < len + 2; i++) {
	        System.out.print(" ");
	    }
	   
	    System.out.println("*");
	    System.out.println("* " + str + " *");
	    System.out.print("*");
	    
	    for (int i = 0; i < len + 2; i++) {
	        System.out.print(" ");
	    }
	    System.out.println("*");
	    
	    for (int i = 0; i < len + 4; i++) {
	        System.out.print("*");
	    }
	}
}
