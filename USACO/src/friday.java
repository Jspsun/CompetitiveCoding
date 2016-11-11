/*
ID: jspsun1
LANG: JAVA
TASK: friday
 */

import java.io.*;
import java.util.*;

public class friday
{

	public static void main(String[] args) throws IOException
	{
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));

		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"friday.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster

		// Get line, break into tokens
		// StringTokenizer st = new StringTokenizer(f.readLine());

		int numOfYears = Integer.parseInt(f.readLine());

		int monthLength;
		int daysPast = 0;
		int tally[] = { 0, 0, 0, 0, 0, 0, 0 };

		// cycle through each given year
		for (int year = 1900; year < 1900 + numOfYears; year++)
		{
			// cycle through each month of year
			for (int month = 1; month <= 12; month++)
				//9_9_7_9_9_8_9
			{
				// February conditions
				if (month == 2)
				{
					monthLength = 28;
					// 29 days for leap year
					if (year % 4 == 0)
					{
						monthLength = 29;

						// exception for centuries except div by 4
						if (year % 100 == 0 && year % 400 != 0)
						{
							monthLength = 28;
						}
					}
				}
				// months 30 days length
				else if (month == 4 || month == 6 || month == 9 || month == 11)
				{
					monthLength = 30;
				}
				// months of 31 days
				else
				{
					monthLength = 31;
				}

				// cycle through each day of particular month
				for (int day = 1; day <= monthLength; day++)
				{
					// mark each 13th
					if (day == 13)
					{
						// add to tally of each day
						tally[daysPast % 7]++;
					}
					// add to days past

					daysPast++;
				}
			}
		}

		out.print(tally[5] + " ");
		out.print(tally[6] + " ");
		for (int i = 0; i < 4; i++)
		{
			out.print(tally[i] + " ");
		}
		out.print(tally[4]);
		out.println("");
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
