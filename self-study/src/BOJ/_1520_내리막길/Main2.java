package BOJ._1520_내리막길;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	
	static int[][] map;
	static int M;
	static int N;
	
	static ArrayList[] adj; // 연결 리스트
	
	// 각 자리에서 시작했을 때 도착지에 도달할 수 있는 가지 수
	static int[][] pathMap;
	
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt(); // 행 사이즈
		
		N = sc.nextInt(); // 열 사이즈
		
		map = new int[M][N]; // 지도
		pathMap = new int[M][N]; // 경로의 수 DP table
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 입력
		
		adj = new ArrayList[M*N];
		adjUpdate();
		
		visited = new boolean[M*N];
		for (int i = M-1; i>=0; i--) {
			for (int j = N-1; j>=0; j--) {
				if (i == M-1 && j == N-1) continue;
				DFS(i,j,i,j);
			}
		}
		
		System.out.println(pathMap[0][0]);
	}
	

	
	private static void DFS(int start_r, int start_c, int i, int j) {
		if (i == M-1 && j == N-1) {
			pathMap[start_r][start_c]++;
			return;
		}
		
		
//		if (pathMap[i][j] != 0) { // 원래 코드
		
		if (pathMap[i][j] != 0 || i*N+j > start_r*N+start_c) { // 여기가 핵심!!! // DP를 하고 있지 않았네 결국
			pathMap[start_r][start_c] += pathMap[i][j];
			return;
		}
		
		int adjIdx = i * N + j;
		for (int a = 0; a <adj[adjIdx].size(); a++) {
			int n = (int) adj[adjIdx].get(a);
			if (!visited[n]) {
				visited[n] = true;
				DFS(start_r,start_c,n/N,n%N);
				visited[n] = false;
			}
		}
	}
	
	private static void adjUpdate() {
		int[] dr = {-1,1,0,0};
		int[] dc=  {0,0,-1,1};
		
		for (int i = 0; i< M; i++) {
			for (int j = 0; j < N; j++) {
				int adjIdx = i*N+j;
				adj[adjIdx] = new ArrayList<Integer>();
				
				
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if (nr>=0 && nr < M && nc >= 0 && nc < N && map[i][j] > map[nr][nc]) {
						adj[adjIdx].add(nr*N+nc);
					}
				}
			}
		}
		
	}

}
