package backjoon_11723

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    var sb = StringBuilder()
    var s : Int = 0

    for(i in 0 until N){
        val tmp = br.readLine().split(" ")

        when (tmp[0]) {
            "add" -> {
                s = s or (1 shl tmp[1].toInt()-1)
            }
            "remove" -> {
                s = s and (1 shl tmp[1].toInt()-1).inv()
            }
            "check" -> {
                if ((s and (1 shl tmp[1].toInt()-1)) == 0) {
                    sb.append("0\n")
                } else {
                    sb.append("1\n")
                }
            }
            "toggle" -> {
                s = s xor (1 shl tmp[1].toInt()-1)
            }
            "all" -> {
                s = (1 shl 21) -1
            }
            "empty" -> {
                s = 0
            }
        }
    }
    println(sb.toString())
}
