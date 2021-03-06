## 수학과 다이나믹 프로그래밍

### 소수
#### ◾ 개념
약수가 1 과 자기 자신 밖에 없는 수  
N이 소수가 되려면, 2보다 크거나 같고,  
N-1보다 작거나 같은 자연수로 나누어 떨어지면 안된다.

#### ◾ 기본 로직

```java
boolean isPrime(int number) {
	if(number < 2) {                       /* 0 과 1 은 소수가 아니다 */
		return false;
	}

	if(number == 2) {                       /* 2는 소수다 */
		return true;
	}
		
	for(int i = 2; i < number; i++) {
		if(number % i == 0) {               /* 약수를 갖는 경우 종료 */
		    return false;
		}
	}

	return true;                           /* 위 반복문에서 약수를 갖지 않는다면 소수다 */
}
```

#### ◾ 에라토스테네스의 체

1. 2부터 N까지 모든 수를 써놓는다.
2. 아직 지워지지 않은 수 중에서 가장 작은 수를 찾는다.
3. 그 수는 소수이다.
4. 이제 그 수의 배수를 모두 지운다.
5. 남아있는 모든 수가 **소수**이다.

<p align="center"><img src="https://user-images.githubusercontent.com/48541984/135542109-d46727c2-6334-4fa9-81ac-3f47d4560615.gif" width="40%"/></p></br>

```java
boolean isPrime(int number) {
	boolean[] primes = new boolean[number + 1];
    	primes[1] = true;
  
    	for(int i = 2 ; i <= number ; ++i){
        	if(primes[i]) continue;                      /* 소수가 아닌 (true) 수는 넘어가기 */
        	for(int j = i + i ; j <= number ; j += i){  /* i를 제외한 i의 배수 모두 체크하기 */
    			primes[j] = true;
   		}
  }
}
```

#### ◾ 시간 복잡도
* Basic `O(N)`
* Sieve of Eratosthenes `O(nloglogn)`

</br>

### 다이나믹 프로그래밍
#### ◾ 개념
큰 문제를 작은 문제로 나누어 푸는 알고리즘

#### ◾ 조건  
**1. 첫번째 조건**  
작은 문제가 반복이 일어나는 경우, (Overlapping Subproblem)

**2. 두번째 조건**  
같은 문제는 구할 때마다 정답이 같다. (Optimal Substructure)  

#### ◾ 메모이제이션(Memoization) 이란?
답을 재활용한다는 의미로,  
동일한 계산을 할 경우 한번 계산한 결과를 메모리에 저장해 두었다가  
꺼내 씀으로써 중복 계산을 방지할 수 있게 하는 기법  

> 즉, 공간적 비용을 투입해 **시간적 비용**을 줄이는 방식  

#### ◾ 분할 정복 방식과의 차이점
**작은 문제가 중복이 일어나는지 안일어나는지** 가 포인트!  
`분할정복` 은 큰 문제를 해결하기 어려워 단지 작은 문제로 나누어 푸는 방법으로,  
작은 문제에서 반복이 일어나는 부분이 없다.  
하지만, `DP` 는 작은 부분 문제들이 반복되는 것 (답이 바뀌지 않음) 을 이용해 풀어나가는 방법이다.  

#### ◾ 기본 로직
**1. Top-down**  

* 문제를 작은 문제로 나눈다.
* 작은 문제들을 푼다.
* 작은 문제들의 답으로 전체 문제를 푼다.

```java
int topDown(int n)
{
    if(n == 0)
        return 0;
    else if(n == 1)
        return 1;
    else
        return topDown(n-1)+topDown(n-2);
}
```

**2. Bottom-up**  

* 가장 작은 문제부터 푼다.
* 문제의 크기를 점점 크게 만들어서 전체 문제를 푼다.

```java
int bottomUp(int n)
{
    dp[0] = 0, dp[1] = 1;
    for (int i = 2; i <= n; i++)
        dp[i] = dp[i - 1] + dp[i - 2];
}
```

</br>

### 참고
[Java 소수 구하는 알고리즘 및 구현](https://st-lab.tistory.com/81)  
[다이나믹 프로그래밍이란?](https://kyun2da.github.io/2020/01/19/DynamicProgramming/) [++](https://galid1.tistory.com/507)  
