## 링크드리스트

### ◾ 개념 및 형태
![캡처2JPG](https://user-images.githubusercontent.com/42407740/138537638-70983d99-f0ea-4be8-a9a7-0ec80dd658cd.JPG)

Linked List는 여러 노드들이 아래의 그림과 같은 구조로 연결되어있는 구조이다. 연결 리스트의 맨 앞을 head라고 하고 맨 마지막을 tail이라고 한다.

### ◾ 언어별 선언 및 사용방법(CRUD)

제네릭 표현 타입을 이용해서 어느 자료형이든 LinkedList를 사용할 수 있습니다.

```kotlin
class LinkedList<E> {
    private var head: Node<E>? = null

    private inner class Node<E>(
        var data: E,
        var next: Node<E>? = null
    )

    private fun addFirst(item: E) {
        head = Node(item)
    }

    fun add(item: E) {
        if (head == null) addFirst(item)
        else {
            var node = head
            while (node?.next != null) node = node.next
            node?.next = Node(item)
        }
    }

    fun delete(item: E) {
        if (head == null) return println("노드가 존재하지 않습니다.")
        else {
            if (head?.data == item) {
                head = head?.next
            } else {
                var node = head
                while (node?.next?.data != item) node = node?.next
                node?.next = node?.next?.next
            }
        }
    }

    fun desc() {
        var node = head
        while (node != null) {
            print("${node.data} ")
            node = node.next
        }
        println()
    }
}
```
### ◾ 시간복잡도

- 삽입 : O(1) 오직 앞 요소와 다음 요소와 연결시켜주는 operation만 수행

- 삭제 : O(1) 삭제하고자 하는 요소의 이 전 요소와 다음 요소를 연결시켜주는 operation이 수행

- 검색 : O(n) 맨 앞의 리스트에서부터 그 다음의 노드들로 순차적으로 검색

### ◾ 장점

- 포인터를 통하여 다음 데이터의 위치를 가르켜고 있어 삽입 삭제의 용이.

- 동적이므로 크기가 정해져 있지 않다.

- 불연속적이므로 메모리 재사용,관리의 편리

- 오버헤드가 발생하지 않는다.

### ◾ 단점

- 검색 성능이 좋지 않다.(첫 항목부터 순차적으로 접근해야하기 때문)

- 포인터를 통해 다음 데이터를 가르키므로 추가적인 메모리 공간 발생.

- 연결을 위한 링크부분이 필요하기 때문에 순차리스트보다 메모리 이용 효율이 좋지않다 -> 배열의 항목은 물리적으로 인접해있어 접근 시간 단축과 캐싱에 유리하다고 한다. 하지만 연결리스트는 아니다.

- 물리적으로 인접한 메모리에 위치해 있지 않다.

- 배열에 비해서 구현이 복잡하다
</br>

## 그래프

### ◾ 개념
![캡처](https://user-images.githubusercontent.com/42407740/138536803-21888834-d94c-4790-ae26-bdf36c669a94.JPG)

정점과 간선으로 이루어진 자료구조로 정점간의 관계를 표현하는 조직도라고 볼 수 있다. 트리는 그래프의 일종이지만 트리와 달리 그래프는 정점마다 간선이 없을수도 있고, 루트 노드, 부모와 자식간의 개념이 존재하지 않는다.

 정점(vertice) : 노드(node)라고도 하며 정점에는 데이터가 저장된다. (0, 1, 2, 3)

 간선(edge): 링크(arcs)라고도 하며 노드간의 관계를 나타낸다

 차수(degree): 무방향 그래프에서 하나의 정점에 인접한 정점의 수 (정점 2의 차수는 3)

그래프의 종류에는 무방향그래프, 방향그래프, 가중치그래프, 완전그래프 등이 있다.

### ◾ 구현방법 1 : 인접 리스트 이용
그래프의 노드들을 리스트로 표현한 것 이다. 주로 정점의 리스트 배열을 만들어 관계를 설정해줌으로써 구현가능하다. 
 
장점 :

 1. 정점들의 연결 정보를 탐색할 때 O(n) 의 시간이면 가능하다. (n: 간선의 갯수)

 2. 필요한 만큼의 공간만 사용하기때문에 공간의 낭비가 적다.
 
단점 :
 
 1. 특정 두 점이 연결되었는지 확인하려면 인접행렬에 비해 시간이 오래 걸린다. (배열보다 search 속도느림)
 
 2. 구현이 비교적 어렵습니다.
 
### ◾ 구현방법 2 : 인접 행렬 이용

인접행렬은 그래프의 노드를 2차원 배열로 만든 것이다. 완성된 배열의 모양은 1, 2, 3, 4, 5, 6의 정점을 연결하는 노드에 다른 노드들이 인접 정점이라면 1, 아니면 0을 넣어준다.

장점 :

 1. 2차원 배열 안에 모든 정점들의 간선 정보를 담기 때문에 배열의 위치를 확인하면 두 점에 대한 연결 정보를 조회할 때 O(1) 의 시간 복잡도면 가능하다.
 
 2. 구현이 비교적 간편하다.

단점 :

 1. 모든 정점에 대해 간선 정보를 대입해야 하므로 O(n²) 의 시간복잡도가 소요된다.
 
 2. 무조건 2차원 배열이 필요하기에 필요 이상의 공간이 낭비됨.

</br>

## 큐

### ◾ 개념
Queue란 FIFO(First In First Out)의 특징을 갖는 자료 구조이다. 즉, 먼저 들어온 값이 먼저 나가는 자료구조이다.

### ◾ 언어별 선언 및 사용방법(CRUD)
Kotlin에서는 Queue를 구현하기 위해 JCF(Java Collection Framework)에서 제공하는 Queue Interface를 이용한다.
하지만, Queue는 단순한 인터페이스이므로, 인터페이스를 구현하는 Class를 사용해야 하는데, 우리는 우리는 그중 LinkedList를 사용하여 Queue를 다루어본다.

1. add, offer : add와 offer은 값을 Queue에 추가해주기 위한 연산이다. add는 Queue의 Capacity 인한 오류 발생 시 Exception이 발생하고, offer는 발생하지 않는다는게 차이점이다. 하지만, 현재 다루는 LinkedList에서는 메모리의 한계까지 LinkedList를 만들지 않는 이상 용량 값의 제한이 발생하기 어렵기 때문에 어느 것을 써도 상관없다. 이후 다루는 ArrayBlockingQueue에서는 용량 값에 제한을 줄 수 있어, 이때 주의해서 보아야 한다.

2. remove, poll : remove와 poll은 Queue에서 값을 빼내기 위한 연산이다. remove와 poll 수행 시 가장 먼저 들어간 데이터가 return 된다. remove와 poll 또한 값이 null이 나올 경우 error handling이 되어있는지 안되어 있는지에 대한 차이점을 가지고 있다. remove는 더이상 빼낼 데이터가 없을 경우 NoSuchElementException을 발생시키고, poll은 null을 리턴한다. 

3. element, peek : element와 peek은 현재 Queue의 Head에 어떤 값이 들어있는지 확인하기 위한 연산이다. Queue를 변화시키지 않으면서 맨 앞에 있는 element의 값을 보기 위한 것이다. element와 peek의 차이점은 마찬가지로 error에 대한 handling이 되어있는지 되어있지 않은지이다. element는 값이 없으면 NoSuchElementException을 발생시키지만, peek은 null을 return 한다.

```kotlin
val queue: Queue<Int> = LinkedList<Int>()

queue.add(5) // queue = [5] queue.add(6) // queue = [5, 6] queue.offer(7) // queue = [5, 6, 7]
queue.add(1) queue.remove() queue.remove()
queue.add(1) queue.poll() queue.poll()
queue.poll() queue.peek() // null, No error thrown queue.element() // Exception in thread "main" java.util.NoSuchElementException
```

### ◾ 시간복잡도

- 삽입 : O(1) 자료가 삽입될 때는 자료의 맨 뒤에 자료가 삽입되는 연산만 수행

- 삭제 : O(1) 검색한 해당 요소를 삭제하는 연산

- 검색 : O(n) 자료를 검색할 때는 맨 앞의 요소부터 맨 마지막 요소까지 차례대로 검색

### ◾ 장점

- 데이터가 입력된 시간 순서대로 처리해야 할 필요가 있는 상황에 유리하다.

### ◾ 단점

- 크기가 제한적이다.

- 큐의 앞 부분이 비어도 데이터를 삽입할 수 없다

- 큐가 비어있어도 not empty로 판단할 수 있다 (rear가 맨뒤)
</br>

## BFS (너비우선탐색 : Breadth First Search)

### ◾ 개념
루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법

시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법이다.

즉, 깊게(deep) 탐색하기 전에 넓게(wide) 탐색하는 것이다.

두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택한다.


### ◾ 시간복잡도

- 인접 리스트로 표현된 그래프: O(N+E)

- 인접 행렬로 표현된 그래프: O(N^2)

### ◾ BFS와 DFS의 비교

![1fe9246903b78fae07577b243a0b22791e02cb39640d5cbaae10d9849343b4ea6f162a9a677a5892fbf7819abd4ef7221ebd3608849cfb66793411fb5e643951eb3ee8c1fd5e82b7ddb591b7857e1fca869b2541cec262d20a5cc3e8eb59dc7c](https://user-images.githubusercontent.com/42407740/138537799-4bae2312-2189-4b78-9aa6-4d22cf2d3473.gif)


### ◾ 코드
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    //각 입력을 변수에 할당
    val (node, edge, start) = br.readLine().split(" ").map { it.toInt() }
    //그래프 선언
    val graph = Array(node + 1) { IntArray(node + 1) { 0 } }
    //방문체크 리스트 선언
    val visited = mutableListOf<Int>()

    //간선 수만큼 반복
    repeat(edge) {
        val (v1, v2) = readLine().split(" ").map { it.toInt() }
        //연결된 노드들의 관계인 인덱스의 값을 1로 설정정
        graph[v1][v2] = 1
        graph[v2][v1] = 1
    }

    dfs(start, graph, visited)
    visited.forEach {
        print("$it ")
    }

    visited.clear()

    println()
    bfs(start, graph, visited)
    visited.forEach {
        print("$it ")
    }
}

fun dfs(start: Int, graph: Array<IntArray>, visited: MutableList<Int>) {
    visited.add(start)

    for (y in 1 until graph.size) {
        //그래프가 연결되어있고, 아직 방문하지 않았으면
        if (graph[start][y] == 1 && !visited.contains(y)) {
            //연결되어있는 노드를 시작점으로 재귀호출
            dfs(y, graph, visited)
        }
    }
}

fun bfs(start: Int, graph: Array<IntArray>, visited: MutableList<Int>) {
    //큐 생성
    val queue = LinkedList<Int>()
    queue.add(start) //시작 노드, 큐 삽입
    visited.add(start) //방문체크

    //큐가 빈 상태가 될 때까지 반복
    while (!queue.isEmpty()) {
        val x = queue.poll()        //큐의 맨 앞을 삭제
        
        for (y in 1 until graph.size) {
            //그래프가 연결되어있고, 아직 방문하지 않았으면
            if (graph[x][y] == 1 && !visited.contains(y)) {                
                queue.add(y)//큐에 추가                
                visited.add(y) //방문체크
            }
        }
   
```
</br>


## 참고
