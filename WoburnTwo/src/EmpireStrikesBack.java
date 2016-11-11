import java.util.Scanner;

public class EmpireStrikesBack
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);

		int numberOfRocks = s.nextInt();
		int maxMass = s.nextInt();

		int total = 0;
		for (int i = 0; i < numberOfRocks; i++)
		{
			int current = s.nextInt();
			if (current <= maxMass)
			{
				total += current;
			}
		}
		System.out.print(total);
	}
}
