package BOJ._1800_인터넷설치;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node> {
		int idx;
		int cost;
		
		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo (Node node) {
			return this.cost - node.cost;
		}
		
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", cost=" + cost + "]";
		}
		
		
	}
	static int N;
	static int K;
	static int left;
	static int right;
	static int mid;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		int P = sc.nextInt();
		K = sc.nextInt();
		
		List<Node>[] adjList = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) adjList[i] = new ArrayList<Node>();
		
		right = Integer.MIN_VALUE;
		for (int i = 0; i < P; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			right = Math.max(cost, right);
			
			adjList[from].add(new Node(to, cost));
			adjList[to].add(new Node(from, cost));
		}
		
		left = 0;
		
		mid = (left + right) /2;
		
		while (left < right) {
			
			Dijkstra(adjList);
			if (right == -1) break;
		}
		
		System.out.println(right);
			
			
			
		}

	private static void Dijkstra(List<Node>[] adjList) {
//		System.out.println();
//		System.out.println(left);
//		System.out.println(mid);
//		System.out.println(right);
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			
			if (nowNode.cost > dist[nowNode.idx]) continue;
			
			for (Node nextNode : adjList[nowNode.idx]) {
				
				if (nextNode.cost > mid) {
					if (nowNode.cost+1 < dist[nextNode.idx]) {
						dist[nextNode.idx]= nowNode.cost+1; 
						pq.add(new Node(nextNode.idx, nowNode.cost+1));
					}
				} else {
					if (nowNode.cost < dist[nextNode.idx]) {
						dist[nextNode.idx]= nowNode.cost; 
						pq.add(new Node(nextNode.idx, nowNode.cost));
					}
				}
			}
			
		}
		
		if (dist[N] == Integer.MAX_VALUE) {
			right = -1;
			return;
		}
		
//		System.out.println(Arrays.toString(dist));
		if (dist[N] <= K) {
			right = mid;
		} else {
			left = mid+1;
		}
		mid = (left+right) /2;
		
		

		
		
		
		
	}



}
