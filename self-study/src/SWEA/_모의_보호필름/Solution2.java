package SWEA._모의_보호필름;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	
	static int answer;
	
	static int[][] map;
	
	static int K;
	static int D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			int W = sc.nextInt();
			K = sc.nextInt();
			answer = K;
			
			map = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int[] state = new int[W];
			int[] cnt = new int[W];
			
			Arrays.fill(cnt, 0);
			Arrays.fill(state, -1);
			
			boolean[] satisfied = new boolean[W];
			
			DP(0,-1,state,cnt,satisfied,0);
			DP(0,0,state,cnt,satisfied,1);
			DP(0,1,state,cnt,satisfied,1);
			System.out.printf("#%d %d%n",tc,answer);
			
		}
		
		
	}

	private static void DP(int depth, int fillWith, int[] oriState, int[] oriCnt, boolean[] oriSatisfied, int ans) {
//		System.out.println("depth:" + depth);
//		System.out.println("fillWith:" + fillWith);
		
		int[] state = Arrays.copyOf(oriState, oriState.length);
		boolean[] satisfied = Arrays.copyOf(oriSatisfied, oriSatisfied.length);
		int[] cnt = Arrays.copyOf(oriCnt, oriCnt.length);
//		if (depth ==3) return;
		
		if (answer <= ans) return;
		if (depth >= D) return;
		
		if (fillWith == -1) {
			for (int i = 0; i < state.length; i++) {
				if (!satisfied[i]) {	
					if (map[depth][i] == state[i]) cnt[i]++;
					else cnt[i] = 1;
				}
			}
			
			state = map[depth];
		}
		else {
			// 채웠을 때 검사 와 cnt 배열 업데이트
			for (int i = 0; i < state.length; i++) {
				if (!satisfied[i]) {				
					if (fillWith == state[i]) cnt[i]++;
					else cnt[i] = 1;
				}
			}
			Arrays.fill(state, fillWith);
		}
		// 각 열마다 만족했는지 여부 업데이트
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] >= K && !satisfied[i]) satisfied[i] = true;
		}
		
		// 모든 열이 만족했는지 확인후 answer 업데이트
		for (int i = 0; i < satisfied.length; i++) {
			if (!satisfied[i]) break;
			if(i == satisfied.length-1) {
				answer = Math.min(answer, ans);
				return;
			}
		}
//		System.out.println("depth:" + depth);
//		System.out.println("fillWith:" + fillWith);
//		System.out.println(Arrays.toString(state));
//		System.out.println(Arrays.toString(cnt));
//		System.out.println(Arrays.toString(satisfied));
		
		
		
		DP(depth+1, -1, state, cnt, satisfied, ans);
		DP(depth+1, 0, state, cnt, satisfied, ans+1);
		DP(depth+1, 1, state, cnt, satisfied, ans+1);
		
		
		
	}

}
