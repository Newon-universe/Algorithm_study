import java.io.BufferedReader

fun main(){
    val br = System.`in`.bufferedReader()
    
    val (a,b) = br.readLine().split(' ').map { it.toDouble()}
    println(a/b)
}
