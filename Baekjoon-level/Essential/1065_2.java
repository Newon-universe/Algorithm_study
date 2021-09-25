import java.util.Scanner;

public class Main {

    /* 1번보다 메모리와 시간이 많이 든다 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        /* 스캐너를 이용하여 입출력했다 */

        if (n < 100) {
            System.out.println(n);
        } else {
            int result = 99;

            for (int i = 100; i <= n; ++i) {
                result += checkHanNumber(i);
                /* 한수를 체크한 결과를 result 값에 더해준다 */
            }
            if (n == 1000) result--;

            System.out.println(result);
        }
    }

    private static int checkHanNumber(int number) {
        int num1 = number / 100 % 10;
        int num2 = number / 10 % 10;
        int num3 = number % 10;

        if (num2 * 2 == num1 + num3) { /* 1번과는 다른 방식으로 등차를 판단했다 */
            return 1;
        }
        return 0; /* 한수가 아니라면 0을 리턴하고 한수라면 1을 리턴하는 함수이다 */
    }
}