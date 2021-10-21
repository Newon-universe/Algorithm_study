## 링크드리스트(인접리스트)
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

### ◾ 구현방법 1 : 인접 리스트 이용
- 구현방법, 특징, 시간/공간복잡도 등

### ◾ 구현방법 2 : 인접 행렬 이용
- 구현방법, 특징, 시간/공간복잡도 등

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

### ◾ 개념

### ◾ 시간복잡도

### ◾ BFS와 DFS의 비교

### ◾ 코드
</br>


## 참고
[Java / 자바 LinkedList 사용법 & 예제 총정리](https://coding-factory.tistory.com/552)  
[LinkedList 시간복잡도에 대하여](https://m.blog.naver.com/raylee00/221944085465)  
[Java / 자바 Queue 클래스 사용법 & 예제 총정리](https://coding-factory.tistory.com/602)  
