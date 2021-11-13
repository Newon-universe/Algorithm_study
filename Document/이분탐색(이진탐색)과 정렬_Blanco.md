## 이분 탐색 / 이진 탐색 (Binary Search)

### ① 개념
 탐색 기법중에 하나로 원하는 탐색범위를 두 부분으로 분할해서 찾는 방식.

### ② 구현과정 및 구현조건

![221D4A3F5705041A1F](https://user-images.githubusercontent.com/42407740/141604941-7f568872-487d-414e-b444-9502dce11e61.gif)

구현과정

1. 배열을 정렬한다.

2. 정렬된 배열에서 왼쪽 끝 인덱스 left와 오른쪽 끝 인덱스 right을 이용해 중간 인덱스 mid 값을 찾는다.

3. mid 인덱스와 배열에서 찾고자 하는 값 target을 비교한다.

4. target이 나올 때까지 탐색 과정을 반복한다.

5. mid 값보다 target이 크다면 left를 mid+1로 이동시켜, 오른쪽 구간에서 탐색한다.

6. mid 값보다 target이 작다면 right을 mid-1로 이동시켜, 왼쪽 구간에서 탐색한다.

7. target이 없다면, None을 반환한다.

구현조건

1. 원소가 정렬이 되어 있을 것(오름차순이든 내림차순이든)

2. 원소의 Random Access가 가능해야 한다.

3. 자료의 집합은 인덱스를 바꿀 때 상수 시간으로 처리되어야 합니다. Big O: (1)

```
function 이진탐색(데이터, 찾는 값)

데이터가 혹시 비어 있는가?
(네) return 찾는 값 없음.

데이터의 가운데 지점을 찾는다.
찾은 지점의 값을 뽑는다.
뽑은 값이 찾는 값인가?

(네) return 뽑은 값.
(아니요)
  뽑은 값과 찾는 값을 비교한다.
  (뽑은 값이 찾는 값보다 큰 값인가?)
    return 이진탐색(데이터 앞쪽 절반, 찾는 값)
  (작은 값인가?)
    return 이진탐색(데이터 뒤쪽 절반, 찾는 값)
```

### ③ 코드(반복문)
> Java
```java

```
> Kotlin
```kotlin
fun binarySearch(arr: IntArray, target: Int): Int {
    var low = 0
    var high = arr.lastIndex
    var mid = 0;

    while (low <= high) {
        mid = (low + high) / 2

        when {
            arr[mid] == target -> return mid
            arr[mid] > target -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return -1
}
```
> Python
```python
```

### ④ 코드(재귀)
> Java
```java

```
> Kotlin
```kotlin
fun binarySearch(arr: IntArray, target: Int, low: Int, high: Int): Int {
    if(low > high) {
      return -1
    }
    
    var mid = (low + high) / 2
  
    if (target == arr[mid]) {
        return mid
    }
    else if (arr[mid] > value) {
        return binarySearch(arr, low, mid - 1, target)
    }
    else 
        return binarySearch(arr, mid+1, high, target)
}
```
> Python
```python
```
### ⑤ 시간복잡도  
▷ 이분 탐색을 반복할 수록, 탐색할 자료의 개수가 절반으로 줄어든다. 따라서 N개의 자료가 있을 때, 총 K번 자료를 검색한다면, 남은 자료의 개수는 N⋅12K이다. 

최악의 경우, 탐색 종료 시점에 남는 자료의 개수가 1이 되어야 하므로, K=logN2이 된다. 따라서, 시간복잡도는 O(logN)이다.

<br/>

### ⑥ 장단점  
▷ 
장점 : 선형 탐색과 비교하여 탐색 시간이 빠르다. (선형 탐색의 경우 시간 복잡도는 T(n) = θ(n)이다. )
단점 : 정렬된 리스트에서만 사용될 수 있다.
<br/>

## 정렬

소트(Sort)란
2개 이상의 자료를 특정 기준에 의해 작은 값부터 큰 값 혹은 그 반대 순서로 재배열하는 것. (오름차순 정렬 / 내림차순 정렬)

### ① 정렬의 종류와 개념
▷ 선택정렬 : 주어진 자료들 중에 현재 위치에 맞는 자료를 찾아 선택하여 위치를 교환하는 정렬 알고리즘이다.

▷ 삽입정렬 : 주어진 자료의 모든 요소를 앞에서부터 차례대로 정렬된 자료 부분과 비교하여 자신의 위치를 찾아 삽입하는 정렬이다.

▷ 버블정렬 : 인접한 두 개의 원소를 비교해서 자리를 교환하는 방식.

### ② 구현과정 및 구현조건

**그림 첨부해서 설명해주실 분들은 여기에 넣어주세요**

선택정렬

![선택정렬](https://user-images.githubusercontent.com/42407740/141605818-6a14a340-3c01-4ff7-b927-166817519c75.gif)

1. 0번 인덱스 ~ n번 인덱스 중 가장 작은 값을 찾아 0번째 인덱스와 swap한다

2. 1번 인덱스 ~ n번 인덱스 중 가장 작은 값을 찾아 1번째 인덱스와 swap한다

…

3. n-1번 인덱스 ~ n번 인덱스 중 가장 작은 값을 찾아 n번째 인덱스와 swap한다

삽입정렬

![삽입정렬](https://user-images.githubusercontent.com/42407740/141605819-0f33ae55-f1ac-4d7a-b035-6ef88998f812.gif)

1. 0번 인덱스는 건너뛴다.

2. 0~1번 인덱스 중 1번 인덱스 값이 들어가야할 위치를 찾아서 넣는다

3. 0~2번 인덱스 중 2번 인덱스 값이 들어가야할 위치를 찾아서 넣는다

…

4. 0~n번 인덱스 중 n번 인덱스 값이 들어가야할 위치를 찾아서 넣는다

버블정렬

![버블정렬](https://user-images.githubusercontent.com/42407740/141605820-20827fa3-91d5-4117-b16d-f039cf76291c.gif)

1. 0번째 원소와 1번째 원소를 비교 후 정렬

2. 1번째 원소와 2번째 원소를 비교 후 정렬

…

3. n-1번째 원소와 n번째 원소를 비교 후 정렬

### ③ 코드(반복문)
> Java
```java
// 선택정렬

// 삽입정렬

// 버블정렬
```
> Kotlin
```kotlin

/* 선택정렬 */
fun selectionSort() {
        /**
         * val arr = arrayOf(10, 1, 4, 2, 5, 7, 3, 8, 9, 6)
         *
         * 제일 작은 숫자를 찾아서 앞으로 보낸다.
         * [1, 10, 4, 2, 5, 7, 3, 8, 9, 6]
         * [1, 2, 4, 10, 5, 7, 3, 8, 9, 6]
         * [1, 2, 3, 10, 5, 7, 4, 8, 9, 6]
         * [1, 2, 3, 4, 5, 7, 10, 8, 9, 6]
         * [1, 2, 3, 4, 5, 7, 10, 8, 9, 6]
         * [1, 2, 3, 4, 5, 6, 10, 8, 9, 7]
         * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         */

        val arr = arrayOf(10, 1, 4, 2, 5, 7, 3, 8, 9, 6)
//        Arrays.sort(arr)
//        println(arr.toList())

        for(i in 0 until arr.size) {
            var min = i

            for(j in i + 1 until arr.size) {
                if(arr[min] > arr[j]) {
                    min = j
                }
            }

            swap(arr, i, min)
            println(arr.toList())
        }

        println(arr.toList())
}

fun swap(arr:Array<Int>, ordinary: Int, change: Int) {
    var temp = arr[ordinary]
    arr[ordinary] = arr[change]
    arr[change] = temp
}
 

/* 삽입정렬 */
fun insertionSort() {
    val lst = mutableListOf(1, 34, 5, 6, 78, 23, 56, 31, 64)
    for (i in 1 until lst.count()) {
        val temp = lst[i]
        for (j in i - 1 downTo 0) {
            if (lst[j] < lst[i]) {
                lst[j + 1] = temp
                break
            } else {
                lst[j + 1] = lst[j]
            }
        }
    }
    println(lst)
}

/* 버블정렬 */
fun bubbleSort(arr:IntArray):IntArray{
    var swap = true
    while(swap){
        swap = false
        for(i in 0 until arr.size-1){
            if(arr[i] > arr[i+1]){
                val temp = arr[i]
                arr[i] = arr[i+1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }
    return arr
}
```
> Python
```python
// 선택정렬

// 삽입정렬

// 버블정렬
```

### ⑤ 각 정렬방법의 시간복잡도  
※ 53412 를 오름차순으로 정렬하는 경우

▷ 선택정렬 : 버블정렬과 비교했을 때, 똑같이 O(N^2)이라는 시간복잡도를 갖지만, 실제로 시간을 측정해보면 버블정렬에 비해서는 조금 더 빠른 정렬 방식이다.

▷ 삽입정렬 : 최선의 경우 O(N)이라는 엄청나게 빠른 효율성, 최악의 경우 O(N^2)이라는 시간복잡도를 갖게된다. 즉, 데이터의 상태 및 데이터의 크기에 따라서 성능의 편차가 굉장히 심한 정렬법이다.

▷ 버블정렬 : 최악이든 최선이든 O(N^2)이라는 시간복잡도를 갖기 때문에 사실 알고리즘에서 효율적인 정렬방법으로 사용되지는 않는다.

<br/>

### ⑦ 참고
[이진탐색](https://namu.wiki/w/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89)

[이진-탐색-이분-탐색binary-search-구현시-고려할-것들](https://eine.tistory.com/entry/%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89-%EC%9D%B4%EB%B6%84-%ED%83%90%EC%83%89binary-search-%EA%B5%AC%ED%98%84%EC%8B%9C-%EA%B3%A0%EB%A0%A4%ED%95%A0-%EA%B2%83%EB%93%A4)

[정렬 알고리즘 정리](https://evan-moon.github.io/2018/10/13/sort-algorithm/)

[정렬별 장단점 및 ](https://yabmoons.tistory.com/250)
