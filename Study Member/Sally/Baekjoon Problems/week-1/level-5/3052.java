import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> ary = new ArrayList<>();

		for(int i = 0; i < 10; i++) {
			int tmp = Integer.parseInt(br.readLine()) % 42;
			if(!ary.contains(tmp)) ary.add(tmp);
		}

		System.out.println(ary.size());
	}
}