import java.io.*;
import java.util.*;

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node root, char data, char leftData, char rightData) {
        if (root == null) {
            return;
        } else if (root.data == data) {
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root.left, data, leftData, rightData);
            searchNode(root.right, data, leftData, rightData);
        }
    }

    // 전위순회 : 루트 -> 좌 -> 우
    public void preorder(Node root) {
        System.out.print(root.data);
        if (root.left != null)
            preorder(root.left);
        if (root.right != null)
            preorder(root.right);
    }

    // 중위순회 : 좌 -> 루트 -> 우
    public void inorder(Node root) {
        if (root.left != null)
            inorder(root.left);
        System.out.print(root.data);
        if (root.right != null)
            inorder(root.right);
    }

    // 후위순회 : 좌 -> 우 -> 루트
    public void postorder(Node root) {
        if (root.left != null)
            postorder(root.left);
        if (root.right != null)
            postorder(root.right);
        System.out.print(root.data);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            char[] data;
            data = br.readLine().replaceAll(" ", "").toCharArray();
            tree.createNode(data[0], data[1], data[2]);
        }

        // 전위 순회
        tree.preorder(tree.root);
        System.out.println();

        // 중위 순회
        tree.inorder(tree.root);
        System.out.println();

        // 후위 순회
        tree.postorder(tree.root);

        br.close();
    }

}