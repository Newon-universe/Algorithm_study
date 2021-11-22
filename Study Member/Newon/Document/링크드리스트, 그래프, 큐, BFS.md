## 링크드리스트

### ◾ 개념 및 형태
<<<<<<< HEAD
링크드 리스트, 연결 리스트란 하나의 노드에 해당 벨류값과 다음 노드에 대한 주소값이 있어  
계속해서 이어지는 형태의 자료구조를 의미한다.  
  
<img src = "https://media.vlpt.us/images/sangh00n/post/bfa73611-96a7-450a-9974-4b40fb70c2fd/linkedLIst.png">

처음 부분을 front, head 등으로 부르고 마지막 부분을 rear, tail 등으로 부르나 의미는 똑같다.  
보통 그래프나 관계성을 지니는 데이터를 가질 때 이용한다.  
### ◾ 언어별 선언 및 사용방법(CRUD)
코틀린은 자체 내자 함수로 링크드 리스트를 지원한다.
```Kotlin
var SampleList = LinkedList()      // 링크드 리스트 생성
=======
각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식으로 데이터를 저장하는 자료구조

데이터가 연속된 위치에 저장되지 않고 모든 데이터가 데이터 부분과 주소 부분을 별도로 가지고 있다

java collection framework 에 있는 list 인터페이스—LinkedList, Stack, Vector, ArrayList—에 속해있는 클래스

![linkedlist](https://user-images.githubusercontent.com/87492707/138562166-bf8babf1-b015-4f18-bb92-a91f3862fea4.png)

`Node` : 데이터 저장 단위. (데이터 값, 포인터)로 구성

`Pointer(link)`: 각 노드안에서, 다음이나 이전 노드와의 연결정보를 가지고 있는 공간. 링크드 리스트의 순서 유지

`Head` : 맨 앞 노드 

`Tail` : 맨 끝 노드

</br>

### ◾ 링크드리스트의 사용
- 중간에 데이터 삽입 방법 : 삽입하려는 그 자리에 있던 주소를 자기가 갖고, 그 앞 노드의 포인터와 연결함

- 데이터 삭제 : 삭제하고자 하는 노드의 포인터에 달린 연결고리를 옮김 (이 경우 자바에서는 자동으로 안쓰는 노드에 대해서 메모리 처리를 해줌)

> Java


```java
import java.util.LinkedList;  
LinkedList<Integer> numList = new LinkedList<Integer>();
// LinkedList<>안에는 String등 다양한 데이터 타입을 선언할 수 있다.

numList.add(1, 2);  //idx 1에 해당 데이터 추가
numList.add(3);     //맨 뒤에 해당 데이터 추가
numList.addFirst(1);  //맨 앞에 해당 데이터 추가
numList.addLast(3);   //맨 뒤에 해당 데이터 추가
numList.set(1, 99);   //idx 1에 있는 데이터를 99로 변경
numList.remove(2);    //idx 2에 있는 데이터 삭제
numList.clear();      //모든 데이터 삭제

System.out.println(numList.get(1));   //idx 1에 있는 데이터 출력
System.out.println(numList.contains(1));  //해당 데이터 있는지 검색 (불리언 반환)
System.out.println(numList.indexOf(1));  //해당 데이터가 몇 번째 인덱스에 있는지 확인(없으면 -1 출력)
System.out.print(numList.size());   //크기 반환
```

> Kotlin


```kotlin
var SampleList = LinkedList()                     // 링크드 리스트 생성
>>>>>>> 347ceb67e85f1e1289eca13aa993a51a1b8a0b8b

SampleList.addNodeAtLast(N)                       // 링크드리스트의 마지막에 데이터를 추가한다. 따라서 이전의 마지막 데이터가 추가하는 데이터와 연결된다.
SampleList.addNodeAtFront(N)                      // 링크드리스트의 처음에 데이터를 추가한다. 추가한 데이터가 이전의 처음 데이터와 연결된다.
SampleList.addNodeAtPosition(5, N)                // 해당 위치에 데이터를 추가한다. position - 1에 위치한 데이터가 추가하는 데이터와 연결된다.

SampleList.removeAtFront()                        // 링크드리스트의 처음 데이터를 삭제한다. 연결관계는 변하지 않는다.
<<<<<<< HEAD
SampleList.removeAtLast()                        // 링크드리스트의 마지막 데이터를 삭제한다. 연결관계는 마지막 - 1의 데이터의 연결 데이터가 NULL 이 된다.
SampleList.removeAtPosition(5)                   // 해당 위치의 데이터를 삭제한다. 연결관계는 위치 - 1 과 위치 + 1 의 데이터가 연결된다.

SampleList.printAllElement()                     // 링크드리스트의 모든 벨류들을 출력한다.
```
### ◾ 시간복잡도
- 검색 : `O(N)`  
  
- 처음에 추가 혹은 삭제 : `O(1)`  
  
- 마지막에 추가 혹은 삭제 : `O(N)`
### ◾ 장점
- 자료의 삽입과 삭제가 용이하다.
- 리스트내에서 자료의 이동이 불필요하다.
- 사용 후 기억장소의 재사용이 가능하다.
- 연속적인 기억 장소의 할당이 필요하지 않다.

### ◾ 단점
- 포인터의 사용으로 저장 공간의 낭비가 생길 수 있다.
- 알고리즘이 복잡하다.
- 특정 자료의 탐색 시간이 많이 소요된다.
  
  
_LinkedList 와 ArrayList 의 시간복잡도 차이_  
<img width="553" alt="스크린샷 2021-10-23 오후 5 50 17" src="https://user-images.githubusercontent.com/80164141/138549850-0d24ffe5-58da-46c3-b0e6-cda3aabbfdf5.png">
=======
SampleList.removeAtLast()                         // 링크드리스트의 마지막 데이터를 삭제한다. 연결관계는 마지막 - 1의 데이터의 연결 데이터가 NULL 이 된다.
SampleList.removeAtPosition(5)                    // 해당 위치의 데이터를 삭제한다. 연결관계는 위치 - 1 과 위치 + 1 의 데이터가 연결된다.

SampleList.printAllElement()                      // 링크드리스트의 모든 벨류들을 출력한다.
```

### ◾ 시간복잡도
- 데이터 탐색 : O(n)</br>
순차 접근 방식을 사용하기에 어떤 데이터를 찾기 위해서는
처음부터 순차적으로 탐색해야 함

- 데이터 추가</br>
추가하려는 데이터의 위치가 맨 앞이라면, O(1) </br>
그렇지 않은 경우 리스트를 순차적으로 탐색해야 하므로, O(n)

- 데이터 삭제</br>
삭제하려는 데이터의 위치가 맨 앞이라면, O(1) </br>
그렇지 않은 경우 추가하는 경우와 마찬가지로, O(n)

### ◾ 장점
- 미리 데이터 공간을 미리 할당하지 않아도 됨
- 데이터의 삽입이나 삭제가 용이함 (배열은 삽입 및 삭제 시 인덱스를 모두 옮겨야 함)

### ◾ 단점
- 연결을 위한 별도 데이터 공간(포인터)이 필요하므로, 저장공간 효율이 높지 않음
- 인덱스가 없어 연결 정보를 찾는 시간이 필요하므로 접근 속도가 느림 (자바의 경우 `get` 메소드로 인덱스 검색 가능)
- 중간 데이터 삭제 시, 앞뒤 데이터의 연결을 재구성해야 하는 부가적인 작업 필요
>>>>>>> 347ceb67e85f1e1289eca13aa993a51a1b8a0b8b

</br>

## 그래프

### ◾ 개념
<<<<<<< HEAD
노드 `Node` 와 그 노드들을 연결하는 간선 `Edge` 을 하나로 모아놓은 자료구조를 의미한다.  

#### 인접과 차수
간선으로 이어진 노드들을 `인접한 노드`라고 정의한다.  
즉, 노드가 `1, 2, 3, 4` 있고 간선이 `1->3` 이 존재한다고 하면  
`1과 3은 인접한 상태이다.`, `1과 2, 4`는 인접하지 않은 상태이다.  

차수는 하나의 노드에 주어지는 간선의 수르 의미한다.  
즉, 노드가 `1, 2, 3, 4` 있으며 간선이 `1->2`, `1->3`으로 존재한다고 하면  
`노드 1의 차수는 2`이다.  

#### 방향과 무방향
그래프에 방향이 존재한다면, 간선은 일방통행이다.  
즉 1->3 이 3->1을 의미하지 않게 된다.
  
그래프에 방향이 존재하지 않다면 간선은 양방통행이다.  
즉 1->3 은 3->1의 간선도 포함한다.  
  
### ◾ 구현방법 1 : 인접 리스트 이용
인접 리스트는 링크드리스트를 배열로 담아서 저장한 자료구조를 의미한다.  


### ◾ 구현방법 2 : 인접 행렬 이용
인접 행렬은 N x N 의 배열을 사용하여, `N번 노드` 와 `M번 노드`가 이어진다면  
`배열[N][M] = 1, 배열[M][N] = 1` 을 하는 방식으로 만들 수 있다.  

=======
`노드(N, node/vertex)`와 그 노드를 연결하는 `간선(E, edge/link/branch)`을 하나로 모아 놓은 자료 구조

즉, 연결되어 있는 객체 간의 관계를 표현할 수 있는 자료구조

아래로만 방향이 존재하는 트리(방향 그래프 중에서도 일방향 그래프에 속함)보다 복잡한 형태 - 무방향(양방향)/유방향 가능, 자기 자신을 돌 수 있고(self-loop), 사이클/loop 가능

  - **인접노드** : 간선에 의해 **직접 연결**된 노드
  - 단순경로 : 경로 중 반복되는 노드가 없는 경우
  - 사이클 : 단순 경로의 시작노드와 종료노드가 동일한 경우
  - 노드의 차수(degree) : 무방향 그래프에서 하나의 노드에 인접한 노드의 수
  - 루프(loop) : 한 노드에서 시작해 같은 노드로 들어오는 간선  
</br>

### ◾ 인접리스트  adjacency list 로 구현하는 방법
**링크드리스트에 그래프를 표현한 것이 인접 리스트!**

인접 리스트에 모든 노드를 넣고, 각각의 노드에 인접한 노드들을 리스트로 표시하여 관계를 링크드리스트로 표현 
(링크드 리스트 안에서는 순서 상관없이 나열)

그래프를 표현할 때 인접리스트가 가장 일반적인 방법

<img src="https://user-images.githubusercontent.com/48541984/138534240-d5eecbb1-430e-4146-8d1d-0324d13731d3.png" width="550" />


#### ◾ 장점
- 어떤 노드에 인접한 노드들을 쉽게 찾을 수 있다 : 특정 노드의 리스트에 있는 노드의 수 (노드 차수) 만큼의 시간이 필요
- 공간 효율이 좋다 : O(E)만큼 메모리 공간이 필요

### ◾ 단점
- 특정 두 점이 연결되었는지 확인이 인접행렬에 비해 시간이 오래 걸린다
- 구현이 비교적 어렵다
</br>

### ◾ 인접행렬 adjacency matrix 로 구현하는 방법
쉽게 말하면 그래프를 표로 표현하는 방법

N * N 형태의 행렬(2차원 배열)을 통해 연결성이 있는 경우에는 0이 아닌 다른 숫자를 저장하여 연결성을 표현하는 방식 - 연결성이 있을 때 일반적으로 1로 표현, 가중치가 있을 경우에 다른 숫자로 표현함

노드가 적고 간선이 많은 그래프일 경우 이 방법으로 사용

<img src="https://user-images.githubusercontent.com/48541984/138534212-088def19-4750-406a-8da4-1d48f992eab6.png" width="550" />

#### ◾ 장점
- 두 노드를 연결하는 간선의 존재 여부를 O(1) 안에 즉시 알 수 있다
- 노드가 가진 간선의 갯수(노드의 차수)는 O(N) 안에 알 수 있다 : 인접 배열의 i번 째 행 또는 열을 모두 더한다
- 구현이 비교적 간편하다

### ◾ 단점
- 어떤 노드에 인접한 노드를 찾기 위해서는 모든 노드를 전부 순회해야 한다
- 인접 행렬 전체를 조사할 때는 모든 노드에 대해 간선 정보를 대입해야 함 → 간선의 갯수와 무관하게 O(N²) 의 시간복잡도가 소요된다
- 무조건 2차원 배열이 필요하기에 필요 이상의 공간이 낭비됨
>>>>>>> 347ceb67e85f1e1289eca13aa993a51a1b8a0b8b
</br>

## 큐

### ◾ 개념
<<<<<<< HEAD
자료구조 중 하나  
  
하나의 배열이 있을 때 언제나 가장 처음 들어간 것이 먼저 나오고, 나중에 넣은 것이 나중에 나오는  
FIFO(First In First Out)을 만족하는 자료구조로, 슈퍼마켓의 우유를 배치하는 것과 같다.  
  
코틀린에서는 보통 Queue 를 생성하고, 해당 큐를 링크드리스트로 연결해 사용하는 경우가 많다.    
### ◾ 언어별 선언 및 사용방법(CRUD)
코틀린은 자체 내장 함수로 큐를 지원하고 있다.

```Kotlin
lateinit var SampleQueue : Queue<Int>         // Queue 생성, Queue 에 들어갈 자료형을 <...> 안에서 지정할 수 있다.
SampleQueue = LinkedList()                    // 처음 생성한 큐는 아무것는 상태이다, 따라서 Queue 에서 사용할 배열 혹은 자료구조를 선언한다.

SampleQueue.add(N)                            // .add 는 Queue 에 하나의 자료를 넣는 명령어로, 가장 마지막에 넣은 벨류값 뒤에 위치하게 된다.
                                              // 성공 시 true 를, 실패 시 false 를 리턴한다.

SampleQueue.poll(N)                           // .poll 은 Queue 에 하나의 자료를 빼는 명령어로, 가장 처음 넣었던 벨류를 출력한다.
                                              // 큐가 비어있는 경우 NULL 을 리턴한다.

SampleQueue.peak                              // 현재 큐의 front, 즉 다음에 poll 했을 때 나올 Queue 의 벨류값을 출력한다.
```

### ◾ 시간복잡도
- 검색 : `O(N)`  
  
- 처음에 추가 혹은 삭제 : `O(1)`  
  
- 마지막에 추가 혹은 삭제 : `O(N)`

### ◾ 장점
- 자료의 삽입과 삭제가 용이하다.
- 리스트내에서 자료의 이동이 불필요하다.
- 사용 후 기억장소의 재사용이 가능하다.
- 연속적인 기억 장소의 할당이 필요하지 않다.
  
> 링크드리스트와 동일하다.  

### ◾ 단점
- 포인터의 사용으로 저장 공간의 낭비가 생길 수 있다.
- 알고리즘이 복잡하다.
- 특정 자료의 탐색 시간이 많이 소요된다.
  
> 링크드리스트와 동일하다

</br>
## BFS (너비우선탐색 : Breadth First Search)

### ◾ 개념
노드로부터 인접한 대상을 먼저 탐색하는 방법을 일컫는다.  
  
BFS는 큐를 활용하여 인접한 노드들을 큐에 넣고`(enqueue)`,  
다시 큐로부터 새로운 노드를 받아서`(dequeue)` 해당 노드에 인접한 노드들을 큐에 넣는`(enqueue)` 방식이 일반적이다.  
  
따라서 BFS는 보통 3개의 단계로 구분된다.  
```Kotlin
var SampleQueue : Queue<Int>;   // Queue 생성
SampleQueue.add(1);             // Queue 에 초기값 0 add

var nextDirection:IntArray(2) = {-1, 1, 0, 0);   // 다음으로 움직일 곳


// Dequeue 단계
while(SampleQueue.peak){
   var dequeue;
   dequeue = SampleQueue.poll
   
   
// 다음에 들어갈 수 있는 노드 탐색   
   for(i in 0..1){
        var next = dequeue + nextDirection[i];       
        
        if(next < 0 || next >= N)                //해당 노드를 Queue 에 넣어도 되는 값인지 확인
           continue;
        if(...)                                  // 즉, 방문처리와 같다. (넣었던 노드를 다시 넣으며 안됨, 노드가 아닌 값을 넣으면 안됨, 특정조건 등)
           continue;
           
           
// Enqueue 단계        
        SampleQueue.add(next);                    // 노드를 Enqueue 하고, dequeue 한 값에서 인접한 노드들에 대한 탐색이 끝나면
                                                  // 큐에서 꺼내 새로운 노드로 위 과정을 반복한다.
   }
}

```
### ◾ 시간복잡도

### ◾ BFS와 DFS의 비교
BFS 가 인접한 노드를 기준으로 탐색을 한다면, DFS 는 링크드리스트 기준으로 다음의 리스트를 계속해서 탐색한다는 특징이 있다.  
### ◾ 코드
=======
먼저 들어온 데이터가 먼저 나가는 형식의 자료구조. FIFO(First In, First Out)

입구와 출구가 모두 뚫려있는 터널 형태!

![queue](https://user-images.githubusercontent.com/87492707/138562852-ae396b79-16c2-4b0e-8bdd-fdca14669780.png)

`enqueue` : Queue에 데이터 하나 추가하기 

`dequeue` : Queue에서 데이터 하나 추출하기 (데이터가 Queue에서 삭제됨)

`peek` : Queue에서 head에 있는 데이터 확인하기 (데이터를 Queue에서 꺼내지는 않음)

</br>

### ◾ 큐의 사용
> 자바 및 코틀린에서 사용되는 메소드

- Enqueue : **offer**, **add**
    - add는 Queue의 Capacity 인한 오류 발생 시 Exception이 발생하고, offer는 발생하지 않는다
- Dequeue : **poll**, **remove**
    - remove는 더이상 빼낼 데이터가 없을 경우 NoSuchElementException을 발생시키고, poll은 null을 리턴
- peek : **peek**, **element**
    - element는 값이 없으면 NoSuchElementException을 발생시키지만, peek은 null을 리턴
- 링크드리스트 내 구현되어 있는 큐를 사용하는 것이 일반적. 큐 중에서도 연결리스트 방식으로 구현된 형태를 이용 => 인접 리스트 
<br/>

> Java
```java
import java.util.Queue;
import java.util.LinkedList;

public class Queue {
    public static void main(String[] args) {
			Queue<Integer> queue = new LinkedList<>(); // int 형 queue 선언
			// 값 추가
			queue.add(1);
			queue.offer(2);
			
			// 값 출력
			queue.peek();    // 첫번째 값 참조
			
			// 값 변경
			queue.set(1, 10);   // index 1번 값 10으로 변경
			
			// 값 삭제
			queue.poll();    // 첫번째 값 반환하고 제거, 비어있다면 null
			queue.remove();  // 첫번째 값 제거
			queue.clear();   // 초기화
		}
}
```

> Kotlin
> 
코틀린 자체적으로 큐 인터페이스 존재
큐 인터페이스를 구현하는 클래스가 필요한데, 일반적으로 링크드리스트를 이용해 큐를 구현함
```kotlin
val queue: Queue<Int> = LinkedList<Int>()

queue.add(5)   // queue = [5] 
queue.offer(6) // queue = [5, 6]
queue.remove() // queue = [5] 
queue.poll()   // queue = [] 
queue.poll()   // null, No error thrown queue.element()
queue.peek()   // null, No error thrown queue.element() // Exception in thread "main" java.util.NoSuchElementException
```

> Python
```python
from collections import deque

q=deque()
q.append(123)
q.append(456)
q.append(789)
print("size:",len(q))
while len(q)>0:
	print(q.popleft())
```

### ◾ 시간복잡도
- 데이터 삽입/삭제 : 항상 맨 앞에서 데이터를 삽입하거나 삭제하기 때문에 O(1)
- 데이터 탐색 : 특정 데이터를 찾을 때까지 탐색을 수행해야 하기 때문에 O(n)

### ◾ 장점
- 입력된 순서대로 데이터를 처리해야 할 때 유리
- 링크드리스트로 큐를 구현하면, 큐의 길이를 쉽게 늘릴 수 있어 오버플로우가 발생하지 않음

### ◾ 단점
- 배열로 큐를 구현한 경우 
	- 크기가 제한되어 있다
	- 큐의 앞부분이 비어있어도 데이터를 삽입할 수 없음
	- 큐가 비어있어도 not empty 로 판단할 수 있음

</br>

## BFS (너비우선탐색 : Breadth First Search)
<img src="https://user-images.githubusercontent.com/48541984/138526861-780c6014-6b1b-49aa-81a4-25c25b75994e.gif"/>

### ◾ 개념

시작 노드에서 거리가 가까운 노드의 순서로 탐색하는 방법

1. 탐색 시작 노드를 큐에 삽입 `enqueue`하고 방문 처리를 한다.
2. 큐에서 노드를 꺼내 `dequeue` 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입`enqueue` 하고 방문처리를 한다.
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.

- 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 큐를 사용. (일반적으로 큐를 이용해 반복적 형태로 구현)
- 인접 리스트나 인접 행렬로 구현 가능 
   - 인접행렬이 최소그래프에 있어서 메모리 낭비가 심한 반면, 인접리스트는 노드의 갯수, 간선의 갯수만큼 메모리를 할당하므로 메모리적인 측면에 있어 인접행렬법보다 좋기 때문에 최소그래프 표현에 적합

### ◾ 시간복잡도
>노드의 수가 n이고, 간선의 수가 e인 그래프일 때

- 인접 행렬로 표현된 경우 : O(n²)
- 인접 리스트로 표현된 경우 : O(n+e)

### ◾ BFS와 DFS의 비교
- 두 방식 모두 모든 노드를 방문함 (-> 시간 복잡도는 동일) 
- DFS는 이동과정에서 경로에 제약조건이 있을 경우, BFS 는 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 유리하다
- BFS는 DFS와 달리 재귀적으로 동작하지 않는다
- DFS는 일반적으로 스택을 이용, BFS는 큐를 이용해서 구현한다
- DFS가 BFS보다 좀 더 구현이 간단하다
- 단순 검색 속도 자체는 DFS가 BFS에 비해서 느리다
- 둘 다 어떤 노드를 방문했는지 여부 검사가 필요하다

### ◾ 코드
> Java 에서 인접 리스트로 구현

```java
import java.util.*; 
public  class BFS_List { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 노드의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		int v = sc.nextInt(); // 탐색을 시작할 노드의 번호 
		
		boolean visited[] = new  boolean[n + 1]; // 방문 여부를 검사할 배열 
		LinkedList<Integer>[] adjList = new LinkedList[n + 1]; 
		for (int i = 0; i <= n; i++) { 
			adjList[i] = new LinkedList<Integer>(); 
		} 

		// 두 노드 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for (int i = 0; i < m; i++) { 
			int v1 = sc.nextInt(); 
			int v2 = sc.nextInt(); 
			adjList[v1].add(v2); 
			adjList[v2].add(v1); 
		} 

		for (int i = 1; i <= n; i++) { 
			Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬 
		} 

		System.out.println("BFS - 인접리스트"); 
		bfs_list(v, adjList, visited); 
	} 

	// BFS - 인접리스트 
	public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true; 
		queue.add(v); 

		while(queue.size() != 0) { 
			v = queue.poll(); 
			System.out.print(v + " "); 
			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) { 
				int w = iter.next(); 
				if(!visited[w]) { 
					visited[w] = true; 
					queue.add(w); 
				} 
			} 
		} 
	} 
}
```
</br>

> Kotlin 에서 인접행렬로 구현

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
        //연결된 노드들의 관계인 인덱스의 값을 1로 설정
        graph[v1][v2] = 1
        graph[v2][v1] = 1
    }

    println()
    bfs(start, graph, visited)
    visited.forEach {
        print("$it ")
    }
}

fun bfs(start: Int, graph: Array<IntArray>, visited: MutableList<Int>) {
    val queue = LinkedList<Int>()  //큐 생성
    queue.add(start)   //시작 노드, 큐 삽입
    visited.add(start) //방문체크

    //큐가 빈 상태가 될 때까지 반복
    while (!queue.isEmpty()) {
        val x = queue.poll()        //큐의 맨 앞을 삭제
        
        for (y in 1 until graph.size) {
            //그래프가 연결되어있고, 아직 방문하지 않았으면
            if (graph[x][y] == 1 && !visited.contains(y)) {                
                queue.add(y)    //큐에 추가                
                visited.add(y)  //방문체크
            }
        }
```
</br>

> Python 에서 구현

파이썬에서 deque(double ended queue) 사용 - deque는 front와 end에서 삭제와 삽입이 모두 가능함

```python
from collections import deque

#bfs메서드 정의
def bfs(graph,start,visited):
  queue = deque([start])
  visited[start] = True
  while queue:
    v = queue.popleft()
    print(v,end='')
    for i in graph[v]:
      if not visited[i]:
        queue.append(i)
        visited[i] = True
        
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
 
 visited = [False]*9
 
 bfs(graph,1,visited)
```
>>>>>>> 347ceb67e85f1e1289eca13aa993a51a1b8a0b8b
</br>


## 참고
<<<<<<< HEAD
[자료구조 : Linked List 대 Array List](https://www.nextree.co.kr/p6506/)  
[\[자료구조\] 그래프\(Graph\)란](https://gmlwjd9405.github.io/2018/08/13/data-structure-graph.html)
=======
[BFS](https://minhamina.tistory.com/36)

[그래프와 트리 비교](https://gmlwjd9405.github.io/2018/08/13/data-structure-graph.html)

[BFS와 DFS 비교](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=ka28&logNo=222181062178)

[큐](https://velog.io/@kwon/JAVA-Queue%EC%9D%98-%EA%B0%9C%EB%85%90-%EB%B0%8F-%EC%82%AC%EC%9A%A9-%EC%A0%95%EB%A6%AC)

[링크드리스트](https://crazykim2.tistory.com/566)
>>>>>>> 347ceb67e85f1e1289eca13aa993a51a1b8a0b8b
