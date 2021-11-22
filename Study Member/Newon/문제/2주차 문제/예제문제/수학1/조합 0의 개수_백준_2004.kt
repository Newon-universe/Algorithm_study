import java.io.*
import kotlin.math.*

fun FivePowChecker(n: Long): Long{
    var N = n
    var count:Long = 0
    
    while (N >= 5) {
        count += (N / 5)
        N /= 5
    }
    return count
}

fun TwoPowChecker(n: Long): Long{
    var N = n
    var count:Long = 0
    
    while (N >= 2) {
        count += (N / 2)
        N /= 2
    }
    return count
}

fun main(){
    val br = System.`in`.bufferedReader()
    
    val (n, m) = br.readLine().split(' ').map{ it.toLong() }

    var FivePowCount = FivePowChecker(n) - FivePowChecker(m) - FivePowChecker(n - m)
    var TwoPowCount = TwoPowChecker(n) - TwoPowChecker(m) - TwoPowChecker(n - m)
    
    println(min(FivePowCount, TwoPowCount))
}
