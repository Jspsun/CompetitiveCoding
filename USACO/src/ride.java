/*
ID: jspsun1
LANG: JAVA
TASK: ride
 */

import java.io.*;
import java.util.*;

public class ride
{

	public static void main(String[] args) throws IOException
	{
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		
		//Scanner s = new Scanner ("ride.in");
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ride.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		//StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens

		String CName = f.readLine();
		
		String PName = f.readLine();

		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		int CValue = 1;
		int PValue = 1;

		for (int i = 0; i < CName.length(); i++)
		{
			CValue *= letters.indexOf(CName.charAt(i))+1;
		}
		
		for (int i = 0; i < PName.length(); i++)
		{
			PValue *= letters.indexOf(PName.charAt(i))+1;
		}

		if (CValue % 47 == PValue % 47)
			out.println("GO");
		// output result
		else
			out.println("STAY");
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}
