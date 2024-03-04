package SWEA._모의_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] adj;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		tc:
		for (int tc =1; tc <=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			
			int target = -1;
			for (int i =0 ; i <N; i++) {
				for (int j =0; j< M; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] ==3) target = i*M+j;
				}
			}
			
			for (int level = 1; level<=N-1; level++) {
				
				adj = new boolean[N*M][N*M];
				
				updateAdj(level);
				
				boolean[] visited = new boolean[N*M];
				
				boolean goal = BFS((N-1)*M, visited, target);
				
				if (goal) {
					System.out.printf("#%d %d%n", tc, level);
					continue tc;
				}
				

			}
			
		}
		sc.close();
			
			
			
		
	}


	public static boolean BFS(int start, boolean[] visited, int target) { // visited = n*m ������
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int i = 0; i <N*M; i++) {
				if (!visited[i] && adj[nowNode][i]) {
					queue.add(i);
					visited[i] = true;
					if (i == target) {
						return true;
					}
				}
			}
			
			
		}
		return false;
	}


	public static void updateAdj(int level) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] ==0) continue;
				
				int adjIndex = i*M+j;
				
				if (j >=1 && map[i][j-1]!=0) adj[adjIndex][adjIndex-1] = true;
				if (j+1 <= M-1 && map[i][j+1]!=0) adj[adjIndex][adjIndex+1] = true;
				for (int l = 1; l<=level; l++) {
					if (i-l>=0&&map[i-l][j] != 0) {
						adj[adjIndex][adjIndex-M*l] = true;
						break;
					}
				}
				for (int l = 1; l<=level; l++) {
					if (i+l<N && map[i+l][j] != 0) {
						adj[adjIndex][adjIndex+M*l] = true;
						break;
					}
				}
				
			}
		}
		
	}
	
}
