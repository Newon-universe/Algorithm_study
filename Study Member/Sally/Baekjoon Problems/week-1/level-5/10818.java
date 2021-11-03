import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] ary = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < num; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		
		int min = ary[0];
		int max = ary[0];

		for(int i : ary) {
			if(min > i) min = i;
			if(max < i) max = i;
		}

		System.out.println(min + " " + max);
	}
}