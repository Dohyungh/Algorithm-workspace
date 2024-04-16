package BOJ._16118_달빛여우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_fin {
	// 늑대 불쌍해
	
	// 아니 내가 더불쌍해
	
	static class Node {
		int idx;
		int dist;
		int lookUp;
		
		Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		
		Node(int idx,  int lookUp,int dist) {
			this.idx = idx;
			this.dist = dist;
			this.lookUp = lookUp;
		}
	}
	
	// 다익스트라 돌릴 때 *2 /2 왔다갔다 하라는 거 같은데
	
	static int[][] distWolf;
	static List<Node>[] adj;
	static int N;
	
	static int[] distFox;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N];
		for (int i = 0; i <N; i++) {
			adj[i] = new ArrayList<>();
		}
		StringTokenizer st2 = null;
		for (int i = 0; i < M; i++) {
			st2 = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st2.nextToken())-1;
			int to = Integer.parseInt(st2.nextToken())-1;
			int d = Integer.parseInt(st2.nextToken()) * 2;
			
			adj[from].add(new Node(to, d));
			adj[to].add(new Node(from, d));
		}
		
		distWolf = new int[2][N]; // 홀수번 도착 / 짝수번 도착
		for (int i = 0; i < 2; i++) {
			Arrays.fill(distWolf[i], Integer.MAX_VALUE);
		}
		distWolf[0][0] = 0;
		distWolf[1][0] = Integer.MAX_VALUE;
				
		switchingDijkstra();
		
		distFox = new int[N];
		Arrays.fill(distFox, Integer.MAX_VALUE);
		distFox[0] = 0;
		
		Dijkstra();		
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (distFox[i] != Integer.MAX_VALUE && distFox[i] < Math.min(distWolf[0][i], distWolf[1][i])) answer++;
		}
		System.out.println(answer);
	}
	
	// 홀수번만에 왔냐 짝수번만에 왔냐를 구분해야해
	// 이거 생각하는데 왜 이렇게 오래 걸렸냐
	public static void switchingDijkstra() {
		
		// 홀수번만에 온 애 다음 애의 짝수번을 업데이트하고
		// 짝수번만에 온 애 다음 애의 홀수번을 업데이트하는 식으로.
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node> () {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.dist - o2.dist;
			}
		});
		
		pq.add(new Node (0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			
			int lookUp = nowNode.lookUp;
			int minIdx = nowNode.idx;
			if (distWolf[lookUp][minIdx] < nowNode.dist) continue;
			int update = 1-lookUp;
			
				
			for (Node node : adj[minIdx]) {
				int nextIdx = node.idx;
				int nextDist = node.dist;
				int cost = update == 0 ? distWolf[lookUp][minIdx] + nextDist*2 : distWolf[lookUp][minIdx] + nextDist/2;
				if (distWolf[update][nextIdx] > cost) {
					distWolf[update][nextIdx] = cost;
					pq.add(new Node(nextIdx, update, cost));
				}
			}
		}
		
	}
	
	public static void Dijkstra() {
			
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node> () {
			
			@Override
			public int compare(Node o1, Node o2) {
				return o1.dist - o2.dist;
			}
			
		});
		pq.add(new Node(0,0));
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int minIdx = nowNode.idx;
			if (distFox[minIdx] < nowNode.dist) continue;
			
			for (Node node : adj[minIdx]) {
				int nextDist = node.dist;
				int nextIdx = node.idx;
				int cost = distFox[minIdx] + nextDist;
				if (cost < distFox[nextIdx]) {
					distFox[nextIdx] = cost;
					pq.add(new Node(nextIdx, cost));
				}
				
			}
		}
	}
	
}