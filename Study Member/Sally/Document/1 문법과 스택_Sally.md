## 문법과 스택

### 입출력 받는 방법
#### ◾ Scanner
**Scanner**는 InputStream을 생성자로 받을 수 있는데,  
여기서 **키보드** 입력을 받으려면 System.in의 InputStream을 넘겨주면 된다.  

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);  
int n = sc.nextInt();                        /* int 자료형의 데이터를 입력받음 */
System.out.println(n);
```

#### ◾ [BufferedReader / BufferedWriter](https://jhnyang.tistory.com/92)
버퍼는 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 임시 메모리 영역으로,  
이 함수를 이용하면 입출력 속도가 더욱 향상한다.  

```java
import java.io.*;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
	String str = br.readLine();   /* 입력 받은 데이터는 String 타입으로 고정됨 */
	bw.write(str + "\n");
	bw.flush();
	bw.close();
}
```
</br>

### 사칙연산
|덧셈|뺄셈|곱셈|나눗셈|나머지|
|:--:|:--:|:--:|:--:|:--:|
|x + y|x - y|x * y|x / y|x % y|
</br>

### if 문
#### ◾ 기본 구조
조건문을 테스트 해서 **참**이면 if문 바로 다음의 문장들을 수행하고,  
조건문이 **거짓**이면 else if문 다음의 문장들을 수행하게 된다.
```java
if (조건문) {
    <수행할 문장> 
    ...
} else if (조건문) {
    <수행할 문장>
    ...
} else {
   <수행할 문장>
   ... 
}
```

#### ◾ 조건문
`if (조건문)` 에서 사용되는 조건문이란 참과 거짓을 판단하는 문장을 말한다.  

#### ◾ else if (다중 조건 판단)
else if 는 이전 조건문이 거짓일 때 수행되게 된다.  
이는 개수에 제한 없이 사용할 수 있다.  
</br>

### 반복문
코드를 자동으로 반복시켜주는 것
#### ◾ for 문
for문 조건이 참일 경우 내부를 실행하고, 다시 돌아와 조건을 검사한다.  
조건이 거짓이 될 때까지 반복해준다.  

```java
for (초기치; 조건문; 증가치) {
    /* 조건이 참일 경우 for문 내부 실행 */
}
```
> for문 안에서 정의된 변수는 for문이 끝나면 메모리에서 사라진다.  

#### ◾ while 문
```java
while (조건문) {
    /* 조건이 참일 경우 while문 내부 실행 */
}
```
</br>

### 1차원 배열
#### ◾ 배열 이란?
하나의 변수 이름 안에 여러 값이 들어가 있는 것이다.  
같은 타입의 변수가 연속적으로 사용될 때 사용한다.  

#### ◾ 기본 형태
홀수들의 집합은 다음과 같이 int 배열로 표현한다.  
```java
int[] odds = {1, 3, 5, 7, 9};
for(int i = 0; i < odds.length; i++) {
  System.out.println(odds[i]);           /* 배열 요소 하나씩 출력 */
}
```
> 자바에서 인덱스(배열의 위치)는 언제나 0부터 시작한다.  
</br>

### 스택
<img src="https://user-images.githubusercontent.com/48541984/134784974-61ec6e2d-71a9-4d55-afbc-1e2c69696e51.png" width="70%" align="center"/>

#### 개념
- 블록을 아래에서부터 위로 쌓아올리는 구조
- **LIFO (Last In First Out)** 구조 - 한쪽 끝에서만 자료를 넣고 뺄 수 있는 구조
- 가장 마지막에 삽입한 데이터를 가장 먼저 사용하게 됨  
- 배열 혹은 연결리스트를 통해 구현함

#### 시간복잡도
삽입/삭제 시 맨 위에 데이터를 삽입/삭제하기에 시간복잡도는 늘 **O(1)** 을 가진다.  
탐색 시 특정 데이터를 찾을 때까지 수행을 해야하므로 **O(n)** 의 시간 복잡도를 가진다.  

- Insertion `O(1)`
- Deletion `O(1)`
- Search `O(n)`

#### 장점
- 데이터의 삽입과 삭제가 빠름

#### 단점
- 데이터 탐색 시 원소를 하나하나 꺼내서 옮겨가면서 해야 함
- 맨 위의 원소만 접근 가능함

#### 결론
- 재귀 알고리즘에서 유용하게 사용함
- 역추적을 해야할 때 사용함 (ex. 문서 작업 시 실행 취소)

</br>

### 참고
[Java 자바 입출력 - BufferedReader / BufferedWriter](https://jhnyang.tistory.com/92)  
[Java 반복문 - for / while](https://velog.io/@max9106/Java-%EB%B0%98%EB%B3%B5%EB%AC%B8-for-while-ffk4a7p2a2#while%EB%AC%B8)  
[Java 1차원 배열 - TCPSchool](http://tcpschool.com/java/java_array_oneDimensional)  
[자료구조 - Stack](https://velog.io/@choiiis/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%8A%A4%ED%83%9DStack%EA%B3%BC-%ED%81%90Queue)  
