package SWEA._모의_활주로건설;

import java.util.Scanner;

public class Solution2 {
	// 완전 틀린 풀이
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
					System.out.println("행번호: "+ i);
					answer++;
				}
			}
			
			for (int i = 0; i< N; i++) {
				int[] tmp = new int[N];
				for (int j = 0; j <N; j++) {
					tmp[j] = map[i][j];
				}
				
				if (check(tmp, X)) {
					System.out.println("열번호: "+ i);
					answer++;
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
			
		}
	}
	
	// 행 by, 열 by 로 한줄 받아서 체크하는 함수 만들자
	
	// 낮은 쪽에 건설해야해
//	public static boolean check(int[] arr, int X) {
//		int nowLevel = arr[0];
//		int cnt = 1;
//		for (int i = 1; i < arr.length; i++) {
//			if (i == arr.length-1) return true;
//			
//			if (arr[i] == nowLevel) {
//				cnt++;
//				continue;
//			} else {
//				if ((Math.abs(arr[i] - nowLevel)) > 1) return false;
//				if (cnt >= X) {
//					cnt=1;
//					nowLevel = arr[i];
//					continue;
//				} else return false;
//			}
//			
//			
//		}
//		return false;
//	}
	public static boolean check(int[] arr, int X) {
		int nowLevel = arr[0];
		boolean descended = false;
		
		int cnt = 1;
		for (int i = 1; i< arr.length; i++) {
			if ((Math.abs(arr[i] - nowLevel)) > 1) return false;
			
			if (arr[i] == nowLevel) {
				cnt++;
				
				continue;
			}
			if (arr[i] > nowLevel) {
				if (cnt < X) return false;
				
				// 너무 복잡해 기각
				
				
				nowLevel = arr[i];
				cnt = 1;
				continue;
			}
			if (arr[i] < nowLevel) {
				cnt = 1;
				
			}
		}
		
		return true;
		
	}
}	
