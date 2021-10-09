
## 브루트 포스 (Brute Force)

### ◾ 개념
Brute (짐승같은, 난폭한) Force(힘), 한국어로 무차별 대입 공격이라고도 불리는 브루트 포스는 </br>
문제를 해결하기 위해서 가능한 모든 경우의 수를 수행하는 로직을 의미한다.</br>

### ◾ 특징
ﾠﾠ<img 
src="https://steemitimages.com/p/2bP4pJr4wVimqCWjYimXJe2cnCgn7vmMA5RochfH2tN?format=match&mode=fit&width=1280" width="400" height="400" margin-left = "10"/>
- 가능한 모든 경우의 수를 확인하므로, 수행만 할 수 있다면 정확도 100%를 자랑한다.
- 완벽하게 병렬 작업이 가능하다, 제 1 컴퓨터에서 0~999 까지, 제 2 컴퓨터에서 1000 ~ 1999 까지 확인하는 식으로 나누어서 확인할 수 있다.
- 문제가 복잡해지는 경우 매우 비효율적인 자원 소모를 보여준다.
</br>

### ◾ 시간복잡도
`O(경우의 수 * 방법1개를 시도해보는데 걸리는 시간복잡도)`</br>
</br>

</br>


### ◾ 완전 탐색 방법 (🙂종류에 대해서 미리 간단하게 살펴보는 정도로!)
**① Brute Force 기법 - 반복 / 조건문을 활용해 모두 테스트하는 방법**  
1 2 3 4 가 있을 때, 3개의 숫자를 뽑아서 순열을 만드는 문제를 가정하면<br/>
다음과 같이 다중의 for 문으로 첫번째 숫자의 인덱스 i, 두번째 숫자의 인덱스 j, 세번째 숫자의 인덱스 k 동안 <br/>
for 문을 돌리면서 모든 결과값을 확인하고 출력하는 방법이 있다. <br/>
```Kotlin
var arr = IntArray(4)
	arr[0] = 1
	arr[1] = 2
	arr[2] = 3
	arr[3] = 4
	var ans = IntArray(3) 
	for(i in 0..arr.size - 1 ){
		for(j in 0..arr.size - 1){
			for(k in 0..arr.size - 1) {
				if( i == j || j == k || k == i ) continue
					ans[0] = arr[i]
					ans[1] = arr[j]
					ans[2] = arr[k]
					for(h in 0..ans.size - 1){
						print("${ans[h]}")
							if(h == ans.size - 1)
								print(" ")
					}
			}
		}
	}
```
</br>

**② 순열(Permutation) - n개의 원소 중 r개의 원소를 중복 허용 없이 나열하는 방법**  
조합의 공식과 마찬가지로 다음과 같이 정리할 수 있다.<br/>
N은 n개의 원소, R 은 구하고자 하는 원소의 수, q 는 for 문의 길이를 위해 사용되었다.

```Kotlin
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
```Kotlin
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
> DP 는 최적화된 정답 1개만을 갖는 반면, 브루트포스는 모든 정답의 경우의 수를 전부 구하는 것에 의의를 갖고 있다.<br/>
> 피보나치 수열을 예시로 들면<br/>
> DP 접근방법은 fibonacci(n - 1) + fibonacci(n - 2) 로 재귀를 수행하면 단 한개의 정답만을 갖는 반면에 <br/>
> 브루트포스 접근방법은 i + j == fobonacci(n - 1) + fibonacci(n - 2) 에 해당하는 i 와 j 를 모두 검색한다.

</br>

**④ 비트마스크 - 2진수 표현 기법을 활용하는 방법**  
어떤 배열 arr 이 있을 때,<br/>
arr 을 기준으로 사용된 배열은 0으로, 사용되지 않은 배열은 1로 두는 방식을 의미한다.<br/>
다음은 N개 중에서 M개를 뽑을 때, 처음 시작하는 배열을 만들고 사용하지 않은 배열을 비트마스크 배열로 저장한 코드이다. <br/>

```Kotlin
void Init(arr: IntArray, unusedArr: IntArray, N: Int, M: Int) {
	var i = 0;

	while (i < M) {
		arr[i] = i + 1;
		i++;
	}

	while (j < N) {
		if (j < M) {
			unusedArr[j] = 0;
		}
		else {
			unusedArr[j] = 1;
		}
		j++;	
	}

}
```

</br>

### 참고
[플래승급전 2승 2패](https://github.com/Newon-universe/Algorithm_study)</br>
[브루트 포스(무식하게 풀기)](https://velog.io/@polynomeer/브루트-포스무식하게-풀기)</br>
[\[코딩테스트 대비\] 순열(Permutation)과 조합(Combination) 알고리즘](https://aerocode.net/376)
