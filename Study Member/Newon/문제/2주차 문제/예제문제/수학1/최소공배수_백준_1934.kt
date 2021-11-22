import java.io.*

fun Gcd(a:Int, b:Int): Int{
    var gcd = a%b
    if(gcd == 0)
       return b
    else
       return Gcd(b, gcd)
}

fun main(){
    val br = System.`in`.bufferedReader()
    var testCase = br.readLine().toInt()
    
    while(testCase > 0){
        var (a,b) = br.readLine().split(' ').map {it.toInt()}
        var gcd = Gcd(a,b)
        println(a*b/gcd)
        testCase--
    }
}
