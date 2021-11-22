import java.io.*;
import java.util.*;

public class Main {
	static String result = "";     //최종결과를 담을 String 선언
	static Map<String, List<String>> tree = new HashMap<>();   //키 타입이 String, 값 타입이 List<String> 인 HashMap 선언
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			List<String> list = new ArrayList<>();
			
			list.add(str[1]);  //list 배열에 왼쪽 자식노드 추가
			list.add(str[2]);  //list 배열에 오른쪽 자식노드 추가
			tree.put(str[0], list);  //tree HashMap 에 노드-key, list 배열-value 추가 
		}
		
    //루트노드를 인자로 해서 함수 수행하고, 각 함수가 끝나면 개행
		preOrder("A");
		result += "\n";
		inOrder("A");
		result += "\n";
		postOrder("A");
		System.out.print(result);
	}
	
	// 전위 순회
	static void preOrder(String s) {
		if(s.equals(".")) {   //재귀를 돌다가 더 이상 자식이 없는 경우 리턴하고 다음으로 넘어감
			return;
		}
		
		result += s;   //전위 순회 -> 루트노드 먼저 출력
		preOrder(tree.get(s).get(0));  //왼쪽 자식노드를 인자로 하여 재귀호출
		preOrder(tree.get(s).get(1));  //오른쪽 자식노드를 인자로 하여 재귀호출
	}
	
	// 중위 순회
	static void inOrder(String s) {
		if(s.equals(".")) {
			return;
		}
		
		inOrder(tree.get(s).get(0));  //왼쪽 자식
		result += s;                  //루트
		inOrder(tree.get(s).get(1));  //오른쪽 자식
	}
	
	// 후위 순회
	static void postOrder(String s) {
		if(s.equals(".")) {
			return;
		}
		
		postOrder(tree.get(s).get(0));  //왼쪽 자식
		postOrder(tree.get(s).get(1));  //오른쪽 자식
		result += s;                    //루트
	}

}
