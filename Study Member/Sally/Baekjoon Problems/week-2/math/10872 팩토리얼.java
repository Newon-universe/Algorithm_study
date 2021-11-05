import java.io.*;

public class Main {
	public static int factorial(int n) {
        int result = 1;

        if(n < 2)
            return 1;

        for(int i = n; i > 1; i--)
            result *= i;

        return result;

	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(factorial(Integer.parseInt(br.readLine())));
	}
}