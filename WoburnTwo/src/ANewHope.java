import java.util.Scanner;

public class ANewHope
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();

		System.out.print("A long time ago in a galaxy ");
		for (int i = 1; i < number; i++)
		{
			System.out.print("far, ");
		}

		System.out.print(" far away...");
	}

}
