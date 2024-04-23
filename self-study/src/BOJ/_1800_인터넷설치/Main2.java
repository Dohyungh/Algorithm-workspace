package BOJ._1800_인터넷설치;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
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
			if (this.pq.size() < K+1) {
				this.pq.add(num);
			} else {
				this.pq.poll();
				this.pq.add(num);
				System.out.println(this.pq);
			}
		}
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", cost=" + cost + ", pq=" + pq + "]";
		}
		
		
	}
	static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int P = sc.nextInt();
		K = sc.nextInt();
		
		List<Node>[] adjList = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) adjList[i] = new ArrayList<Node>();
		
		for (int i = 0; i < P; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			adjList[from].add(new Node(to, cost));
			adjList[to].add(new Node(from, cost));
		}
		
		PriorityQueue<Node> nodePq = new PriorityQueue<Node>();
		PriorityQueue<Integer> startPq = new PriorityQueue<>();
		
		startPq.add(0);
		
		Node start = new Node(1, startPq);
		
		nodePq.add(start);
		
		int[] answer = new int[N+1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		
		while(!nodePq.isEmpty()) {
			Node nowNode =nodePq.poll();
			System.out.println();
			System.out.println("nowNode:" + nowNode);
			
			if (answer[nowNode.idx] < nowNode.pq.peek()) continue;
			
			for (Node nextNode : adjList[nowNode.idx]) {
				System.out.println("nextNode: " + nextNode);
				
				
				PriorityQueue<Integer> tempPq = new PriorityQueue<>();
				Queue<Integer> nowPq = (Queue<Integer>)nowNode.pq;
				
				int size = nowPq.size();
				int[] temp = new int[size];
				for (int i = 0; i < size; i++) {
					temp[i] = nowPq.poll();
					tempPq.add(temp[i]);
				}
				for (int i = 0 ; i < size; i++) {
					nowPq.add(temp[i]);
				}
				System.out.println("tempPq: " + tempPq);
				
//				System.out.println(nextNode.cost);
				Node newNode = new Node(nextNode.idx, tempPq);
				
				newNode.add(nextNode.cost);
//				System.out.println(newNode.pq);
				
				if (newNode.pq.peek()!=0) {
					answer[newNode.idx]= Math.min(answer[newNode.idx], newNode.pq.peek()); 
				}
				nodePq.add(newNode);
				
//				System.out.println(newNode);
			}
			System.out.println(nodePq);
			
			
			
		}
		System.out.println(Arrays.toString(answer));
		
		
		
		
		
	}

}
