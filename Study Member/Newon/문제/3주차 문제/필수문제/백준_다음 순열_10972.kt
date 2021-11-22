import java.io.*
import java.util.*

fun Print(arr:IntArray) {
	for(i in 0..arr.size-1){
		print("${arr[i]} ")
	}
}

fun Combination(arr:IntArray) {
    var i = arr.size - 1;
    var j = arr.size - 1;
    var k = arr.size - 1;
    var temp = 0;
    
    while (i > 0 && arr[i - 1] >= arr[i]) {
        i -= 1;
    }
    
    if (i == 0) {
        print("-1");
        return
    }
    
    while (j > 0 && arr[i - 1] >= arr[j]) {
        j -= 1;
    }
    
    temp = arr[i - 1];
    arr[i - 1] = arr[j];
    arr[j] = temp;
    
    while (i < k) {
        temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
        i += 1;
        k -= 1;
    }

    Print(arr);
}

fun main(){
    val br = System.`in`.bufferedReader()
    var N = br.readLine().toInt()
    val stringToken = StringTokenizer(br.readLine())
    
    var arr = IntArray(N)
    for (i in 0..N-1) {
	    arr[i] = stringToken.nextToken().toInt()
    }
    Combination(arr);
    
}
