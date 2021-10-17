package backjoon_14889

import java.util.*

lateinit var map: Array<IntArray>
lateinit var isVisited: BooleanArray
private var min = Integer.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    var size = br.readLine().toInt()

    map = Array(size) { IntArray(size) }
    isVisited = BooleanArray(size)
    for (i in 0 until size) {
        var strtok = StringTokenizer(br.readLine())

        for (j in 0 until size) {
            map[i][j] = strtok.nextToken().toInt()
        }
    }
    dfs(0, 0)
    println(min)
}

private fun dfs(index: Int, depth: Int) {
    if (depth == map.size / 2) {
        var startTeam = 0
        var linkTeam = 0
        for (i in 0 until map.size - 1) {
            for (j in i + 1 until map.size) {
                if (isVisited[i] && isVisited[j]) {
                    startTeam += map[i][j] + map[j][i]
                } else if (!isVisited[i] && !isVisited[j]) {
                    linkTeam += map[i][j] + map[j][i]
                }
            }
        }
        min = Math.min(min, Math.abs(startTeam - linkTeam))
        return
    }
    for (i in index until map.size) {
        if (!isVisited[i]) {
            isVisited[i] = true
            dfs(i + 1, depth + 1)
            isVisited[i] = false
        }
    }

}
