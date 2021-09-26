# WEEK 1 : 문법과 스택
> Java의 기본 문법과 스택을 정리해보자! 🔥🔥 🧑‍🚒🚒 
## 입출력
```java
public class IOTest {
public static void main(String[] args) throws Exception {
        String start;
        start = "Study start";
        System.out.println(start);
    }
}
```
## 사칙연산
+ 예제 코드
```java
public class CalTest {
	public static void main(String[] args) {
	    
		int x = 9;
		int y = 5;
		
		int add = x+y;   /* 덧셈 */
		int sub = x-y;   /* 뺄셈 */
		int mult = x*y;  /* 곱셈 */
		int div = x/y;   /* 나눗셈 */
		int mod = x%y;   /* 나머지 */
		
		System.out.println(add);   /* 14 */
		System.out.println(sub);   /* 4 */
		System.out.println(mult);  /* 45 */
		System.out.println(div);   /* 1 */
		System.out.println(mod);   /* 4 */
	}
}
```

## if문
+ 개념
  
  조건을 판단하여 해당 조건에 맞는 상황을 수행해야 할 경우 사용한다.


+ 예제 코드
```java
public class IfTest {
    public static void main(String[] args) throws Exception {
        boolean hasMoney = true;
        if (hasMoney) {        /* 조건문 */
            System.out.println("떡볶이를 먹자");
        } else {
            System.out.println("굶자");
        }
    }
}
```

+ 추가 공부

조건 판단을 위해서는 boolean보다는 비교 연산자를 쓰는 경우가 많으므로 공부해 두도록 한다.



## for문과 while문
+ 개념

for문과 while문 모두 반복해서 문장을 수행해야 할 경우 사용한다.
### for문


+ 예제 코드
```java
public class ForTest {
    public static void main(String[] args) throws Exception {
        boolean hasMoney = true;
        if (hasMoney) {
            System.out.println("떡볶이를 먹자");
        } else {
            System.out.println("굶자");
        }
    }
}
```
### while문
+ 예제 코드

```java
public class WhileTest {
    public static void main(String[] args) throws Exception {
        int hasTteokguk = 0;
        while (hasTteokguk < 10) {    /* 조건문 */
            hasTteokguk++;            /* 변수값이 1씩 증가 */
            System.out.println("떡국을  " + hasTteokguk + "번 먹었습니다.");
            if (hasTteokguk == 10) {  /* 조건문 거짓이 되면 while문 빠져나감 */
                System.out.println("나이를 열 살 먹었습니다.");
            }
        }
    }
}
```

+ 추가 공부

while문을 강제로 빠져나가는 break와 조건문으로 다시 돌아가는 continue 명령어도 알아두도록 하자.

## 1차원 배열
```java
public class ArrayTest {
    public static void main(String[] args) throws Exception {
        String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};  /* 배열 선언 */
        for (int i=0; i<weeks.length; i++) {
            System.out.println(weeks[i]);                         /* 배열 값에  인덱싱 이용하여 접근 */
        }
    }
}
```

## 자료형
*후에 추가*

## 자료구조 - Stack
###  개념
<img src="https://blog.kakaocdn.net/dn/bxNCzJ/btqFZywQnIJ/TlyeT9hjwuvEXKlKjlnR40/img.png" width="450px" height="300px" title="스택의 구조" alt="스택의 구조"></img><br/>

리스트 자료구조의 특별한 경우 중 하나이다. <br>
리스트 자료구조는 읽기, 삽입, 삭제를 리스트의 어느 곳에서나 할 수 있는 반면에 스택은 삽입과 삭제를 리스트의 한 쪽(__Top__)에서 행한다.
<br>
이를 LIFO(Last In First Out), 혹은 후입선출이라 한다.

### 시간복잡도

삭제 및 삽입 : 맨 위에 데이터를 삽입하거나 삭제하기 때문에 늘 O(1) <br>
데이터 검색 : 특정 데이터를 찾을 때까지 수행해야 하므로 O(n)

#### 장점
+ 구조가 단순하며 구현이 쉽다.
+ 데이터 저장/조회/삭제의 속도가 빠르다.

#### 단점
+ 일반적으로 구현 시 데이터 최대 개수를 미리 정해야 한다
+ 따라서 미리 저장공간을 확보해야 하므로 저장 공간의 낭비가 발생할 수 있다.

### 구현
배열과 연결리스트로 구현할 수 있다.
<br> 먼저 자바에서 배열로 구현한 스택을 살펴보자.

```java
interface Stack{
  boolean isEmpty();
  boolean isFull();
  void push(char item);
  char pop();
  char peek();
  void clear();
}
public class ArrayStack implements Stack {

  private int top;
  private int stackSize;
  private char stackArr[];

  // 스택을 생성하는 생성자
  public ArrayStack(int stackSize) {
    top = -1;    // 스택 포인터 초기화
    this.stackSize = stackSize;    // 스택 사이즈 설정
    stackArr = new char[this.stackSize];    // 스택 배열 생성
  }

  // 스택이 비어있는 상태인지 확인
  public boolean isEmpty() {
    // 스택 포인터가 -1인 경우 데이터가 없는 상태이므로 true 아닌 경우 false를 return
    return (top == -1);
  }

  // 스택이 가득찬 상태인지 확인
  public boolean isFull() {
    // 스택 포인터가 스택의 마지막 인덱스와 동일한 경우 true 아닌 경우 false를 return
    return (top == this.stackSize-1);
  }

  // 스택에 데이터를 추가
  public void push(char item) {
    if(isFull()) {
      System.out.println("Stack is full!");
    } else {
      stackArr[++top] = item;    // 다음 스택 포인터가 가리키는 인덱스에 데이터 추가
      System.out.println("Inserted Item : " + item);
    }
  }

  // 스택의 최상위(마지막) 데이터 추출 후 삭제
  public char pop() {
    if(isEmpty()) {
      System.out.println("Deleting fail! Stack is empty!");
      return 0;
    } else {
      System.out.println("Deleted Item : " + stackArr[top]);
      return stackArr[top--];
    }
  }

  // 스택의 최상위(마지막) 데이터 추출
  public char peek() {
    if(isEmpty()) {
      System.out.println("Peeking fail! Stack is empty!");
      return 0;
    } else {
      System.out.println("Peeked Item : " + stackArr[top]);
      return stackArr[top];
    }
  }

  // 스택 초기화
  public void clear() {
    if(isEmpty()) {
      System.out.println("Stack is already empty!");
    } else {
      top = -1;    // 스택 포인터 초기화
      stackArr = new char[this.stackSize];    // 새로운 스택 배열 생성
      System.out.println("Stack is clear!");
    }
  }

  // 스택에 저장된 모든 데이터를 출력
  public void printStack() {
    if(isEmpty()) {
      System.out.println("Stack is empty!");
    } else {
      System.out.print("Stack elements : ");
      for(int i=0; i<=top; i++) {
        System.out.print(stackArr[i] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    int stackSize = 5;
    ArrayStack arrStack = new ArrayStack(stackSize);

    arrStack.push('A');
    arrStack.printStack();

    arrStack.push('B');
    arrStack.printStack();

    arrStack.push('C');
    arrStack.printStack();

    arrStack.pop();
    arrStack.printStack();

    arrStack.pop();
    arrStack.printStack();

    arrStack.peek();
    arrStack.printStack();

    arrStack.clear();
    arrStack.printStack();
  }

}
```



## 참고 자료 및 링크
[점프 투 자바](https://wikidocs.net/226) <br>
[스택(Stack)이란 by heejeong Kwon](https://gmlwjd9405.github.io/2018/08/03/data-structure-stack.html) <br>
[스택, 큐 by sbinha](https://velog.io/@sbinha/%EC%8A%A4%ED%83%9D-%ED%81%90) <br>
[FREESTROKES DEVLOG](https://freestrokes.tistory.com/82) 