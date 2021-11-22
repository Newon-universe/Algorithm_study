import java.io.*

fun solve(N: Double) {
    if (N == 1.toDouble()) {
        print(1)
        return
    }
    
    solve(Math.ceil(N / -2.toDouble()))
    print(Math.abs(N % -2).toInt())
}


fun main() {
    val br = System.`in`.bufferedReader()
    
    var N = br.readLine().toDouble()
    if (N == 0.toDouble()) {
        print(0)
    } else {
        solve(N)
    }
}
