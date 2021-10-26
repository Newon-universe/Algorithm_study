## 링크드리스트
<img src="https://user-images.githubusercontent.com/48541984/138364353-533a8122-87a3-4108-bb00-95667ab447cb.png" width="550" />

### ◾ 개념 및 형태
#### 개념
각 노드가 **데이터**와 **포인터**를 가지고 한줄로 연결되어 있는 방식의 자료구조  
데이터를 담고있는 노드들이 연결되어 있고, 노드의 포인터가 이전 노드와 다음 노드와의 연결을 담당  

#### 구조
* 노드(Node)와 링크(Link)로 구성
* **노드(Node)**: 실제 정보를 담고 있는 하나의 단위
* **링크(Link)**: 노드 간의 위치 정보를 저장하고 있어 연결리스트의 순서를 유지할 수 있도록 하는 연결고리
* 노드의 시작점은 **head**ㆍ끝점은 **tail** 이라 부르며, 노드의 추가ㆍ삭제ㆍ탐색 가능

#### 💡 ArrayList 와 차이
*ArrayList* 와 다르게 중간에 데이터가 추가되거나,  
중간에 있는 데이터가 삭제되어도 앞으로 땡기거나 뒤로 미는 동작이 없다.  
단지 추가되거나 삭제될 노드 위치의 바로 앞쪽에 있는 노드의 참조를 변경하면 된다.  

### ◾ 언어별 선언 및 사용방법(CRUD)
> Java
* LinkedList **선언**
```java
// 타입 미설정, Object 로 선언
LinkedList list = new LinkedList();

// 타입 설정, int 타입만 사용 가능
LinkedList<Integer> num = new LinkedList<Integer>();

// new 에서 타입 파라미터 생략 가능
LinkedList<Integer> num = new LinkedList<>();

// 생성 시 값 추가 가능
LinkedList<Integer> num = new LinkedList<Integer>(Arrays.asList(1,2));
```

* LinkedList **CRUD**
```java
// 값 추가
list.addFirst(1);
list.addLast(2);
list.add(1, 10); // index 1번에 데이터 10 추가

// 값 출력
list.get(1); // index 1번 값 읽어오기
list.contains(1); // list 에 값 1이 있는지 검색 : true
list.indexOf(1); // 1이 있는 index 반환 없다면 -1

// 값 변경
list.set(1, 10); // index 1번 값 10으로 변경

// 값 삭제
list.removeFirst();
list.removeLast();
list.clear(); // 모든 값 제거
```

### ◾ 시간복잡도
1. **데이터 탐색** : O(n)  
순차 접근 방식을 사용하기에 어떤 데이터를 찾기 위해서는  
처음부터 순차적으로 탐색해야 함  

2. **데이터 추가** : O(1) , O(n)  
추가하려는 데이터의 위치가 맨 앞이라면, O(1)  
그렇지 않은 경우 리스트를 순차적으로 탐색해야 하므로, O(n)  

3. **데이터 삭제** : O(1) , O(n)  
삭제하려는 데이터의 위치가 맨 앞이라면, O(1)  
그렇지 않은 경우 추가하는 경우와 마찬가지로, O(n)  

### ◾ 장점
* 자료의 삽입과 삭제가 용이
* 리스트 내에서 자료의 이동이 필요하지 않음
* 사용 후 메모리 재사용 가능
* 연속적인 메모리 할당이 필요하지 않음

### ◾ 단점
* 포인터 사용으로 인한 저장 공간 낭비 있음
* 복잡한 알고리즘
* 특정 자료의 탐색 시간이 많이 소요됨

</br>

## 그래프
### ◾ 개념
**정점** (Node, Vertex) 과 **간선** (Edge) 으로 이루어진 자료구조  
객체 사이의 연결 관계를 설정해야 하는 상황에서 활용  

#### 💡 그래프 관련 용어
1. **차수**(degree) : 각 정점에 연결된 간선의 수  
2. **outdegree** : 자신에게서 나가는 간선의 수  
3. **indegree** : 자신에게 들어오는 간선의 수  
4. **루프**(loop) : 한 정점에서 시작해 같은 정점으로 들어오는 간선  
5. **사이클**(cycle) : 임의의 한 정점에서 출발해 자기 자신으로 돌아올 수 있는 경로  

### ◾ 구현방법 1 : 인접 리스트 이용
<img src="https://user-images.githubusercontent.com/48541984/138534240-d5eecbb1-430e-4146-8d1d-0324d13731d3.png" width="550" />

#### 구현방법
**인접리스트**란 그래프의 정점들을 리스트로 표현한 것이다.  
주로 정점의 리스트 배열을 만들어 관계를 설정해줌으로써 구현한다.  

#### 장점
* 정점들의 연결 정보를 탐색할 때 O(n)의 시간이면 가능하다. (n : 간선의 수)
* 필요한 만큼의 공간만 사용하기 떄문에 공간 낭비가 적다.

#### 단점
* 특정 두 점이 연결되었는지 확인하려면 인접행렬에 비해 시간이 오래 걸린다. (배열보다 검색 속도 느림)
* 구현이 비교적 어렵다.

#### 시간복잡도
> V는 Vertex 정점이며, E는 Edge 간선  
1. 두 정점이 연결되었는지 확인하는데 걸리는 시간 : O(V)
2. 한 정점에 연결된 모든 정점들을 확인하는데 걸리는 시간 : O(E)
3. 공간복잡도 : O(V + E)

### ◾ 구현방법 2 : 인접 행렬 이용
<img src="https://user-images.githubusercontent.com/48541984/138534212-088def19-4750-406a-8da4-1d48f992eab6.png" width="550" />

#### 구현방법
**인접행렬**은 그래프의 정점을 2차원 배열로 만든 것이다.  
완성된 배열의 모양은 1, 2, 3, 4, 5, 6 의 정점을 연결하는 정점에 다른 정점들이 인접 정점이라면 1, 아니면 0을 넣는다.  

#### 장점
* 2차원 배열 안에 모든 정점들의 간선 정보를 담기 떄문에 배열의 위치를 통해 빠르게 연결 정보를 확인 가능하다.
* 구현이 비교적 간편하다.

#### 단점
* 모든 정점에 대해 간선 정보를 대입해야 하므로 O(n²)의 시간복잡도가 소요된다.
* 무조건 2차원 배열이 필요하기에  필요 이상의 공간이 낭비된다.

#### 시간복잡도
> V는 Vertex 정점이며, E는 Edge 간선  
1. 두 정점이 연결되었는지 확인하는데 걸리는 시간 : O(1)
2. 한 정점에 연결된 모든 정점들을 확인하는데 걸리는 시간 : O(V)
3. 공간복잡도 : O(V^2)

</br>

## 큐
<img src="https://media.vlpt.us/images/gillog/post/63841ffd-fffc-4825-97ae-7ebac63af39a/bandicam%202020-10-13%2010-49-20-585.png" width="550" />

### ◾ 개념
구조적으로 먼저 들어간 원소가 먼저 나오게 되는, FILO(First In Last One) 자료구조  
큐는 한쪽 끝은 **front** 로 정하여 삭제 연산만 수행  
다른 한쪽 끝은 **rear** 로 정하여 삽입 연산만 수행  
그래의 넓이 우선 탐색(BFS)에서 사용  

### ◾ 언어별 선언 및 사용방법(CRUD)
> Java
* Queue **선언**
```java
import java.util.LinkedList;
import java.util.Queue;

Queue<Integer> queue = new LinkedList<>(); // int 형 queue
```

* Queue **CRUD**
```java
// 값 추가
queue.add(1);
queue.offer(2);

// 값 출력
queue.peek(); // 첫번째 값 참조

// 값 변경
queue.set(1, 10); // index 1번 값 10으로 변경

// 값 삭제
queue.poll(); // 첫번째 값 반환하고 제거, 비어있다면 null
queue.remove(); // 첫번째 값 제거
queue.clear(); // 초기화
```

### ◾ 시간복잡도
1. **데이터 삽입ㆍ삭제** : O(1)  
항상 맨 앞에서 데이터를 삽입하거나 삭제하기에 O(1)  

2. **데이터 탐색** : O(n)  
특정 데이터를 찾을 때까지 탐색을 수행해야 하기에 O(n)  

### ◾ 장점
* 입력된 순서대로 데이터를 처리해야 할 때 유리

### ◾ 단점
* 크기가 제한적
* 큐의 앞부분이 비어있어도 데이터를 삽입할 수 없음
* 큐가 비어있어도 not empty 로 판단할 수 있음  

</br>

## BFS (너비우선탐색 : Breadth First Search)
<img src="https://user-images.githubusercontent.com/48541984/138526861-780c6014-6b1b-49aa-81a4-25c25b75994e.gif"/>
                                                                                                                           
### ◾ 개념
다차원 배열에서 각 칸을 방문할 때 **너비**를 우선으로 방문하는 알고리즘  
**그래프(간선+정점)** 라는 자료구조에서 모든 정점을 방문하기 위한 알고리즘  
일반적으로 **큐 (Queue)** 를 활용하여 구현  

#### 동작과정
1. 시작하는 칸을 큐에 넣고 방문했다는 표시를 남김  
2. 큐에서 원소를 꺼내어 그 칸에 상하좌우로 인접한 칸에 대해 3번을 진행  
3. 해당 칸을 이전에 방문했다면 아무것도 하지 않고, 처음으로 방문했다면 방문했다는 표시를 남기고 해당 칸을 큐에 삽입  
4. 큐가 빌 때 까지 2번을 반복  

### ◾ 시간복잡도
모든 칸이 큐에 1번씩 들어가므로 시간복잡도는 칸이 n개일 때, **O(n)**  

### ◾ BFS와 DFS의 비교
BFS는 너비 우선 , DFS는 깊이 우선으로 탐색을 수행  
BFS는 큐를 , DFS는 스택 또는 재귀함수를 이용해 구현  

### ◾ 코드
> Java
```java
import java.io.*;
import java.util.*;

public class Main {
	static Queue<Pair> queue = new LinkedList<>();
	static int map[][];
	static boolean visited[][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int N; // 세로 길이
	static int M; // 가로 길이

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();

			this.x = x;
			this.y = y;
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

                 visited[0][0] = true;
		  queue.add(new Pair(0, 0));

        while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = pair.x + dx[dir];
				int ny = pair.y + dy[dir];

				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny] || map[nx][ny] == 0) continue;

				visited[nx][ny] = true;
				queue.add(new Pair(nx, ny));
			}
		}
	}
}
```

</br>

## 참고
[Java / 자바 LinkedList 사용법 & 예제 총정리](https://coding-factory.tistory.com/552)  
[LinkedList 시간복잡도에 대하여](https://m.blog.naver.com/raylee00/221944085465)  
[Java / 자바 Queue 클래스 사용법 & 예제 총정리](https://coding-factory.tistory.com/602)  
[BFS와 DFS 비교](https://devuna.tistory.com/m/32)  
[자료구조 그래프(Graph) 란?](https://coding-factory.tistory.com/610)  
[그래프의 시간복잡도와 공간복잡도에 대하여](https://codermun-log.tistory.com/288)  
