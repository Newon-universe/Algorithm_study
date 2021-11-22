## 문법과 스택


### 입출력 받는 방법

코틀린은 자바와 같은 컴파일러를 사용하는 만큼, 자바의 기능들도 사용이 가능하다.  
코틀린 자체의 내장함수로 readLine() 을 이용해서 입출력을 받는 법도 있지만, 안정적인 코딩테스트를 위해 자바의 BufferedReader 를 사용할 수도 있다.

자바의 BufferedReader 는 입력값을 실시간으로 인식하는 것이 아닌, 
메모리 내 buffer의 크기만큼 저장한 다음 연산한다는 특징이 있다. 이에 대량의 Input 값을 받는 경우 다른 입출력을 받는 방식보다 빠르게 된다.
buffer는 설정할 수도 있지만, 설정하지 않을 경우 컴퓨터의 기본 버퍼값을 따르게 된다.

입력값이 한 줄에 여러개인 경우, split 을 활용해서 받는다.

```
import java.io.*

val br = System.`in`.bufferedReader()
val A = br.readLine()                                        // String 값을 들어오게 된다.
val (B, C, D) = br.readLine().split(' ').map {it.toInt()}    // Split 으로 구별한 input 값들을 map 에 저장한 후, map 의 모든 벨류들을 Int 로 바꿈

```

출력의 경우 코틀린 내장함수인 print 와 println 을 활용할 수 있다.
print 의 경우 출력 이후 한칸을 띄우지 않지만
println 의 경우 출려 이후 한칸을 띄우게 된다.

```
print("AB")
println("CD")
print("EF")

--- 결과값 ---
ABCD
EF
```
  
  </br>
  
### 사칙연산
코틀린의 사칙연산은 다르 프로그래밍 언어들과 동일하다.
<img src="https://mblogthumb-phinf.pstatic.net/20150903_99/brickbot_1441270812498d86ji_PNG/C-%BF%AC%BB%EA%C0%DA1.png?type=w2" width="70%" align="center"/>
  
    
  </br>
  
### if 문

기본형태 : if(조건)  
  
출력    : True / False (Boolean 자료형)  
  
내용    : 조건의 내용이 참이면 True, 거짓이면 False 를 출력한다.  
  
기타    : else, else if  
 - else 는 if 의 조건이 거짓인 경우 무조건 else 문의 내용을 수행한다.  
 - else if 는 if 의 조건이 거짓이 경우, else if 의 조건이 참이 경우 else if 의 내용을 수행한다.  


```
if (조건) {
   조건이 참일 경우, 수행할 내용
}
else if (조건) {
   if 의 조건이 거짓이며, else if 의 조건이 참일 경우 수행
}
else {
   if 와 else if 의 조건이 모두 거짓일 경우 수행
}
```
  
  </br>
  
### for 문과 while 문

기본형태 : for(조건)    
  
내용    : 조건의 내용이 참이면 for 문의 내용을 반복 수행한다., 거짓이면 for 문을 벗어난다. 
  
**for 문 기본 사용법**
```
var sum = 0
for (i in 1..10) {
     sum += i
}
print(sum)
```

**실행결과**
```
55
```

**for 문 표현식**
```
for(i in 1..100) { … } → 100까지 포함
for(i in 1 until 100) { … } → 100은 포함하지 않음
for(x in 2..10 step 2) { … } → 2씩 증가
for(x in 10 downTo 1) { … } → 숫자 감소
```
  
  </br>
  
### 1차원 배열
코틀린은 Collection 패키지에서 배열의 형태를 Array, List, Map, Set 등으로 제공하고 있다.  
또한 모든 Collection 패키지는 수정할 수 있는 (mutable) 형태와 수정할 수 없는 형태 (immutable) 상태를 정할 수 있다.  
  
_* mutable 의 Array 를 선언한다고 가정했을 때 Array 자체를 Val 로 선언하여도, 내부 벨류값들을 추가할 수 있다._  
_* 단, 이 경우 재할당을 할 수는 없다._
  
```
      // 1) mutable 인터페이스를 구현하는 mutableList라는 자료구조를 val 키워드를 사용하여 선언하였다.
      // 2) 3개의 원소에 각각 1, 2, 3 이라는 Int 형 데이터를 저장하였다.
      val mutableList = mutableListOf<Int>(1, 2, 3)

      // 3) 저장된 원소를 확인하기 위해 출력 코드를 작성하였다.
      // 출력결과 ) 1(개행) 2(개행) 3(개행)
      mutableList.forEach{
          println(it)
      }

      // 4) val로 선언했던 mutableList 자료구조에 새로운 원소 추가 작업을 하였다.
      mutableList.add(4)
      mutableList.add(5)

      // 5) 저장된 원소를 확인하기 위해 출력 코드를 작성하였다.
      // 출력결과 ) 1(개행) 2(개행) 3(개행) 4(개행) 5(개행)
      mutableList.forEach {
          println(it)
      }
```
Array  
- Array 는 일반적인 배열과 마찬가지로 처음에 자료형과 크기를 선언하고서 진행한다.  
- Array 의 내용은 정적이며 연속적이므로,그 내용을 찾기가 쉽지만 Array 는 메모리에 그 크기가 할당되므로  
  배열이 빌 경우 메모리의 낭비가 생기게 된다.  
</br>

List
- List 는 자료형을 선언하지만 크기가 원소 갯수에 맞춰서 자동적으로 맞춰지는 특징이 있다.
- 데이터의 삽입과 삭제가 편하지만 원소의 위치를 포인터로 배열하기 때문에 검색이 쉽지 않다는 단점이 있다.
</br>

map
- map 은 Key 값과 Value 값을 할당해서 저장하는 배열이다.
  
**예시**
```
val numbers = mapOf(0 to "zero", 1 to "one")
println(numbers.mapValues { it.value.toUpperCase() }) //값을 대문자로 변환
```  
**출력값**
```
{0=ZERO, 1=ONE}
```


</br>
</br>

### Stack  

#### 개념
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fby1qnT%2FbtqBE1v1UlX%2FzbnXdYnGAXhMYbcDCca6WK%2Fimg.png" width="30%" height="30%" align="center"/>

- 스택(stack)이란 쌓아 올린다는 것을 의미한다.  
  따라서 스택 자료구조라는 것은 책을 쌓는 것처럼 차곡차곡 쌓아 올린 형태의 자료구조를 말한다.  
    
- 스택은 위의 사진처럼 같은 구조와 크기의 자료를 정해진 방향으로만 쌓을수 있고,  
  top으로 정한 곳을 통해서만 접근할 수 있다.
  top에는 가장 위에 있는 자료는 가장 최근에 들어온 자료를 가리키고 있으며,  
  삽입되는 새 자료는 top이 가리키는 자료의 위에 쌓이게 된다.  
  스택에서 자료를 삭제할 때도 top을 통해서만 가능하다.  
  스택에서 top을 통해 삽입하는 연산을 'push' , top을 통한 삭제하는 연산을 'pop'이라고 한다.  

- 

#### 시간복잡도
- 삭제나 삽입시 맨 위에 데이터를 삽입하거나 삭제하기 때문에 시간복잡도는 늘 O(1) 의 시간복잡도를 가진다.

#### 장점

- 구조가 단순해서, 구현이 쉽다. 데이터 저장/읽기 속도가 빠르다.

#### 단점

- (일반적인 스택 구현시) 데이터 최대 갯수를 미리 정해야 한다. 파이썬의 경우 재귀 함수는 1000번까지만 호출이 가능함



#### 결론
- 스택의 특징인  후입선출(LIFO)을 활용하여 여러 분야에서 활용 가능하다.
- 웹 브라우저 방문기록 (뒤로 가기) : 가장 나중에 열린 페이지부터 다시 보여준다.
- 역순 문자열 만들기 : 가장 나중에 입력된 문자부터 출력한다.
- 실행 취소 (undo) : 가장 나중에 실행된 것부터 실행을 취소한다.
- 후위 표기법 계산
- 수식의 괄호 검사 (연산자 우선순위 표현을 위한 괄호 검사)


##### 참고
[깡샘의 코틀린 프로그래밍] 정리 6 - for 반복문 https://kkangsnote.tistory.com/65  
[Kotlin] 코틀린의 Collection            https://choheeis.github.io/newblog//articles/2020-10/kotlinCollection  
[튜나 개발일기]                          https://devuna.tistory.com/22 
