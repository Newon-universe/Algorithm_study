2089. -2진수
다시 이해하기!
  
import java.io.IOException;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
 
        int num = sc.nextInt();
        String result = "";
        if (num == 0) {
            System.out.println(num);
            return;
        }
        while (num != 0) {
            if (num % -2 == -1) {
                result = (num % -2) + 2 + result;
                num = (num / -2) + 1;
            } else {
                result = (num % -2) + result;
                num = num / -2;
            }
        }
        System.out.println(result);
    }
 
}
