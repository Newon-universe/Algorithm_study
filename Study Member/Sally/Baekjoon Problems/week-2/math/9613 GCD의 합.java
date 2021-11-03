import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static int euclidean(int a, int b) {
		if(b == 0)
			return a;
		else
			return euclidean(b, a % b);
	}

	public static long GCD(StringTokenizer st) {
		long result = 0;
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) { 
			for(int j = i + 1; j < n; j++) {
				result += euclidean(arr[i], arr[j]);
			}
		}

        return result;
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-- != 0) {
			System.out.println(GCD(new StringTokenizer(br.readLine())));
		}
	}
}