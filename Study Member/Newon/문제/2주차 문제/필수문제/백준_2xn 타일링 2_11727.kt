import java.io.*

fun main(){
    val br = System.`in`.bufferedReader()
    
    val N = br.readLine().toInt()
    var dp = IntArray(N+1)
    
    if (N == 1) {
        dp[1] = 1
    } else {
        dp[1] = 1
        dp[2] = 3
        var i = 3
        for (i in i..N) {
            dp[i] = ((dp[i - 1] + 2 * dp[i - 2]) % 10007)
        }
    }

    println(dp[N])
}
