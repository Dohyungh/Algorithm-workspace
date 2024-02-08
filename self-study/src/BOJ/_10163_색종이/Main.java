package BOJ._10163_색종이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[1001][1001];
		for (int i = 0; i < N; i++) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			int w_max = sx+w; // 등호가 안들어간 부등호
			int h_max = sy+h;
			
			for (int x = sx; x<w_max; x++) {
				for (int y = sy; y<h_max; y++) {
					arr[x][y]= i+1;
				}
			}
		}
		int cnt;
		for (int n = 1; n<=N; n++ ) {
			cnt = 0;
			for (int i = 0; i<arr.length; i++) {
				for (int j = 0; j<arr.length; j++) {
					if (arr[i][j]==n) cnt++;
					
				}
			}
			System.out.println(cnt);
		}
				
		
	}

}
