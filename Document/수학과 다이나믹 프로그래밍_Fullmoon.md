## 수학과 다이나믹 프로그래밍

### 소수
#### ◾ 개념
+ 1보다 큰 자연수 중 1 과 그 수 자기 자신만을 약수로 갖는 자연수
+ 비교 - 합성수: 1 보다 크고 자기 자신의 수보다 작은 자연수를 약수로 갖는 자연수

#### ◾ 사용처
암호화 방식에 주로 쓰이며, 대표적으로 'RSA 암호화 방식'에 쓰이고 있다.
소수를 곱하여 암호를 만들기는 쉽지만 이렇게 만들어진 키를 역으로 소인수 분해하기는 어렵기 때문이다.

#### ◾ 기본 로직

> 로직 1) N보다 작은 자연수들로 모두 나눠보기
```java
import java.util.Scanner;

public class Prime_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        is_prime(in.nextInt());
    }

    public static void is_prime(int number) {
        if(number < 2) {
            System.out.print("소수가 아닙니다");
            return;
        }

        if(number == 2) {
            System.out.print("소수입니다");
            return;
        }
        
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                System.out.print("소수가 아닙니다");
                return;
            }
        }
        
        System.out.print("소수입니다");
        return;
    }
}
```
시간 복잡도는 N 이하의 모든 수를 검사하므로 O(N)이다.

> 로직 2) √N(제곱근) 이하의 자연수들로 모두 나누기
```java
import java.util.Scanner;
 
public class Prime_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		is_prime(in.nextInt());
	}
	
	public static void is_prime(int number) {
		if(number < 2) {
			System.out.print("소수가 아닙니다");
			return;
		}
		
		if(number == 2) {
			System.out.print("소수입니다");
			return;
		}
		
		for(int i = 2; i <= Math.sqrt(number); i++) {
        
			if(number % i == 0) {
				System.out.print("소수가 아닙니다");
				return;
			}
		}
		
		System.out.print("소수입니다");
		return;
	}
}
```
임의의 자연수 𝐍 (𝐍 > 0)은 𝑝 × 𝑞 = 𝐍 을 만족한다. 이를 통해 다음의 부등식을 완성할 수 있다. <br>
( 1 ≤  𝑝 , 𝑞 ≤ 𝐍 ) <br>
즉, p와 q 중 하나는 𝐍보다 작고, p와 q 중 하나는 반드시 √N보다 작거나 같다. <br>
√N 이하의 자연수 중에 나누어 떨어지는 수가 있다면 1과 𝐍을 제외한 자연수 중 약수가 존재한단 뜻이므로 소수가 아니다.

시간 복잡도는 √N 이하의 수까지 모든 수를 검사하므로 O(√N) 이다.


#### ◾ 에라토스테네스의 체
가장 대표적인 소수 판별 알고리즘이다. <br>
위의 소수 판별 알고리즘은 한 두개의 소수를 판별하는 데 접학한 반면, 에라토스테네스의 체는 소수를 대량으로 빠르고 정확하게 판별하는 데 적합하다.
1. 이차원 배열을 생성하여 값을 초기화한다.
2. 2부터 시작해서 특정 숫자의 배수에 해당하는 수들을 모두 지운다.
3. 이미 지워진 숫자는 건너뛰고 해당 과정을 반복한다.

![에라토스테네스](https://blog.kakaocdn.net/dn/38eHN/btqA8iGafD7/ziA43Ku5YjWzOHg3yIUKC0/img.gif)

```java
public class Eratostenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num <= 1) return;

        boolean[] arr = new boolean[num+1];    //true 이면 해당 인덱스 소수.
        arr[0] = arr[1] = false;
        for(int i=2; i<=num; i+=1) {
            arr[i] = true;
        }

        //2 부터 숫자를 키워가며 배수들을 제외(false 할당)
        for(int i=2; i*i<=num; i+=1) {
            for(int j=i*i; j<=num; j+=i) {
                arr[j] = false;        //2를 제외한 2의 배수 false
            }
        }
        System.out.println("Prime number list from 2 to " + num + " : ");
        for(int i=0; i<=num; i+=1) {
            if(true == arr[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
```

</br>

### 다이나믹 프로그래밍(DP)
#### ◾ 개념
문제를 한 번에 해결하기 힘들 때 작은 여러 개의 문제로 나누어서 풀 때, 여러 개의 문제 중 반복되는 같은 문제를 매번 재계산하지 않고 값을 저장해두었다가 재사용하는 기법

#### ◾ 조건  
**1. 첫번째 조건**  
+ 작은 문제에서 반복이 일어난다. (Overlapping Subproblem)


**2. 두번째 조건**  
+ 같은 문제는 구할 때마다 정답이 같다. (Optimal Substructure, 최적 부분 구조)

#### ◾ 메모이제이션(Memoization) 이란?
한번 계산한 결과를 메모리에 저장해놓고 재사용하여 중복 계산을 방지하는 기법

#### ◾ 분할 정복 방식과의 차이점
큰 문제를 작은 문제로 나누어 풀지만, 작은 부분에서 반복이 없다는 점에서 다이나믹 프로그래밍과 다르다.

#### ◾ 기본 로직
**1. Top-down**  
> 문제를 작은 문제로 나눠 푼 뒤, 작은 문제들의 답으로 전체 문제를 푼다. 재귀함수로 구현하는 경우에 해당한다.
> + 파이썬에서는 시간 복잡도 문제 발생 가능성이 있다.
> + 소스의 가독성이 증가한다.
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
> 문제의 크기가 작은 것부터 큰 것까지 차례대로 풀어가며 큰 문제의 답을 구한다. 반복문을 사용하여 구현한다.
> + 시간복잡도를 줄일 수 있다.
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
[Stranger's Lab](https://st-lab.tistory.com/81)  
[안경잡이 개발자](https://blog.naver.com/PostView.naver?blogId=ndb796&logNo=221233595886&redirect=Dlog&widgetTypeCall=true&directAccess=false)
[에브리 저장소](https://eblee-repo.tistory.com/27)
[Dev Cristoval](https://data-make.tistory.com/384)