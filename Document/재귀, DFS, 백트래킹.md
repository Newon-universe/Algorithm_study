## 재귀

### ① 개념
자기 자신을 호출하는 함수를 말한다.
재귀 함수가 언제 끝날지, 종료 조건을 꼭 명시해야 한다.(자칫 종료 조건을 명시하지 않으면 함수가 무한 호출될 수 있다)
### ② 코드
```
def recursive_function(i):
  if i == 100: 
    return 
  print(i,'번째 재귀 함수에서',i+1,'번째 재귀 함수를 호출합니다.')
  recursive_function(i + 1)
  print(i,'번째 재귀 함수를 종료합니다.')
  
 recursive_function(i)
```

##  깊이 우선 탐색(DFS, Depth First Search)
그래프를 깉은 부분을 우선적으로 탐색하는 알고리즘이다.
### ① 그림으로 개념 알아보기
![6CC23D65-31A5-4556-99CF-8F5C4809BAFD](https://user-images.githubusercontent.com/70764912/137519914-b0e2af2e-2775-461f-8c68-ebe376c4fe95.jpeg)

### ② 구현 방법
- 시간복잡도   
  O(간선의 개수 + 노드의 개수)
- 공간복잡도

### ③ 코드
```
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


##  백트래킹(Backtracking)
### ① 개념
해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법을 말합니다. 최적화 문제와 결정 문제를 푸는 방법.
### ② 시간복잡도

### ③ 코드
```


```
> ◾ DFS와 백트래킹(Backtracking)의 차이
DFS는 깊이 우선 탐색하여 모든 노드를 방문하는 것을 목표로 한다.
백트래킹은 불필요한 탐색을 하지 않기 위해 유망하지 않는 경우의 수를 줄이는 것을 목표로 한다.

</br>

### 참고
[플래승급전 2승 2패](https://github.com/Newon-universe/Algorithm_study)  
(https://gamedevlog.tistory.com/49)
이것이 코딩 테스트다 책  
