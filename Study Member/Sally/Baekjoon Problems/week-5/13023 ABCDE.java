import java.io.*;
import java.util.*;

public class Main {
    // N 사람 수, M 친구 관계 수
    static int N, M;
    static ArrayList<Integer>[] adjacencyList;
    static boolean visit[];

    public static void DFS(int current, int depth) {
      if(depth == 5) {
        System.out.println("1");
        System.exit(0);
      }

      visit[current] = true;
      
      for(int i : adjacencyList[current]) {
        if(!visit[i])
          DFS(i, depth + 1);
      }
      visit[current] = false;
    }

    public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      adjacencyList = new ArrayList[N];
      visit = new boolean[N];

      for(int i = 0; i < N; i++)
        adjacencyList[i] = new ArrayList<Integer>();

      for(int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        adjacencyList[N1].add(N2);
        adjacencyList[N2].add(N1);
      }

      for(int i = 0; i < N; i++)
        DFS(i, 1);

      System.out.println("0");
    }
}