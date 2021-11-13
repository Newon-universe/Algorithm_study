package backjoon_2343

lateinit var myArr: List<Int>

var low = 0
var high = 0

fun main() {
    val br = System.`in`.bufferedReader()
    var (A,B) = br.readLine().split(" ").map{ it.toInt()}
    myArr = br.readLine().split(" ").map{ it.toInt() }
    var sum = 0

    for (i in 0 until myArr.size){
        sum += myArr[i]
        low = Math.max(low, myArr[i])
    }

    high = sum

    binarySearch(A,B)

    print(low)
}

fun binarySearch(A : Int, B: Int) {

    while (low <= high) {
        var mid = (low + high) / 2
        var sum = 0
        var count = 0

        for (i in 0 until A) {
            if (sum + myArr[i] > mid) {
               sum = 0
               count++
            }

            sum += myArr[i]
        }

        if (sum > 0) count++

        if (count <= B) {
            high = mid -1
        } else {
            low = mid + 1
        }
    }
}
