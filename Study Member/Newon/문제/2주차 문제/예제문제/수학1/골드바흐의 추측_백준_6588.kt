import java.io.*

fun Eratos(eratos:IntArray):IntArray {
    for (i in 2..1000000) {
        if (eratos[i] == 0) {
            continue
        }
        
        for (j in i+i..1000000 step i) {
            eratos[j] = 0
        }
    }
    eratos[1] = 0
    return eratos
}

fun main() {
    val br = System.`in`.bufferedReader()
    var eratos = IntArray(1000001) { i -> i }
    eratos = Eratos(eratos)
    
    var n = br.readLine().toInt()
    while (n != 0) {
        for (j in 1..n) {
            if(eratos[j] != 0) {
                if(eratos[n-j] != 0) {
                    println("$n = ${eratos[j]} + ${eratos[n-j]}")
                    break
                }        
            }
        }
        n = br.readLine().toInt()
    }
}
