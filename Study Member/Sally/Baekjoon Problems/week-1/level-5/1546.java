import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] score = new int[cnt];
		double max = 0;
		double sum = 0;

		for(int i = 0; i < cnt; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if(max < score[i]) max = score[i];
		}

		for(int i = 0; i < cnt; i++) {
			sum += (((double)score[i] / max) * 100);
		}

		System.out.println(sum/cnt);
	}
}