package SWEA._1238_Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_little_dijkstra {
		
		public static void main(String[] args) {
			// 다익스트라
			// BFS에서 depth (거리) 저장하는 방식과 비교해 볼 만한데,
			// 엄청 좋은가? 하면 그건 잘..
			
			Scanner sc = new Scanner(System.in);
			
			int T = 10;
			
			for (int tc = 1; tc <= T; tc++) {
				int answer = 0;
				
				int N = 101;
				
				int V = sc.nextInt()/2;
				
				int start = sc.nextInt();
				
				int[][] edges = new int[V][2]; // 간선 정보 저장
				
				for (int i = 0; i < V; i++) {
					edges[i][0] = sc.nextInt();
					edges[i][1] = sc.nextInt();
				}
					
				
				int[] dist = new int[N];
				
				Arrays.fill(dist, Integer.MAX_VALUE);
				
				int depth = 0;
				dist[start] = depth;
				
				while(true) {
					
					List<Integer> nn = new ArrayList<>();
					
					for (int i = 0; i < N; i++) { // 현재 depth 의 node 들을 dist 배열을 보면서 저장
						if (dist[i] == depth) {
							nn.add(i);
						}
					}
					
					if (nn.size() == 0) break; // 더 이상 뻗을 곳이 없으면 break;
					// BFS 와 유사한 것 같기도?
					
					for (int i = 0; i < nn.size(); i++) { // 모든 현재 depth의 노드에 대해
						for (int j = 0; j <V; j++) { // 모든 간선을 조사
							if (edges[j][0] == nn.get(i)) { // 출발점이 현재 depth의 노드이면
								// dist 를 업데이트 할 수 있는 기회를 줌
								dist[edges[j][1]] = Math.min(dist[edges[j][1]], depth+1); // 원래 다익스트라에서는 +1이 아니라 거리로 판단
							}
						}
					}
					
					depth++;
				}

				for (int i = 0; i < N; i++) {// 작은 곳에서 큰 쪽으로 순회 하면
					if (dist[i] == depth-1) { 
						answer = i; // 마지막에 자동으로 정답이 뽑아진다.
					}
				}
				System.out.printf("#%d %d%n", tc, answer);
			}
		}

	
}
