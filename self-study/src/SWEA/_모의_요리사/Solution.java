package SWEA._모의_요리사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static List<boolean[]> cases;
	static int final_answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T ; tc++) {
			cases = new ArrayList<>();
			final_answer = Integer.MAX_VALUE;
			
			int N  = sc.nextInt();
			
			int[][] s = new int[N][N];
			
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j< N; j++) {
					
					s[i][j] = sc.nextInt();
				}
			}
			
			boolean[] visited = new boolean[N];
			getCases(N,0,0,N/2,visited);
//			for (int i = 0 ; i< cases.size(); i++) {
//				System.out.println(Arrays.toString(cases.get(i)));
//				
//			}
			
			for(boolean[] aCase : cases) {
				calcAnswer(aCase,s);
				
			}
			System.out.printf("#%d %d%n", tc, final_answer);
			
		}
		
	}

	private static void calcAnswer(boolean[] aCase, int[][] s) {
		int ans1 = 0;
		int ans2 = 0;
		for (int i = 0; i < aCase.length; i++) {
			if (aCase[i]) {
				for (int j = 0; j < aCase.length; j++) {
					if(aCase[j]) {
						ans1 += s[i][j];
					}
				}
			}
			if (!aCase[i]) {
				for (int j = 0; j < aCase.length; j++) {
					if(!aCase[j]) {
						ans2 += s[i][j];
					}
				}
			}
		}
//		System.out.println();
//		System.out.println(ans1);
//		System.out.println(ans2);
		final_answer = Math.min(final_answer, Math.abs(ans1-ans2));
		
	}

	private static void getCases(int n, int start, int depth, int r, boolean[] visited) {
		
		if (depth ==r) {
			boolean[] temp = Arrays.copyOf(visited, visited.length);
//			System.out.println(Arrays.toString(temp));
//			System.out.println(start);			
			cases.add(temp);
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				getCases(n,i+1,depth+1,r,visited);
				visited[i] = false;
			}
		}
		
		
	}

}
