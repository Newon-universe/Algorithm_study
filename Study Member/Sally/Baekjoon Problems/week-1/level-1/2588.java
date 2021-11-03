import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
		System.out.println(a*(b%10));
		System.out.println(a*((b/10)%10));
		System.out.println(a*(b/100));
		System.out.println(a*b);
	}
}