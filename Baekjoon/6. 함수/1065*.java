1065. 한수

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        int third = 0;
        int second = 0;
        int first = 0;
        
        if(n == 1000){
            n = 999;
        }
        if(100 <= n && n <= 999){
            for(int i = 100; i <= n; i++){
                second = (i / 10) % 10;
                third = i % 10;
                first = (i - second * 10 - third) / 100;
                if(first - second == second - third){
                    count++;
                }
            }
            System.out.println(count + 99);
        } else if (n >= 1 && n <= 99){
            count = n;
            System.out.println(count);
        }
    }
}
