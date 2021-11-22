import java.io.*;
import java.util.*;

public class Main{
    static int[] card;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        card = new int[n];

        // 상근이 카드에 적힌 숫자들 입력 받고 sort
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        // 주어진 m개의 카드 입력 받기 (상근이가 가진 숫자인지 아닌지 판단해야할 수들의 갯수)
        int m = Integer.parseInt(br.readLine());
        nums = new int[m];

				//nums[] = 상근이가 가진 숫자인지 아닌지 판단해야할 수들의 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            nums[i] = Integer.parseInt(st.nextToken()); 
        }

        // 각 주어진 숫자를 이진 탐색으로 찾아서 있으면 1, 없으면 0으로 표기
        StringBuilder sb = new StringBuilder(); //sb = 결과값들을 담는 곳
        for(int i = 0; i < m; i++){
            if(binarySearch(nums[i])){
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    // 이분탐색(분할정복)을 통해 숫자가 있는지 확인하는 메소드
    private static boolean binarySearch(int num){
        int start = 0;              //탐색시작점
        int end = card.length - 1;  //탐색을 끝내는 지점
        int mid = (start+end)/2;    //중간지점
 
        while(start <= end){            // < 로 하면 마지막 숫자를 탐색하지 못함
            if(card[mid] == num) {      // 숫자가 있으면 true 반환
                return true;
            } else if(card[mid] < num){ //판단하려는 값이 가지고 있는 카드의 중간값보다 크면
                start = mid + 1;        //중간값 이상의 구간 안에서만 탐색하기 위해 start를 mid+1로 변경
            } else {                    //판단하려는 값이 중간값보다 작으면
                end = mid - 1;          //탐색의 구간을 하나씩 줄여나가며 while문을 돌린다
            }
            mid = (start + end) / 2;    //while문 한 번 돌릴 때마다 중간값 업데이트
        }
        return false;
    }
}
