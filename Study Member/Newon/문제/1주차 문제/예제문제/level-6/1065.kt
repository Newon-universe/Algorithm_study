import java.io.*

fun main(){
    val br = System.`in`.bufferedReader()
    
    val n = br.readLine().toInt()
    var i = 100
    var han = 99
    var arr = Array(3,{0})
    
    if (n < 100){
        println(n)
    } else if (n < 1000){
        while (i <= n) {
            arr[0] = i / 100;
	        arr[1] = (i / 10) % 10;
	        arr[2] = i % 10;
	        if (arr[0] - arr[1] == arr[1] - arr[2]){
		    han++;
            }
	    i++;
        }
    println(han)
    } else if (n == 1000) {
        println("144")
    }
}
