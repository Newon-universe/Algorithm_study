import java.io.*;
import java.util.*;

public class Main {
	static int bitmask = 0;
	static StringBuilder sb = new StringBuilder();

	public static void calculation(StringTokenizer st) {
		String cal = st.nextToken();
		int tmp;

		switch(cal) {
			case "add" : 
				tmp = Integer.parseInt(st.nextToken());
				bitmask |= (1 << tmp);
				break;
			case "remove" :
				tmp = Integer.parseInt(st.nextToken());
				bitmask &= ~(1 << tmp);
				break;
			case "check" :
				tmp = Integer.parseInt(st.nextToken());
				sb.append((bitmask & (1 << tmp)) != 0 ? "1\n" : "0\n");
				break;
			case "toggle" :
				tmp = Integer.parseInt(st.nextToken());
				bitmask ^= (1 << tmp);
				break;
			case "all" :
				bitmask |= ~0;
				break;
			case "empty" :
				bitmask &= 0;
				break;
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-- != 0) {
			calculation(new StringTokenizer(br.readLine()));
		}

		System.out.println(sb);
	}
}
