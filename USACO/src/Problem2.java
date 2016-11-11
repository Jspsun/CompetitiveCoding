import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem2
{

	public static void main(String[] args) throws IOException
	{
		int[] speedLimit = new int[100];
		int[] cowSpeed = new int[100];

		BufferedReader f = new BufferedReader(new FileReader("speeding.in"));

		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"speeding.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int noOfRoadSegments = Integer.parseInt(st.nextToken());
		int noOfCowSegments = Integer.parseInt(st.nextToken());

		int place = 0;
		for (int i = 0; i < noOfRoadSegments; i++)
		{

			st = new StringTokenizer(f.readLine());
			int length = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			for (int j = 0; j < length; j++)
			{
				
				speedLimit[place] = speed;
				place++;
			}
		}
		place = 0;
		for (int i = 0; i < noOfCowSegments; i++)
		{

			st = new StringTokenizer(f.readLine());
			int length = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			for (int j = 0; j < length; j++)
			{
				
				cowSpeed[place] = speed;
				place++;
			}
		}
		int biggestDifference = 0;
		for (int i = 0; i < 100; i++)
		{
			int difference = cowSpeed[i] - speedLimit[i];
			if (difference > biggestDifference)
			{
				biggestDifference = difference;
			}
		}
		out.print(biggestDifference);
		out.close();
	}
}
