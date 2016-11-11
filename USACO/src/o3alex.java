import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class o3alex
{
	static int d, j, r;
	static char[] a, b;
	static int[][] dp;
	
	static int solve(int e, int f)
	{
		while (e < a.length && f < b.length && a[e] == b[f])
		{
			e++;
			f++;
		}
		if (e >= a.length && f >= b.length)
			return 0;
		if (e >= a.length)
			return Math.min(j, d) * (b.length - f);
		if (f >= b.length)
			return Math.min(j, d)  * (a.length - e);
		
		if (dp[e][f] != 0)
			return dp[e][f];
		
		int min = Integer.MAX_VALUE;
		min = Math.min(min, solve(e + 1, f + 1) + r);
		min = Math.min(min, solve(e, f + 1) + j);
		min = Math.min(min, solve(e + 1 ,f) + d);
		
		
		return dp[e][f] = min;
	}
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		d = Integer.parseInt(st.nextToken());
		j = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		
		a = new char[s.length()];
		for (int i = 0; i < a.length; i++)
			a[i] = s.charAt(i);
		
		s = st.nextToken();
		b = new char[s.length()];
		for (int i = 0; i < b.length; i++)
			b[i] = s.charAt(i);
		
		dp = new int[a.length][b.length];
		System.out.println(solve(0, 0));
	}

}
