import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[12];  //결과 모두 넣을 배열 선언 (n=11이기 때문에 12길이로 선언)
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for(int i = 4; i < 12; i++){
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
//        System.out.println(Arrays.toString(result));    //미리 결과 배열 만들기 : [0, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504]

        int T = Integer.parseInt(br.readLine());    //테스트 케이스 수 받아오기

        for (int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());    //정수 받아오기
            System.out.println(result[n]);
        }


    }
}
