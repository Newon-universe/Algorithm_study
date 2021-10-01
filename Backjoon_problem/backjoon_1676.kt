fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    var count = 0
    /*
    var result : Double = 1.0
    var count = 0

    for (i in N downTo 1){
        result *= i
    }

    println(result)
    val s_result = result.toInt().toString()
    val size = s_result.length

    for (i in size-1 downTo 0) {
        if (s_result[i].digitToInt() == 0) {
            count++
        }
        else {
            break
        }
    }

    print(count)
    */

    for (i in 1..N) {
        var j = i
        while ( j > 0 && j%5 == 0) {
            count++
            j/=5
        }
    }

    println(count)
}
