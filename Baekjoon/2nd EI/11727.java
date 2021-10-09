import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        
        int d[] = new int[length + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= length; i++){
            d[i] = d[i - 1] + 2 * d[i - 2];
            d[i] %= 10007;       
        }
        System.out.println(d[length]);
    }
}