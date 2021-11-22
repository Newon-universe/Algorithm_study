import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] input;  //두번째줄 숫자들 넣는 배열
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
    
        visited = new boolean[N];
        arr = new int[M];
        input = new int[N];   //초기화 해줘야 NPE 안뜸
        
        st = new StringTokenizer(br.readLine());  //둘째줄 입력받기 - 인스턴스 다시 만들어줘야 에러 안뜸
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);   //오름차순으로 정렬

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = input[i];  //input 의 숫자들을 인덱스 순으로 arr 에 넣어주기 (input 내에서 for 문 x)
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

}
