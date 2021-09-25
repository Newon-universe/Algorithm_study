import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
	  int[] arr;
	  int input = Integer.parseInt(br.readLine());
	  StringTokenizer st;

	  for(int i = 0 ; i < input ; i++) {
		  st = new StringTokenizer(br.readLine()," ");
		  int n = Integer.parseInt(st.nextToken());
		  arr = new int[n];
		  double sum = 0;
		  
		  for(int j = 0 ; j < n ; j++) {
			  int val = Integer.parseInt(st.nextToken());
			  arr[j] = val;
			  sum += val;
			}
			
			double mean = (sum / n) ;
			double count = 0;

			for(int j = 0 ; j < n ; j++) {
				if(arr[j] > mean) {
					count++;
				}
			}
			
			System.out.printf("%.3f%%\n",(count / n) * 100);
		}
	}
}