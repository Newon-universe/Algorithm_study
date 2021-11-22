## 재귀
<<<<<<< HEAD
프로그래밍에서 재귀란 자기 자신을 호출하는 형태의 함수를 일컫는다.  
  
  
### ① 개념
#### 관점
재귀함수의 사용 의도는 선언형 프로그래밍의 관점에서 비롯된다.  
  
팩토리얼이란 n을 기준으로 n부터 1까지의 모든 수를 곱한 값이다. `(표기는 n!)`  
이때 명령형 프로그래밍의 관점에서 10!을 구하려면 다음과 같이 바라보게 된다.
  
```kotlin
var value = 1
for (i in 1..10){
    value *= i
}

----------------
value = 1 * 2
value = (1 * 2) * 3
value = (1 * 2 * 3) * 4
...
value = (1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9) * 10
```
- value 에 대하여 사용자는 모든 i 항들에 대하여 절차적으로 구하고 나서야 팩토리얼 n을 알게되는 것으로 `인식`한다.  
  
<br/>

이를 다시 선언형 프로그래밍 관점에서 바라본다면 다음과 같아진다.
  
```kotlin
fun Factorial(N: Int): Int{    
    if(N == 1) return 1
    return Factorial(N - 1) * N  
}

----------------
N == 10  Factorial(9) * 10
N == 9   Factorial(8) * 9
N == 8   Factorial(7) * 8
...
N == 2   Factorial(1) * 2
N == 1   1
```

- 재귀함수 Factorial 은 return 값이 재귀함수와 어떤 관계가 있는지 `선언`만 하였다.  
- 그 이후 절차에 관련한 것은 return 을 수행하는 컴퓨터에게 `맡겨버리고` 사용자는 `선언`에 해당하는 결과값을 갖는 것으로 `인식`한다.
  
같은 결과값이지만 `명령형 프로그래밍의 관점은 사용자가 모든 절차를 인지하고 있음을 전제`하는 반면  
`선언형 프로그래밍의 관점은 사용자가 결과와 그 나머지의 관계를 선언만` 한다는 점에서 차이가 나타난다.  
_E.g. 다이나믹 프로그래밍_  

<br/>

#### 조건
재귀함수는 자기 자신을 호출하기 때문에 자기 자신을 종료시킬 조건문이 항상 존재해야한다. `(base condition)`  
다시 한번 팩토리얼을 구하는 재귀함수를 살펴보면 if(N==1) 일때 재귀함수를 호출하지 않고서 return 하는 것을 알 수 있다.
  
```kotlin
fun Factorial(N: Int): Int{    
    if(N == 1) return 1               // 해당 부분이 Factorial 재귀함수의 base condition
    return Factorial(N - 1) * N  
}
```
  
재귀함수는 `base condition` 을 기점으로 종료하기 때문에 이를 고려해서 작성하는 것이 중요하다.    
일반적으로 `base condition` 은 재귀함수의 매개변수를 기준으로 설계하는 경우가 많다.  
위의 예제는 `fun Factorial(N: Int)` 는 `매개변수 N`을 기준으로 return 때마다 `N`을 줄여줌으로써  
재귀함수가 반복되면 될수록 base condition 에 가까워지도록 설계되었다.  

<br/>
  
### ② 코드
재귀함수는 for문, while 문에 비해 많은 자원을 사용해야 하며, 컴퓨터 관점에서 비효율적이다.  
그럼에도 불구하고 재귀함수를 사용한다면 코드의 간결함과 가독성으로 프로그래머의 시간을 아낄 수 있을 때 사용되게 된다.  
그 대표적인 예시가 하노이의 탑이다.  

```Kotlin
fun Hanoi(int N, int A, int B, int C){
	if(N > 0){
		Hanoi(N-1,A,C,B);
		println("$A 에서 $C 로 가장 맨 위의 원판 이동", A,C);
		Hanoi(N-1,B,A,C);
	}
}

fun main(){
	var N = br.readLine().toInt()
	Hanoi(N,1,2,3);
}
```

<br/>

##  깊이 우선 탐색(DFS, Depth First Search)
### ① 그림으로 개념 알아보기
<img src="https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif">

결국 모든 예시를 확인한다는 전제에서 브루트포스적인 방법이 사용된다.  
  
**용어**
- 정점      : 4, 7, 8, 10 처럼 깊이의 가장 마지막, `정점`
- 정점의 집합 : 4, 7, 8, 10 이 각각 지나온 모든 단계들을 합쳐서 이르는 말
- 간선      : 4의 정점 이후 7 정점의 첫 자식(5)을 갈 때 이를 간선이라 표현한다.  
> _간선은 트리개념에서 다시 한번 정리한다._

<br/>

### ② 구현 방법
> 정점의 집합 : V,  간선의 집합 : E  
> 무방향 그래프(undirected graph) : 간선의 방향이 없어 양 방향으로 이동 가능(즉 중복가능)  
> 방향그래프(directed graph) : 간선의 방향으로만 이동  

- 시간복잡도  
  
▷ 리스트 형태로 구현(위의 그림처럼) : O (|V| + |E|)  
dfs()는 한 정점마다 한 번씩 호출되므로, 정확히 |V|번 호출된다.  
모든 정점에 대해 dfs()를 수행 후, 모든 간선을 정확히 한 번(방향 그래프) 혹은 두 번(무방향 그래프) 확인함을 알 수 있다.  
  
▷ 행렬로 구현    : O (|V|²)  
=======

### ① 개념
<img src="https://media.giphy.com/media/3ov9jQX2Ow4bM5xxuM/giphy.gif" width="30%"/></br>
컴퓨터 과학에 있어서 재귀(再歸, Recursion)는 자신을 정의할 때 자기 자신을 재참조하는 방법을 뜻하며, 이를 프로그래밍에 적용한 재귀 호출(Recursive call)의 형태로 많이 사용된다. </br>

**구현 조건**
1. 내가 원하는 값을 얻었을 때에는 조건(= base case)을 걸어 반드시 재귀를 끝내야 한다
2. 재귀 함수 속에 들어가는 인자 값이 계속해서 변해야 한다 (같은 인자 값이 계속해서 들어가게된다면 무한대로 함수를 실행하기 때문)

### ② 코드
> Java
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
> Kotlin
```kotlin
/* 팩토리얼 구하기 */
fun factorial(n: Int, acc: Int): Int {
    return if (n <= 0) {
        acc
    } else {
        factorial(n-1, n*acc)
    }
}
```
> Python
```python
def recursive_function(i):
  if i == 100: 
    return 
  print(i,'번째 재귀 함수에서',i+1,'번째 재귀 함수를 호출합니다.')
  recursive_function(i + 1)
  print(i,'번째 재귀 함수를 종료합니다.')
  
 recursive_function(i)
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
>>>>>>> 347ceb67e85f1e1289eca13aa993a51a1b8a0b8b
dfs() 호출 횟수는 |V|번이다.  
인접 행렬을 사용할 때는 dfs() 내부에서 다른 모든 정점을 순회하며 두 정점 사이에 간선이 있는가를 확인해야 하기 때문에   
한 번의 실행에 O (|V|)의 시간이 든다.  

<br/>

<<<<<<< HEAD
- 공간복잡도
> 공간복잡도란 프로그램을 실행시킨 후 완료하는 데 필요로 하는 자원 공간의 양이다.  
> 총 공간 요구 = 고정 공간 요구 + 가변 공간 요구로 나타낼 수 있다.  
> 시간복잡도가 알고리즘을 푸는데 걸리는 시간을 나타낸다면, 공간복잡도는 알고리즘을 푸는데 소모되는 컴퓨터 자원을 뜻한다.  
  
각 깊이만큼의 메모리가 필요하므로 `O (|V|)`  
  
### ③ 코드
```Kotlin
fun dfs(graph: Graph) {
    fun dfs(current: Vertex, visited: MutableSet<Vertex>) {
        if (!visited.add(current)) return
        for (v in current.neighbors)
            dfs(v, visited)
    }

    dfs(graph.vertices[0], HashSet())
}
```

### ④ 방향 / 무방향 그래프
방향 그래프는 간선의 방향이 있음을 상정한다. 즉, 같은 정점간의 이동은 같은 방향이라며 `한개의 간선`으로 인지하는 것이다.  
무방향 그래프는 간선의 방향이 없음을 상정한다. 즉, 같은 정점간의 이동이더라도 방향이 없으므로, `각각 독자적인 간선`으로 인지한다.   

##  백트래킹(Backtracking)
### ① 개념
백트래킹은 모든 조합의 수를 살펴보는 것인데 단 조건이 만족할 때 만이다.  
즉 모든 조합을 살펴보되, 해당 조합이 조건을 불만족시킨다면 관련 조합을 더 이상 검색하지 않고 이전의 조합으로 되돌아가서 살펴보는 것이다.`가지치기`  

### ② 시간복잡도
모든 경우의 수 = 조합의 수 ^ 해당 조합 중에 조건을 만족하는 경우의 수

### ③ 코드
백트래킹으로 유명한 N-queen 문제이다. [N-Queen](https://www.acmicpc.net/problem/9663)  
  
> N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.  
> N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.  
  
```Kotlin

var N: Int
var count = 0;
var arr[15][15] = {0, };

fun CanLeftDiagnol(col: Int, row: Int): Bool{
    while(col >= 0 && row >= 0){
        if(arr[col][row] == 1){
            return false;
        }
        col -= 1;
        row -= 1;
    }
    return true;
}

fun CanRightDiagnol(col: Int, row: Int): Bool{
    while(col >= 0 && row <= N - 1){
        if(arr[col][row] == 1){
            return false;
        }
        col -= 1;
        row += 1;
    }
    return true;
}

fun CanCol(col: Int, row: Int): Bool{
    for(i in col downTo 0){
        if(arr[i][row] == 1){
            return false;
        }
    }
    return true;
}

fun Solve(k: Int){
    if (k == N){
        count += 1;
        return;
    }
    
    for(row in 0..N-1){
        if(CanCol(k, row) && CanLeftDiagnol(k, row) && CanRightDiagnol(k, row)){
            arr[k][row] = 1;
            Solve(k + 1);
            arr[k][row] = 0;
        }
    }
    return;
}

fun main(){
    N = readLine().toInt();
    Solve(0);
    print(count);
}
```

> ◾ DFS와 백트래킹(Backtracking)의 차이  
DFS 는 모든 정점을 살펴본 후 간선을 통해 이동하지만  
백트래킹은 하나의 정점에 도달하지 않더라도 유망하지 않으면 생략하고 다른 간선으로 이동한다.

</br>

### 참고
[플래승급전 2승 2패](https://github.com/Newon-universe/Algorithm_study)  
[\[알고리즘\] 깊이 우선 탐색 (depth-first search, DFS)](https://brenden.tistory.com/13)  
[공간복잡도](http://wiki.hash.kr/index.php/공간복잡도)  
[functions_kotlin.org](https://kotlinlang.org/docs/functions.html#local-functions)  
[\[알고리즘\] Backtracking 이해하기](https://jeongdowon.medium.com/알고리즘-backtracking-이해하기-13492b18bfa1)
=======
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

      // 방문한 정점와 인접한 모든 정점을 가져온다.
      Iterator<Integer> i = adj[v].listIterator();
      while (i.hasNext()) {
          int n = i.next();
          // 방문하지 않은 정점이면 해당 정점을 시작 정점로 다시 DFSUtil 호출
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
      // 정점의 방문 여부 판단 (초깃값: false)
      boolean visited[] = new boolean[V];

      // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
      for (int i=0; i<V; ++i) {
          if (visited[i] == false)
              DFSUtil(i, visited);
      }
  }
}
```
> Kotlin
```kotlin
/* 백준 13023 */
val br = System.`in`.bufferedReader()
val bw = System.`out`.bufferedWriter()

var N = 0//정점 수
var M = 0//간선 수
var graph = ArrayList<ArrayList<Int>>()
lateinit var visited : BooleanArray
var result = 0

fun solution() {
    var strtok = StringTokenizer(br.readLine())
    N = strtok.nextToken().toInt()
    M = strtok.nextToken().toInt()

    visited = BooleanArray(N)

    for(i in 0 until N)
        graph.add(ArrayList())

    for(i in 0 until M)
    {
        strtok = StringTokenizer(br.readLine())
        var from = strtok.nextToken().toInt()
        var to = strtok.nextToken().toInt()

        graph.get(from).add(to)
        graph.get(to).add(from)
    }

    for(i in 0 until N)
    {
        if(!visited[i])
        {
            visited[i] = true
            dfs(i, 0, visited)
            visited[i] = false
        }
        if(result == 1)
            break
    }

    bw.write(result.toString())
}

fun dfs(now : Int, depth : Int, visited : BooleanArray)
{
    if(depth == 4)
    {
        result = 1
        return
    }

    for(i in 0 until graph[now].size)
    {
        var next = graph[now][i]

        if(!visited[next])
        {
            visited[next] = true
            dfs(next, depth + 1, visited)
            visited[next] = false
        }
    }
}

fun main() {
    solution()
    br.close()
    bw.close()
}
```
> Python
```python
def dfs(graph,v,visited):
  visited[v] = True
  print(v,end='')
  for i in graph[v]:
    if not visited[i]:
      def(graph,i,visited)
      
graph = [
  [],
  [2,3,8],
  [1,7],
  [1,4,5],
  [3,5],
  [3,4],
  [7],
  [2,6,8],
  [1,7]
]

visited = [False] * 9

dfs(graph,1,visited)

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
- 제한 조건에 위배되는 경우 해당 상태(정점)를 제외하고 다음 단계로 나아간다.
- 현재 상태(정점)에서 다음 상태(정점)로 나아갈 수 있는 모든 경우를 찾되, 그 중 유망하지 않다면 현재에서 더 이상 나아가지 않고 이전의 상태(정점)로 돌아가 다음 상태(정점)를 검사한다.
- 더 이상 탐색할 필요가 없는(유망하지 않은) 상태(정점)를 제외하는 것을 가지치기(pruning)라고 한다.
 
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
> Kotlin
```kotlin
/* 백준 14889 */
package backjoon_14889

import java.util.*

lateinit var map: Array<IntArray>
lateinit var isVisited: BooleanArray
private var min = Integer.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    var size = br.readLine().toInt()

    map = Array(size) { IntArray(size) }
    isVisited = BooleanArray(size)
    for (i in 0 until size) {
        var strtok = StringTokenizer(br.readLine())

        for (j in 0 until size) {
            map[i][j] = strtok.nextToken().toInt()
        }
    }
    dfs(0, 0)
    println(min)
}

private fun dfs(index: Int, depth: Int) {
    if (depth == map.size / 2) {
        var startTeam = 0
        var linkTeam = 0
        for (i in 0 until map.size - 1) {
            for (j in i + 1 until map.size) {
                if (isVisited[i] && isVisited[j]) {
                    startTeam += map[i][j] + map[j][i]
                } else if (!isVisited[i] && !isVisited[j]) {
                    linkTeam += map[i][j] + map[j][i]
                }
            }
        }
        min = Math.min(min, Math.abs(startTeam - linkTeam))
        return
    }
    for (i in index until map.size) {
        if (!isVisited[i]) {
            isVisited[i] = true
            dfs(i + 1, depth + 1)
            isVisited[i] = false
        }
    }

}
```
> **DFS와 백트래킹(Backtracking)의 차이** </br>
> DFS : 깊이 우선 탐색하여 모든 정점을 방문하는 것을 목표로 한다. </br>
> Backtracking : 불필요한 탐색을 하지 않기 위해, 유망하지 않은 경우의 수를 줄이는 것을 목표로 한다.
</br>

### 피드백
간선 내용 더 추가해주세욥 (**정점과 노드, 같은 의미이니 용어 통일해주세요 :)**)
코틀린 코드 맨 마지막꺼 블랑코의 새로운 코드로 바꿔주세요 (**문의**)


### 참고
[글쓰는 개발자의 꿈](https://juyeop.tistory.com/16) 
[Heee's Development Blog](https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html)
[평범한 게임 개발자](https://gamedevlog.tistory.com/49)
[DFS, BFS 정리](https://bbangson.tistory.com/42)  
[백트래킹 (Backtracking) 알고리즘](https://hongjw1938.tistory.com/88)  
[DFS 와 백트래킹의 차이점](https://gamedevlog.tistory.com/49) 
>>>>>>> 347ceb67e85f1e1289eca13aa993a51a1b8a0b8b
