import java.io.*
import java.util.*

fun Add(arr:IntArray, N:Int){
    if(arr[N-1] != N)
        arr[N-1] = N;
    return
}

fun Remove(arr:IntArray, N:Int){
    if(arr[N-1] != 0)
        arr[N-1] = 0;
    return
}

fun Check(arr:IntArray, N:Int):Int{
    if(arr[N-1] != 0)
        return 1
    return 0
}

fun Toggle(arr:IntArray, N:Int){
    if(arr[N-1] != 0){
        arr[N-1] = 0;
    } else if(arr[N-1] == 0){
        arr[N-1] = N;
    }
    return
}

fun All(arr:IntArray){
    for (i in 0..19){
        arr[i] = i + 1;
    }
    return
}

fun Empty(arr:IntArray){
    for (i in 0..19){
        arr[i] = 0;
    }
    return
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var arr = IntArray(20)
    var command:String
    var number:Int
    var check:Int
    
    var M = br.readLine().toInt()
    while(M > 0){
        var stringToken = StringTokenizer(br.readLine())
        command = stringToken.nextToken().toString()

        when(command){
            "add" -> {number = stringToken.nextToken().toInt()
                     Add(arr, number)}
            "remove" -> {number = stringToken.nextToken().toInt()
                        Remove(arr, number)}
            "check" -> {number = stringToken.nextToken().toInt()
                       check = Check(arr, number)
                       bw.write("${check}\n")}
            "toggle" -> {number = stringToken.nextToken().toInt()
                         Toggle(arr, number)}
            "all" -> All(arr);
            "empty" -> Empty(arr);
        }
	M--;
    }
    bw.flush()
}
