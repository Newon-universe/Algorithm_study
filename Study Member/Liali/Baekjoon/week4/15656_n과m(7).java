n과m(5) 에서 방문체크만 없애주기

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] input;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        visited = new boolean[N];
        arr = new int[M];
        input = new int[N];
        
        st = new StringTokenizer(br.readLine());  
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        
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
                visited[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1);
                visited[i] = false;
        }
    }
}
