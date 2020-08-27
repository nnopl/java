import java.util.Scanner;

public class Stars2 {
    public static void main (String[] args) {
    	Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive number 1: ");
        int a = scan.nextInt();
        System.out.print("Enter a positive number 2: ");
        int b = scan.nextInt();
        System.out.print("Enter a positive number 3: ");
        int c = scan.nextInt();
        scan.close();

        int HistogramHeight = Math.max(Math.max(a, b), c);
        for(int x = HistogramHeight; x > 0; x = x -1) {
            System.out.print(x > a ? " " : "*");
            System.out.print(x > b ? " " : "*");
            System.out.println(x > c ? " " : "*");
            System.out.println();
        }
    }
}
