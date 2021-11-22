import java.io.*

fun Factorial(n: Int, res: Int):Int {
    if (n <= 0) {
        return res
    }  else {
        return Factorial(n-1, n*res)
    }
}

fun main(){
    val br = System.`in`.bufferedReader()
    
    val N = br.readLine().toInt()
    val factorial = Factorial(N, 1)
    println(factorial)
}
