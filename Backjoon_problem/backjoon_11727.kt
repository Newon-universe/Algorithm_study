package backjoon_15988

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    var arr = LongArray(1000001, {0})
    arr[1] = 1
    arr[2] = 2
    arr[3] = 4

    for (i in 4..1000000) {
        arr[i] = (arr[i-1] + arr[i-2] + arr[i-3]) % 1000000009
    }
    for (i in 0 until N) {
        val n = br.readLine().toInt()
        println(arr[n])
    }
}
