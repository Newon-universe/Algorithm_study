## 스택


### 개념

- 스택은 택배 상하차로 이해하면 쉽다.
- 트럭이 컴퓨터고, 택배가 데이터라면 기본적으로 트럭에서 택배를 넣고 빼는 행위를 컴퓨터에서 데이터를 삽입하거나 삭제하는 것에 비유할 수 있다.
- 트럭의 적재공간의 입출구는 하나기 때문에, 가장 먼저 넣은 택배를 가장 나중에 꺼내게 되는 것이 자연스러운데 여기서 스택의 선입후출(혹은 후입선출) 속성을 이해할 수 있다.
- 다음은 스택 자료구조를 그림으로 표현한 것이다.

![img](https://media.vlpt.us/images/sbinha/post/17a3cf61-fb95-4970-b66c-92a71b99846b/Screenshot%202020-04-20%2019.07.55.png)

- push(삽입) , pop(삭제) , peek(가장 최상단의 데이터를 읽기) => 메서드 이름은 언어마다 다르므로 삽입,삭제,읽기 같은 처리를 하는구나 정도로 이해하면 된다.
- 스택이라는 이름의 물리적 무언가가 있는게 아니라, 컴퓨터 자료구조에서 데이터를 처리하는 메서드나 명령들의 작동원리를 개념화한 것이다.

### 시간복잡도
- 선입후출, 후입선출의 특징때문에 삭제나 삽입시 항상 맨 위의 데이터를 대상으로 하게 된다. ( 위에 그림을 보고 이해하면 더 쉽다. )
- 그래서 스택에서 삽입과 삭제의 시간복잡도는 늘 O(1) 이다. O(1)에서 O는 시간복잡도를 빅오 표기법으로 표현한건데 그건 알아서 구글링 해보길 바라고, 괄호 안의 1은 연산 횟수를 뜻하는 것이다.
- 컴퓨터한테 '삽입해' 또는 '삭제해' 라는 명령을 내렸을 때 어차피 대상은 항상 맨 위의 데이터이므로 연산은 1번으로 끝난다는 뜻이다. 그래서 O(1) 이다.
- 만약 특정 데이터를 찾아서 읽어야 한다면, O(n) 의 시간복잡도가 걸리게 된다. peek 함수는 항상 맨 위의 데이터밖에 못 읽어오는 바보함수기 때문에, 내가 맨 위에서 3번째 데이터를 읽어오고 싶다면 위의 데이터 2개를 삭제하고 읽어와야 한다.
- 그래서 1번째 데이터 삭제 - 2번째 데이터 삭제 - 3번째 데이터(맨 위로 올라옴) 읽기 와 같은 로직을 통해 '3번째 데이터를 읽어와' 라는 연산이 완료되므로, 이 경우 O(3)이 되는 것이다. 이런식으로 데이터를 읽어올 경우 연산횟수가 몇번이 될지는 랜덤이기 때문에 O(n) 이라는 시간복잡도로 표기를 하게 되는 것이다.


### 로직 
( 위의 pop, push 함수는 C 에서 사용하는 함수다. 여기서는 pop, push 와 같은 스택함수들을 코틀린으로 구현하여 설명해보려고 한다. 어차피 원리는 똑같다. )

코틀린에서는 완전히 C의 스택을 구현할 수 없으므로, 스택을 발전시킨 MutableList로 로직을 이해해보고자 한다. ( 자바의 Stack 라이브러리를 사용할 수도 있지만 프로그램이 많이 무겁다. )


```kotlin
 fun main() {
    // stack
    var mutableList = mutableListOf<Int>()

    // push = add (삽입)
    mutableList.add(1)
    mutableList.add(2)
    mutableList.add(3)

    // pop = removeAt (삭제)
    mutableList.removeAt(mutableList.size-1)

    // isEmpty or isNotEmpty ( Boolean 타입으로 판단 )
    println(mutableList.isEmpty())
    println(mutableList.isNotEmpty())

    // stack 크기
    println(mutableList.size)
}
```


### 장점

- 구현이 쉽다. (구현객체로 배열이나 리스트를 만들고 객체.메서드 형태로만 사용하면 데이터의 삽입,추가,읽기 등이 가능하기 때문에)
- 원하는 데이터로 접근 속도가 빠르다. (예를 들어, 웹 브라우저에서 링크를 여러 번 클릭하여 웹 페이지 스택이 쌓여 있을 때, 간단하게 뒤로가기 나 앞으로가기 버튼만 눌러도 자신이 원하는 페이지로 금방 접근할 수 있다.)



### 단점

- 데이터를 탐색하는데 있어 비효율적이다. 데이터를 자주 꺼내 읽어와야 하는 경우나 자주 삽입해야 하는 경우 많이 불편하다는 뜻이다. (만약에 웹 페이지 스택이 100개 쌓여 있다고 한다면 첫번째 페이지로 가고 싶을 땐 뒤로가기를 99번이나 눌러야 한다. 개념에서 봤듯이 스택의 원리 때문에 원소를 하나하나 꺼내가면서 원하는 데이터에 도달해야 하기 때문이다. 최상단 스택의 데이터만 읽을 수 있기 때문.)



### 결론

- 스택만의 장단점이 있으므로, 스택에 적합한 자료관리일 경우에만 사용하는 것이 좋겠다.



### 참고
https://www.youtube.com/watch?v=WB_BoAgWLNU&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=14&ab_channel=%EB%8F%99%EB%B9%88%EB%82%98
https://velog.io/@choiiis/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%8A%A4%ED%83%9DStack%EA%B3%BC-%ED%81%90Queue
https://choheeis.github.io/newblog//articles/2020-10/kotlinStack


