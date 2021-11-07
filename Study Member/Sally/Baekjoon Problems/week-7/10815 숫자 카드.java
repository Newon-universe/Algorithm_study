import java.io.*;
import java.util.*;

public class Main {
    static int[] cards;
    static int[] nums;

    public static boolean divideAndConquer(int card) {
      int start = 0;
      int end = cards.length - 1;

      while(start <= end) {
        int mid = (start + end) / 2;
        if(cards[mid] == card) return true; // 같은 숫자 발견 시 true!!
        else if(cards[mid] < card) start = mid + 1;
        else end = mid - 1;
      }

      return false;
    }

    public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int n = Integer.parseInt(br.readLine()); // 상근이 숫자 카드 넣기
      cards = new int[n];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0; i < n; i++) {
          cards[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(cards);

      n = Integer.parseInt(br.readLine()); // 주어진 숫자 카드 넣기
      nums = new int[n];

      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < n; i++) {
          nums[i] = Integer.parseInt(st.nextToken());
      }

      for(int i = 0; i < n; i++) {
        boolean checked = divideAndConquer(nums[i]);
        if(checked) sb.append("1 ");
        else sb.append("0 ");
      }

      System.out.println(sb);
    }
}