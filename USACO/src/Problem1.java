import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem1
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("paint.in"));

		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"paint.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());

		int farmerStart = Integer.parseInt(st.nextToken());
		int farmerEnd = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(f.readLine());

		int cowStart = Integer.parseInt(st.nextToken());
		int cowEnd = Integer.parseInt(st.nextToken());

		boolean[] fence = new boolean[Math.max(cowEnd + 1, farmerEnd + 1)];
		for (int i = farmerStart; i <= farmerEnd-1; i++)
		{
			fence[i] = true;
		}

		for (int i = cowStart; i <= cowEnd-1; i++)
		{
			fence[i] = true;
		}

		int total = 0;
		for (int i = 0; i < fence.length; i++)
		{
			if (fence[i])
			{
				total++;
			}
		}
		// int total = Math.max(cowEnd, farmerEnd)- Math.min(cowStart,
		// farmerStart);
		out.print(total);
		out.close();
		f.close();
	}

}
