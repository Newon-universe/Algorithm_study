import java.io.*;

public class Main {
	public static int countSum(int n, int cur) {
		if(cur >= n) {
			if(cur == n) return 1;
			return 0;
		}

		int result = 0;
		for(int i = 1; i <= 3; i++)
			result += countSum(n, cur + i);
		
		return result;
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-- != 0)
			System.out.println(countSum(Integer.parseInt(br.readLine()), 0));
	}
}