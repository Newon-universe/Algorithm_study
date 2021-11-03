import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int idx = 0;
		
		for(int i = 0; i < 9; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(max < tmp) {
				max = tmp;
				idx = i + 1;
			}
		}
		
		System.out.println(max + "\n" + idx);
	}
}