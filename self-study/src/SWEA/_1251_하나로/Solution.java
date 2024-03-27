package SWEA._1251_하나로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int[] p;
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
			
			
			Double[][] tunnels = new Double[(N*(N-1))/2][3];
			int idx = 0;
			
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					tunnels[idx][0] = (double) i;
					tunnels[idx][1] = (double) j;
					tunnels[idx][2] = getCost(islands[i], islands[j], E);
					idx++;
				}
			}
			
			Arrays.sort(tunnels, new Comparator<Double[]>() {

				@Override
				public int compare(Double[] o1, Double[] o2) {
					// 
					return Double.compare(o1[2], o2[2]);
				}
			});
			
			double answer = 0.0;			
			
			p = new int[N];
			for (int i = 0; i < N; i++) p[i] = i;
			
			int cnt = 0;
			out:
			for (int i = 0; i < tunnels.length; i++) {
				int a = tunnels[i][0].intValue();
				int b = tunnels[i][1].intValue();
				while (p[a] != a) {
					a = p[a];
				}
				
				while (p[b] != b) {
					b = p[b];
				}
				
				if (a != b) {
					p[a] = b;
					answer += tunnels[i][2];
					cnt++;
					if (cnt == N-1) break out;
				}
				
				
				
			}
			System.out.printf("#%d %d%n", tc, Math.round(answer));
			
			
			
			
			
		}
		
	}

	private static double getCost(double[] is, double[] is2, double E) {
		
		return E * ((is[0] - is2[0])*(is[0] - is2[0]) +(is[1] - is2[1])*(is[1] - is2[1]));
	}

}
