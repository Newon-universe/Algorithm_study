<img src="https://img.shields.io/badge/JAVA-007396?style=flat-square&logo=java&logoColor=white"></br>

# 1. 문법과 스택

## 입출력 받는 방법
### 스캐너(Scanner) VS # 버퍼드리더(BufferedReader)
#### Scanner
```java
    Scanner scan = new Scanner(System.in);
```
- java.util.Scanner 클래스
- 기본 유형과 문자열을 구문 분석할 수 있는 **간단한 텍스트 스캐너** 방식
- Java 프로그램에서 입력을 읽는 가장 쉬운 방법
- **데이터 유형**에 따라 사용하는 함수가 다르다.
	( nextInt(), nextFloat(), next(), nextLine() etc... )
	
#### BufferedReader
```java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```
- java.io.BufferedReader 클래스
- Buffer를 이용하여 입출력의 효율을 높여준다.
- **문자 입력 스트림**으로 텍스트를 읽어서 문자를 버퍼링하여 문자 시퀀스를 효율적으로 읽을 수 있도록 한다.
- **read() 작업에 비용이 많이 들 수 있는** FileReaders or InputStreamReaders[^1]의 경우에는 **BufferedReader를 래핑**하는 것이 좋은 방식이다.

#### 주요 차이점
- BufferedReader 는 동기식, but Scanner X
- 다중 스레드로 작업을 해야하는 경우에는 BufferedReader를 사용해야 한다.
- 버퍼 메모리 크기 : BufferedReader >> Scanner
- 읽기 속도 : Scanner >> BufferedReader

</br></br>

## 사칙연산
```java
	public class Test {

		public static void main(String[] args) {
			int x = 3;
			int y = 2;

			int add = x + y;
			int sub = x - y;
			int mult = x * y;
			int div = x / y;
			int mod = x % y;

			System.out.println(add);  //5
			System.out.println(sub);  //1
			System.out.println(mult); //6
			System.out.println(div);  //1
			System.out.println(mod);  //1
		}
	}
```

</br></br>

## if 문
### if 문의 기본 구조
```java
	if (조건문) {
		<수행할 문장1>;
		<수행할 문장2>;
		...
	} else {
		<수행할 문장A>;
		<수행할 문장B>;
		...
	}
```
단, 다중 조건 판단의 경우에는 `else if` 를 사용한다.

</br></br>

## for 문과 while 문

### for 문
```java
	for (초기치; 조건문; 증가치)
```
for의 조건문은 세미콜론(;)을 구분자로 세 부분으로 나뉘어진다.

### while 문
```java
	while (조건문) {
		<수행할 문장1>;
		<수행할 문장2>;
		<수행할 문장3>;
		...
	}
```
조건문이 참인 동안 while문 아래의 문장들을 계속해서 수행 하게 된다.
여기서, 조건문에 `true`를 작성하면 무한 루프를 돌게 된다.

>  ### 반복문의 친구들
>   continue : 조건문의 처음 조건으로 돌아감
>    break : 반복문 종료

</br></br>

## 1차원 배열
배열은 자료형 타입 바로 옆에  `[]`  기호를 사용하여 표현한다. 

요일의 집합은 다음과 같이 String 배열로 표현 할 수 있다.
```java
	String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
```
### 배열의 길이는 고정
배열의 길이만 설정하여 변수를 먼저 생성한 다음 그 값은 나중에 대입할 수 있다.
단, 초기값 없이 배열 변수를 만들 때에는 반드시 길이값이 필요하다.
```java
	String[] weeks = new String[7];
```
### 배열의 값에 접근 (Index)
여러 값들을 포함하고 있는 배열에서 특정 값에 접근을 하고 싶을 때, 인덱스를 사용한다.
```java
	String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
	System.out.println(weeks[3]);
```
weeks[3]은 weeks배열의 4번째 항목을 의미한다. (자바는 0부터 숫자를 센다.)

</br></br>

## Stack
### 개념
<img src="https://media.vlpt.us/images/sbinha/post/17a3cf61-fb95-4970-b66c-92a71b99846b/Screenshot%202020-04-20%2019.07.55.png"></br>
```java
	Stack<Integer> stack = new Stack<>(); //int형 스택 선언
	stack.push(1); // stack에 값 1 추가
	stack.push(2); // stack에 값 2 추가
	stack.pop(); // stack에 값 제거 (2 제거)
	stack.clear(); // stack의 전체 값 제거 (초기화)
```
- LIFO 방식(Last In First Out) 
- 시스템 해킹에서 버퍼오버플로우 취약점을 이용한 공격을 할 때, 스택 메모리의 영역이 사용된다.
- 인터럽트처리, 수식의 계산, 서브루틴의 복귀 번지 저장 등에 쓰인다.
- 그래프의 깊이 우선 탐색(DFS)에서 사용된다.
- 재귀적(Recursion) 함수를 호출 할 때 사용된다.
 

### 시간복잡도

	- 삽입(Push): 맨 위에 데이터를 넣으면 되기 때문에 O(1) 입니다.
    - 삭제(Pop): 맨 위에 데이터를 삭제하면 되기 때문에 O(1) 입니다.
    - 읽기(Peek): 맨 위의 데이터를 읽으면 되기 때문에 O(1) 입니다.
    - 탐색(Search): 맨 위의 데이터부터 하나씩 찾아야 하기 때문에 O(n)이 걸리게 됩니다.


### 장점
- 구조가 단순해서 구현이 쉽다.
-  데이터 저장/읽기 속도가 빠르다.

### 단점
- 데이터 최대 갯수를 미리 정해야 한다.
Ex) 파이썬의  경우 재귀 함수는 1000번까지만 호출이 가능하다.


#### 참고

> - Scanner VS BufferedReader </br>
> https://www.geeksforgeeks.org/difference-between-scanner-and-bufferreader-class-in-java/
> - https://wikidocs.net/book/31
