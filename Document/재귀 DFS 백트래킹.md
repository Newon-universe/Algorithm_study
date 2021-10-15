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
  

### ② 코드


##  깊이 우선 탐색(DFS, Depth First Search)
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
