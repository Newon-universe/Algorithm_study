import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(arithmeticSequence(Integer.parseInt(br.readLine())));
    }

    public static int arithmeticSequence(int num) {
        int count = 0;

        if (num < 100) {
            return num;
        } else {
            count = 99;
            if (num == 1000) { // 1000의 경우, 예외처리
                num = 999;
            }

            for (int i = 100; i <= num; i++) {
                int hun = i / 100; // 백의 자리
                int ten = (i / 10) % 10; // 십의 자리
                int one = i % 10;

                if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
                    count++;
                }
            }
        }

        return count;
    }
}