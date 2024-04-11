package BOJ._1944_복제로봇;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[][] adj; 
	static boolean[] visited;
	static int[] dr = {-1,1,0,0}; //상 하 좌 우
	static int[] dc = {0,0,-1,1}; //상 하 좌 우
	static int[] dAdj;
	
	static int N;
	
	public static void main(String[] args) {
		// 머라는 겨
		
		// 근데 이건 다익스트라 아닌교?
		// 250 * 100 * 250 = 625 0000
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		map = new int[N][N];
		int[][] keys = new int[M][2]; // 열쇠
		int[] start = new int[2];
		
		//인접행렬 쓰고싶어!!
		//메모리초과가 걱정돼!!
		adj = new boolean[N*N][4];
		visited = new boolean[N*N];
		dAdj = new int[] {-N,+N,-1,+1};
		
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split("");
			
			for (int j = 0; j < N; j++) {
				if(str[j].equals("1")) map[i][j] = 1;
				else map[i][j] = 0; // 0, S, K 는 모두 갈 수 있는 곳. (벽이 아닌 곳)
				if(str[j].equals("S")) {
					start[0] = i;
					start[1] = j;
				}
				if(str[j].equals("K")) {
					keys[idx][0] = i;
					keys[idx++][1] = j;
				}
			}
		}
		
		
		adjUpdate();
		
		
		
		int[] dist = new int[M+1];
		
		dist[0] = 0; // start;
		
		for (int i = 1; i <= M; i++) {
			visited = new boolean[N*N];
			dist[i] = getDist(start, keys[i-1]);
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= M; j++) {
				if (i==j) continue;
				visited = new boolean[N*N];
				dist[j] = Math.min(dist[j], getDist(keys[i-1],keys[j-1])); 

			}
		}

		int answer = 0;
		for (int i = 1; i <= M; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				answer =-1;
				break;
			}
			answer += dist[i];
		}
		
		System.out.println(answer);
		
	}
	
	
	public static void adjUpdate() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				int adjIdx = i*N+j;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if (nr < N && nr >=0 && nc < N && nc >= 0 && map[i][j] == 0 && map[nr][nc] == 0) {
						adj[adjIdx][d] = true;
					}
				}
			}
		}
	} 
	// 접근시에는 
	// adjIdx - N
	// adjIdx + N
	// adjIdx - 1
	// adjIdx + 1
	
	
	
	public static int getDist(int[] start, int[] keys) {
		
		// BFS 돌려말어돌려말어돌려말어돌려말어 애매해
		// 해 그냥
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start[0]*N+start[1]);
		int sz = 1;
		int depth = 0; // 거리
		
		while(!queue.isEmpty()) {
			for (int c = 0; c < sz; c++) {
				int nowNode = queue.poll();
				if (nowNode == keys[0] *N + keys[1]) return depth;
				
				for (int d = 0; d < 4; d++) {
					
					int nextNode= nowNode +dAdj[d];
					if (adj[nowNode][d] && !visited[nextNode]) {
						queue.add(nextNode);
						visited[nextNode] = true;
					}
				}
			}
			sz = queue.size();
			depth++;
			
		}
		return Integer.MAX_VALUE;
		
	}

}
