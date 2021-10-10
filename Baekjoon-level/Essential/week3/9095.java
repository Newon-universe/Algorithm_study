/**
 * 1 -> 1
 * 2 -> 2
 * 3 -> 4
 * 4 -> 1+ 3+ 1+ 2 = 7 (= 4 + 2 + 1)
 * 5 -> 1+ 4+ 3+ 3+ 2 = 13 (= 7 + 4 + 2)
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        // 물어보기
        int array[] = new int[11];

        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        int ans = 0;
        for (int i=0;i<input;i++) {
            ans = sc.nextInt();
            for(int j=4;j<=ans;j++) {
                array[j]=array[j-1]+array[j-2]+array[j-3];
            }
            System.out.println(array[ans]);
        }
    }
}