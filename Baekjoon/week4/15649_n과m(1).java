import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int N, M;  //변하지 않는 값이니 정적 변수로 선언하는게 더 편함
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();  //string 추가가 많으니 String 대신에 StringBuilder 사용
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());   //문자열 분리 위해
 
		int N = Integer.parseInt(st.nextToken());   //N개 중에서
		int M = Integer.parseInt(st.nextToken());   //중복없이 M개를 뽑는 순열
 
		arr = new int[M];        //찾은 순열을 넣을 배열 선언
		visit = new boolean[N];  //방문체크 위한 boolean 배열 선언 (N과 같은 길이)
		dfs(0);
		System.out.println(sb); 
 
	}
 
	public static void dfs(int depth) {
		if (depth == M) {  //재귀 깊이가 M과 같아지면
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {   //해당 노드를 방문하지 않았다면 (방문했으면 if문 실행안되고 for문의 i++해서 다시 검색)
				visit[i] = true;    //방문상태로 변경
				arr[depth] = i + 1;   // 이해 ✅
				dfs(depth + 1);    //다음 자식노드 방문 위해 depth를 1 증가시켜 재귀호출. 여기서 재귀호출을 시키면 아랫줄 안거치고 바로, dfs 함수가 따로 추가로 실행되는 것!!
				visit[i] = false;  //자식노드 방문 끝나고 돌아오면, 방문하지 않은 상태로 변경
			}
		}
	}
 
}
