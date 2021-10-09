import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(n);
            return;
        }

        StringBuilder outputStr = new StringBuilder();

        while (n != 1) {
            outputStr.append(Math.abs(n % (-2)));
            n = (int)Math.ceil((double)n / (-2));
        }
        outputStr.append(n);

        System.out.println(outputStr.reverse());
    }
}