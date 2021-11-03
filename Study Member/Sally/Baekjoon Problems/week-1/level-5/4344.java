import java.io.*;
import java.util.*;

public class Main {
	public static void ratioStudents(StringTokenizer st) {
		int len = Integer.parseInt(st.nextToken());
		int[] score = new int[len];
		int cnt = 0;
		float avg = 0;

		for(int i = 0; i < len; i++) {
			int num = Integer.parseInt(st.nextToken());
			score[i] = num;
			avg += num;
		}

		avg /= (float)len;

		for(int i = 0; i < len; i++) {
			if(score[i] > avg)
				cnt++;
		}

		System.out.println(String.format("%.3f", ((float)cnt/len) * 100) + "%");
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());

		while(cnt-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ratioStudents(st);
		}
	}
}