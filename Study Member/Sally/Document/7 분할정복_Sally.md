# 분할정복(Divide and Conquer)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F1jaZt%2Fbtrd1xZC9sT%2FBZy2RklFUqqUhS1AuCJxW1%2Fimg.png" width="650" />

### 1. 개념
문제를 두 단계, **①분할** 과 **②정복** 으로 나눠 해결하는 것  
즉, 한 문제를 둘 이상의 **부분 문제(sub-problem)** 로 나누어 해결하고 이를 합쳐 원래 문제를 해결하는 기법이다.  

분할하는 단계에서 주어진 문제를 여러 개의 부분 문제들로 나누는데,  
문제가 작아지면 작아질수록 풀기 쉬워지는 성질을 이용한 것이다.  

Quick Sort 나 Merge Sort 로 대표되는 정렬 알고리즘 문제가 대표적이다.  
해당 알고리즘은 보통 **재귀 함수(recursive funtion)** 를 통해 자연스럽게 구현된다.  

<br/>

### 2. 특징
* 분할된 문제들은 크기만 작아질 뿐, 원래 문제와 성격이 동일하다.
* 대개 재귀적인 방식으로 구현하나,  빠른 실행이나 부문제 해결 순서 선택을 위해  
 스택 , 큐 등의 자료구조를 이용해 구현하기도 한다.

<br/>

### 3. 장단점
분할정복은 *Top-down* 방식으로 재귀 호출과 장단점이 같다.

#### 장점
* 작은 문제로 분할함으로써 같은 작업을 더 빠르게 수행할 수 있게 해준다.
* 어려운 문제를 간단한 작은 문제로 나누어 풀 수 있다.

#### 단점
* 재귀 함수를 호출함으로써 함수 호출로 인한 오버헤드가 발생한다.
* 스택에 다양한 데이터를 보관하고 있어야 하므로 스택 오버플로우가 발생한다.
* 메모리를 과도하게 사용하게 된다.

<br/>

### 4. 분할정복 알고리즘의 처리과정 (문제해결과정-기본로직)
1. **분할(Divide)** : 원래 문제를 분할해 더 작은 하위 문제로 나눈다.
2. **정복(Conquer)** : 하위 문제 각각을 재귀적으로 해결  
(더이상 분할하지 않고 곧장 풀 수 있는 매우 작은 문제를 **기저 사례(base case)** 라 부름)
3. **병합(Merge/Combine)** : 하위 문제들의 답을 합쳐서 원래 문제를 해결

<br/>

### 5. 시간복잡도
|정렬 알고리즘|최대 실행 시간|최소 실행 시간|평균 실행 시간|
|:--:|:--:|:--:|:--:|
|**병합 정렬**|O(nlgn)|O(nlgn)|O(nlgn)|
|**퀵 정렬**|O(n²)|O(nlgn)|O(nlgn)|

<br/>

### 6. 분할정복 알고리즘이 적용된 정렬에서의 분할 과정
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FpfWKt%2FbtrhZNbm0OZ%2F6EkiqFde7OpgQjlp5e0kKk%2Fimg.png" width="400" />

#### 💫 병합 정렬(Merge sort)
하나의 리스트를 **두 개의 균등한 크기**로 분할하고 분할된 부분 리스트를 정렬한 다음,  
두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는 방식이다.

1. **Divide** : 입력 배열을 같은 크기의 2개의 부분 배열로 분할
2. **Conquer** : 부분 배열로 정렬한다.  
　　　　 부분 배열의 크기가 충분히 작지 않으면 순환 호출을 이용해 다시 분할정복 방법을 적용한다.
3. **Combine** : 정렬된 부분 배열들을 하나의 배열에 결합한다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbpzifb%2FbtrhZnjD2mD%2Fz4sh5giBUZ9Cjhe2WW5xUK%2Fimg.png" width="400" />

#### 💫 퀵 정렬(Quick sort)
**특정 원소 피봇(pivot)을 기준**으로 주어진 배열을 두 부분 배열로 분할하고  
각 부분 배열에 대해 정렬을 순환적으로 적용하는 방식이다.

1. **Divide** : 피봇 하나를 선택하여 피봇을 기준으로 2개의 부분 배열로 분할
2. **Conquer** : 피봇을 기준으로 피봇보다 큰 값, 혹은 작은 값을 찾는다.  
 　　　　  왼쪽부터 피봇보다 큰 값을 찾고 오른쪽부터는 피봇보다 작은 값을 찾아서 두 원소를 교환한다.  
 　　　　  분할된 부분 배열의 크기가 0이나 1일 될 때까지 반복한다.
3. **Combine** : Conquer 과정에서 값의 위치가 바뀌므로 따로 결합은 하지 않는다.

<br/>
  
### 7. 동적 계획법(Dynamic Programming)과의 비교
#### 공통점
* 문제를 잘게 쪼개서, 가장 작은 단위로 분할

#### 차이점
* **동적 계획법 (Dynamic Programming)**
  * 부분 문제는 중복되어, 상위 문제 해결 시 재활용된다.
  * Memoization 기법을 사용한다.  
  (부분 문제의 답을 저장해 재활용하는 최적화 기법으로 사용)
* **분할정복법 (Divide and Conquer)**
  * 부분 문제는 서로 중복되지 않는다.
  * Memoization 기법을 사용하지 않는다.

<br/>

### 참고
[Java / Divide and Conquer (분할정복)](https://velog.io/@sanizzang00/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-Divide-and-Conquer%EB%B6%84%ED%95%A0-%EC%A0%95%EB%B3%B5)  
[합병 정렬, 퀵 정렬, 이진 탐색 정리](https://loosie.tistory.com/237)  
[동적 계획법 vs 분할정복 알고리즘](https://syujisu.tistory.com/147)  
