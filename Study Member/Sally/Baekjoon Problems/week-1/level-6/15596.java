public class Test {
    long sum(int[] a) {
        long answer = 0;
		int len = a.length;

		for(int i = 0; i < len; i++)
			answer += a[i];

		return answer;
    }
}
