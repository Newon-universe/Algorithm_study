import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] ary = new int[10];
		int cal = 1;

		for(int i = 0; i < 3; i++)
			cal *= Integer.parseInt(br.readLine());

		while(cal != 0) {
			int tmp = cal % 10;
			ary[tmp]++;
			cal /= 10;
		}

		for(int a : ary)
			System.out.println(a);
	}
}