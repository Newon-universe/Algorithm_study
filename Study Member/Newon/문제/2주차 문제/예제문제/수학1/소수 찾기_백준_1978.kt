import java.io.*
import java.util.*

fun Sqrt(N: Int):Int {
    var sqrt = 0
    for (i in 1..N) {
        if (i * i >= N) {
            sqrt = i
            break
        }
    }
    
    if (sqrt * sqrt > N) {
        sqrt -= 1
    }
    return sqrt
}

fun main(){
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val arr = IntArray(N)
    
    val stringToken = StringTokenizer(br.readLine())
    var count = 0
    
    for (i in 0..N-1) {
        arr[i] = stringToken.nextToken().toInt()

        if (arr[i] == 1) {
            continue
        } else if (arr[i] == 2 || arr[i] == 3) {
            count += 1
            continue
        }

        var sqrt = Sqrt(arr[i])

        for (j in 2..sqrt) {
            if (arr[i] % j == 0) {
                break
            }
            else if (j == sqrt) {
                count += 1
            }
        }
    }
    println(count)
}
