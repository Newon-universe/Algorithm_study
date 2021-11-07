package backjoon_10815

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var myArr: List<Int>   //상근이가 가진 카드
lateinit var cmpArr: List<Int>  //비교용 카드

fun binary(arr: List<Int>, search: Int): Int {
    var low = 0 //가장 작은 값 초기 0
    var high = arr.size - 1 //가장 큰값 초기 사이즈-1
    var mid: Int; //중간값

    //로우가 하이보다 작거나 같을때 반복
    while (low <= high) {
        mid = (low + high) / 2

        //찾을 값이 중간의 값과 같으면 리턴
        if (search == arr[mid]) {
            return 1
        }
        //찾을 값이 중간 값보다 작으면
        else if (search < arr[mid]) {
            high = mid - 1 //가장 큰값을 중간값 바로 앞에 값으로 설정
        }
        //찾을 값이 중간 값보다 크면
        else low = mid + 1 //가장 작은값을 중간값 바로 뒤에 값으로 설정
    }
    return 0
}

fun main() {
    val br = System.`in`.bufferedReader()
    var N = br.readLine().toInt()
    myArr = br.readLine().split(" ").map { it.toInt() }.sorted()  //정렬을 해야만 이진탐색이 가능하기에 정렬
    var M = br.readLine().toInt()
    cmpArr = br.readLine().split(" ").map { it.toInt() }

    for (i in cmpArr) {
        print("${binary(myArr, i)} ")
    }
}
