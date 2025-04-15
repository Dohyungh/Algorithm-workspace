package SWEA._1220_Magnetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			boolean has1;
			int temp;
			int ans = 0;
			for (int j = 0; j < N; j++) {
				has1 = false;
				temp = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i][j] == 1 && !has1) {
						has1 = !has1;	
					} else if (arr[i][j] ==2 && has1) {
						temp++;
						has1 = !has1;
					}
				}
				
				ans += temp;
				
			}			
			System.out.printf("#%d %d%n",tc,ans);
			
		}
		
		br.close();
		
		
	}
}
