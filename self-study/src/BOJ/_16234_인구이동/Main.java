package BOJ._16234_인구이동;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[] visited; // 방문
	static boolean[][] adj; // 인접행렬
	static int[][] map;
	static int N;
	static int L;
	static int R;
	static boolean allDisconnected;
	public static void main(String[] args) {
		
		//BFS
		//가 맞아??
		//더 좋은게 있을 것 같은데
		
		//와우 시간초과
		
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
		
		int day = 0;
		while (true) {
			
			visited = new boolean[N*N];
			adj = new boolean[N*N][N*N];
			allDisconnected = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {	
					updateAdj(i,j);
				}
			}
			
			if(allDisconnected) break;
			
			day++;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i*N+j]) {
						BFS(i,j);						
					}
				}
			}
			
		}
		System.out.println(day);
		sc.close();
		
	}
	private static void BFS(int i, int j) {
		Queue<Integer> queue = new LinkedList<>();
		
		int adjIndex = i*N+j; 
		queue.add(adjIndex);
		
		visited[adjIndex] = true;
		
		int sum = 0;
		
		List<int[]> union = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			int r = nowNode/N;
			int c = nowNode%N;
			visited[nowNode] = true;
			sum += map[r][c];
		
			union.add(new int[] {r,c});
			
			for (int k = 0; k < adj.length; k++) {
				if (adj[nowNode][k] && !visited[k]) {
					queue.add(k);
					visited[k] = true;
				}
			}
		}
		
		int cnt = union.size();
		
		int result = sum /cnt;
		
		for (int[] country : union) {
			map[country[0]][country[1]] = result;
		}
		
		
		
		
		
	}
	private static void updateAdj(int i, int j) { // 굉장히 sparse(성긴) 하다 // 낭비가 있다는 뜻
		
		
		int adjIndex = i * N +j;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			int nAdjIndex = nr*N +nc;
			
			if (nr >=0 && nr <N && nc >=0 && nc <N) {
				int gap = Math.abs(map[nr][nc] - map[i][j]);
				if (gap <=R && gap >=L) {
					adj[adjIndex][nAdjIndex] = true;
					cnt++;
					allDisconnected = false;
				}
				
			}
		}
		if (cnt ==0) { // 시간초과 해결! // 혼자인 곳은 BFS 사전 차단
			visited[adjIndex] = true;
		}
		
		
	}

}
