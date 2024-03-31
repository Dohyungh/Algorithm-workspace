package SWEA._1249_보급로;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] dist;
	static boolean[][] visited;
	static int N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			
			
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				String[] st = str.split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st[j]);
				}	
			}
			dist = new int[N][N];
			
			for (int i = 0; i <N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			dist[0][0] = 0;

			
			visited = new boolean[N][N]; // 필요해!
			visited[0][0] = true;
			
			dijkstra(0,0);
			
			System.out.printf("#%d %d%n", tc, dist[N-1][N-1]);
		}
		
	}
	private static void dijkstra(int i, int j) {
		
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc <N && !visited[nr][nc]) {
				dist[nr][nc] = Math.min(dist[nr][nc], dist[i][j] + map[i][j]);
			}
		}
		int[] nextNode = searchMinAndNotVisited();
		if (nextNode[0] == -1) return;
		dijkstra(nextNode[0], nextNode[1]);
		
	}
	private static int[] searchMinAndNotVisited() {
		
		int[] nextNode = {-1,-1};
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] < min && !visited[i][j]) {
					min = dist[i][j];
					nextNode[0] = i;
					nextNode[1] = j;
					
				}
				
			}
		}
			
		return nextNode;
	}

}
