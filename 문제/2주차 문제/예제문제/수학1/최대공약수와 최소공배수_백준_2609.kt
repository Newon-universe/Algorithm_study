import java.io.*

fun Gcd(a:Int, b:Int):Int {
    var r = a % b
    if (r == 0)
       return b
    else
       return Gcd(b, r)
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (a,b) = br.readLine().split(' ').map {it.toInt()}
    
    var gcd = Gcd(a,b)
    println(gcd)
    println(a*b/gcd)
}
