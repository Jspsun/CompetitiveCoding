/*
ID: jspsun1
LANG: JAVA
TASK: friday
 */

import java.io.*;
import java.util.*;

public class beads
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
		//StringTokenizer st = new StringTokenizer(f.readLine(),"r");

		//st.countTokens();
		
		out.println("");
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
