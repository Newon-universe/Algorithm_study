import java.io.*

lateinit var SangGunCard: List<Int>   //상근이가 가진 카드
lateinit var RandomCard: List<Int>  //비교용 카드

fun binary(target: Int): Int {
    var left = 0 //가장 작은 값 초기 0
    var right = SangGunCard.lastIndex //가장 큰값 초기 사이즈-1
    var mid: Int; //중간값

    //로우가 하이보다 작거나 같을때 반복
    while (left <= right) {
        mid = (left + right) / 2

        when{
            target == SangGunCard[mid] -> return 1
            target < SangGunCard[mid] -> right = mid - 1
            target > SangGunCard[mid] -> left = mid + 1
        }
    }
    return 0
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    var N = br.readLine().toInt()
    SangGunCard = br.readLine().split(" ").map { it.toInt() }.sorted()  //정렬을 해야만 이진탐색이 가능하기에 정렬

    var M = br.readLine().toInt()
    RandomCard = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until M) {
        bw.append("${binary(RandomCard[i])} ")
    }
    bw.flush()
    bw.close()
}
