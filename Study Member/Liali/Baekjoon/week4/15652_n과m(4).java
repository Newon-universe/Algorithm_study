import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    //**중복으로 고를 수 있기 때문에 방문체크는 필요하지 않음**
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

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
        for (int i = 1; i <= N; i++) {     // i = 1부터 시작!!
            if(depth == 0 || arr[depth-1] <= i){
                arr[depth] = i;
                dfs(depth + 1);
            } 
        }
    }

}


    ********for 문이 i = 0으로 시작하는 경우**********
    for (int i = 0; i < N; i++) {
        if(depth == 0 || arr[depth] <= i+1){
            arr[depth] = i+1;     //i+1 이 arr 에 추가 과정에서 문제 발생 ( N=4, M=2 일때 [2, 2], [3, 3] 이 스킵됨 )
            dfs(depth + 1);
        }
    }
