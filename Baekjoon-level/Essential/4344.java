import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    /**
     * 전체로직
     * 1. 평균을 구한다 sum/n = avg
     * 2. 평균이 넘는 수를 카운팅한다
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* 버퍼리더로 입력을 받는다 */

        int[] arr;
        int testcase = Integer.parseInt(br.readLine());
        /* Integer.parseInt로 버퍼리더를 통해 읽은 줄의 문자열을 10진수의 integer로 반환해준다 */
        StringTokenizer st;
        /* 버퍼리더는 입력 과정에서 한 줄을 통째로 읽기 때문에 문자열을 스트링토크나이저를 통해 공백을 기준으로 분리해준다 */

        for (int i=0; i<testcase; i++) {
            st = new StringTokenizer(br.readLine()," ");
            /* 공백 기준 분리 */
            int N = Integer.parseInt(st.nextToken());
            /* nextToken()은 다음 토큰을 불러오는 메소드이다 */
            arr = new int[N];
            /* 다음 토큰을 불러와서 배열에 넣어준다 */

            double sum = 0;
            /* double은 소수점 14자리까지 표현할 수 있는 실수형 타입이다 */

            for (int j=0; j<N; j++) {
                int score = Integer.parseInt(st.nextToken());
                arr[j] = score;
                sum += score;
                /* 학생들의 성적을 배열에 저장하고 성적의 합을 구한다 */
            }
            double avg = (sum/N);
            double count = 0;
            /* 평균이 넘는 학생 수를 count 변수로 선언한다 */

            for (int j=0; j<N; j++) {
                if(arr[j] > avg) {
                    count++;
                }
            }
            System.out.printf("%.3f%%\n",(count/N)*100);
            /* %.3f로 포맷 출력을 지정해서 소수점 셋째 자리까지 출력 + % + %\n 은 줄바꿈 */
        }

    }

}