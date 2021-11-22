import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(br.readLine());

		if(score > 89)
			System.out.println("A");
		else if(score > 79)
			System.out.println("B");
		else if(score > 69)
			System.out.println("C");
		else if(score > 59)
			System.out.println("D");
		else
			System.out.println("F");
	}
}