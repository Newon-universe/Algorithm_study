## 재귀
<img src="https://media.giphy.com/media/3ov9jQX2Ow4bM5xxuM/giphy.gif" width="30%"/>

### ① 개념
하나의 함수에서 자기 자신을 다시 호출해 작업을 수행하는 알고리즘  
재귀를 이해하기 위해서는, 기존에 가진 절차적 사고방식을 벗어나 **귀납적 사고방식**을 가져야 한다.  
> **귀납적 사고**는 작은 입력에 대해 옳다고 가정하고 큰 입력에 대한 처리를 진행하는 것을 말한다.  

#### 조건
* 특정 입력에 대해서는 자기 자신을 호출하지 않고 종료되어야 함 (**Base Condition**)
* 모든 입력은 Base Condition 으로 수렴해야 함

#### 절차
1. 함수 정의 (인자 등)
2. Base Condition 설정
3. 재귀 식 도출

### ② 코드
아래 코드는 n..1 까지 출력하는 재귀함수이다.
```java
public void printNumber(int n) {
  if(n == 0)
      return;
  System.out.println(n);
  printNumber(n - 1);
}
```

</br>

##  깊이 우선 탐색(DFS, Depth First Search)
### ① 그림으로 개념 알아보기
<img src="https://user-images.githubusercontent.com/48541984/137497637-43b1966b-5e17-48ce-99b9-80c7de5a9d1d.gif" width="300"/>

다차원 배열에서 각 칸을 방문할 때 **깊이** 우선으로 방문하는 알고리즘  

#### 동작 과정
1. 현재 정점과 인접한 간선들을 하나씩 검사하다가,
2. 아직 방문하지 않은 정점으로 향하는 간선이 있다면 따라가고,
3. 더이상 갈 곳이 없다면 포기하고 마지막에 온 간선을 따라 이전으로 돌아간다.

### ② 구현 방법
- **시간복잡도**
  - **인접 행렬**  

    DFS 하나에 for loop 를 V(정점)만큼 돌기에, O(V) 시간이 필요하다.  
    
    정점을 방문할 때마다 DFS를 부르는데, V개의 정점을 모두 방문하므로  
    
    DFS의 전체 시간 복잡도 = V * O(V) = **O(V^2)**  
  - **인접 리스트**  

    DFS 하나당 각 정점에 연결되어 있는 간선의 개수만큼 탐색을 하게 된다.  
    
    DFS가 다 끝났을 시점에 모든 정점을 한번씩 방문하고,  
    
    모든 간선을 한번씩 검사하게 되므로 **O(V+E)** (E 간선)의 시간이 걸린다.  

- **공간복잡도**  
   O(d) (d = 최대 깊이)

### ③ 코드
#### 인접 행렬로 표현한 경우
```java
public static void dfs_array_recursion(int v, int[][] adjArray, boolean[] visited) {
	int l = adjArray.length-1;
	visited[v] = true;
	System.out.print(v + " ");

	for(int i = 1; i <= l; i++) {
		if(adjArray[v][i] == 1 && !visited[i]) {
			dfs_array_recursion(i, adjArray, visited);
		}
	}
}
```

#### 인접 리스트로 표현한 경우
```java
public static void dfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
	visited[v] = true; // 정점 방문 표시
	System.out.print(v + " "); // 정점 출력

	Iterator<Integer> iter = adjList[v].listIterator(); // 정점 인접리스트 순회
	while (iter.hasNext()) {
		int w = iter.next();
		if (!visited[w]) // 방문하지 않은 정점이라면 
			dfs_list(w, adjList, visited); // 다시 DFS
	}
}
```

### ④ 방향 / 무방향 그래프
<img src="https://media.vlpt.us/images/jewon119/post/397487db-4f1f-4261-9e20-c3ba1c50d86b/qa.png" width="60%"/>

#### 방향 그래프
간선에 **방향이 존재**하는 그래프  
G(A,B) 와 G(B,A) 는 다름  

#### 무방향 그래프
간선을 통해 **양방향으로 이동**할 수 있는 그래프  
G(A,B) 는 G(B,A) 와 동일

</br>

##  백트래킹(Backtracking)
### ① 개념
현재 상태에서 가능한 모든 후보군을 따라 들어가며 탐색하는 알고리즘  
재귀적으로 문제를 하나씩 풀어나가되 현재 재귀를 통해 확인 중인 **상태(노드)** 가 제한 조건에 위배되는지(유망하지 않은지)  
판단하고, 그러한 경우 해당 상태(노드)를 제외하고 다음 단계로 나아가는 방식이다.  

### ② 시간복잡도
보통 **Exponmential(지수, 2^n 꼴)** 이 일반적이다.  
경우를 제거한다고 하지만, 경우를 제거하는 것은 상수로 취급하거나 조건을 만족하는 경우의 증가량보다 작기 때문에,  
시간복잡도에서는 크게 고려되지 않는다.  

◾ DFS와 백트래킹(Backtracking)의 차이  
> **DFS** 는 노드를 Depth 우선 순으로 방문하는 알고리즘을 말하며,  
> **백트래킹**은 재귀를 통해 알고리즘을 풀어 가는 기법중 하나로, 이를 구현하기 위해 DFS가 쓰인다.

> **DFS** 는 완전 탐색을 기본으로 하는 그래프 순회 깁버으로, 모든 노드를 방문하는 것읆 목표로 하며,  
> **백트래킹**은 불필요한 탐색을 하지 않기 위해 유망하지 않은 경우의 수를 줄이는 것을 목표로 한다.

</br>

### 참고  
[DFS, BFS 정리](https://bbangson.tistory.com/42)  
[Java / DFS 깊이 우선 탐색 - 인접리스트 / 인접행렬로 구현](https://minhamina.tistory.com/22)  
[백트래킹 (Backtracking) 알고리즘](https://hongjw1938.tistory.com/88)  
[DFS 와 백트래킹의 차이점](https://gamedevlog.tistory.com/49)  
