import java.io.*

fun checker(N: Int): Int{
    var count = 0
    
    for (i in N downTo 5) {
        var temp = i

        if (temp % 5 == 0) {
            while (temp % 5 == 0) {
                temp /= 5
                count++
            }
        }
    }
    
    return count
}

fun main(){
    val br = System.`in`.bufferedReader()
    
    val N = br.readLine().toInt()
    
    val result = checker(N)
    println(result)
    
}
