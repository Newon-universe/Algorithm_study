import java.io.*;
import java.util.StringTokenizer;

public class Main {
	/* 유클리드 호제법 */
	public static int GCD(int a, int b) {
		if(b == 0)
			return a;
		else
			return GCD(b, a % b);
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int gcd = GCD(a, b);
		System.out.println(gcd + "\n" + (a * b) / gcd);
	}
}
