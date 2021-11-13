## 이분 탐색 / 이진 탐색 (Binary Search)

### ① 개념

탐색 기법중에 하나로 원하는 탐색범위를 두 부분으로 분할해서 찾는 방식이다. 
이름이 가나다순으로 정렬된 전화번호부에서 사람 이름을 찾는 것으로 예를 들면, 전화번호부의 정중앙을 펴서 양쪽면을 살펴서 왼쪽에 있을지, 오른쪽에 있을지 판단한 후,
왼쪽에 있다면 다시 왼쪽부분을 정중앙을 펴서 양쪽면을 살피고, 왼쪽과 오른쪽을 판단 후 다시 그 부분의 정중앙을 펴는 행위를 반복하는 탐색기법이다.

### ② 구현과정 및 구현조건

[!img](https://t1.daumcdn.net/cfile/tistory/221D4A3F5705041A1F)

### ③ 코드(반복문)
> Java
```java
int BSearch(int arr[], int target) {
    int start = 0;
    int end = arr.length - 1;
    int mid;

    while(start <= end) {
        mid = (start + end) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            end = mid - 1;
        else
            start = mid + 1;
    }
    return -1;
}
```
> Kotlin
```Kotlin
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

### ④ 코드(재귀)
> Java
```java
int BSearchRecursive(int arr[], int target, int start, int end) {
    if (start > high)
        return -1;

    int mid = (start + end) / 2;
    if (arr[mid] == target)
        return mid;
    else if (arr[mid] > target)
        return BSearchRecursive(arr, target, start, mid-1);
    else
        return BSearchRecursive(arr, target, mid+1, end);
}
```
> Kotlin
```Kotlin
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

### ⑤ 시간복잡도  
▷ 데이터의 크기가 N일 때 O(logN)
<br/>

### ⑥ 장단점  
▷ 검색이 반복될 때마다 검색 범위가 절반으로 줄기 때문에 속도가 빠르다는 장점

▷ 정렬된 리스트에만 사용할 수 있다는 단점
<br/>

## 정렬

### ① 정렬의 종류와 개념
▷ 선택정렬
1. 주어진 리스트 중에 최소값을 찾는다.
2. 그 값을 맨 앞에 위치한 값과 교체한다.
3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
4. 정렬될 때까지 반복.

▷ 삽입정렬
1. 배열에서 2번째 위치한 값부터 시작한다.
2. 2번째 값과 1번째 값을 비교한다. 2번째 값이 더 크다면 놔두고 작다면 바꾼다.
3. 3번째값과 1번째,2번째 값을 비교한다. 대소를 비교해서 3번째 값을 적절한 인덱스에 넣는다.
4. 4번째 값과 1번째,2번째,3번째 값을 비교한다. 대소를 비교해서 4번째 값을 적절한 인덱스에 넣는다.
5. 정렬될 때까지 반복.

▷ 버블정렬
1. 버블 정렬은 첫 번째 자료와 두 번째 자료만 비교해서 정렬한다.
2. 두 번째 자료와 세 번째 자료만을 비교해서 정렬한다.
3. 세 번째와 네 번째를 비교해서 정렬한다.
4. 정렬될 때까지 반복.



### ② 구현과정 및 구현조건

▷ 선택정렬 </br>
![선택정렬](https://gmlwjd9405.github.io/images/algorithm-selection-sort/selection-sort.png)

▷ 삽입정렬 </br>
![삽입정렬](https://gmlwjd9405.github.io/images/algorithm-insertion-sort/insertion-sort.png)

▷ 버블정렬 </br>
![버블정렬](https://gmlwjd9405.github.io/images/algorithm-bubble-sort/bubble-sort.png)


### ③ 코드(반복문)
> Java
```java
// 선택정렬
void SelectionSort(int arr[], int n) {
	int i, j, min;
 
	for (i = 0; i < n; i++){
				min = i;
		    for(int j = i + 1; j < n; j++){
		        if(arr[j] > arr[min])
		           min = j;               
		    } 
        	swap(&arr[min],&arr[i]);
	}
}

// 삽입정렬

void InsertionSort(int arr[], int length) {
	int i = 0;
	int j = 0;
	int key = 0;
 
	for (i = 1; i < length; i++){
		key = arr[i]
              for(int j = i-1;j>=0;j--){
                  if(arr[j]>key)
                     arr[j+1] = arr[j];
                  else break;                
              } 
        	arr[j+1]=key;
	}
}

// 버블정렬
void BubbleSort(int* _arr, int _length) {
	int i = 0;
	int j = 0;
	int temp = 0;
 
	for (i = 0; i < _length - 1; i++){
		for (j = 0; j < _length - 1 - i; j++) {
			if (_arr[j] > _arr[j + 1]) {
				temp = _arr[j];
				_arr[j] = _arr[j + 1];
				_arr[j + 1] = temp;
			}
	  }
}

```
> Kotlin
```kotlin
// 선택정렬

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

// 삽입정렬

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

// 버블정렬

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

### ⑤ 각 정렬방법의 시간복잡도  
※ 53412 를 오름차순으로 정렬하는 경우
▷ 선택정렬 O(n^2)

▷ 삽입정렬 O(n^2) (이미 정렬되어 있다면 O(n))

▷ 버블정렬 O(n^2)
<br/>

