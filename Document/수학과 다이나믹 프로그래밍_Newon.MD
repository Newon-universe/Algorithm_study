## 수학과 다이나믹 프로그래밍

### 소수

#### ◾ 개념
1보다 큰 자연수 중에서 1과 자기 자신으로만 나누어 떨어지는 수를 의미한다.
어떠한 수 N 이 소수가 되려면
- `2`보다 크거나 같은 정수이며
- `N-1`보다 작거나 같은 정수로 나누어 떨어지면 안된다.

소수의 특징
1. `N/2` 보다 작거나 같은 자연수에서 `N`의 약수를 찾지 못하면 `N`은 소수이다.
2. `루트 N` 보다 작거나 같은 자연수에서 `N`의 약수를 찾지 못하면 `N`은 소수이다.

#### ◾ 기본 로직
##### 1. 어떤 자연수로 N이 나누어지는지 확인 -- 정의 
```kotlin
for (i 2..N-1) {
    if (N % i == 0) {
        NisPrime = false
    }
}
```

##### 2. N/2 보다 작거나 같은 자연수로 N이 나누어지는지 확인 -- 특징 1
```kotlin
for (i 2..N/2) {
    if (N % i == 0) {
        NisPrime = false
    }
}
```

##### 3. 루트 N 보다 작거나 같은 자연수로 N이 나누어지는지 확인 -- 특징 2
```kotlin
import kotlin.math.*

val N = 16.toDouble()
val sqrtN = sqrt(N).toInt()
var NisPrime = true

	for (i in 2..sqrtN) {
		if( sqrtN % i == 0) {
			NisPrime = false
		}
	}
	println(NisPrime)
  
/*
*   여기서 sqrt 는 toInt() 를 이용해서 내림으로 구현하였으며, 
*   math 를 import 하지 않을 시 다음과 같이 구현이 가능하다.
*
*   @sqrtLoop for (i in 2..N) {
*                 if (i * i >= N) {
*                   break@sqrtLoop
*                 }
*              }
*
*/
```

#### ◾ 에라토스테네스의 체
1. 
2. 
3. 

```kotlin
 // 풀이 코드
```

#### ◾ 시간 복잡도
> 기본 로직과 에라토스테네스의 체 각각의 시간복잡도에 대해 서술  

</br>

### 다이나믹 프로그래밍
#### ◾ 개념

#### ◾ 조건  
**1. 첫번째 조건**  
> 첫번째 조건에 대한 설명  

**2. 두번째 조건**  

#### ◾ 메모이제이션(Memoization) 이란?

#### ◾ 분할 정복 방식과의 차이점

#### ◾ 기본 로직
**1. Top-down**  
> Top-down 방식을 짧막하게 서술하고,  
```java
 // 풀이 코드
```

**2. Bottom-up**  
> Bottom-up 방식을 짧막하게 서술하고,  
```java
 // 풀이 코드
```

</br>

### 각주
<a name="footnote_1">1_역수</a>: 그 수와 서로 곱한 결과가 1인 수, 즉 분자와 분모를 바꾼 수

### 참고
[이런 식으로 참고한 사이트를 넣어요](https://github.com/Newon-universe/Algorithm_study)  
