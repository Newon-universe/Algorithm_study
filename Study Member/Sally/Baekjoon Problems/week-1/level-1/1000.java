import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		for(int i = 0; i < 2; i++)
			ans += Integer.parseInt(st.nextToken());

		System.out.println(ans);
	}
}