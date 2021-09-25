# Java Coding Conventions
[![All Contributors](https://img.shields.io/badge/all_contributors-4-critical.svg?style=flat-square)](#contributors)

## 목차
- [1. 포맷팅](#포맷팅)
    - [1-1. 중괄호](#포맷팅-중괄호)
    - [1-2. 띄어쓰기](#포맷팅-띄어쓰기)
- [2. 네이밍](#네이밍)
    - [2-1. 패키지명](#네이밍-패키지명)
    - [2-2. 클래스명](#네이밍-클래스명)
    - [2-3. 그 외의 모든 식별자](#네이밍-식별자)
- [3. 주석](#주석)
    - [3-1. 블록 ](#주석-블록)
    - [3-2. 꼬리 주석](#주석-꼬리)

</br><h2 id="포맷팅">1. 포맷팅</h2>
코드의 가독성(readability)를 높이고, 일관된 표준을 적용한다.

<h3 id="포맷팅-중괄호">1-1. 중괄호</h3>

시작하는 중괄호는 새로운 라인에서 시작하지 않고 제어문과 같은 라인을 사용한다.

```java
/* Bad */
if (superHero == theTick)
{
  System.out.println("Spoon!");
}

/* Good */
if (superHero == theTick) {
  System.out.println("Spoon!");
}
```

<h3 id="포맷팅-띄어쓰기">1-2. 띄어쓰기</h3>

#### A. 메소드 이름 다음에는 띄어쓰기 없이 왼쪽 괄호를 사용

```java
/* Bad */
foo (i, j);

/* Good */
foo(i, j);
```

#### B. 배열 다음에는 띄어쓰기 없이 왼쪽 괄호를 사용

```java
/* Bad */
args [0];

/* Good */
args[0];
```

#### C. 이진 연산자 간에는 양쪽에 띄어쓰기를 사용

```java
/* Bad */
z = 2*x + 3*y;

/* Good */
z = 2 * x + 3 * y;
z = (2 * x) + (3 * y); 
```

#### D. 쉼표와 세미콜론 뒤에는 띄어쓰기를 사용

```java
/* Bad */
for (int i = 0;i < 10;i++)

/* Good */
for (int i = 0; i < 10; i++)
```

#### E. cast 사용시 띄어쓰기 없이 작성

```java
/* Bad */
(MyClass) v.get(3);
( MyClass )v.get(3);

/* Good */
(MyClass)v.get(3);
```

#### F. if, while, for, switch, catch 문 뒤에는 띄어쓰기를 사용

```java
/* Bad */
if(hungry)
while(pancakes < 7)
for(int i = 0; i < 10; i++)
catch(TooManyPancakesException e)

/* Good */
if (hungry)
while (pancakes < 7)
for (int i = 0; i < 10; i++)
catch (TooManyPancakesException e)
```

</br><h2 id="네이밍">2. 네이밍</h2>
> **카멜, 파스칼 등 <a target="_blank" href="https://needjarvis.tistory.com/632">각 표기법</a>을 익혀두세요!**

모든 식별자는 영문 대소문자와 숫자만 사용한다.

<h3 id="네이밍-패키지명">2-1. 패키지명</h3>

8자 이내로, 소문자만 사용한다.

```java
Examples:
    common
    core
    lang
```

<h3 id="네이밍-클래스명">2-2. 클래스명</h3>

`파스칼 표기법`을 사용해주세요. 각 단어의 첫 글자는 대문자로, 나머지는 소문자를 사용하세요.

```java
Examples:
    XmlHttpRequest
    SalesOrder
    Html
```

<h3 id="네이밍-식별자">2-3. 그 외의 모든 식별자</h3>

`카멜 표기법`을 사용해주세요. 첫 단어를 제외한 첫 글자는 대문자로 나머지는 소문자를 사용하세요.

```java
Examples:
    customer
    salesOrder
    addToTotal
```

</br><h2 id="주석">3. 주석</h2>

<h3 id="주석-블록">3-1. 블록 주석</h3>

메서드, 자료구조, 알고리즘에 대한 설명을 제공할 때 사용된다.
- 각각의 파일이 시작될 때와 메서드 전에 사용된다.
- 블록 주석은 다른 코드들과 구분하기 위해서 처음 한 줄은 비우고 사용한다.

```java
/*
 * 여기에 블록 주석을 작성한다.   
 */
```

<h3 id="주석-꼬리">3-2. 꼬리 주석</h3>

그 외 짧은 주석이 필요한 경우 주석이 설명하는 코드와 같은 줄에 작성한다.
- 실제 코드와는 구분될 수 있도록 충분히 멀리 떨어뜨려야 한다.

```java
if (a == 2) {
    return TRUE;       /* a 가 2인 경우 */
}
```

<!-- /br> [↑ 목차](#목차) -->

</br>

## Contributors
*Fullmoon Liali Sally Sony*

</br>

> ###### 참고자료
> - <a target="_blank" href="http://developer.gaeasoft.co.kr/development-guide/java-guide/java-coding-style-guide/#32/">Java 코딩 스타일 가이드 - 지어소프트</a>
> - <a target="_blank" href="https://velog.io/@kwj1270/JAVA-%EC%BD%94%EB%93%9C-%EC%BB%A8%EB%B2%A4%EC%85%98#%EC%A3%BC%EC%84%9D">JAVA 코드 컨벤션 "주석" - Sprout Develog</a>
> - <a target="_blank" href="https://github.com/choegyumin/markup-coding-conventions">Markup Coding Conventions - README 양식</a>