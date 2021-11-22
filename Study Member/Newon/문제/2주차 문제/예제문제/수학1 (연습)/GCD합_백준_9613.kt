import java.io.*
import java.util.*

fun GCD_Calculator(a: Long, b: Long):Long {
    var r:Long = a % b
    if (r == 0.toLong()) {
        return b
    } else {
        return GCD_Calculator(b, r)
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    var t = br.readLine().toLong()
    
    while (t > 0) {
        val stringToken = StringTokenizer(br.readLine())
        var n = stringToken.nextToken().toInt()
        var arr = arrayOfNulls<Long>(n)
        var i = 0
        var result:Long = 0
        while (stringToken.hasMoreTokens()) {
            arr[i] = stringToken.nextToken().toLong()
            i++
        }
        
        for (i in 0 .. n-2) {
            for (j in i+1 .. n-1) {
                result += GCD_Calculator(arr[i]!!, arr[j]!!)
            }
        }
        
        println(result)
        t--
    }
}
