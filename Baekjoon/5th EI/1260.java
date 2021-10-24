import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int v;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i < n + 1; i++) {
            if (graph[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void bfs(int start) {
        q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + " ");
            for (int i = 1; i < n + 1; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}