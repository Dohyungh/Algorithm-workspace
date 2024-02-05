package SWEA._1493_수의새로운연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			System.out.printf("#%d %d%n", tc, shop(add(and(a),and(b))));
			
		}

	}
	
	public static int shop(int[] a) {
		int ans = 1;
		int i = 1;
		int j = 1;
		
		while(a[0]!= i || a[1] !=j) {
			if (j==1) {
				j = i+1;
				i = 1;
				ans++;
			} else {
				j--;
				i++;
				ans++;
			}
		}
		return ans;
		
	}
	
	public static int[] and(int a) {
		int row = 1;
		while (a-row>0) {
			a -=row;
			row++;
		}
		int[] ans = {1,row};
		
		for (int i = 0; i<a-1; i++) {
			ans[0]++;
			ans[1]--;
		}
		
		return ans;
	}
	
	public static int[] add(int[] a, int[] b) {
		
		int[] ans = {0,0};
		
		ans[0] = a[0] + b[0];
		ans[1] = a[1] + b[1];
		
		return ans;
		
		
	}

}
