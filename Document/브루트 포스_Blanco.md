## 브루트 포스 (Brute Force)

### ◾ 개념
조합 가능한 모든 문자열을 하나씩 대입해 보는 방식

브루트 포스 공격(brute force attack) 또는 키 전수조사(exhaustive key search), 무차별 대입 공격(無差別代入攻擊) 등으로도 부른다. 
흔히 수학 문제를 원시적으로 푸는 방법인 '수 대입 노가다'의 학술적 버전이다. 주로 암호학에서 연구되는 방법이나, 다른 알고리즘 분야에서도 사용되고 있다.

</br>

### ◾ 특징
완전탐색 알고리즘. 즉, 가능한 모든 경우의 수를 모두 탐색하면서 요구조건에 충족되는 결과만을 가져온다.

이 알고리즘의 강력한 점은 예외 없이 100%의 확률로 정답만을 출력한다.

</br>

### ◾ 시간복잡도

기본적으로 완전 탐색(Brute Force)은 N의 크기가 작을 때 이용이 되기 때문에 보통 시간 복잡도가 지수승이나, 팩토리얼 꼴로 나올 때 많이 이용된다. 

</br>

### ◾ 완전 탐색 방법 (🙂종류에 대해서 미리 간단하게 살펴보는 정도로!)
**① Brute Force 기법 - 반복 / 조건문을 활용해 모두 테스트하는 방법**  
반복 / 조건문을 통해 가능한 모든 방법을 단순히 찾는 경우를 의미한다. 원하는 만큼 반복하면 되기에 재귀 호출보다는 접근하고 구현하기가 쉽다.
```kotlin
/* 약수의 합을 구하기 */

for (i in 1 until N) {
	if (n % i == 0) {
		sum = sum + i
	}		
}	
```
</br>

**② 순열(Permutation) - n개의 원소 중 r개의 원소를 중복 허용 없이 나열하는 방법**  
순열은 임의의 수열이 있을 때, 그것을 다른 순서로 연산하는 방법! 
순서가 중요함! 만약, 수열에서 숫자 [1, 2, 3]이 있다면, 이것을 [1, 2, 3]으로 보는 순서와 [3, 2, 1]로 보는 순서가 차이가 있음이 중요한 경우를 의미한다.
같은 데이터가 입력된 수열이지만, 그 순서에 따라 의미가 있고 이 순서를 통해 연결되는 이전 / 다음 수열을 찾아낼 수 있는 경우를 계산할 수 있다.

```kotlin
/* 순열 구하기*/
fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el ): List<List<T>> {
    if(sub.isEmpty()) {
    	return listOf(fin)
    } else {
        return sub.flatMap { permutation(el, fin + it, sub - it) }
    }
}

fun main() {
    val list = mutableListOf('a', 'b', 'c', 'd')
    val list2 = permutation(list)
    list2.forEach { print("$it ") }
    println()

    val list3 = mutableListOf(1, 2, 3, 4, 5)
    val list4 = permutation(list3)
    list4.forEach { print("$it ") }
    println()

    val str = "abcd"
    val list5 = permutation(str.toList())
    list5.forEach { print("$it ") }
}
```
</br>

**③ 재귀 호출**  
더 이상 함수를 return 하지 않아야 하는 작업에 다다를 때까지 함수를 재호출한다. return 시에 함수가 아닌 값을 return 하는 경우를 기저 사례 Base Case라고 한다.
```kotlin
/* 최대 공약수 구하기 */
fun greatest_common_divisor(numA: Int, numB: Int): Int{
    if (numB == 0) {
      return numA  
    } else {
      return greatest_common_divisor(numB, numA%numB)
    }
}

fun main() {
    println(greatest_common_divisor(72,90) // 재귀함수 시작
}
```

> **브루트 포스에서의 재귀와 DP의 차이점** </br>
> 차이점
잘 생각해보면 Dynamic Programming과도 매우 흡사해 보인다. 그 또한 Top-Down을 사용 시 재귀를 통해 수행하는데, 기저 사례를 통해 탈출 조건을 만들고, 현재 함수의 상태를 전달하는 Parameter를 전달한다. 또한 Return을 통해 필요한 값을 반환하여 정답을 구하는 연산 시에 사용하게 된다. 완전 탐색의 재귀와 DP의 차이점은, DP는 작은 문제가 큰 문제와 동일한 구조를 가져 큰 문제의 답을 구할 시에 작은 문제의 결과를 기억한 뒤 그대로 사용하여 수행 속도를 빠르게 한다는 것이다.
그에 반해 완전 탐색은 크고 작은 문제의 구조가 다를 수 있고, 이전 결과를 반드시 기억하는 것이 아니라 해결 가능한 방법을 모두 탐색한다는 차이가 있다.
(즉, DP는 일반적인 재귀 중 조건을 만족하는 경우에 적용 가능!)

</br>

**④ 비트마스크 - 2진수 표현 기법을 활용하는 방법**  
비트(bit) 연산을 통해서 부분 집합을 표현하는 방법을 의미한다.

비트 연산이란 다음과 같은 것들이 있다.

And 연산(&) : 둘 다 1이면 1 
OR 연산(|) : 둘 중 1개만 1이면 1
NOT 연산(~) : 1이면 0, 0이면 1
XOR 연산(^) : 둘의 관계가 다르면 1, 같으면 0
Shift 연산(<<, >>) : A << B라고 한다면 A를 좌측으로 B 비트만큼 미는 것이다.

```kotlin
/*백준 11723번*/
for(i in 0 until N){
   val tmp = br.readLine().split(" ")
   val sb = StringBuilder()
   var s = 0

   when (tmp[0]) {
      "add" -> {
         s = s or (1 shl tmp[1].toInt())  // shl => Shift연산, or => OR 연산
      }
     "remove" -> {
         s = s and (1 shl tmp[1].toInt()) // and => And 연산
     }
     "check" -> {
        if ((s or (1 shl tmp[1].toInt())) > 0) {
           sb.append("1\n")
        } else {
           sb.append("0\n")
        }
    }
    "toggle" -> {
        s = s xor (1 shl tmp[1].toInt()) // xor => XOR 연산
    }
    "all" -> {
         s.inv() // inv() => NOT 연산
    }
    "empty" -> {
         s = 0
    }
  }
  print(s)
}
  
```

</br>

### 참고
(https://namu.wiki/w/%EB%B8%8C%EB%A3%A8%ED%8A%B8%20%ED%8F%AC%EC%8A%A4)

(https://rebro.kr/59)
