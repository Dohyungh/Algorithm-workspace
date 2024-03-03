package SWEA._모의_탈주범검거;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int[][] map;
	static int answer;
	
	public static void main(String[] args) {
		
		//easy 한가
		//안 easy 하군
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) { 
					map[i][j] = sc.nextInt();
				}
			}
			
//			for (int i =0; i <map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			
			boolean[][] adj = updateAdj();
//			for (int i =0; i<adj.length; i++) {
//				System.out.println(Arrays.toString(adj[i]));
//				
//			}
			
//			System.out.println(Arrays.toString(adj[13]));
			
			//대칭 체크를 해줘야 하네
			
			for (int i = 0; i < adj.length; i++) {
				for (int j =0; j <adj[0].length; j++) {
					if (adj[i][j]) {
						if (!adj[j][i]) {
							adj[i][j] = false;
						}
					}
				}
			}
			
			answer = 0;
			boolean[] visited = new boolean[N*M];
			
			BFS(adj, R, C, visited);
			System.out.printf("#%d %d%n", tc, answer);
			
			
			
			
			
		}
		
		
	}
	
	public static boolean[][] updateAdj() {
		
		int[] dr = {-1,1,0,0}; //상, 하 , 좌, 우
		int[] dc = {0,0,-1,1};
		
		boolean[][] adj = new boolean[N*M][N*M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int idx = i*M +j;
				
				if (map[i][j] ==1) {					
					int[] ds = {0,1,2,3};
					for (int d : ds) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						int nIdx = nr*M+nc;
						if (nr >=0 && nr <N && nc >=0 && nc <M  && map[nr][nc]!=0) {
							adj[idx][nIdx] = true;						
						}	
					}
				}
				if (map[i][j] ==2) {					
					int[] ds = {0,1};
					for (int d : ds) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						int nIdx = nr*M+nc;
						if (nr >=0 && nr <N && nc >=0 && nc <M && map[nr][nc]!=0) {
							adj[idx][nIdx] = true;						
						}	
					}
				}
				if (map[i][j] ==3) {					
					int[] ds = {2,3};
					for (int d : ds) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						int nIdx = nr*M+nc;
						if (nr >=0 && nr <N && nc >=0 && nc <M && map[nr][nc]!=0) {
//							System.out.println(i);
//							System.out.println(j);
//							System.out.println();
							
							adj[idx][nIdx] = true;						
						}	
					}
				}
				if (map[i][j] ==4) {					
					int[] ds = {0,3};
					for (int d : ds) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						int nIdx = nr*M+nc;
						if (nr >=0 && nr <N && nc >=0 && nc <M && map[nr][nc]!=0) {
							adj[idx][nIdx] = true;						
						}	
					}
				}
				if (map[i][j] ==5) {					
					int[] ds = {1,3};
					for (int d : ds) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						int nIdx = nr*M+nc;
						if (nr >=0 && nr <N && nc >=0 && nc <M && map[nr][nc]!=0) {
							adj[idx][nIdx] = true;						
						}	
					}
				}
				if (map[i][j] ==6) {					
					int[] ds = {1,2};
					for (int d : ds) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						int nIdx = nr*M+nc;
						if (nr >=0 && nr <N && nc >=0 && nc <M && map[nr][nc]!=0) {
							adj[idx][nIdx] = true;						
						}	
					}
				}
				if (map[i][j] ==7) {					
					int[] ds = {0,2};
					for (int d : ds) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						int nIdx = nr*M+nc;
						if (nr >=0 && nr <N && nc >=0 && nc <M && map[nr][nc]!=0) {
							adj[idx][nIdx] = true;						
						}	
					}
				}
				
				
				
					
				

				
			}
		}
		return adj;
		
	}
	
	public static void BFS(boolean[][] adj, int i, int j, boolean[] visited) {
		int index = i*M+j;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(index);
		int depth = 1;
		int size = 1;
		int cnt = 0;
		visited[index] = true;
		while(!queue.isEmpty()) {
			
//			System.out.println(queue);
			
			
			int nowNode = queue.poll();
			
			cnt++;
			
			answer++;
			
			
			for (int n = 0; n < adj.length; n++) {
				if (adj[nowNode][n]&& !visited[n]){
					queue.add(n);
					visited[n] = true;
				}
			}
			
			if (cnt == size) {
				depth++;
//				System.out.println(depth);
				size = queue.size();
				cnt = 0;
			}
			
			if (depth > L) {
//				System.out.println(queue);
				break;
			}
			
			
			
			
		}
		
	}

}































