import java.io.*;

public class Main {
	public static int countTile(int n) {
		int dp[] = new int[1001];

		dp[0] = 1; dp[1] = 1;;

		for(int i = 2; i <= n; i++) 
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
		
		return dp[n];
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(countTile(Integer.parseInt(br.readLine())));
	}
}
