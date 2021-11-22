211727. 2xn타일링2

규칙찾기
2xn 크기의 사각형을 채우는 경우의 수는
 = (n-1의 경우에서 세로 타일 1개 추가하는 경우) + (n-2의 경우에서 가로타일 2개 또는 정사각형 타일 1개 추가하는 경우)
    ㄴ 가로를 +1 해서 채우는 방식은 한 가지, +2로 채우는 방식을 두 가지이기 때문
 = (n-1의 경우의 수) + (n-2의 경우의 수 * 2)

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
        }

        System.out.println(arr[n]);
    }
}
