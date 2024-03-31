package SWEA._1251_하나로;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Solution_prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			double[][] islands = new double[N][2];
			
			for (int i = 0; i <N; i++) {
				islands[i][0] = sc.nextInt();
			}
			
			for (int i = 0; i <N; i++) {
				islands[i][1] = sc.nextInt();
			} 
			
			double E = sc.nextDouble();
			
			double[][] costs = new double[N][N];
			
			for (int i= 0; i<N; i++) {
				for (int j = 0 ; j<N; j++) {
					costs[i][j] = costs[j][i] <=0 ? getCost(islands[i],islands[j],E) : costs[j][i];
				}
			}
			
			int node = 0;
			double answer = 0.0;
			
			double[] dist = new double[N];
			Arrays.fill(dist, Double.MAX_VALUE);
			
			boolean[] visited = new boolean[N];
			
			int cnt = 1;
			
			while (cnt < N) {
				visited[node] = true;
				for (int i = 0; i < N; i++) {
					if (costs[node][i] == 0) continue;
					if (!visited[i]) {
						dist[i] = Math.min(dist[i], costs[node][i]);						
					}
				}
				
				// 최솟값 뽑아
				double min = Double.MAX_VALUE;
				for (int i = 0; i <N; i++) {
					if (!visited[i] && costs[node][i] != 0 && dist[i] < min) {
						min = dist[i];
						node = i;
					}
				}
				answer += min;
				cnt++;
			}
			
			System.out.printf("#%d %d%n", tc, Math.round(answer));
			
		}
	}

	private static double getCost(double[] is, double[] is2, double E) {
		
		return E * ((is[0] - is2[0])*(is[0] - is2[0]) +(is[1] - is2[1])*(is[1] - is2[1]));
	}

}
