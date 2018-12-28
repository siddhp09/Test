package schoolProjects;

import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		//ask user for number of rows
		System.out.print("Enter Number of Rows: ");
		int n = scn.nextInt();
		
		double p = 1; 
		double x = n;
		
		//prints out each row
		for(int i=1;i<=n;i++)
		{
			for(int j=n-i; j>=0; j--)
			{
				//prints spaces (decrementing)
				System.out.print(" ");
			}
			
			for(double z=1;z<=i;z++)
			{
				//prints numbers in each row
				 System.out.print((int)p + " ");
                 p *= (x/z);
                 x--;
			}
			System.out.println();
			p = 1;
			x = i;
			}
		scn.close();

}
}
