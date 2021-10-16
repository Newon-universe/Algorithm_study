## 재귀

### ① 개념
단어 그대로 자기 자신으로 되돌아온다는 뜻이다. 프로그래밍에서는 비슷한 형태의 인자들로 같은 연산을 반복할 때 사용한다. 개념적으로는 for와 while 같은 반복문과 거의 같지만, 반복문은 괄호 내에서 반복이 일괄적으로 수행되기 때문에 특수한 경우에는 오히려 불편해 재귀 알고리즘을 사용한다. 재귀에는 자기 자신안에서 종료조건까지 계속해서 호출되는 직접재귀가 있고, 다른 함수로 반복 호출되게 하는 간접재귀가 있다.

### ② 코드
대표적인 factorial 함수 예제다.

```Kotlin
fun factorial(n: Int): Long = if (n==1) n.toLong() else n * factorial(n-1) // 코틀린은 함수를 식으로 표힌이 가능한데, factorial 함수식 내에 factorial 함수가 또 호출되고 있는걸 볼 수 있다.
fun main() {
  val num = 10
  val result: Long = factorial(num)
  println("Factorial: $num -> $result")
}
```


##  깊이 우선 탐색(DFS, Depth First Search)

### ① 그림으로 개념 알아보기
![img](https://media.vlpt.us/images/sukong/post/b9042f15-fb5b-4272-abe7-8cdeb3f0f22f/DFS.png)
트리나 그래프에서 한 루트로 탐색하다가 특정 상황에서 최대한 깊숙히 들어가서 확인한 뒤 다시 돌아가 다른 루트로 탐색하는 방식이다. 대표적으로 백트래킹에 사용한다.
한 방향으로 인접한 노드가 없을 때까지 (가장 아래의 노드까지) 탐색하는 방식이다. 노드라고 하면 좀 헷갈리는데 방법론적으로 설명하자면 어떤 문제의 가능한 해결방법들(노드들)을 늘어놓고 한번씩 다 트라이 해본다는 의미다. 인접한 노드끼리는 상위의 해결방법에서 파생된 방법정도로 이해하면 된다.

### ② 구현 방법

- 시간복잡도
O(n). n은 최대 노드 수. 모든 노드를 다 돌아본다는 이유로 완전탐색과 시간복잡도를 헷갈리는 경우가 있을 수 있지만, 프로그래밍적으로 완전탐색은 탐색시마다 스택이 계속해서 쌓이는 반면, DFS는 노드를 탐색하고 되돌아갈 때 직전에 탐색한 노드의 스택을 제거하고 돌아가기 때문에 완전탐색보다는 시간이 더 적게 걸린다. 프로그래밍적으로.(사실 사람이 직접한다고 하면 그게 그거일 수도. 근데 원래 시간복잡도라는 의미가 컴퓨터 입장에서 걸리는 시간을 측정하는거기 때문에 결과가 이렇다.)

- 공간복잡도
O(d). d는 최대 깊이. RPG 게임에서 맵 이동가능 타일을 계산하는 방식으로 예를 들 수 있다. 아무튼 최대 맵 타일의 길이를 깊이로 치환해서 생각해서, 어느 맵 타일까지 이동할 수 있는지 전체 맵의 깊이만큼 계산하면서 되돌아오며, 캐릭터의 접근이 불가능한 맵 타일에서는 캐릭터의 이동경로를 제어하는 방식으로 쓰인다고 한다.

### ③ 코드

```Kotlin
import java.util.*
 
var a = Array(10, { mutableListOf<Int>() })
var check = BooleanArray(10,{false})
 
fun dfs(node: Int){
 
    check[node]=true
    print("$node ")
    for(i in 0..a[node].size-1){
        var next = a[node][i]
        if(check[next])continue
        dfs(next)
    }
}
 
fun main() {
 
    a[1].add(2)
    a[1].add(3)
    a[2].add(1)
    a[2].add(3)
    a[2].add(4)
    a[2].add(5)
    a[3].add(1)
    a[3].add(2)
    a[3].add(6)
    a[3].add(7)
    a[4].add(2)
    a[4].add(5)
    a[5].add(2)
    a[5].add(4)
    a[6].add(3)
    a[6].add(7)
    a[7].add(3)
    a[7].add(6)
    dfs(1)
}
```

### ④ 방향 / 무방향 그래프
그래프는 관계를 나타내는 노드와 간선으로 구성된 모음이다. 노드는 대응하는 객체를 나타내는 정점이다. 간선은 객체 사이를 잇는 연결이다.
#### 방향 그래프
![img](https://kr.mathworks.com/help/matlab/math/simpleundirectedgraph.png)
방향이 없는 간선을 갖는다. 간선은 양방향 관계를 나타내며, 각 간선은 양방향으로 진행할 수 있다.
#### 무방향 그래프
![img](https://kr.mathworks.com/help/matlab/math/simpledirectedgraph.png)
간선은 단방향 관계를 나타내며, 각 간선은 한 방향으로만 진행할 수 있다.

##  백트래킹(Backtracking)

### ① 개념
DFS의 비효율성을 개선하기 위해 옳지 않은 경로를 차단하고 목표지점에 갈수있는 가능성을 가진 루트만 검사하는 것이 백트래킹 알고리즘이다. DFS에 가지치기를 옳을 가능성이 높은 방향으로만 치게하는 것이다.

### ② 시간복잡도
가능한 거의 모든 해를 탐색한다는 면에서 O(N^N) 혹은 O(N^2)의 완전탐색방식에 준하는 높은 시간복잡도를 가지지만 조건이 달려있고, 조건을 만족할 때만 따지기 때문에 노드 수에 따라 그때그때 다르다.

### ③ 코드
백준 2661번 좋은 수열을 고르는 문제 예제다.

```Koltin
import java.util.*
import kotlin.system.exitProcess


lateinit var arr: IntArray
var n: Int = 0
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    arr = IntArray(n)
    dfs(0, "")
}

fun dfs(depth: Int, num: String) {
    if (depth == n) {
        println(num)
        exitProcess(0) // 가장 작은수 발견 종료
    }
    for (i in 1..3) {
        if (check(num + i)) {
            dfs(depth+1, num + i)
        }
    }
}

// 좋은 수열인지 검사
fun check(num: String): Boolean {
    for (i in 1..num.length / 2) {
        val left = num.substring(num.length - i * 2, num.length - i)
        val right = num.substring(num.length - i, num.length)
        if (left == right) return false
    }
    return true
}
```

> ◾ DFS와 백트래킹(Backtracking)의 차이
DFS는 기본적으로 그래프 형태 자료구조에서 모든 정점을 탐색할 수 있는 알고리즘 중 하나이다. 깊이를 우선적으로 탐색하기에 재귀 또는 스택을 이용한다.
백트래킹은 재귀를 통해 알고리즘을 풀어 가는 기법 중 하나로 가지치기(Pruning)을 통해서 탐색을 시도하다가 유망하지 않으면 추가 탐색을 하지 않고 다른 해를 찾는 방법이다.
결국 가능한 모든 노드들을 탐색하느냐, 아니면 조금이라도 정답에 가까울 것 같은 노드들 위주로 탐색하느냐 차이다.


</br>

### 참고
https://itandhumanities.tistory.com/27
https://namu.wiki/w/%EA%B9%8A%EC%9D%B4%20%EC%9A%B0%EC%84%A0%20%ED%83%90%EC%83%89?from=DFS
https://velog.io/@ehdrms2034/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%9E%98%ED%94%84%EC%9D%98-%EA%B9%8A%EC%9D%B4-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89-DFS
https://wlshddlek.tistory.com/9
https://hongjw1938.tistory.com/88
https://velog.io/@sohi_5/algorithmDFS

