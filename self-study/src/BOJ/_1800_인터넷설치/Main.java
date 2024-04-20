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
		PriorityQueue<Integer> pq;
		
		Node(int idx, PriorityQueue<Integer> pq) {
			this.idx = idx;
			this.pq = pq;
		}
		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo (Node node) {
			return this.pq.peek() - node.pq.peek();
		}
		
		public void add(Integer num) {
			if (this.pq.size() <)
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int P = sc.nextInt();
		int K = sc.nextInt();
		
		List<Node>[] adjList = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) adjList[i] = new ArrayList<Node>();
		
		for (int i = 0; i < P; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			adjList[from].add(new Node(to, cost));
			adjList[to].add(new Node(from, cost));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		PriorityQueue<Integer> startPq = new PriorityQueue<>();
		
		startPq.add(0);
		
		Node start = new Node(0, startPq);
		
		pq.add(start);
		
		int[] answer = new int[N+1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		
		while(!pq.isEmpty()) {
			Node nowNode =pq.poll();
			
			if (answer[nowNode.idx] < nowNode.pq.peek()) continue;
			
			for (int i = 0; i < adjList[nowNode.idx].size(); i++) {
				
			}
			
			
			
		}
		
		
		
		
		
	}

}
