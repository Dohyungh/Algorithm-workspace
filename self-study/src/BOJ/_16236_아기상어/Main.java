package BOJ._16236_아기상어;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static int[] nowNode; // 현재위치는 스태틱으로 선언하고, // BFS 돌릴 때는 OnThePath 로 지나가는 와중을 표시.
	static int size;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		map = new int[N][N];
		nowNode = null;
		for (int i = 0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j]==9) nowNode = new int[] {i,j};
			}
		}
		
		size = 2;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		
		while(true) {
			
			boolean[][] visited = new boolean[N][N];
			
			visited[nowNode[0]][nowNode[1]] = true;
			
			int[] prey = null;
			
			int path_r = nowNode[0]; // primitive 깊은 복사
			int path_c = nowNode[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = path_r + dr[d];
				int nc = path_c + dc[d];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					
					
					
					
					
					
				}
			}

		}
		
		
		
		
		
		
		
		
	}

}
