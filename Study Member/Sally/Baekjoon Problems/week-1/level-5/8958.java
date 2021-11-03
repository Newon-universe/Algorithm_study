import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = Integer.parseInt(br.readLine());

		for(int i = 0; i < cnt; i++) {
			int score = 0;
			int tmp = 0;

			for(byte b : br.readLine().getBytes()) {
				if(b == 'O') {
					tmp++;
					score += tmp;
				}
				else
					tmp = 0;

			}

			sb.append(score).append("\n");
		}

		System.out.println(sb);
	}
}