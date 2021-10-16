## 재귀

### ① 개념
- 컴퓨터 과학에 있어서 재귀(再歸, Recursion)는 자신을 정의할 때 자기 자신을 재참조하는 방법을 뜻하며, 이를 프로그래밍에 적용한 재귀 호출(Recursive call)의 형태로 많이 사용된다.
### ② 코드(kotlin)
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
##  깊이 우선 탐색(DFS, Depth First Search)
### ① 그림으로 개념 알아보기
![Depth-First-Search](https://user-images.githubusercontent.com/42407740/137576448-61237db1-d5c6-4e0d-9371-408ac33f26a4.gif)
- 완전탐색 방법 중 하나

- 탐색 트리의 수직방향으로 점차 깊은 곳까지 목표노드를 찾아 탐색해 나가는 기법(backtracking 과정이 존재)
### ② 구현 방법
- 시간복잡도 : 트리의 깊이가 목적 노드 깊이와 같을 때 최악의 경우 모든 노드를 다 검사하게 되는데 이때 전체 시간은 아래와 같다.

![1](https://user-images.githubusercontent.com/42407740/137576758-aac1ddf5-b07a-46b1-82d2-3fdc93dcc03d.JPG)

따라서 깊이 우선 탐색의 시간 복잡도는 ![2](https://user-images.githubusercontent.com/42407740/137576766-e83d73d5-b68e-4b84-aeee-af18f6d65113.JPG) 이다.

- 공간복잡도: 저장 공간에 저장해야할 노드들은 트리에서 루트 노드로부터 어떠한 노드까지의 경로상에 있는 각 노드의 자식들 중 해당 노드를 제외한 것들이다. 이때 가장 긴 경로의 길이가 d이므로 최악의 경우 깊이 우선 탐색에서 사용하는 전체 저장 공간은 아래와 같다.

![3](https://user-images.githubusercontent.com/42407740/137576791-54e71878-7f6c-4925-982a-e38fbd22e98a.JPG)

따라서 깊이 우선 탐색의 공간 복잡도는![4](https://user-images.githubusercontent.com/42407740/137576787-4ec0463e-70ea-4505-b4d3-3656048efc57.JPG)이다.

### ③ 코드(kotlin)
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

### ④ 방향 / 무방향 그래프
- 무방향 그래프(undirected graph) : 간선을 표현하는 두 정점의 쌍에 순서 즉 방향이 없는 그래프이다. 따라서 두 정점 V0와 V1을 잇는 간선 (V0, V1)과 (V1, V0)는 똑같은 간선을 나타낸다.

- 방향 그래프(directed graph) : 모든 간선을 순서가 있는 두 정점의 쌍으로 표현하는 즉, 간선이 방향을 가진 그래프이다. 방향 그래프에서는 하나의 간선을 V0 -> V1을 <V0, V1>이라 표기하며  V0를 tail, V1를 Head라 한다. 또한 방향 그래프에서는 <V0, V1>과  <V1, V0>는 다른 간선이다. 방향 그래프에서는 이 간선을 아크(arc)라고도 한다.
아래는 무방향 그래프와 방향 그래프이며 그에 해당하는그래프의 정점의 집합과 간선의 집합을 나타낸것이다.

![5](https://user-images.githubusercontent.com/42407740/137577053-48ab54a1-6c61-4bdc-9995-214b7d575ae0.JPG)

 V(a) = { 0, 1, 2, 3 }    E(a) = { (0, 1), (0, 2), (1, 2), (1, 3), (2, 3) } 

 V(b) = {0, 1, 2}         E(b) = { <0, 1>, <1, 0>, <1, 2> }

##  백트래킹(Backtracking)
### ① 개념
백트래킹은 알고리즘 기법 중 하나로, 재귀적으로 문제를 하나씩 풀어나가되 현재 재귀를 통해 확인 중인 상태(노드)가 제한 조건에 위배되는지(유망하지 않은지) 판단하고 그러한 경우 해당 상태(노드)를 제외하고 다음 단계로 나아가는 방식이다.

여기서 알아둘 것은 특정 상태(노드)를 제외한다는 것이다.

백트래킹은 현재 상태(노드)에서 다음 상태(노드)로 나아갈 수 있는 모든 경우를 찾되, 그 중 유망하지 않다면 현재에서 더 이상 나아가지 않고 이전의 상태(노드)로 돌아가 다음 상태(노드)를 검사한다.

여기서 더 이상 탐색할 필요가 없는(유망하지 않은) 상태(노드)를 제외하는 것을 가지치기(pruning)라고도 한다.
 
즉, 이 방법을 통해 우리는 모든 경우의 수를 체크 하지 않고 필요한 것만 체크하여 전체 풀이 시간을 단축할 수 있게 된다!

백트래킹을 사용하는 알고리즘 중 하나는 대표적으로 DFS가 있다. (관련 포스팅은 여기) DFS는 재귀를 통해 가능한 경로 중 유망한 경로만 찾아서 탐색을 수행한 뒤 다시 돌아와 그 중 가장 최적의 경로를 반환한다.

백트래킹을 사용해 해결할 수 있는 문제는 의사 결정, 최적화, 열거하기 등의 경우가 있다.

### ② 시간복잡도
백트래킹은 사용 가능한 경우가 많지만 시간복잡도가 보통 Exponential(지수, 2n꼴)이며, 대부분 Dynamic Programming, 그리디 알고리즘 등으로 더 빠르게 해결할 수 있다.

하지만 일부 경우의 문제들은 여전히 백트래킹으로만 해결이 가능한 문제도 있으며 그러한 경우에 많이 사용된다.

### ③ 코드(kotlin)
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
> ◾ DFS와 백트래킹(Backtracking)의 차이

DFS는 기본적으로 그래프 형태 자료구조에서 모든 정점을 탐색할 수 있는 알고리즘 중 하나이다. 깊이를 우선적으로 탐색하기에 재귀 또는 스택을 이용한다.

재귀를 이용하여 탐색을 수행한다는 부분에서 완전탐색 알고리즘의 재귀 / 백트래킹(Backtracking)과 유사한 측면이 보여 혼란이 올 수 있다.

그런데, 재귀라는 것은 말 그대로 스스로의 함수(또는 메소드)를 호출하는 방식을 의미하는 것이므로 DFS가 재귀라는 방식을 이용해 탐색을 수행하는 것으로 하나의 방식이라고 이해하면 된다.

또한 백트래킹(Backtracking)은 재귀를 통해 알고리즘을 풀어 가는 기법 중 하나로 가지치기(Pruning)을 통해서 탐색을 시도하다가 유망하지 않으면 추가 탐색을 하지 않고 다른 해를 찾는 방법이다.

DFS는 기본적으로 모든 노드를 탐색하는 것이 목적이지만 상황에 따라서 백트래킹 기법을 혼용하여 불 필요한 탐색을 그만두는 것이 가능하다.

즉, DFS와 백트래킹은 유사한 부분이 있으며 기본적으로 사용 목적이 다르지만 두 기법을 혼용하여 사용하는 것이 가능하다. 완전히 다른 개념이 아니라 재귀 호출을 통한 기법 중 하나 이기 때문이다.

</br>

### 참고
[https://hongjw1938.tistory.com/88#2.-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9-%EC%82%AC%EC%9A%A9-%EC%98%88]
[https://kingpodo.tistory.com/45]
