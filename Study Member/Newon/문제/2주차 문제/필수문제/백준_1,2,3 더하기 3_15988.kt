import java.io.*

fun main() {
    val br = System.`in`.bufferedReader()
    var T = br.readLine().toInt()
    var arr = LongArray(1000001)
    arr[0] = 0
    arr[1] = 1
    arr[2] = 2
    arr[3] = 4

    for (j in 4..1000000) {
        arr[j] = (arr[j-1] + arr[j-2] + arr[j-3])  % 1000000009
    }
    
    for (i in T downTo 1) {
        var n = br.readLine().toInt()
        println(arr[n])
    }
}
