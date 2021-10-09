## 브루트 포스 (Brute Force)

### ◾ 개념
Brute (짐승같은, 난폭한 😈) + Force (힘 💪) = 무차별 대입 공격</br>
문제를 해결하기 위해서 가능한 모든 경우에 대해 모두 직접 해보는, 무식하게 푸는 방법이다.</br>
즉, 문제를 해결하기 위해서 가능한 모든 경우의 수를 모두 탐색하며 요구조건에 충족되는 결과만을 가져온다.  

</br>

### ◾ 특징
* 모든 자료를 탐색해야 하기에 특정한 구조를 전체적으로 탐색할 수 있는 방법을 필요로 한다.  
* 단, 경우의 수를 계산하는데 걸리는 시간이 주어진 문제의 **시간 제한**을 넘지 않아야 한다.  
* 예외 없이 100%의 확률로 정답만을 출력한다.  
* 시간 측면에서 비효율적인 알고리즘이다.

</br>

### ◾ 문제해결법
#### 1. 문제의 가능한 경우의 수를 계산
직접 계산을 통해서 구해본다.  
경우의 수를 계산해보며 문제가 브루트 포스로 해결 가능한 문제인지 판별한다.  </br>

#### 2. 가능한 모든 방법을 다 만드는 구현 방법을 구상
하나도 빠짐 없이 만들어야 한다.  
대표적으로 N중 for문, permutation, recursive, bitmask => 이 중에 어떤 방법이 최선인지는 문제마다 다르다.  </br>

#### 3. 작성한 알고리즘에서 방법 하나하나 나올 때마다 정답을 갱신
문제에 나와있는 대로 답을 계산해본다.

</br>

### ◾ 시간복잡도
O ( 경우의 수 N * 방법 1개를 시도해보는데 걸리는 시간복잡도 )

</br>

### ◾ 완전 탐색 방법
**① Brute Force 기법**  
이 방법은 반복 / 조건문을 통해 가능한 모든 방법을 단순히 찾는 경우를 의미한다.</br>
아주 기초적인 문제에서 주로 이용되거나, 전체 풀이의 일부분으로 이용된다.
```java
for(int i =0; i <n; i++) {
  for(int j =i+1; j<n; j++)  {
    for(int k =j+1; k <n; k++) {
      ... (r개의 for문..)
```
```kotlin
/* 약수의 합을 구하기 */

for (i in 1 until N) {
	if (n % i == 0) {
		sum = sum + i
	}		
}	
```
</br>

**② 순열(Permutation)**  
순열은 임의의 수열이 있을 때, 그것을 다른 순서로 연산하는 방법이다.</br> 
<p align="center"><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbpqibZ%2FbtqW1t57wif%2FAE4EvpEQeY5ZEFWLoJyAmK%2Fimg.png"></p></br>
만약, 숫자 [1, 2, 3]이 있다면, 순열은 이것을 [1, 2, 3]으로 보는 순서와 [3, 2, 1]로 보는 **순서가 차이가 있음**이 중요한 경우를 의미한다.</br>
같은 데이터가 입력된 수열이지만, 그 순서에 따라 의미가 있고 이 순서를 통해 연결되는 이전 / 다음 수열을 찾아낼 수 있는 경우를 계산할 수 있다.</br>

> **n개의 원소 중 r개의 원소를 중복 허용 없이 나열하는 방법 : nPr = n x (n-1) x (n-2) x ... x (n-r+1)** 
```java
private static void dice2(int cnt) {
	if(cnt == N) {
		totalCnt++;
		System.out.println(Arrays.toString(numbers));
		return;
	}
	for(int i =1; i<=6; i++) {
		if(isSelected[i]) continue; // 선택 되지 않은 것들만 선택(중복 X)
		numbers[cnt] = i;
		isSelected[i] = true; // 선택
		dice2(cnt+1); // cnt++ 이 아니라 cnt+1 로 해야한다. (cnt 변경되면 안됨.) 
		isSelected[i] = false; // 선택 해제
	}
}
```
```kotlin
combination(N: Int, R: Int, q: Int)
{
	if (R == 0)
	{
		for (i in q-1 downTo 0)
		{
			print(A[i]);
		}
		println("");
	}
	else if (N < R)
	{
		return;
	}
	else
	{
		A[R - 1] = arr[N - 1];
		combination(N - 1, R - 1, q);
		combination(N - 1, R, q);
	}
}
```
</br>

**③ 재귀 호출**  
재귀 함수(자기 자신을 호출하는 함수)를 통해서 조건을 만족하는 경우들을 찾아가는 방식이다.</br>
더 이상 함수를 return 하지 않아야 하는 작업에 다다를 때까지 함수를 재호출한다. return 시에 함수가 아닌 값을 return 하는 경우를 기저 사례, Base Case라고 한다.</br>
```kotlin
fun fibonacci(n): Int {

    for (i in 1..n) {
        for (j in 1..n) {
	    if (i + j == fibonacci(n - 1) + fibonacci(n - 2)) {
	        n = i + j
		println(n);
	    }
	}
    }
    return n;
}	
```
> **브루트 포스에서의 재귀와 DP의 차이점** </br>
> - DP는 작은 문제가 큰 문제와 동일한 구조를 가져, 큰 문제의 답을 구할 시에 작은 문제의 결과를 기억한 뒤 그대로 사용하여 수행 속도를 빠르게 한다.
> - 완전 탐색은 크고 작은 문제의 구조가 다를 수 있고, 이전 결과를 반드시 기억하는 것이 아니라 해결 가능한 방법을 모두 탐색한다.
> - 피보나치 수열을 예시로 들면 DP 접근방법은 fibonacci(n - 1) + fibonacci(n - 2) 로 재귀를 수행하면 단 한개의 정답만을 갖는 반면에 브루트포스 접근방법은 i + j == fobonacci(n - 1) + fibonacci(n - 2) 에 해당하는 i 와 j 를 모두 검색한다.
</br>

**④ 비트마스크**  
비트마스크는 비트(bit) 연산을 통해서 부분 집합을 표현하는 방법을 의미한다.</br>
브루트 포스에서 비트마스크는 문제에서 나올 수 있는 모든 문제의 경우의 수가 각각의 원소가 포함되거나, 포함되지 않는 두 가지 선택으로 구성되는 경우에 유용하게 사용이 가능하다. 

> **-비트 연산**  
**And 연산(&) : 둘 다 1이면 1  
OR 연산(|) : 둘 중 1개만 1이면 1  
NOT 연산(~) : 1이면 0, 0이면 1  
XOR 연산(^) : 둘의 관계가 다르면 1, 같으면 0  
Shift 연산(<<, >>) : A << B라고 한다면 A를 좌측으로 B 비트만큼 미는 것이다.**

</br>

### 참고
[알고리즘 - 완전탐색](https://hongjw1938.tistory.com/78)
[Rebro의 코딩 일기장 59](https://rebro.kr/59)
[Rebro의 코딩 일기장 63](https://rebro.kr/63)
[브루트 포스(무식하게 풀기)](https://velog.io/@polynomeer/브루트-포스무식하게-풀기)
[[코딩테스트 대비] 순열(Permutation)과 조합(Combination) 알고리즘](https://aerocode.net/376)
[[ C/C++] 순열(Permutation)과 조합(Combination) 알고리즘 구현하기](https://cocoon1787.tistory.com/81)
[Brute Force 자세한 개념](https://hcr3066.tistory.com/26)  
[Brute Force 문제해결법, 시간복잡도](https://github.com/Itsbeenalongday/Brute-Force)  
