import java.io.*;

public class Main {
	public static int countNumber(int num) {
		int ans = 0;
		int a = 0; // 100의 자리
		int b = 0; // 10의 자리
		int c = 0; // 1의 자리

		if(num < 100)
			return num;
		
		else {
			ans = 99;

			for(int i = 100; i <= num; i++) {
				a = i / 100;
				b = (i / 10) % 10;
				c = i % 10;

				if((a - b) == (b - c))
					ans++;
			}
		}

		return ans;
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(countNumber(Integer.parseInt(br.readLine())));
	}
}