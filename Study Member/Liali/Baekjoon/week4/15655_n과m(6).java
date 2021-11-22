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
        input = new int[N];   
        
        st = new StringTokenizer(br.readLine());  
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);   

        dfs(0, 0);
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
        
        for (int i = at; i < N; i++) {  //오름차순 수열을 만들어야 하므로, i를 at부터 시작해서 더 작은 숫자는 고르지 않도록 하기
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = input[i];
                dfs(i + 1, depth + 1);   //dfs(at + 1, depth + 1) 이 아님에 주의
                visited[i] = false;
            }
            
        }
    }

}
