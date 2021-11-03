import java.io.*;
import java.util.*;

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
		int n = Integer.parseInt(br.readLine());

		while(n-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
	
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println((a * b) / GCD(a, b));
		}
	}
}
