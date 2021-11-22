import java.io.*

fun solve(n: Int) {
    var N = n
    
	if (N == 0)
		return;
	if (N == 1) {
		print("1");
		return;
	}
	if (N == -1) {
		print("11");
		return;
	}
	if (N % -2 == 0) {
		solve(N / -2);
		print("0");
	}
	else {
		if (N > 0)                            // 지금 양수
			solve((N / -2));
		else                                  // 지금 음수
			solve((N / -2 + 1));
		print("1");
	}
	
}
fun main() {
	val br = System.`in`.bufferedReader()
	var N = br.readLine().toInt()

	if (N == 0)
		println("0");
	else
		solve(N);
}
