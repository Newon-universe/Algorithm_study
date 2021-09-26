# Kotlin Coding Conventions
[![All Contributors](https://img.shields.io/badge/all_contributors-3-critical.svg?style=flat-square)](#contributors)
 
## 목차
- [1. 네이밍](#네이밍)
  - [1-1. 패키지와 클래스명](#네이밍-클래스명)
  - [1-2. 함수 및 변수명](#네이밍-함수-및-변수명)
- [2. 형식](#형식자)
  - [2-1. 식별](#형식-식별)
  - [2-2. 수평공백](#형식-수평공백)
  - [2-3. Wrapping 과 람다](#형식-Wrapping&Lamda)
- [3. 주석](#주석)
  - [3-1. 블록 ](#주석-블록)
  - [3-2. 꼬리 주석](#주석-꼬리)



</br><h2 id="네이밍">1. 네이밍</h2>
Kotlin 네이밍에는 영문 대소문자와 숫자만 사용한다.</br>
Kotlin 의 네이밍은 전체적인 맥락에서 명확하며, 의미있는 이름으로 정한다.</br>
Kotlin 네이밍에서는 `카멜 케이스`, `파스칼 케이스`를 사용하며 해당 용어의 정의는 <a href="https://velog.io/@leyuri/표기법-스네이크-케이스-파스칼-케이스-카멜-케이스">다음</a>을 따른다.</br>
```
카멜 케이스  : 첫 단어는 소문자, 이후 단어는 대문자
            ex) val camelCase
            
파스칼 케이스 : 모든 단어의 시작이 대문자
            ex) val PascalCase
```
</br>

<h3 id="네이밍-패키지와 클래스명">1-1. 패키지명</h3>
패키지와 클래스명은 점 `.`과 `파스칼 케이스`를 통해 구별하되, 최소한의 단어를 사용하는 것을 원칙으로 한다.</br>
단, 클래스의 매개변수를 나타내는 중괄호는 생략이 가능한 경우에도 생략하지 않는다.</br>
</br>

```Kotlin
org.example.project

open class DeclarationProcessor { /*...*/ }

object EmptyDeclarationProcessor : DeclarationProcessor() { /*...*/ }
```

</br>

<h3 id="네이밍-함수-및-변수명">1-2. 함수 및 변수명</h3>
함수 및 변수명은 카멜 케이스를 사용한다.</br>
함수 및 변수명은 긴 단어를 사용하더라도 주석 없이 이해할 수 있도록 네이밍한다.</br>
단, 의미없이 긴 단어를 사용하지 않도록 주의한다.</br>
</br>
변수명은 특별한 이유가 없으면 자동캐스팅을 사용한다.</br>
함수의 매개변수를 나타내는 중괄호는 생략이 가능한 경우에도 생략하지 않는다.</br>
</br>


```Kotlin
fun foo(){
    val autumn = "가을"
    val averagePeoplePerMonth = 7.5
    val shoreSize: Float = 102.7
    
    println("$autumn 에" +
             "평균 방문객은 $averagePeoplePerMonth 명이며," +
             "해당 해변의 크기는 $shoreSize 입니다."
    }
```

함수의 매개변수가 긴 경우 다음과 같은 문법을 사용한다.</br>

```Kotlin
fun longMethodName(
    argument: ArgumentType = defaultValue,
    argument2: AnotherArgumentType,
): ReturnType {
    // body
}
```
</br>

<h2 id="형식">2. 형식</h2>
Kotlin 의 가독성을 높이는 방향으로 작성하며, <a href="https://kotlinlang.org/docs/coding-conventions.html#expression-bodies">코틀린 코딩 컨벤션</a>을 따른다.

<h3 id="형식-식별">2-1. 식별</h3>
식별에는 공백문자(spacebar)을 사용하고, 탭(tab)을 사용하지 않는다.</br>
또한 명확한 식별을 위해서 시작하는 중괄호와 마침 중괄호에는 공백을 넣어서 구분한다.</br>
</br>

```Kotlin
if (elements != null) {
    for (element in elements) {
        // ...
    }
}
```

</br>

<h3 id="형식-수평공백">2-2. 수평공백</h3>

  #### A. 이항 연산자 사이에는 공백문자를 넣는다. </br> ﾠﾠﾠ단, "range to" 를 사용해야하는 연산자에는 공백문자를 넣지 않는다.</br>

```Kotlin
/* Bad */
print (A+B)

for (i A .. B ) {
    println(i)
}

/* Good */
print (A + B)

for (i A..B) {
    println(i)
}
```
    
  #### B. 연산자는 다음을 따른다. </br>

```Kotlin
/* 대입,   비교,     논리,   산술연산자 사이에는 공백문자를 넣는다. 
*   =     > <    && ||    + - / %
*/
val a = b
val c = a > b
val d = a && b
val e = a % b

/* 증감산 연산자 ++ -- 사이에는 공백문자를 넣지 않는다. */
print ($a++, $a--)

```

  #### C. 제어 흐름 명령어(if, when, for, while)와 해당 명령어를 여는 괄호 사이에는 공백문자를 넣는다. </br>
 
```Kotlin
/* Bad */
if(is){
   // ...
}

/* Good */
if (isTrue) {
   // ...
}
```

  #### D. 주요 생성자, 메소드 선언, 메소드 호출의 여는 괄호에는 그 앞에 공백문자를 넣지 않는다.</br>
  
```Kotlin
/* Bad */
class A (val x: Int)

fun foo (x: Int) { ... }

fun bar () {
    foo (1)
}

/* Good */
class A(val x: Int)

fun foo(x: Int) { ... }

fun bar() {
    foo(1)
}
```
  
  #### E. 절대 여는 괄호 `(`, `[` 나 닫는 괄호 `)`, `]` 뒤에 공백문자를 넣지 않는다.</br>
```Kotlin
/* Bad */
class A( val x: Int )

fun foo( x: Int ) { ... }

fun bar() {
    foo( 1 )
}

/* Good */
class A(val x: Int)

fun foo(x: Int) { ... }

fun bar() {
    foo(1)
}
```

  #### F. 절대 `.` 이나 `?.`, `!!.` 사이에 공백문자를 넣지 않는다.</br>
```Kotlin
/* Bad */
A = readLine() .toInt()
B = readLine?() ? . toInt()
C = readLine() !!. toInt()

/* Good */
A = readLine().toInt()
B = readLine?()?.toInt()
C = readLine()!!.toInt()

/* 실제 예제 */
foo.bar().filter { it > 2 }.joinToString(), foo?.bar()

```

  #### G. 꺽쇠 뒤에 특정 자료형을 나타내는 매개변수가 나올 경우 공백문자를 붙이지 않는다. 
    
```Kotlin
/* Bad */
class Map <K, V> { ... }

/* Good */
class Map<K, V> { ... }
```
</br>

<h3 id="형식-Wrapping&Lamda">2-3. Wrapping 과 람다</h3>

  #### A. 묶여서(Wrapping) 연속으로 호출되는 `.` 와 `?.` 연산자는 각각 하나의 줄로 적는다.
  
```Kotlin
/* Bad */
val anchor = owner?.firstChild!!.siblings(forward = true).dropWhile { it is PsiComment || it is PsiWhiteSpace }

/* Good */
val anchor = owner
    ?.firstChild!!
    .siblings(forward = true)
    .dropWhile { it is PsiComment || it is PsiWhiteSpace }
```
    
    
  #### B. 람다식
  ##### B - 1.  람다식을 매개변수로 받는 함수에서, 람다식의 내용이 길다면 람다식의 이름과 화살표를 첫째줄에 적고 다음 줄에 내용을 적는다. 
  
```Kotlin
/* Bad */
exampleLamda(properties) { prop -> val propertyValue = prop.get(obj)  // ...
}


/* Good */
exampleLamda(properties) { prop ->
    val propertyValue = prop.get(obj)  // ...
}

```

<br/>

  ##### B - 2.  람다식의 매개변수가 한 줄에 적기에 너무 길 경우, 매개변수를 여러 줄에 걸쳐 작성하고 화살표는 가장 마지막 매개변수의 하단에 넣는다.
```Kotlin
/* Bad */
exampleLamda {
   context: Context, environment: Env ->
   context.configureEnv(environment)
}

/* Good */
exampleLamda {
   context: Context,
   environment: Env
   ->
   context.configureEnv(environment)
}

```




</br>

</br><h2 id="주석">3. 주석</h2>

<h3 id="주석-블록">3-1. 블록 주석</h3>

메서드, 자료구조, 알고리즘에 대한 설명을 제공할 때 사용된다.
- 각각의 파일이 시작될 때와 메서드 전에 사용된다.
- 블록 주석은 다른 코드들과 구분하기 위해서 처음 한 줄은 비우고 사용한다. 

```Kotlin
/*
 * 여기에 블록 주석을 작성한다.   
 */
```

<h3 id="주석-꼬리">3-2. 꼬리 주석</h3>

그 외 짧은 주석이 필요한 경우 주석이 설명하는 코드와 같은 줄에 작성한다.
- 실제 코드와는 구분될 수 있도록 충분히 멀리 떨어뜨려야 한다.

```Kotlin
if (a == 2) {
    return TRUE;       /* a 가 2인 경우 */
}
```

<!-- /br> [↑ 목차](#목차) -->

</br>

## Contributors
*Sol Blanco Newon*  

</br>

> ###### 참고자료
> - <href="https://kotlinlang.org/docs/coding-conventions.html#documentation-comments"> Coding Conventions - kotlinlang.org</a>
> - <href="https://developer.android.com/kotlin/style-guide?hl=ko#formatting">Kotlin 스타일 가이드 - Android for Developers</a>
> - <href="https://velog.io/@leyuri/표기법-스네이크-케이스-파스칼-케이스-카멜-케이스"> 표기법 - 스네이크 케이스, 파스칼 케이스, 카멜 케이스 - leyuri Velog </a>
