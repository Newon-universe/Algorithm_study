## 재귀

### ① 개념
자기 자신을 호출하는 함수를 말한다.
재귀 함수가 언제 끝날지, 종료 조건을 꼭 명시해야 한다.(자칫 종료 조건을 명시하지 않으면 함수가 무한 호출될 수 있다)
### ② 코드
'''
def recursive_function(i):
  if i == 100: 
    return 
  print(i,'번째 재귀 함수에서',i+1,'번째 재귀 함수를 호출합니다.')
  recursive_function(i + 1)
  print(i,'번째 재귀 함수를 종료합니다.')
  
 recursive_function(i)
'''


##  깊이 우선 탐색(DFS, Depth First Search)
그래프를 깉은 부분을 우선적으로 탐색하는 알고리즘이다.
### ① 그림으로 개념 알아보기
### ② 구현 방법
- 시간복잡도
- 공간복잡도

### ③ 코드
### ④ 방향 / 무방향 그래프


##  백트래킹(Backtracking)
### ① 개념
### ② 시간복잡도
### ③ 코드
> ◾ DFS와 백트래킹(Backtracking)의 차이


</br>

### 참고
[플래승급전 2승 2패](https://github.com/Newon-universe/Algorithm_study)
