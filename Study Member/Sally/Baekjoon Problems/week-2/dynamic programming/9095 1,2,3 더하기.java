import java.io.*;

public class Main {
	public static void countSum(int n) {
		int[] dp = new int[11];

		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		for(int i = 4; i <= n; i++)
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		
		System.out.println(dp[n]);
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-- != 0)
			countSum(Integer.parseInt(br.readLine()));
	}
}
