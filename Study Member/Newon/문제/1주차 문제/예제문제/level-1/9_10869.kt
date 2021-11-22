import java.io.BufferedReader

fun main(){
    val br = System.`in`.bufferedReader()
    
    val (A, B) = br.readLine().split(' ').map { it.toInt() }
    println(A+B)
    println(A-B)
    println(A*B)
    println(A/B)
    println(A%B)
}
