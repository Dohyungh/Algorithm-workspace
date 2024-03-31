package SWEA._1238_Contact;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			
			
			int N = 101;
			
			int V = sc.nextInt()/2;
			
			int start = sc.nextInt();
			
			boolean[][] adj = new boolean[N][N];
			
			for (int i = 0; i < V; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adj[from][to] = true;
				
			}
			
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[N];
			
			queue.add(start);
			
			visited[start] =true;
			
			answer = start;
			
			int size = queue.size(); 
			int cnt = 0;
			while(!queue.isEmpty()) {
				
				int nowNode = queue.poll();
				cnt++;

				for (int i = 1; i <N; i++) {
					if (!visited[i] && adj[nowNode][i]) {
						queue.add(i);
						visited[i] = true;
					}
				}
				if (cnt == size && !queue.isEmpty()) {
					cnt = 0;
					size = queue.size();
					answer = 0;
					
					for (int i=0; i<size; i++) {
						int whatever = queue.poll();
						answer = Math.max(whatever, answer);
						queue.add(whatever);
						
					}
					
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

}
