## 재귀
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
dfs() 호출 횟수는 |V|번이다.  
인접 행렬을 사용할 때는 dfs() 내부에서 다른 모든 정점을 순회하며 두 정점 사이에 간선이 있는가를 확인해야 하기 때문에   
한 번의 실행에 O (|V|)의 시간이 든다.  

<br/>

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
