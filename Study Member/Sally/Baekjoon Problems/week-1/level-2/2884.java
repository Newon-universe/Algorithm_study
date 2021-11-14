import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		m -= 45;

		if (m >= 0)
			System.out.println(h + " " + m);
		else if (h == 0 && m > 0)
			System.out.println("23 " + m);
		else if (h == 0 && m < 0)
			System.out.println("23 " + (60 + m));
		else
			System.out.println((h - 1) + " " + (60 + m));
	}
}