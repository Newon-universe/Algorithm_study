
## 수학과 다이나믹 프로그래밍

### 소수
#### ◾ 개념
1보다 큰 자연수 중에서 1과 자기 자신만을 약수로 갖는 것이다.
따라서 모든 짝수는 2를 약수로 갖기 때문에 소수에서 짝수는 2만 존재하게 된다.

#### ◾ 기본 로직
소수 판별 알고리즘.
N보다 작은 자연수들로 모두 나눠본다.
```java
	import java.io.*;
	import java.util.Scanner;

	public class Main {
		public static void main(String[] args) throws IOException {
			Scanner pr = new Scanner(System.in);

			isPrime(pr.nextInt());
		}

		public static void isPrime(int number) {
			if (number < 2) { // 0 과 1 은 소수가 아니다
				System.out.print("소수가 아닙니다");
				return;
			}

			if (number == 2) { // 2 는 소수다
				System.out.print("소수입니다");
				return;
			}

			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					System.out.print("소수가 아닙니다");
					return;
				}
			}
			
			System.out.print("소수입니다");
			return;
		}
	}
```

#### ◾ 에라토스테네스의 체
1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
2. 2는 소수이므로 오른쪽에 2를 쓴다.
3. 자기 자신을 제외한 2의 배수를 모두 지운다.
4. 남아있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다.
5. 자기 자신을 제외한 3의 배수를 모두 지운다.
6. 남아있는 수 가운데 5는 소수이므로 오른쪽에 5를 쓴다.
7. 자기 자신을 제외한 5의 배수를 모두 지운다.
8. 남아있는 수 가운데 7은 소수이므로 오른쪽에 7을 쓴다.
9. 자기 자신을 제외한 7의 배수를 모두 지운다.
10. 위의 과정을 반복하면 구하는 구간의 모든 소수가 남는다.

```java
	import java.io.*;
	import java.util.Scanner;

	public class Main {
		public static void main(String[] args) throws IOException {
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			if (num <= 1)
				return;

			boolean[] arr = new boolean[num + 1];
			arr[0] = arr[1] = false;
			for (int i = 2; i <= num; i++) {
				arr[i] = true;
			}

			// 2 부터 숫자를 키워가며 배수들을 제외
			for (int i = 2; i * i <= num; i++) {
				for (int j = i * i; j <= num; j += i) {
					arr[j] = false;
				}
			}
			System.out.println("Prime number list : ");
			for (int i = 0; i <= num; i++) {
				if (true == arr[i]) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
```

#### ◾ 시간 복잡도
> 기본 로직 : O(N)
> 기본 로직은 N-1까지의 수를 반복해서 직접 나눠보기 때문에 O(N)이 된다.
> 에라토스테네스의 체 : O(Nlog(logN))
</br>

### 다이나믹 프로그래밍
#### ◾ 개념
특정 범위까지의 값을 구하기 위해서 그것과 다른 범위까지의 값을 이용하여 효율적으로 값을 구하는 알고리즘 설계 기법이다. 답을 재활용하는 것이다. 앞에서 구했던 답을 뒤에서도 이용하고, 옆에서도 이용하고....
다이나믹 프로그래밍에서는 어떤 문제를 풀기 위해 그 문제를 더 작은 문제의 연장선으로 생각하고, 과거에 구한 해를 활용하는 것이 핵심이다.
#### ◾ 조건  
**1. 첫번째 조건**  
> **최적 부분 구조**
> 큰 문제를 작은 문제로 나눌 수 있으며 작은 문제로 나눌 수 있으며 작은 문제의 답을 모아서 큰 문제를 해결할 수 있다

**2. 두번째 조건**  
> **중복되는 부분 문제**
> 동일한 작은 문제를 반복적으로 해결해야 한다

#### ◾ 메모이제이션(Memoization) 이란?
컴퓨터가 동일한 계산을 반복하는 경우, 이전에 계산한 값을 메모리에 저장함으로써 동일한 계산의 반복 수행을 최소화하여 프로그램의 실행 속도를 높여준다.
</br>
#### ◾ 분할 정복 방식과의 차이점
- 다이나믹 프로그래밍 : 부분 문제는 중복되어서 상위 문제 해결 시에 재사용되고, 메모이제이션 기법을 사용한다.
- 분할 정복 : 부분 문제는 서로 중복되지 않으며, 메모이제이션 기법을 사용하지 않는다.
</br>
#### ◾ 기본 로직
**1. Top-down**  
> 문제를 작은 문제로 나누고, 그 문제를 풀어냄으로써 전체 문제를 해결하는 방식. 재귀 호출을 이용해서 쉽게 해결할 수 있다.
```java
	public static void main(String[] args) {
		int answer = finbonachi(n);
	}

	public int fibonachi(n) {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibonachi(n-1) + fibonachi(n-2);
	}
```

**2. Bottom-up**  
> 문제의 크기가 작은 문제부터 풀어나간다. 크기를 조금씩 키워나가면서 해결한다. 그렇게 크기를 키워나가다보면 언젠간 풀어야하는 문제를 해결할 수 있다.
```java
	public int bottomUp(int n) {
		int[] arr = new int[n];
		arr[0] = 0;
		arr[1] = 1;
		
		if(n == 0)
			return arr[0];
		else  if(n == 1)
			return arr[1];
		else {
			for(int i = 2; i < n+1; i++)
				arr[i] = arr[i-1] + arr[i-2];
			return arr[n];
		}
	}
```

</br>

### 참고
[에라토스테네스의 체](https://choheeis.github.io/newblog//articles/2020-04/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98%EC%B2%B4)</br>
[[이것이 코딩 테스트다] 6. 다이나믹 프로그래밍](https://freedeveloper.tistory.com/276)</br>
[동적 계획법 (Dynamic Programming)과 분할 정복(Divide and Conquer) 알고리즘](https://syujisu.tistory.com/147)
