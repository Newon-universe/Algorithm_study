package backjoon_1260

import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    //각 입력을 변수에 할당
    val (node, edge, start) = br.readLine().split(" ").map { it.toInt() }
    //그래프 선언
    val graph = Array(node + 1) { IntArray(node + 1) { 0 } }
    //방문체크 리스트 선언
    val visited = mutableListOf<Int>()

    //간선 수만큼 반복
    repeat(edge) {
        val (v1, v2) = br.readLine().split(" ").map { it.toInt() }
        //연결된 노드들의 관계인 인덱스의 값을 1로 설정정
        graph[v1][v2] = 1
        graph[v2][v1] = 1
    }

    dfs(start, graph, visited)
    visited.forEach {
        print("$it ")
    }

    visited.clear()

    println()
    bfs(start, graph, visited)
    visited.forEach {
        print("$it ")
    }
}

fun dfs(start: Int, graph: Array<IntArray>, visited: MutableList<Int>) {
    visited.add(start)

    for (y in 1 until graph.size) {
        //그래프가 연결되어있고, 아직 방문하지 않았으면
        if (graph[start][y] == 1 && !visited.contains(y)) {
            //연결되어있는 노드를 시작점으로 재귀호출
            dfs(y, graph, visited)
        }
    }
}

fun bfs(start: Int, graph: Array<IntArray>, visited: MutableList<Int>) {
    //큐 생성
    val queue = LinkedList<Int>()
    queue.add(start) //시작 노드, 큐 삽입
    visited.add(start) //방문체크

    //큐가 빈 상태가 될 때까지 반복
    while (!queue.isEmpty()) {
        val x = queue.poll()        //큐의 맨 앞을 삭제

        for (y in 1 until graph.size) {
            //그래프가 연결되어있고, 아직 방문하지 않았으면
            if (graph[x][y] == 1 && !visited.contains(y)) {
                queue.add(y)//큐에 추가
                visited.add(y) //방문체크
            }
        }
    }
}
