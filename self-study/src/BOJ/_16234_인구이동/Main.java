package BOJ._16234_인구이동;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[][] visited; // 방문
	static boolean[][] adj; // 인접행렬
	static int[][] map;
	static int N;
	static int L;
	static int R;
	public static void main(String[] args) {
		
		//BFS
		//가 맞아??
		//더 좋은게 있을 것 같은데
		
		Scanner sc = new Scanner (System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				
			}
		}
		
		visited = new boolean[N][N];
		adj = new boolean[N*N][N*N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {	
					updateAdj(i,j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					
					BFS(i,j);
					
					visited[i][j] = true;
					
				}
			}
		}
		
	}
	private static void BFS(int i, int j) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(i*N+j);
		
		
	}
	private static void updateAdj(int i, int j) { // 굉장히 sparse(성긴) 하다 // 낭비가 있다는 뜻
		
		int adjIndex = i * N +j;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			int nAdjIndex = nr*N +nc;
			
			if (nr >=0 && nr <N && nc >=0 && nc <N) {
				int gap = Math.abs(map[nr][nc] - map[i][j]);
				if (gap <=R && gap >=L) adj[adjIndex][nAdjIndex] = true;
			}
		}
		
	}

}
