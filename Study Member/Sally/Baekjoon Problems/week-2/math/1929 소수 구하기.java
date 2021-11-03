import java.io.*;
import java.util.*;

public class Main {
	// 에라토스테네스의 체 사용하여 풀이하기
	public static void printPrime(int m, int n) {
		boolean[] prime = new boolean[n + 1];

		if(n < 2) return; /* 2 미만의 수 소수 없음 */

		prime[0] = prime[1] = false;
		for(int i = 2; i < m; i++)
			prime[i] = false;

		for(int i = m; i < n + 1; i++) {
			if(i < 2)
				continue;
			prime[i] = true;
		}
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			for(int j = i * i; j <= n; j += i)
				prime[j] = false;
		}

		for(int i = m; i < n + 1; i++)
			if(prime[i])
				System.out.println(i);
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		printPrime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}
}