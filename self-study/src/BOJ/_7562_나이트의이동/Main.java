package BOJ._7562_나이트의이동;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static boolean found;
	static int answer;
	static int N;
	static int[][] timeMap;
	
	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,-2,-1,1,2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // SWEA의 향기
		
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
			
			visited[start_r][start_c] = true;
			
			timeMap = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(timeMap[i], Integer.MAX_VALUE);
			}
			
			DFS(start_r,start_c,dest_r,dest_c,0,visited);
			
			System.out.println(answer);
			
			
		}
		
		sc.close();
		
	}
	public static void DFS(int r, int c, int dest_r, int dest_c, int depth, boolean[][] visited) {
		if (r == dest_r && c == dest_c) {
			found = true;
			answer = Math.min(answer, depth);
			return;
		}
		
		if (depth < answer) {
			
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				int alpha = -1;
				//난 쩔어 난 멋있어 난 대단해 나 산공맞아
				if (getDist(r,c,dest_r,dest_c)<=3) alpha = 3; // <=2, alpha = 1 (틀림, 도달을 못함) //<=3, alpha = 1혹은2 (백준은 정답이라는데 내가 틀린 테케를 찾음 (6나오는 그것)) // <=3, alpha = 3 (정답!)
				else alpha = 0;
				
				if (nr >= 0 && nr < N && nc >= 0 && nc <N  && getDist(r,c,dest_r,dest_c)+alpha>=getDist(nr,nc,dest_r,dest_c)) {
					if (!visited[nr][nc] || timeMap[nr][nc] > depth+1) { // timeMap 을 -1로 해서 방문체크를 visited를 안쓰고 timeMap으로 동시에 할 수도 있음!(by 성진)
						visited[nr][nc] = true;
						timeMap[nr][nc] = depth+1;
						DFS(nr,nc,dest_r,dest_c,depth+1, visited);
					}
				}
			}
		}
	}
	
	// 없으면 시간초과
	public static int getDist(int r, int c, int dest_r, int dest_c) {
		return Math.abs(r-dest_r) + Math.abs(c-dest_c);
	}

}


//2
//300
//0 0
//0 299
//
//
//300
//0 0
//123 123
//
//<<2번째 꺼 시간초과>>
//
//1
//10
//5 5
//6 6
//
//거리가 단순 짧아진다는 백트래킹은?
//<<답을 못찾음>>
//바로 도달하기 힘든 곳에 대해서 거리가 멀어 질 수 도 있음