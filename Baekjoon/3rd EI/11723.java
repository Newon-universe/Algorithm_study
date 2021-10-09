import java.io.*;
import java.util.*;

public class Main {
    // {1,.., 20} : 총 21개
    private static int N = 21;
    private static int S = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            String[] s = bf.readLine().split(" ");
            String operation = s[0];
            int number = (operation.equals("all") || operation.equals("empty")) ? 1 : Integer.parseInt(s[1]);

            go(operation, number, sb);
        }
        System.out.println(sb.toString());
        bf.close();
    }

    private static void go(String operation, int number, StringBuilder sb) {
        switch (operation) {
            // |
            case "add":
                S = S | (1 << number);
                break;

            // & ~
            case "remove":
                S = S & ~(1 << number);
                break;

            // &
            case "check":
                int result = S & (1 << number);
                if (result == 0) {
                    sb.append("0\n");
                } else {
                    sb.append("1\n");
                }
                break;

            // ^
            case "toggle":
                S = S ^ (1 << number);
                break;

            // 0
            case "empty":
                S = 0;
                break;

            // all
            case "all":
                S = (1 << N) - 1;
                break;
            default:
                break;
        }
    }
}