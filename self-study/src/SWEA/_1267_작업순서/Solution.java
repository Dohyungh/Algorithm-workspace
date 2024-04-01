package SWEA._1267_작업순서;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
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
			
			Queue<Integer> queue = new LinkedList<>();
			
			
			for (int i = 1; i < V+1; i++) {
				if (degree[i] == 0) {
					queue.add(i);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc);
			while(!queue.isEmpty()) {
//				System.out.println(queue);
				int node = queue.poll();
				sb.append(" " + node);
				for (int i = 1; i < V+1; i++) if (adj[node][i]) {
					degree[i]--;
					if (degree[i] == 0) queue.add(i);
				}
//				for (int i = 1; i < V+1; i++) if (degree[i] == 0) queue.add(i); // 이렇게 쓰면 안된다니까유
				
				
			}
			
			System.out.println(sb.toString());
		}
		
		
	}

}
