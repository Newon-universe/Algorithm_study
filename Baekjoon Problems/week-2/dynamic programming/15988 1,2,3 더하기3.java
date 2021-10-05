import java.io.*;

public class Main {
	public static long countSum(int n) {
		long dp[] = new long[1000001];

		dp[1] = 1; dp[2] = 2; dp[3] = 4;

		for(int i = 4; i <= n; i++)
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
		
		return dp[n];
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		while(n-- != 0) {
			System.out.println(countSum(Integer.parseInt(br.readLine())));
		}
	}
}
