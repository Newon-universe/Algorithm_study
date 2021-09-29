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

val N: Double = readLine().toDouble()
val sqrtN = sqrt(N).toInt()
var NisPrime = true

	for (i in 2..sqrtN) {
		if( sqrtN % i == 0) {
			NisPrime = false
		}
	}
	println(NisPrime)
  
/*
*   여기서 sqrtN 은 toInt() 를 이용해서 내림으로 구현하였으며, 
*   math 를 import 하지 않을 시 다음과 같이 구현이 가능하다.
*
*   @sqrtLoop for (i in 2..N) {
*                 if (i * i >= N) {
*                   break@sqrtLoop
*                 }
*              }
*             if (i * i > N) {
*                 i--
*             }
*             sqrtN = i
*
*/
```
</br>

#### ◾ 에라토스테네스의 체
<img src="https://blog.kakaocdn.net/dn/47gsG/btqGmOMVuzk/Kp5rTFrj8R2Rj7rf4wfxF1/img.gif">
<Strong>개념</Strong> ﾠﾠﾠ2부터 N 중에서 여러개의 소수를 찾거나 판별해야할 때 사용되는 기법 중 하나이다.</br>
</br>
<Strong>로직</Strong>ﾠﾠ ﾠ① 1 ~ N 이 들어가있는 배열을 선언한 후, 2의 배수들을 전부 제거한다.</br>
	ﾠﾠﾠﾠﾠﾠﾠ② N까지의 2의 배수가 전부 제거되면 2에 1을 더한 후, 해당 숫자가 제거되어있지 않다면 그 배수들을 전부 제거한다.</br>
        ﾠﾠﾠﾠﾠﾠﾠ③ 이전단계를 N까지 반복한다.</br>
	ﾠﾠﾠﾠﾠﾠﾠ④ 배열에서 제거되지 않은 수들은 소수이다.</br>
</br>

> 에라토스테네스의 체는 현존하는 다수의 소수판별법 중에서 프로그래밍적으로 가장 적은 시간복잡도를 갖는다.

</br>

```kotlin

fun eratosSieve(N:Int, eratos:Array<Int>) {
    var i = 2
    var j = i
    
    for (i in i .. N) {
        if (eratos[i] == 0) {
	    continue
	}
        
	j = i + i
        for (j in j .. N step i) {
             if (eratos[j] != 0) {
	            eratos[j] = 0
	     }
        }
    }
}

fun main() {
    val N = readLine().toInt()
    var eratos = Array<Int>(N+1) { i -> i }
    
    eratosSieve(N, eratos)
}

// 배열에 소수만 남기는 형태로, 소수 유무로 출력하고 싶다면 배열을 Boolean 타입으로 작성하면 된다.
```

#### ◾ 시간 복잡도
##### N 이 소수인지 판별하는 알고리즘의 시간복잡도
- 정의에 따른 소수판별의 시간 복잡도는 O(N)</br>
- 특징 1에 따른 소수판별의 시간 복잡도는 O(N/2)</br>
- 특징 2에 따른 소수판별의 시간 복잡도는 O(루트 N)</br>

##### N 까지의 숫자들이 소수인지 판별하는 알고리즘의 시간복잡도
- 특징 2에 따른 다수의 소수 찾기 시간 복잡도는 O(N * 루트 N)</br>
- 에라토스테네스의 체에 따른 다수의 소수 찾기 시간 복잡도는 O(N * log(logN))</br>

</br>

### 다이나믹 프로그래밍
#### ◾ 개념
큰 문제를 작은 단위로 나누어서 푸는 알고리즘을 총칭하는 용어</br>
조건으로 부분 반복 문제, 최적 부분 구조를 가지며 방법론으로 Top-Down, Bottom-Up 방법이 있다.</br>

#### ◾ 조건  
**1. 첫번째 조건**</br> 
**부분 반복 문제 (Overlapping Subproblem)**
- 큰 문제를 작은 단위로 나누었을 때, `작은 단위로 나누어진 문제들은 같은 정답`의 형태가 되어야 한다.</br>
- 즉 큰 문제를 나눌 때, 항상 새로운 문제를 생성하는 것이 아닌 계속해서 `같은 문제가 여러번 재사용되는 구조`를 보여야한다.</br>
- 대표적인 예시가 피보나치 수열로, 다음 수열 = `이전 수열 + 그 이전 수열의 합`의 형태가 반복됨을 알 수 있다.</br>

```
부분 반복 문제 예시
문제: N번째 피보나치 수를 구하는 문제
작은 문제: N-1번째 피보나치 수를 구하는 문제, N-2번째 피보나치 수를 구하는 문제

문제: N-1번째 피보나치 수를 구하는 문제
작은 문제: N-2번째 피보나치 수를 구하는 문제, N-3번째 피보나치 수를 구하는 문제

문제: N-2번째 피보나치 수를 구하는 문제
작은 문제: N-3번째 피보나치 수를 구하는 문제, N-4번째 피보나치 수를 구하는 문제
```

</br>

**2. 두번째 조건**</br>
**최적 부분 구조 (Optimal Substructure)**</br>
- `작은 부분에서 구한 최적의 답으로 큰 문제의 최적의 답`을 구할 수 있어야 한다.
- 즉 `큰 문제의 정답을 작은 문제의 정답에서 부터 구할 수 있는 구조`여야 한다.

```Kotlin
최적 부분 구조 예시
10번째 피보나치 수를 구하기 위한 방법

10번째 피보나치 수는 8번째와 9번째 피보나치 수의 합이다.
9번째 피보나치 수는 7번째와 8번째 피보나치 수의 합이다.
...
4번째 피보나치 수는 2번째와 3번째 피보나치 수의 합이다.
3번째 피보나치 수는 1번째와 2번째 피보나치 수의 합이다.

따라서 10번째 피보나치의 수는 1 ~ 9번째 피보나치의 수를 최적으로 구하는 방법들의 합이다.

```
#### ◾ 메모리제이션(Memoization) 이란?
다이나믹 프로그래밍은 다음 단계가 이전 단계의 반복이므로 반복되는 연산 과정이 생기게 된다.</br>
이 연산을 줄이기 위해서 이전 단계의 답을 메모리에 저장하는 방법을 사용하는데, 이를 메모리제이션이라고 한다.

다수의 피보나치 수열 출력을 다이나믹 프로그래밍으로 푼 예시이다.
```Kotlin


```

#### ◾ 분할 정복 방식과의 차이점
분할 정복 방식은 작은 단위의 문제가 반복되지 않는 반면, 다이나믹 프로그래밍은 작은 단위의 문제가 반복된다는 차이점이 있다.


#### ◾ 기본 로직
**1. Top-down**  
재귀를 통해 N을 넣고, N 에서부터 1까지 찾아가는 로직의 피보나치 수열 구하기가 대표적 예시이다. 

```Kotlin
fun fibonacciArr(n: Int): Int {
    Array(n) { 0 }.also {
       it[0] = 1
       it[1] = 1
    for (i in 2 until it.size) {
        it[i] = it[i - 1] + it[i - 2]
     }
     return it.last()
   }
}

fun main () {
    fibonacciArr(N)
}
```

**2. Bottom-up**  
For 문을 통해서 0에서부터 다음 피보나치 수열을 찾으며, 원하는 N의 피보나치 수열이 나올 때 까지 진행하는 로직이 대표적 예시이다.

```Kotlin

```

</br>

### 각주
<a name="footnote_1">(1) 역수</a>: 그 수와 서로 곱한 결과가 1인 수, 즉 분자와 분모를 바꾼 수

### 참고
[이런 식으로 참고한 사이트를 넣어요](https://github.com/Newon-universe/Algorithm_study)  
https://defian.tistory.com/entry/알고리즘-에라토스테네스의-체-C-소수-찾기


https://galid1.tistory.com/507
https://velog.io/@gillog/동적-계획법Dynamic-Programming
https://velog.io/@polynomeer/동적-계획법Dynamic-Programming
https://codeinleonis.tistory.com/28?category=801279
