## 재귀

### ① 개념
컴퓨터 과학에 있어서 재귀(再歸, Recursion)는 자신을 정의할 때 자기 자신을 재참조하는 방법을 뜻하며, 이를 프로그래밍에 적용한 재귀 호출(Recursive call)의 형태로 많이 사용된다. </br>

**구현 조건**
1. 내가 원하는 값을 얻었을 때에는 조건(= base case)을 걸어 반드시 재귀를 끝내야 한다
2. 재귀 함수 속에 들어가는 인자 값이 계속해서 변해야 한다 (같은 인자 값이 계속해서 들어가게된다면 무한대로 함수를 실행하기 때문)

### ② 코드
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
- 완전탐색 방법 중 하나
- 탐색 트리의 수직방향으로 점차 깊은 곳까지 목표노드를 찾아 탐색해 나가는 기법(backtracking 과정이 존재)
### ① 그림으로 개념 알아보기
![Depth-First-Search](https://user-images.githubusercontent.com/42407740/137576448-61237db1-d5c6-4e0d-9371-408ac33f26a4.gif)


![](https://gmlwjd9405.github.io/images/algorithm-dfs-vs-bfs/dfs-example.png)
1. 현재 정점과 인접한 간선들을 하나씩 검사하다가,
2. 아직 방문하지 않은 정점으로 향하는 간선이 있다면 따라가고,
3. 더이상 갈 곳이 없다면 포기하고 마지막에 온 간선을 따라 이전으로 돌아간다.

### ② 구현 방법
> 정점의 집합 : V,  간선의 집합 : E  

#### 시간복잡도  
▷ 리스트 형태로 구현(위의 그림처럼) : **`O (|V| + |E|)`**  
dfs()는 한 정점마다 한 번씩 호출되므로, 정확히 |V|번 호출된다.  
모든 정점에 대해 dfs()를 수행 후, 모든 간선을 정확히 한 번(방향 그래프) 혹은 두 번(무방향 그래프) 확인함을 알 수 있다.  
  
▷ 행렬로 구현    : **`O (|V|²)`**  
dfs() 호출 횟수는 |V|번이다.  
인접 행렬을 사용할 때는 dfs() 내부에서 다른 모든 정점을 순회하며 두 정점 사이에 간선이 있는가를 확인해야 하기 때문에   
한 번의 실행에 O (|V|)의 시간이 든다.  

<br/>

#### 공간복잡도 :  각 깊이만큼의 메모리가 필요하므로 `O (|V|)` 
> 공간복잡도란,
>  프로그램을 실행시킨 후 완료하는 데 필요로 하는 자원 공간의 양이다.  
> 총 공간 요구 = 고정 공간 요구 + 가변 공간 요구로 나타낼 수 있다.  
> 시간복잡도가 알고리즘을 푸는데 걸리는 시간을 나타낸다면, 공간복잡도는 알고리즘을 푸는데 소모되는 컴퓨터 자원을 뜻한다.  
   

### ③ 코드
> Java
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
- 재귀적으로 문제를 하나씩 풀어나가되 현재 재귀를 통해 확인 중인 상태(노드)가 제한 조건에 위배되는지(유망하지 않은지) 판단한다.
- 제한 조건에 위배되는 경우 해당 상태(노드)를 제외하고 다음 단계로 나아간다.
- 현재 상태(노드)에서 다음 상태(노드)로 나아갈 수 있는 모든 경우를 찾되, 그 중 유망하지 않다면 현재에서 더 이상 나아가지 않고 이전의 상태(노드)로 돌아가 다음 상태(노드)를 검사한다.
- 더 이상 탐색할 필요가 없는(유망하지 않은) 상태(노드)를 제외하는 것을 가지치기(pruning)라고 한다.
 
즉, 이 방법을 통해 우리는 모든 경우의 수를 체크 하지 않고 필요한 것만 체크하여 전체 풀이 시간을 단축할 수 있게 된다!
> DFS도 백트래킹을 사용한 대표적인 알고리즘이다.

### ② 시간복잡도
보통 **Exponmential(지수, 2^n 꼴)** 이 일반적이다. 
경우를 제거하는 것은 상수로 취급하거나 조건을 만족하는 경우의 증가량보다 작기 때문에, 시간복잡도에서는 고려되지 않는다.

### ③ 코드
> Java
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
DFS : 깊이 우선 탐색하여 모든 노드를 방문하는 것을 목표로 한다.
Backtracking : 불필요한 탐색을 하지 않기 위해, 유망하지 않은 경우의 수를 줄이는 것을 목표로 한다.
</br>

### 참고
[백트래킹 (Backtracking) 알고리즘](https://hongjw1938.tistory.com/88)  
[DFS 와 백트래킹의 차이점](https://gamedevlog.tistory.com/49) 
