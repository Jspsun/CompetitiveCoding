/*
ID: jspsun1
LANG: JAVA
TASK: gift1
 */

import java.io.*;
import java.util.*;

public class gift1
{

	public static void main(String[] args) throws IOException
	{
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));

		// Scanner s = new Scanner ("ride.in");
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster

		// Get line, break into tokens

		int numOfPpl = Integer.parseInt(f.readLine());
		String[] names = new String[numOfPpl];
		int[] cash = new int[numOfPpl];

		// recording names
		for (int i = 0; i < numOfPpl; i++)
		{
			names[i] = f.readLine();
		}

		// cyclr through each person's gift
		for (int i = 0; i < numOfPpl; i++)
		{
			// skip over givers name
			String giver = f.readLine();

			StringTokenizer st = new StringTokenizer(f.readLine());

			// get money to split
			int gift = Integer.parseInt(st.nextToken());

			// get amount of people to split money amongst
			int divider = Integer.parseInt(st.nextToken());

			int amount;
			if (divider != 0)
			{
				amount = gift / divider;
			}
			else
			{
				amount = gift;
			}

			// go through each recipient
			for (int n = 0; n < divider; n++)
			{
				String reciever = f.readLine();

				// deposit money into account
				for (int p = 0; p < numOfPpl; p++)
				{
					if (reciever.equals(names[p]))
					{
						cash[p] += amount;
					}
				}
			}

			for (int p = 0; p < numOfPpl; p++)
			{
				if (giver.equals(names[p]))
				{
					if (divider != 0)
						cash[p] += (gift % divider);
					cash[p] -= gift;
				}
			}

		}
		for (int i = 0; i < numOfPpl; i++)
		{
			out.println(names[i] + " " + cash[i]);
		}

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
