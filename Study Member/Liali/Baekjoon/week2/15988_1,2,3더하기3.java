15988. 1,2,3 더하기 3


import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();    //test case 갯수
 
        long dp[] = new long[1000001];   //10억 9 로 나눈 나머지를 묻는 문제 => 10억이 넘는 결과값이 있다는 뜻 -> int 가 아닌 long 타입으로 배열 선언해야
 
        //베이스 케이스들은 미리 세팅 -> dp[4]부터는 이들을 활용해 결과 도출
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
      
        for (int i = 1; i <= tc; i++) {
            int    data = Integer.parseInt(sc.nextLine());
            
            for (int row = 4; row <= data; row++) {
                dp[row] = (dp[row-1] + dp[row-2] + dp[row-3]) % div;
            }
            
            long sum = dp[data];
            System.out.println(sum);
        }
    }
}




참고 : https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-12101-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-3-Java
