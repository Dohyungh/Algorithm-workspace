package BOJ._7562_나이트의이동;

import java.util.Scanner;

public class Main {
	
	static boolean found;
	static int answer;
	static int N;
	
	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,-2,-1,1,2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // SWEA 출신인가
		
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			int start_r = sc.nextInt();
			int start_c = sc.nextInt();
			
			int dest_r = sc.nextInt();
			int dest_c = sc.nextInt();
			
			// 뭐로하지
			// BFS는 지겨우니까!
			// DFS
			
			found = false;
			answer = Integer.MAX_VALUE;
			boolean[][] visited = new boolean[N][N];
			DFS(start_r,start_c,dest_r,dest_c,0,visited);
			System.out.println(answer);
			
			
		}
		
		
		
	}
	public static void DFS(int r, int c, int dest_r, int dest_c, int depth, boolean[][] visited) {
		if (r == dest_r && c == dest_c) {
			found = true;
			answer = Math.min(answer, depth);
			
		}
		
		visited[r][c] = true;
//		System.out.println("r:" + r);
//		System.out.println("c:" + c);
		if (!found) {
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc <N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					DFS(nr,nc,dest_r,dest_c,depth+1, visited);
				}
			}
			
		}
	}

}
