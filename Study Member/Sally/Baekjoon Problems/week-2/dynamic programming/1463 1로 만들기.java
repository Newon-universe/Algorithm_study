import java.io.*;

public class Main {
	public static void makeOne(int n) {
		int[] dp = new int[1000001];
		dp[1] = 0;

		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}

		System.out.println(dp[n]);
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		makeOne(Integer.parseInt(br.readLine()));
	}
}
