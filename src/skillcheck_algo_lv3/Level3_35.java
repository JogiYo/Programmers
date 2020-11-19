package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// Programmers Level 3 : Directions game
// using Binary Tree, preOrder and postOrder
public class Level3_35 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] nodeinfo = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(",");
			nodeinfo[i][0] = Integer.parseInt(input[0]);
			nodeinfo[i][1] = Integer.parseInt(input[1]);
		}
		
		int[][] result = solution(nodeinfo);
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				sb.append(result[i][j] + " ");
			}
			if(i != result.length - 1) sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static int k = 0;
	public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Node[] nodelist = new Node[nodeinfo.length];
        
        for(int i = 0; i < nodelist.length; ++i) {
        	nodelist[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        // Sort x in ascending order and y in descending order.
        // To make the tree easier
        Arrays.sort(nodelist, new Comparator<Node>() {
			@Override
			public int compare(Node no1, Node no2) {
				// TODO Auto-generated method stub
				return no1.y == no2.y ? no1.x - no2.x : no2.y - no1.y; 
			}
        });
        // Build a binary tree.
        Node root = nodelist[0];
        for(int i = 1; i < nodelist.length; ++i) {
        	makeTree(root, nodelist[i]);
        }
        
        preOrder(root, answer);
        k = 0;
        postOrder(root, answer);
        return answer;
    }
	// Depending on where the root is located, the traversal method is determined.
	// pre_order : root -> left -> right
	private static void preOrder(Node root, int[][] answer) {
		answer[0][k++] = root.idx;
		if(root.left != null) preOrder(root.left, answer);
		if(root.right != null) preOrder(root.right, answer);
	}
	// post_order : left -> right -> root
	private static void postOrder(Node root, int[][] answer) {
		if(root.left != null) postOrder(root.left, answer);
		if(root.right != null) postOrder(root.right, answer);
		answer[1][k++] = root.idx;
	} 
	
	private static void makeTree(Node root, Node cur_node) {
		if(cur_node.x < root.x) {
			if(root.left != null) {
				makeTree(root.left, cur_node);
			}
			else root.left = cur_node;
		}
		else {
			if(root.right != null) {
				makeTree(root.right, cur_node);
			}
			else root.right = cur_node;
		}
	}

	static class Node {
		int x, y, idx;
		Node left = null;
		Node right = null;
		
		Node(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
	}
}