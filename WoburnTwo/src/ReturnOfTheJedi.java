import java.util.Scanner;

public class ReturnOfTheJedi
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int noOfTroopers = s.nextInt();
		int noOfEwoks = s.nextInt();
		int rangeOfTroopers = s.nextInt();

		int trooperWeapons[] = new int[noOfTroopers];
		int trooperX[] = new int[noOfTroopers];
		int trooperY[] = new int[noOfTroopers];

		int ewokX[] = new int[noOfEwoks];
		int ewokY[] = new int[noOfEwoks];

		int deadEwok = 0;

		boolean[] weaponsType = new boolean[4];

		for (int i = 0; i < noOfTroopers; i++)
		{
			trooperWeapons[i] = s.nextInt();
			trooperX[i] = s.nextInt();
			trooperY[i] = s.nextInt();
		}
		for (int i = 0; i < noOfEwoks; i++)
		{
			ewokX[i] = s.nextInt();
			ewokY[i] = s.nextInt();
		}

		for (int i = 0; i < noOfEwoks; i++)
		{
			for (int j = 0; j < noOfTroopers; j++)
			{
				int differenceX = trooperX[j] - ewokX[i];
				int differenceY = trooperY[j] - ewokY[i];
				int XSquared = (int) Math.pow(differenceX, 2);
				int YSquared = (int) Math.pow(differenceY, 2);
				double distance = Math.sqrt(XSquared + YSquared);
				if (distance <= rangeOfTroopers)
				{
					weaponsType[trooperWeapons[j] - 1] = true;
				}
			}
			int totalWeapons = 0;
			for (int j = 0; j < 4; j++)
			{
				if (weaponsType[j])
				{
					totalWeapons++;
				}
			}
			if (totalWeapons >= 2)
			{
				deadEwok++;
			}
			for (int j = 0; j < 4; j++)
			{
				weaponsType[j] = false;
			}
		}
		System.out.print(deadEwok);
	}
}
