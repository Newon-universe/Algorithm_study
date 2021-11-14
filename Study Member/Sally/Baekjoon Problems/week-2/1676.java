import java.io.*;

public class Main {
	public static int countZero(int n) {
		int cnt = 0;

		while(n >= 5) {
			cnt += n / 5;
			n /= 5;
		}

        return cnt;
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(countZero(Integer.parseInt(br.readLine())));
	}
}