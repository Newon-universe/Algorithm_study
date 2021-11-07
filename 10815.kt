import java.io.*
import java.util.*

val br = System.`in`.bufferedReader()
val bw = System.`out`.bufferedWriter()

fun read(): List<Int> {
    val n = br.readLine().toInt() // 배열의 개수
    val token = StringTokenizer(br.readLine())

    return MutableList(n) { token.nextToken().toInt() } // 입력 받아온 값을 공백을 기준으로 나눠서 한 요소씩 저장
}

fun main() {
    val list = read().sorted() // 리스트 요소들을 오름차순 정렬한 다음 mutableList에 리턴
    val find = read() // 정렬되기 전의 리스트

    for (f in find) { // 상근이가 가진 카드들을 한장씩 꺼냄
       if (list.binarySearch(f) >= 0) { // binarySearch() 메서드는 정렬된 배열에 매개변수로 들어온 값이 몇번째 인덱스에 위치하는지 값을 반환하는 메서드. 그러니까 있으면 0 이상의 양수,
           bw.write("1 ") // 있다면 1을 출력
       } else { // 없으면 음수를 리턴
           bw.write("0 ") // 없다면 0을 출력
       }
    }
    bw.flush()
}
