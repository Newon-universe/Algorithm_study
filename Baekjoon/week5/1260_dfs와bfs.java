package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class bfs_dfs_1260 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[node+1];

        //arraylist 생성. 각각 arraylist에 연결된 노드의 정보가 들어간다.
        ArrayList<Integer>[] adjlist = new ArrayList[node+1];   //일차원 배열 생성 : [null, null, null, null, null]
        //초기화를 해서 생성을 하지 않으면 오류뜸
        for(int i = 0; i < adjlist.length; i++) {
            adjlist[i] = new ArrayList<Integer>();   //빈 이차원 배열 생성 (adjlist 안에 또 배열 넣기)
        }

        //배열에 각 노드를 추가
        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            adjlist[a1].add(a2);
            adjlist[a2].add(a1);
        }

//        System.out.println(Arrays.toString(adjlist));  //[[], [2, 3, 4], [1, 4], [1, 4], [1, 2, 3]]

        //자식이 여러개라면 노드 번호가 작은 것 먼저 방문하므로 오름차순으로 정렬
        for(int i = 0; i < adjlist.length; i++) {
            Collections.sort(adjlist[i]);    // Arraylist 일 때는 Collections.sort() 사용
        }

        dfs(adjlist, visited, start);
        System.out.println();          // 한줄 띄어주기
        Arrays.fill(visited, false);   //방문체크 배열 초기화
        bfs(adjlist, visited, start);
    }

    public static void dfs(ArrayList<Integer>[] adjlist, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int e : adjlist[v]) {
            if(!visited[e]) {
                dfs(adjlist, visited, e);   //재귀적으로 호출
            }
        }
    }

    public static void bfs(ArrayList<Integer>[] adjlist, boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();   //링크드리스트로 큐 선언
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for(int e : adjlist[v]) {
                if(!visited[e]) {
                    q.add(e);
                    visited[e] = true;
                }
            }
        }
    }
}

