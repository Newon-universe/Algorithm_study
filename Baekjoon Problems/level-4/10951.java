import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s;

		while((s = br.readLine()) != null) {
			st = new StringTokenizer(s, " ");

			if(st.hasMoreTokens())
				bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
			else
				break;
		}

		bw.flush();
		bw.close();
	}
}