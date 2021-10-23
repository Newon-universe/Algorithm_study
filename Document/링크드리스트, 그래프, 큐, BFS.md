## 링크드리스트

### ◾ 개념 및 형태

### ◾ 언어별 선언 및 사용방법(CRUD)

### ◾ 시간복잡도

### ◾ 장점

### ◾ 단점

</br>

## 그래프

### ◾ 개념

### ◾ 구현방법 1 : 인접 리스트 이용
- 구현방법, 특징, 시간/공간복잡도 등

### ◾ 구현방법 2 : 인접 행렬 이용
- 구현방법, 특징, 시간/공간복잡도 등

</br>

## 큐

### ◾ 개념
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

### ◾ 장점

### ◾ 단점

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

### ◾ 코드
</br>


## 참고

(이해에 도움이 되는 그림이 있다면 어디에든 추가해주세요:))
