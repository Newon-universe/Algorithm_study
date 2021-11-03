import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());

		for(int i = num; i > 0; i--) {
			bw.write(i + "\n");
		}

		bw.flush();
		bw.close();
	}
}