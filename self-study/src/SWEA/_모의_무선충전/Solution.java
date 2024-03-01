package SWEA._모의_무선충전;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			map = new int[10][10];
			
			int[] dr = {0,-1,0,1,0};
			int[] dc = {0,0,1,0,-1};
			
			int M = sc.nextInt();
			int A = sc.nextInt();
			int[] dir1 = new int[M];
			int[] dir2 = new int[M];
			
			
			for (int i = 0; i< M; i++) {
				dir1[i] = sc.nextInt();
			}
			for (int i = 0; i< M; i++) {
				dir2[i] = sc.nextInt();
			}
			
			int[][] bcs = new int[A][4];
			for (int i = 0; i<A; i++) {
				bcs[i][1] = sc.nextInt()-1;
				bcs[i][0] = sc.nextInt()-1;
				bcs[i][2] = sc.nextInt();
				bcs[i][3] = sc.nextInt();
			}
			
			int[] p1 = {0,0};
			int[] p2 = {9,9};
			
			int answer = getBest(p1,p2,bcs);
//			System.out.println("answer: "+answer);
//			System.out.println();
			
			for (int i =0; i<M; i++) {
				
//				System.out.println(i);
				
				p1[0] += dr[dir1[i]];
				p1[1] += dc[dir1[i]];
				
				p2[0] += dr[dir2[i]];
				p2[1] += dc[dir2[i]];
				
				answer += getBest(p1,p2,bcs);
				
//				System.out.println(answer);
//				System.out.println();
				
			}
			
			System.out.printf("#%d %d%n",tc,answer);
			
			
		}
	}
	
	public static int getDist(int[] p, int[] bc) {
		return Math.abs(p[0]-bc[0]) + Math.abs(p[1]-bc[1]);
	}
	
	public static List<Integer> reachAble (int[] p, int[][] bcs) {
		List<Integer> reachAble = new ArrayList<>();
		
		for (int i = 0; i < bcs.length; i++) {
			int[] bc = {bcs[i][0], bcs[i][1]};
//			System.out.println(Arrays.toString(p));
//			System.out.println(Arrays.toString(bc));
//			System.out.println(getDist(p,bc));
			if (getDist(p,bc)<=bcs[i][2]) {
				reachAble.add(i);
			}
		}
//		System.out.println(reachAble);
		return reachAble;
	}
	
	public static int getBest(int[] p1,int[] p2 , int[][] bcs) {
		
		List<Integer> reachAbleA = reachAble(p1,bcs);
		List<Integer> reachAbleB = reachAble(p2,bcs);
		
		int lenA = reachAbleA.size();
		int lenB = reachAbleB.size();
		
		int best = 0;
		if (lenA == 0 && lenB==0) return best;
		
		if (lenA ==0 && lenB !=0) {
			for (int i = 0; i < lenB; i++) {
				best = Math.max(best, bcs[reachAbleB.get(i)][3]);
			}
			return best;
			
		}
		if (lenA !=0 && lenB ==0) {
			for (int i = 0; i < lenA; i++) {
				best = Math.max(best, bcs[reachAbleA.get(i)][3]);
			}
			return best;
			
		}
		
		for (int i = 0; i < lenA; i++) {
			for (int j = 0; j < lenB; j++) {
				if (reachAbleA.get(i) == reachAbleB.get(j)) {
					best = Math.max(best, bcs[reachAbleA.get(i)][3]);
				}
				else {
					best = Math.max(best, bcs[reachAbleA.get(i)][3]+bcs[reachAbleB.get(j)][3]);
				}
			}
		}
		
		return best;
	}

}
