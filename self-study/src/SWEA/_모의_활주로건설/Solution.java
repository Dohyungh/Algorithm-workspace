package SWEA._모의_활주로건설;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				if (check(map[i],X)) {
					answer++;
				}
			}
			
			for (int i = 0; i< N; i++) {
				int[] tmp = new int[N];
				for (int j = 0; j <N; j++) {
					tmp[j] = map[j][i];
				}
				
				if (check(tmp, X)) {
					answer++;
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
			

		}
		
	}
	
	public static boolean check (int[] arr, int X) {
		List<int[]> list = new ArrayList<>();
		
		
		int nowLevel = arr[0];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] != nowLevel) {
				int[] temp = {nowLevel,cnt};
				list.add(temp);
				nowLevel = arr[i];
				cnt = 1;
			} else {

				cnt++;
			}
			
			if (i == arr.length-1) {
				int[] temp = {nowLevel,cnt};
				list.add(temp);
			}
			
		}

		
		int[] construct = new int[list.size()];
		//양 쪽으로 검사
		for (int i = 0; i < list.size()-1; i++) {
			int[] arr1 = list.get(i);
			int[] arr2 = list.get(i+1);
			
			if (arr1[0] < arr2[0]) {
				if (arr2[0] - arr1[0] > 1) {				
					return false;
				}
				if (arr1[1] < X) {					
					return false;
				} else {
					construct[i]++;
				}
			}
			if (arr1[0] > arr2[0]) {
				if (arr1[0] - arr2[0] > 1) {				
					return false;
				}
				if (arr2[1] < X) {
					return false;
				} else {
					construct[i+1]++;
				}
			}
		}
		
		for (int i = 0; i<construct.length; i++) {
			if (construct[i] ==2) {
				if (list.get(i)[1] <X*2) return false;
			}
		}
		
		return true;
	}
}