package SWEA._1267_작업순서;

import java.util.Scanner;
import java.util.Stack;

public class Solution_Stack {
	
	Stack<Integer> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			boolean[][] adj = new boolean[V+1][V+1];
			
			int[] degree = new int[V+1];
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				adj[from][to] = true;
				
				degree[to]++;
				
			}
			
			Stack<Integer> stack = new Stack<>();
			
			
			for (int i = 1; i < V+1; i++) {
				if (degree[i] == 0) {
					DFS(i);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc);
			while (!stack.isEmpty()) {
				sb.append(""+stack.pop());
			}
			
			System.out.println(sb.toString());
		}
		
		
	}

	private static void DFS(int i) {
		
		
		
	}

}
