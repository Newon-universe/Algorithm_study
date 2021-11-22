4344. 평균은 넘겠지

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int C = Integer.parseInt(br.readLine());
        int[] arr;
//         int sum = 0;
        int avg = 0;
//         int count = 0;
        
            for(int i = 0; i < C; i++){
                int sum = 0;
                int count = 0;         //⭑⭑⭑ for 문 안에서 초기화 필요 ⭑⭑⭑
                
                st = new StringTokenizer(br.readLine()," ");
                int n = Integer.parseInt(st.nextToken());
                arr = new int[n];
                for(int j = 0; j < n; j++){
                    int score = Integer.parseInt(st.nextToken());
                    arr[j] = score;
                    sum += arr[j];
                }
                avg = sum/n;
                
                for(int k = 0; k < arr.length; k++){
                    if(arr[k] > avg){
                        count ++;
                    }
                }
                double percent = (double) count/n * 100;        //double 로 캐스팅!!! 또는 위에서 count 를 double/float 로 선언
                System.out.println(String.format("%.3f", percent)+"%");
                //ㄴ 다른 방법 : System.out.printf("%.3f%% \n",(count/(double)n) * 100);
            }
            
        }
        
    }
