package SWEA._7465_창용마을무리의개수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			
			int p[] = new int[N+1];
			// make-set
			for (int i = 1; i < N+1; i++) p[i] = i;
			
			for (int i = 0; i < M; i++) {
				
				int idx1 = sc.nextInt();
				int idx2 = sc.nextInt();
				if(idx1 == idx2) continue;
				int grandParents = idx2;
				
				List<Integer> childs = new ArrayList<Integer>();
				
				childs.add(idx2);
				
				if(p[idx1] == idx2) continue;
				
//				if (p[idx2] == idx1) continue;
				
				p[idx2] = idx1;
				int idx = idx1;
				
				while(true) {
					System.out.println(Arrays.toString(p));
					if (idx == p[idx]) {
						grandParents = idx;
						break;
					}
					if (!childs.contains(idx) ) childs.add(idx);
					if (!childs.contains(p[idx]) ) childs.add(p[idx]);
					idx = p[idx];
					if (idx == idx2) break;
				}
				
				for (Integer child : childs) {
					p[child] = grandParents;
				}
				
			}
			int answer = 0;
			boolean[] check = new boolean[N+1];
			for (int i = 1; i < N+1; i++) {
				int head = p[i];
				if (p[i] != i) {
					int index = p[i];
					while (true) {
						if (p[index] == index) {
							head = index;
							break;
						}
						index = p[index];
						head = index;
						
						
					}
					p[i] = head;
					
					
				}
				else {
				}
			}
			System.out.println(Arrays.toString(p));
			
//			for (int i = 1; i < N+1; i++) {
//				if (i == p[i]) answer++;
//			}
			
			for (int i = 1; i< N+1; i++) {
				if (!check[p[i]]) {
					answer++;
					check[p[i]] = true;
					
				}
			}
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

}
