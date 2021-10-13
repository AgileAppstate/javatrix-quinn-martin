import javatrix.*;
import java.util.Scanner;

public class Menu
{
	public static void main(String[] args)
	{
		String command = "";
		Scanner kb = new Scanner(System.in);
		Matrix C = new Matrix(3, 3, 0.);
		Matrix A = C.random(3, 3);
		Matrix B = C.random(3, 3);

		System.out.println("Matrix A");
		A.print(9, 2);
		System.out.println("Matrix B");
		B.print(9, 2);
		
		System.out.println("List of Valid Commands: times, plus, minus, transpose, trace, norm1, normInf, random, identity, copy");
		System.out.println("Enter \" q \" to quit");
		while (!command.equals("q"))
		{
			System.out.print("Enter a command: ");
			command = kb.nextLine();
			if (command.equals("times"))
			{
				System.out.println("A x B");
				C = A.times(B);
				C.print(9, 2);
			}
			else if (command.equals("plus"))
			{
				System.out.println("A + B");
				C = A.plus(B);
				C.print(9, 2);
			}
			else if (command.equals("minus"))
			{
				System.out.println("A - B");
				C = A.minus(B);
				C.print(9, 2);
			}
			else if (command.equals("transpose"))
			{
				System.out.println("Transpose of A");
				C = A.transpose();
				C.print(9, 2);
			}
			else if (command.equals("trace"))
			{
				System.out.println("Trace of A");
				System.out.printf("%.2f\n", A.trace());
			}
			else if (command.equals("norm1"))
			{
				System.out.println("norm1 A");
				System.out.printf("%.2f\n", A.norm1());
			}
			else if (command.equals("normInf"))
			{
				System.out.println("normInf A");
				System.out.printf("%.2f\n", A.normInf());
			}
			else if (command.equals("random"))
			{
				System.out.println("Random 3X3 Matrix");
				C = C.random(3, 3);
				C.print(9, 2);
			}
			else if (command.equals("identity"))
			{
				System.out.println("3X3 Identity Matrix");
				C = A.identity(3, 3);
				C.print(9, 2);
			}
			else if (command.equals("copy"))
			{
				System.out.println("Copy of A");
				C = A.copy();
				C.print(9, 2);
			}
			else if (!command.equals("q"))
			{
				System.out.println("Invalid Command");
			}
		}
		System.out.println("Exiting Menu");
	}

}

