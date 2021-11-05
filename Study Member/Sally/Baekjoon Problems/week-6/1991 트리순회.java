import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, List<String>> binaryTree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void preOrder(String node) {
      if(node.equals("."))
        return;
      
      sb.append(node);
      preOrder(binaryTree.get(node).get(0));
      preOrder(binaryTree.get(node).get(1));
    }

    public static void inOrder(String node) {
      if(node.equals("."))
        return;
      
        inOrder(binaryTree.get(node).get(0));
        sb.append(node);
        inOrder(binaryTree.get(node).get(1));
    }

    public static void postOrder(String node) {
      if(node.equals("."))
        return;
      
        postOrder(binaryTree.get(node).get(0));
        postOrder(binaryTree.get(node).get(1));
        sb.append(node);
    }
    
    public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      for(int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> tempList = new ArrayList<>();
        String key = st.nextToken();

        tempList.add(st.nextToken());
        tempList.add(st.nextToken());
        binaryTree.put(key, tempList);
      }

      preOrder("A"); sb.append("\n");
      inOrder("A"); sb.append("\n");
      postOrder("A"); sb.append("\n");

      System.out.println(sb);
    }
}