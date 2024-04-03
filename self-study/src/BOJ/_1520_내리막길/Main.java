package BOJ._1520_내리막길;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static int M;
	static int N;
	
	static int answer;
	
	static List[] adj;
	
	static int[][] pathMap;
	public static void main(String[] args) {
		answer = 0;
		// 이 문제가 DP 인줄 몰랐다면
		// DFS 를 썼겠지
		
		// 써보자
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		
		N = sc.nextInt();
		
		map = new int[M][N];
		pathMap = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		adj = new ArrayList[M*N];
		adjUpdate();
		
		for (int i = M-1; i>=0; i--) {
			for (int j = N-1; j>=0; j--) {
				if (i == M-1 && j == N-1) continue;
				DFS(i,j,i,j);
			}
		}
		
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(pathMap[i]));
//		}
		System.out.println(pathMap[0][0]);
	}
	private static void DFS(int start_r, int start_c, int i, int j) {
		if (i == M-1 && j == N-1) {
			pathMap[start_r][start_c]++;
			return;
		}
		
		
		if (pathMap[i][j] != 0) {
			pathMap[start_r][start_c] += pathMap[i][j];
			return;
		}
		
		int adjIdx = i * N + j;
		for (int a = 0; a <adj[adjIdx].size(); a++) {
			int n = (int) adj[adjIdx].get(a);
			DFS(start_r,start_c,n/N,n%N);
			
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
