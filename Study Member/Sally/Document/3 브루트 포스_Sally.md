## 브루트 포스 (Brute Force)
### ◾ 개념
#### brute (동물 🦍) + force (힘 💪) : 힘으로 무식하게 해결한다 !  
고지식한 패턴 검색으로 분문의 처음부터 끝까지 차례대로 순회하면서 패턴 내의 문자들을 일일이 비교하는 방식이다.  
즉, 문제를 해결하기 위해서 가능한 모든 경우의 수를 모두 탐색하며 요구조건에 충족되는 결과만을 가져온다.  

### ◾ 특징
* 모든 자료를 탐색해야 하기에 특정한 구조를 전체적으로 탐색할 수 있는 방법을 필요로 한다.  
* 단, 경우의 수를 계산하는데 걸리는 시간이 주어진 문제의 **시간 제한**을 넘지 않아야 한다.  
* 예외 없이 100%의 확률로 정답만을 출력한다.  
* 시간 측면에서 비효율적인 알고리즘이다.

### ◾ 문제해결법
#### 1. 문제의 가능한 경우의 수를 계산
직접 계산을 통해서 구해본다.  
경우의 수를 계산해보며 문제가 브루트 포스로 해결 가능한 문제인지 판별한다.  

#### 2. 가능한 모든 방법을 다 만드는 구현 방법을 구상
하나도 빠짐 없이 만들어야 한다.  
대표적으로 N중 for문, permutation, recursive, bitmask => 이 중에 어떤 방법이 최선인지는 문제마다 다르다.  

#### 3. 작성한 알고리즘에서 방법 하나하나 나올 때마다 정답을 갱신
문제에 나와있는 대로 답을 계산해본다.  

### ◾ 시간복잡도
> O(경우의 수 * 1가지 경우를 시도해보는데 걸리는 시간)  

</br>

### ◾ 완전 탐색 방법
**① Brute Force 기법 - 반복 / 조건문을 활용해 모두 테스트하는 방법**  

반복적인 작업을 해야 하는 코드는 간단하게 for문과 if문을 사용해 구현할 수 있다.  

```java
for(int i =0; i <n; i++) {
  for(int j =i+1; j<n; j++)  {
    for(int k =j+1; k <n; k++) {
      ... (r개의 for문..)
```
</br>

**② 순열(Permutation) - n개의 원소 중 r개의 원소를 중복 허용 없이 나열하는 방법**  

서로 다른 n개의 원소 중 r(<=n) 개를 순서 있게 골라낸 것을 순열이라 하며, nPr로 나타낸다.  
브루트포스에서 순열은 **순서**와 관련된 경우, **선택**과 관련된 경우, 그 **수가 고정**된 경우 사용된다.  
아래 예제는 주사위를 3번 던졌을 때 나올 수 있는 경우의 수이다. (중복 X, 순서 O)  

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
</br>

**③ 재귀 호출**  

수행할 작업을 유사한 형태의 여러 조각으로 쪼갠 뒤 그 중 한 조각을 자신이 수행하고,  
나머지를 자기 자신을 호출하여 실행한다.  

```java
void pick(int n, int r) {
  if(r ==0) {
    ..
  }
  for(int i =0; i <n; i++) {
    ...
  }
}
```
> **브루트 포스에서의 재귀와 DP의 차이점**  
> 브루트 포스와 달리 DP는 어떤 경로나 수를 탐색했을 때의 값을 저장해주는 공간이 존재한다.  

</br>

**④ 비트마스크 - 2진수 표현 기법을 활용하는 방법**  

비트 마스크란 [비트(bit) 연산](https://pang2h.tistory.com/261)을 통해 부분 집합을 표현하는 방법을 의미한다.  
브루트 포스에서 비트마스크는 문제에서 나올 수 있는 모든 문제의 경우의 수가 각각의 원소가 포함되거나, 포함되지 않는 두 가지 선택으로 구성되는 경우에 유용하게 사용이 가능하다.  

```[java](https://canoe726.tistory.com/45)
for (i = 1; i < (1 << N); i++) {
	int sum = 0;
	for (j = 0; j < N; j++) {
		if (i & (1 << j)) {
			sum += num[j];
		}
	}
	if (sum == S)
		answer += 1;
}
```

</br>

### 참고
[Brute Force 자세한 개념](https://hcr3066.tistory.com/26)  
[Brute Force 문제해결법, 시간복잡도](https://github.com/Itsbeenalongday/Brute-Force)  
[Java - 반복, 재귀 호출 예제](https://medium.com/jaehoon-techblog/%EA%B0%9C%EC%9D%B8%EC%A0%81%EC%9D%B8-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%A0%95%EB%A6%AC-brute-force-fb2330391f91)  
[Java - 순열 예제](https://sohee-dev.tistory.com/entry/Java-%EC%88%9C%EC%97%B4-%EC%A1%B0%ED%95%A9-%EB%B6%80%EB%B6%84-%EC%A7%91%ED%95%A9-%EC%A0%95%EB%A6%AC-%EC%88%98%EB%8F%84-%EC%BD%94%EB%93%9C-%EC%9E%AC%EA%B7%80%ED%8E%B8)  
[브루트 포스와 다이나믹 프로그래밍에 대하여](https://kyounju.tistory.com/2)  
[브루트 포스 관련 전체적인 정리](https://hongjw1938.tistory.com/78)  
