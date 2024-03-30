package BOJ._1922_네트워크연결;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		// 프림 알고리즘
		// 내 네트워크와 포함되지 않은 네트워크 사이에(Visited) 가장 작은 간선을 포함하는 노드를 가져와
		// 그 노드와의 거리 vs 기존 거리 중에 짧은 걸로 업데이트 해
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		int[][] cost = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			int val = sc.nextInt();
			
			cost[from][to] = val;
			cost[to][from] = val;
			
		}
		
		System.out.println(Prim(0,N,cost));

	}

	private static int Prim(int node, int N, int[][] cost) {
		int answer = 0;
		
		boolean[] visited = new boolean[N];
		
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		for (int n = 0; n < N; n++) {
			int idx = -1;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < dist.length; i++) {
				if (!visited[i]) {
					if (dist[i] < min) {
						idx = i;
						min = dist[i];
					}
				}
			}
			if(idx == -1) return answer;
			visited[idx] = true;
			answer += min;
			for (int i = 0; i < cost.length; i++) {
				if (!visited[i] && cost[idx][i] != 0 && cost[idx][i] < dist[i] ) {
					dist[i] = cost[idx][i];
				}
			}
			
		}
		
		return answer;
	}

}
