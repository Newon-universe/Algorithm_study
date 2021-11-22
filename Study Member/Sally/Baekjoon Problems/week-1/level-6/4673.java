public class Main {
	public static int selfNumber(int a) {
		int ans = a;

		while(a != 0) {
			ans += a % 10;
			a /= 10;
		}

		return ans;
	}

    public static void main(String[] args) {
		boolean[] ary = new boolean[10000];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10000; i++) {
			int num = selfNumber(i);
			if(num < 10000)
				ary[num] = true;
		}

		for(int i = 0; i < 10000; i++)
			if(!ary[i]) sb.append(i).append("\n");
		
		System.out.println(sb);
	}
}