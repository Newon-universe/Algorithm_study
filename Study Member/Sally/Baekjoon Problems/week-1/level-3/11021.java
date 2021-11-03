import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());

		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			bw.write("Case #" + (i + 1) + ": " + ((Integer.parseInt(st.nextToken())) + (Integer.parseInt(st.nextToken()))) + "\n");
		}

		bw.flush();
		bw.close();
	}
}