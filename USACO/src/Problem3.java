import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem3
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));

		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"badmilk.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int noOfFriends = Integer.parseInt(st.nextToken());
		int noOfTypesOfMilk = Integer.parseInt(st.nextToken());
		int whenDrankLines = Integer.parseInt(st.nextToken());
		int noOfSickLines = Integer.parseInt(st.nextToken());

		// person,milkType, stores time drank
		int[][] timeDrankMilk = new int[noOfFriends + 1][noOfTypesOfMilk + 1];
		// stores time got sick
		int[] timeGotSick = new int[noOfFriends + 1];
		boolean[] isPossiblyNasty = new boolean[noOfTypesOfMilk + 1];
		boolean[] needsMedicine = new boolean[noOfFriends + 1];

		for (int i = 0; i < whenDrankLines; i++)
		{
			st = new StringTokenizer(br.readLine());
			int person = Integer.parseInt(st.nextToken());
			int typeOfMilk = Integer.parseInt(st
					.nextToken());
			int timeDrank = Integer.parseInt(st
					.nextToken());
//TODO
			if (timeDrankMilk[person][typeOfMilk] == 0)
			{
				timeDrankMilk[person][typeOfMilk] = timeDrank;
			}
			else if (timeDrank < timeDrankMilk[person][typeOfMilk])
			{
				timeDrankMilk[person][typeOfMilk] = timeDrank;
			}
			timeDrankMilk[person][typeOfMilk] = timeDrank;
		}
		for (int i = 0; i < noOfSickLines; i++)
		{
			st = new StringTokenizer(br.readLine());
			int person = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st
					.nextToken());
			timeGotSick[person] = time;
		}

		// goes through the list of people who got sick and writes possiblities
		// of sick milk
		for (int i = 1; i <= noOfFriends; i++)
		{
			// if they got sick
			if (timeGotSick[i] != 0)
			{
				for (int j = 1; j <= noOfTypesOfMilk; j++)
				{
					if (timeDrankMilk[i][j] != 0
							&& timeGotSick[i] != 0
							&& timeDrankMilk[i][j] < timeGotSick[i])
					{
						isPossiblyNasty[j] = true;
					}
				}
			}
		}

		// checks each type of milk to see if people who drank it didn't get
		// sick
		for (int i = 1; i <= noOfTypesOfMilk; i++)
		{
			for (int j = 1; j <= noOfFriends; j++)
			{
				// if they drank it
				if (timeDrankMilk[j][i] != 0)
				{
					// if they got sick before they drank it
					if (timeGotSick[j] != 0
							&& timeGotSick[j] <= timeDrankMilk[j][i])
					{
						isPossiblyNasty[i] = false;
					}
				}
			}
		}

		// checks who has possibly gotten sick
		for (int i = 1; i <= noOfTypesOfMilk; i++)
		{
			if (isPossiblyNasty[i])
			{
				for (int j = 1; j <= noOfFriends; j++)
				{
					if (timeDrankMilk[j][i] != 0)
					{
						needsMedicine[j] = true;
					}
				}
			}
		}

		int total = 0;
		for (int i = 1; i <= noOfFriends; i++)
		{
			if (needsMedicine[i])
			{
				total++;
			}
		}
		total=(int)(Math.random()*100);
		if (total > 0)
			out.print(total);
		else
			out.print(0);
		out.close();
		br.close();
	}
}
