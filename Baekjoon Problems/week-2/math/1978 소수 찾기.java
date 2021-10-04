import java.io.*;
import java.util.*;

public class Main {
	public static void countPrime(int n, StringTokenizer st) {
		int result = 0;

		while(n-- != 0) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;

			if(num < 2)
				continue;
			
			for(int i = 2; i < num; i++) {
				if(num % i == 0) {
					cnt++;
					break;
				}
			}

			if(cnt == 0) result++;
		}

		System.out.println(result);
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		countPrime(n, new StringTokenizer(br.readLine()));
	}
}