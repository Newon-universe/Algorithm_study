import java.io.*

fun EratosSieve(eratos:IntArray, N:Int) {
    var i = 2
    var j = i
    
    eratos[1] = 0
    
    for (i in i .. N) {
        if (eratos[i] == 0) {
            continue
        }
    
        j = i + i
        for (j in j .. N step i) {
            if (eratos[j] != 0) {
                eratos[j] = 0
            }
        }
    }
}

fun main(){
    val br = System.`in`.bufferedReader()
    
    val (M, N) = br.readLine().split(' ').map { it.toInt() }
    var eratos = IntArray(N+1){ i -> i}
    EratosSieve(eratos, N)
    
    for (i in M .. N) {
        if (eratos[i] != 0) {
            println(eratos[i])
        }
    }
}


