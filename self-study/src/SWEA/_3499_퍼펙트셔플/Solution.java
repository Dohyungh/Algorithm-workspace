package SWEA._3499_퍼펙트셔플;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc<=T; tc++) {
			
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			
			
			int N = sc.nextInt();
			int k;
			
			if (N%2==0) {
				k = N/2-1;
				
			} else k = N/2;
			
			
			for (int i=0; i<=k; i++) {
				queue1.add(sc.next());
			}
			for (int i=k+1; i<N;i++) {
				queue2.add(sc.next());
			}
			System.out.printf("#%d ",tc);
			if (!queue1.isEmpty()) {
				System.out.printf("%s ",queue1.poll());
				
			}
			
		}
		
	}
}
