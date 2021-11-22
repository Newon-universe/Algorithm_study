import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private var n = 0
private var m = 0
private var max = 0
private lateinit var map: Array<MutableList<Pair<Int, Int>>>
private var curPos = 0
private var destination = 0

fun main() {
    init()
    println(biSearch(1, max + 1) - 1)
}

private fun init() = with(System.`in`.bufferedReader()) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    map = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val c = nextToken().toInt()

            map[a].add(Pair(b, c))
            map[b].add(Pair(a, c))
            max = max(max, c)
        }
    }
    with(StringTokenizer(readLine())) {
        curPos = nextToken().toInt()
        destination = nextToken().toInt()
    }
    close()
}

private fun biSearch(left: Int, right: Int): Int {
    if (left == right) {
        return left
    }

    val mid = (left + right) / 2
    return if (bfs(mid)) {
        biSearch(mid + 1, right)
    } else {
        biSearch(left, mid)
    }
}

private fun bfs(value: Int): Boolean {
    val visited = BooleanArray(n + 1).apply {
        this[curPos] = true
    }
    val queue = LinkedList<Int>().apply {
        addLast(curPos)
    }

    while (queue.isNotEmpty()) {
        val pos = queue.pollFirst()
        if (pos == destination) {
            return true
        }

        for (node in map[pos]) {
            if (!visited[node.first] && value <= node.second) {
                visited[node.first] = true
                queue.addLast(node.first)
            }
        }
    }
    return false
}
