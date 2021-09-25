import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(countNumber(Integer.parseInt(br.readLine())));
    }
    /* 스캐너를 통해 입출력하는 방법도 있다 */

    public static int countNumber(int number) {
        int a = 0; /* 100의 자리 */
        int b = 0; /* 10의 자리 */
        int c = 0; /* 1의 자리 */
        int answer = 0;

        /*
         * 숫자가 100보다 작다면, 10의 자리까지는 숫자가 2개이므로
         * 등차를 비교할 대상이 없다. 따라서 모든 숫자가 한수이다.
         */
        if(number < 100) {
            return number;
        } else {
            answer = 99; /* 99까지의 한수 개수 세팅 */

            for(int i=100; i<=number; i++) {
                a = i/100;     /* 100 이상의 수부터 입력받은 숫자까지 각 자리의 수를 구한다 */
                b = (i/10)%10; /* 숫자를 대입해서 생각해보자 */
                c = i%10;

                if((a-b)==(b-c)) {
                    answer++;  /* 등차 조건을 성립할 시 1을 더한다 */
                }
            }
            return answer;
        }
    }
}