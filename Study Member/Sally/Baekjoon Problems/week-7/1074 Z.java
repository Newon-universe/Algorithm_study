import java.io.*;
import java.util.*;

/* 재귀 */
public class Main {
	static StringBuilder sb = new StringBuilder();

	public static int findZ(int n, int r, int c) {
		if(n == 0) return 0;

		int half = 1 << (n - 1); // 한 변 길이의 절반 2n-1승
		if(r < half && c < half) return findZ(n - 1, r, c);
		if(r < half && c >= half) return half*half + findZ(n - 1, r, c - half);
		if(r >= half && c < half) return 2*half*half + findZ(n - 1, r - half, c);
		return 3*half*half + findZ(n - 1, r - half, c - half);

	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		System.out.println(findZ(Integer.parseInt(st.nextToken()), 
			Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	}
}