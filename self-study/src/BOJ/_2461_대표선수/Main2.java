package BOJ._2461_대표선수;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		PriorityQueue<Integer>[] pq = new PriorityQueue[N];
		
		for (int i = 0; i < N; i++) {
			pq[i] = new PriorityQueue<Integer>();
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				pq[i].add(sc.nextInt());
			}
		}
		
		int minIdx= -1;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int answer = Integer.MAX_VALUE;
		out:
		while (true) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				if (pq[i].isEmpty()) break out;
				int val = pq[i].peek();
				if (val < min) {
					min = val;
					minIdx = i;
				}
				if (val > max) {
					max = val;
				}
			}
			answer = Math.min(answer, max - min);
			pq[minIdx].poll();

		}
		System.out.println(answer);
		
	}

}
