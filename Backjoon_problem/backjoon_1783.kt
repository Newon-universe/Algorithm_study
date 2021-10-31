package backjoon_1783

import java.util.Collections.min

fun main() {
    val br = System.`in`.bufferedReader()
    var (N,M) = br.readLine().split(" ").map{ it.toInt() }
    var count = 0

    if (N == 1) {
        count = 1
    }

    else if (N == 2) {
        count = minOf(4, (M-1)/2 + 1)
    }

    else if (M < 7) {
        count = minOf(4, M)
    }

    else
        count = (2 + ((M-5) +1))

    print(count)
}
