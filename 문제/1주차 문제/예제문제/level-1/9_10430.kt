import java.io.BufferedReader

fun main(){
    val br = System.`in`.bufferedReader()
    
    val (A, B, C) = br.readLine().split(' ').map {it.toInt()}
    
    println((A+B)%C);
    println(((A%C) + (B%C))%C);
    println((A*B)%C);
    println(((A%C) * (B%C))%C);
}
