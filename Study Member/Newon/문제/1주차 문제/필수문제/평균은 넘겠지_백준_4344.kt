import java.io.*
import java.util.*

fun main() {
	val br = System.`in`.bufferedReader()

	val arr = IntArray(1_001)
	var testCase = br.readLine().toInt()

	var sum: Double
	var average: Double
	var sumCount: Double
	var result: Double

	for (i in 1..testCase) {
		sum = 0.0
		average = 0.0
		sumCount = 0.0
		val stringToken = StringTokenizer(br.readLine())

		var i:Int = 0
		while(stringToken.hasMoreTokens()) {
			arr[i] = stringToken.nextToken().toInt()
			i++
		}

		for (i in 1..arr[0]){
			sum += arr[i]
			average = sum / arr[0]
		}

		for (i in 1..arr[0]) {
			if (arr[i] > average) {
				sumCount += 1
			}
		}
		result = sumCount / arr[0] * 100
		println("${String.format("%.3f", result)}%")
	}
}

