package BOJ._1520_내리막길;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static int M;
	static int N;
	 
	// 여기도 노란줄 떠요
	// 연결리스트 안 써봐서 모르겠어요
	// 이거 맞아요??
	static ArrayList[] adj; // 연결 리스트 (쭉 늘어뜨린 인덱스를 가짐) i*N+j
	
	// 죽은 자리(사방이 내리막이라 출발점에서 도달할 수 없는 자리)인지 확인 (죽은 자리에서 뻗어 나가는 경우의 수가 많음)
	static boolean[][] reachable; 
	
	// 각 자리에서 시작했을 때 도착지에 도달할 수 있는 가지 수
	static int[][] pathMap;
	
	static boolean[] visited; // 방문 배열 (쭉 늘어뜨린 인덱스를 가짐) i*N+j
	
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
		// 여기까지 입력
		
		// 인접리스트 업데이트
		adj = new ArrayList[M*N];
		adjUpdate();
		
		
		// 30% 짜리 백트래킹
		reachable = new boolean[M][N];
		// 같은 visited 재활용 해야 함.
		// BFS 한테 줄 visited. 초기화
		visited = new boolean[M*N];
		
		reachableUpdate(); // BFS 로 업데이트
		
		
		// DFS 한테 줄 visited. 다시 초기화
		visited = new boolean[M*N];
		
		// DFS + DP 출발
		for (int i = M-1; i>=0; i--) {
			for (int j = N-1; j>=0; j--) {
				
				// 도착지는 0으로 그대로 둬. 아무것도 하지마
				if (i == M-1 && j == N-1) continue;
				
				DFS(i,j,i,j);
			}
		}
		
		// 시작점의 경로의 수를 출력하면 끝
		System.out.println(pathMap[0][0]);
		
		//조은습관
		sc.close();
	}
	
	
	// 30% 짜리 백트래킹
	private static void reachableUpdate() {
		
		// BFS 로 맵을 쭉 훑어서 
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(0);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			// queue에 들어온 모든 애들은 도달 가능한 걸로 체크해 줄 거임.
			reachable[node/N][node%N] = true;
			
			for (int a = 0; a <adj[node].size(); a++) {
				int n = (int) adj[node].get(a);
				if (!visited[n]) {
					queue.add(n);
					visited[n] = true;
				}
			}
		}
	}

	
	private static void DFS(int start_r, int start_c, int i, int j) {
		
		// 어차피 못 가는 자리라면 제외
		if (!reachable[i][j]) return;
		
		// 해봤던 자리를 한번도 안지나고 도착지점에 도착할 수도 있겠지
		if (i == M-1 && j == N-1) {
			pathMap[start_r][start_c]++;
			return;
		}
		
		
//		if (pathMap[i][j] != 0) { // 원래 코드
		// 이미 체크한 자리의 경로의 수가 0일 수도 있다는 걸 간과함.
		// 그래서 pathMap에 0이라고 써있으니까 여기 안와봤나? 하고 계속 다시 검사하니까 시간초과.
		
		if (i*N+j > start_r*N+start_c) { // 더 정확한 조건문 // DP를 하고 있지 않았네 결국
			
			// 이미 시작해 봤던 자리라면 그냥 그 값을 더해줌.
			pathMap[start_r][start_c] += pathMap[i][j]; // 이걸 도입하는 것 자체는 6%짜리 백트래킹
			return;
		}
		
		// 그냥 평범한 DFS
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
	
	// 연결리스트 업데이트
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
						
						// 여기 노란줄 없애려면 어떻게 해야 하는지 아시는 자바 스터디 원??
						// Type safety: The method add(Object) belongs to the raw type ArrayList. 
						// References to generic type ArrayList<E> should be parameterized
						adj[adjIdx].add(nr*N+nc);
					}
				}
			}
		}
		
	}

}
