import java.io.*;
import java.util.*;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        ArrayList<Integer> rising = new ArrayList<>();

        // 초기 비교값 설정을 위해 0 추가
        rising.add(0);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (rising.get(rising.size() - 1) < arr[i]) {
                rising.add(arr[i]);
            } else {
                int left = 1;
                int right = rising.size() - 1;
                // 이진 탐색
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (rising.get(mid) < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                rising.set(right, arr[i]);
            }
        }
        // 처음에 0을 추가해준 것을 제외하기 위해 -1
        System.out.println(rising.size() - 1);
    }
}
