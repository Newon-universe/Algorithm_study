import java.io.*

fun solve(sum: Int, n: Int):Int {
    var result = 0
    
    if (sum > n) {
        return 0
    }
    if (sum == n) {
        return 1
    }
    
    for (i in 1..3) {
        result += solve(sum + i, n)
    }

    return result
}

fun main() {
    val br = System.`in`.bufferedReader()
    
    var T = br.readLine().toInt()
    
    while(T > 0) {
        var n = br.readLine().toInt()    
        var result = solve(0, n)
        println(result)
        T--
    }
}
