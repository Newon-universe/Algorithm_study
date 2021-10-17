import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    private static void dfs(int n, int m, int d) {
        if(d == m) {
            for(int a : arr) sb.append(a + " ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[d] = i;
                dfs(n, m, d+1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        arr = new int[m]; visit = new boolean[n+1];

        dfs(n, m, 0);
        System.out.print(sb);
    }
}