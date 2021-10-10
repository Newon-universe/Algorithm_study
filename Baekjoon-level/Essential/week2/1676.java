import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int ans = 0;

        while (number>=5) {
            ans += number/5;
            number /= 5; // 5*5
        }

        System.out.println(ans);
        // System.out.println(factFunction(number));
    }

    // 재귀함수
    //    public static int factFuction(int n) {
    //        if (n <= 1) {
    //            retrurn n;
    //        } else {
    //            return factFuction(n-1)*n;
    //        }
    //    }
}