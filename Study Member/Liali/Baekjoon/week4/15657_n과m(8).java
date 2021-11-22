(6)과 (7)을 같이 적용해서 풀기 : 방문체크 없애고, for문에서 시작지점 정해주기

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] input;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        input = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input); 
        
        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = at; i < N; i++) {    //시작지점 지정
                arr[depth] = input[i];
                dfs(i, depth + 1);      //i + 1 대신 i 부터 시작해주기
        } 
    }
}
