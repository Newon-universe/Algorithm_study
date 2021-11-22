import kotlin.math.pow

fun Solve(n: Int, r: Int, c: Int): Int{
    if(n == 0) return 0

    var half = 2.toDouble().pow(n - 1).toInt()

    return when{
        r < half && c < half -> Solve(n - 1, r, c)
        r < half && c >= half -> half * half + Solve(n - 1, r, c - half)
        r >= half && c < half -> half * half * 2 + Solve(n - 1, r - half, c)
        else -> half * half * 3 + Solve(n - 1, r - half, c - half)
    }
}

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (N, r, c) = br.readLine().split(" ").map{ it.toInt() }
    bw.append("${Solve(N,r,c)}")
    bw.flush()
    bw.close()
}
