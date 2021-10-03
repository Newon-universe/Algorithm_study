package backjoon_2089

fun main() {
    val br = System.`in`.bufferedReader()
    var N = br.readLine().toInt()
    var list = mutableListOf<Int>()

    if (N == 0){
        print(0)
    } else {
        while (N != 1) {
            list.add(Math.abs(N % -2))
            N = Math.ceil( N.toDouble() / (-2)).toInt()
        }

        list.add(N)
    }

    list.asReversed().forEach(){
        print(it)
    }
}
