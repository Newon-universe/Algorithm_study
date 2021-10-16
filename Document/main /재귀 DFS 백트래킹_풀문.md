## 재귀

### ① 개념
어떤 사건이 자기 자신을 포함하고 다시 자기 자신을 사용하여 정의되는 것
### ② 코드
> 팩토리얼 구현 코드 예제
```java
public class Factorial {

    public static int factorial(int input){
        if(input > 0) return input * factorial(input - 1);
        else return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력해주세요 : "); int input = scanner.nextInt();
        System.out.println(input + "의 펙토리얼은 " + factorial(input) + "입니다.");
    }
}
```


##  깊이 우선 탐색(DFS, Depth First Search)
### ① 그림으로 개념 알아보기
![](https://gmlwjd9405.github.io/images/algorithm-dfs-vs-bfs/dfs-example.png)
1. a 노드(시작 노드)를 방문한다.
    + 방문한 노드는 방문했다고 표시한다.
2. a와 인접한 노드들을 차례로 순회한다.
    + a와 인접한 노드가 없다면 종료한다.
3. a와 이웃한 노드 b를 방문했다면, a와 인접한 또 다른 노드를 방문하기 전에 b의 이웃 노드들을 전부 방문해야 한다. 
    + b를 시작 정점으로 DFS를 다시 시작하여 b의 이웃 노드들을 방문한다.
4. b의 분기를 전부 완벽하게 탐색했다면 다시 a에 인접한 정점들 중에서 아직 방문이 안 된 정점을 찾는다.
    + 즉, b의 분기를 전부 완벽하게 탐색한 뒤에야 a의 다른 이웃 노드를 방문할 수 있다는 뜻이다.
    + 아직 방문이 안 된 정점이 없으면 종료한다.
    + 있으면 다시 그 정점을 시작 정점으로 DFS를 시작한다.
### ② 구현 방법
- 시간복잡도
  DFS는 그래프(정점의 수: N, 간선의 수: E)의 모든 간선을 조회한다.
  + 인접 리스트로 표현된 그래프: O(N+E)
  + 인접 행렬로 표현된 그래프: O(N^2)
- 공간복잡도
  Tree의 최대 깊이: O(log(N)) 

### ③ 코드
1. 순환호출을 이용한 DFS 의사코드
```java
void search(Node root) {
  if (root == null) return;
  // 1. root 노드 방문
  visit(root);
  root.visited = true; // 1-1. 방문한 노드를 표시
  // 2. root 노드와 인접한 정점을 모두 방문
  for each (Node n in root.adjacent) {
    if (n.visited == false) { // 4. 방문하지 않은 정점을 찾는다.
      search(n); // 3. root 노드와 인접한 정점 정점을 시작 정점으로 DFS를 시작
    }
  }
}
```
2. 순환호출을 이용한 DFS 구현 (java)
```java
import java.io.*;
import java.util.*;

/* 인접 리스트를 이용한 방향성 있는 그래프 클래스 */
class Graph {
  private int V;   // 노드의 개수
  private LinkedList<Integer> adj[]; // 인접 리스트

  /** 생성자 */
  Graph(int v) {
      V = v;
      adj = new LinkedList[v];
      for (int i=0; i<v; ++i) // 인접 리스트 초기화
          adj[i] = new LinkedList();
  }

  /** 노드를 연결 v->w */
  void addEdge(int v, int w) { adj[v].add(w); }

  /** DFS에 의해 사용되는 함수 */
  void DFSUtil(int v, boolean visited[]) {
      // 현재 노드를 방문한 것으로 표시하고 값을 출력
      visited[v] = true;
      System.out.print(v + " ");

      // 방문한 노드와 인접한 모든 노드를 가져온다.
      Iterator<Integer> i = adj[v].listIterator();
      while (i.hasNext()) {
          int n = i.next();
          // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
          if (!visited[n])
              DFSUtil(n, visited); // 순환 호출
      }
  }

  /** 주어진 노드를 시작 노드로 DFS 탐색 */
  void DFS(int v) {
      // 노드의 방문 여부 판단 (초깃값: false)
      boolean visited[] = new boolean[V];

      // v를 시작 노드로 DFSUtil 순환 호출
      DFSUtil(v, visited);
  }

  /** DFS 탐색 */
  void DFS() {
      // 노드의 방문 여부 판단 (초깃값: false)
      boolean visited[] = new boolean[V];

      // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
      for (int i=0; i<V; ++i) {
          if (visited[i] == false)
              DFSUtil(i, visited);
      }
  }
}
```
### ④ 방향 / 무방향 그래프
1. 유방향 그래프 
    + 방향이 있는 간선을 갖는다. 
    + 선은 단방향 관계를 나타내며, 각 간선은 한 방향으로만 진행할 수 있다.
    ![](https://kr.mathworks.com/help/matlab/math/simpledirectedgraph.png)
2. 무방향 그래프
    + 방향이 없는 간선을 갖는다.
    + 간선은 양방향 관계를 나타내며, 각 간선은 양방향으로 진행할 수 있다.
    ![](https://kr.mathworks.com/help/matlab/math/simpleundirectedgraph.png)
##  백트래킹(Backtracking)
### ① 개념
유망(promising)하면 탐색을 계속 진행하고, 유망하지 않으면 부모 노드로 다시 돌아가(Backtracking)는 것으로, 탐색 중 유망성 검사를 통해 가지치기(pruning)를 하는 기법 <br>
- (유망하다 = 해가 될 가능성이 있다) <br>
### ② 시간복잡도
모든 조합의 수를 살펴보는 것이므로 O(N^N)
### ③ 코드
```java
public class BackTracking_예제 {

	private static int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private static int cnt = 0;
	private static StringBuffer sb;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sb = new StringBuffer();
		int k = 10;
		
		for (int i = 0; i < k; i++) {
			cnt = 1;
			dfs(i, input[i] + " "); // 기준이 되는 자릿수를 변경해주는 것
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	private static void dfs(int v, String str) {
		System.out.println(str + "/" + cnt);
		if (cnt == 7) {
			sb.append(str + "\n");
		} else {
			for (int i = v + 1; i < 10; i++) {
				//System.out.println("cnt : " + cnt + " / " + " i : " + i);
				++cnt;
				dfs(i, str + input[i] + " ");
			/*	System.out.println("v값 : " + v);
				System.out.print("다시 돌아갔을 때의 i : " + i);*/
			}
		}
		--cnt;
		return;
	}
}
```

> ◾ DFS와 백트래킹(Backtracking)의 차이

두 알고리즘은 사용목적에 차이가 있다.
+ DFS : 깊이 우선 탐색하여 모든 노드를 방문하는 것을 목표로 한다.
+ Backtracking : 불필요한 탐색을 하지 않기 위해, 유망하지 않은 경우의 수를 줄이는 것을 목표로 한다.
</br>

### 참고
[글쓰는 개발자의 꿈](https://juyeop.tistory.com/16) <br>
[Heee's Development Blog](https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html)
[평범한 게임 개발자](https://gamedevlog.tistory.com/49)
[Trade Off](https://jasonyoo.tistory.com/59)
[Math Works](https://kr.mathworks.com/help/matlab/math/directed-and-undirected-graphs.html)
[플래너함](https://haams704.tistory.com/50)