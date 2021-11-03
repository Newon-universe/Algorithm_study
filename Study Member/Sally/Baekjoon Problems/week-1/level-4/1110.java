import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());

		int tmp = num;
		int cnt = 0;

		while(true) {
			tmp = ((tmp % 10) * 10) + (((tmp / 10) + (tmp % 10)) % 10);
			cnt++;

			if(tmp == num)
				break;
		}

		bw.write(cnt + "\n");

		bw.flush();
		bw.close();
	}
}