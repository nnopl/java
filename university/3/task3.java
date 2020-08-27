import java.util.Scanner;

public class ReversePyramidPattern {
	
	int i,j,k,number;
	Scanner user_input;
	
	public ReversePyramidPattern()
	{
		user_input = new Scanner(System.in);
		System.out.print("Enter an odd number: ");
		number = user_input.nextInt();
        user_input.close();

	}
	
	public void printReversePyramid()
	
	{
		for(i=number;i>=1;i=i-2)
		{
			for(j=number;j>i;j=j-2)
				System.out.print(" ");
			
			for(k=1;k<=i;k=k+1)
				System.out.print("*");
			
			System.out.print("\n");
		}
		
	}
	
	public static void main(String[] args) {
				
	ReversePyramidPattern obj=new ReversePyramidPattern();
	obj.printReversePyramid();
	
	}
}
