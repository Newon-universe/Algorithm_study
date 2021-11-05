import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int len = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < len; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp < num)
				bw.write(tmp + " ");
		}

		bw.flush();
		bw.close();
	}
}