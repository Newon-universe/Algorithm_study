import java.io.*;
import java.util.*;

public class Main {
    // N 정점, M 간선, V 탐색 시작할 정점 번호
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int current) {
      if(visit[current])
        return;

      visit[current] = true;
      sb.append(current + " ");

      for(int i : graph[current]) {
        if(!visit[i])
          DFS(i);
      }
    }

    public static void BFS(int current) {
      Queue<Integer> queue = new LinkedList<>();
      queue.add(current); // 시작점
      visit[current] = true;

      while(!queue.isEmpty()) {
        int n = queue.poll();
        sb.append(n + " ");

        for(int i : graph[n]) {
          if(!visit[i]) {
            queue.add(i);
            visit[i] = true;
          }
        }
      }
    }

    public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());

      graph = new ArrayList[N + 1];
      visit = new boolean[N + 1];

      for(int i = 1; i < N + 1; i++)
        graph[i] = new ArrayList<Integer>();

      for(int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
  
        graph[N1].add(N2);
        graph[N2].add(N1);
      }

      /*
      * 행렬은 1부터 순차적으로 접근하므로 처음부터 작은 순으로 접근,
      * 리스트는 삽입한 순서대로 들어가기에 정렬 필요 !
      */
      for(int i = 1; i < N + 1; i++)
        Collections.sort(graph[i]);

      DFS(V);
      sb.append("\n");
      
      visit = new boolean[N + 1];
      BFS(V);

      System.out.println(sb);
    }
}