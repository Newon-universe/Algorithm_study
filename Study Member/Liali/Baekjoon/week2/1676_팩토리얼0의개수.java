1676. 팩토리얼 0의 개수

팩토리얼의 값에 0이 몇 개 있는지 찾는 문제 (일의 자리 수부터 연속되는 0의 갯수)
팩토리얼 값 안에 2*5 가 n개 있어야 뒷자리가 n개의 0으로 끝남
뒷자리 0 의 갯수 = 팩토리얼 값 소인수 분해했을 때 5의 갯수 (2는 항상 5보다 갯수가 많기 때문에 2의 갯수는 고려하지 않아도 됨)


import java.io.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int num = Integer.parseInt(br.readLine());
		int count = 0;
 
		while (num >= 5) {
			count += num / 5;   //5로 나눈 몫을 (소인수분해) count 에 누적해 더함
			num /= 5;           //5로 나눈 값으로 while 문 조건 다시 실행
		}
		System.out.println(count);
	}
 
}
