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


## Stack
### 개념
![enter image description here](data:image/png;base64,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)
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

> - Scanner VS BufferedReader 
> https://www.geeksforgeeks.org/difference-between-scanner-and-bufferreader-class-in-java/
> - https://wikidocs.net/book/31
