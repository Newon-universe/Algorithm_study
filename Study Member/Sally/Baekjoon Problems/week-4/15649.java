import java.io.*;
import java.util.*;

// 비어있는 리스트에서 시작해 수를 하나씩 추가하면서
// 길이가 M인 수열이 완성되면 출력하는 방식으로 구현할 수 있다
// arr = 수열을 담을 배열 , isused = 특정 수가 쓰였는지 나타내는 배열
// fun(k) = 현재 k개까지 수를 택한 상황에서 arr[k] 를 정하는 함수
// base condition = 확인 완료 하면 종료
// for 문 = 1부터 n까지 수를 차례로 확인하며 아직 쓰이지 않은 수를 찾아냄
public class Main {
	static int n, m; // m은 길이
	static int[] arr = new int[10];
	static boolean[] isused = new boolean[10];
	static StringBuilder sb = new StringBuilder();

	public static void solution(int k) {
		if(k == m) {
			// 수열 출력
			for(int i = 0; i < m; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!isused[i]) {
				arr[k] = i;
				isused[i] = true;
				solution(k + 1);
				isused[i] = false;
			}
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		solution(0);
		System.out.println(sb);
    }
}