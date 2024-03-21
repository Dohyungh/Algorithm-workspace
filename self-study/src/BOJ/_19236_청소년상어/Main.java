package BOJ._19236_청소년상어;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	
	static int[][] fishes;
	
	static int[] shark = new int[2];
	
	public static void main(String[] args) {
		
		// 복잡시럽다
		
		Scanner sc = new Scanner (System.in);
		
		// 4by4 고정 사이즈
		// 16마리 물고기 고정
		
		fishes = new int[16][3]; // r, c, dir
		
		int idx = 0;
		while (idx <16) {
			int i = sc.nextInt()-1;
			
			fishes[i][0] = idx /4;
			fishes[i][1] = idx %4;
			fishes[i][2] = sc.nextInt()-1;
			
			idx++;
		}
		
//		for (int i = 0 ; i < 16; i++) {
//			System.out.println(Arrays.toString(fishes[i]));
//		}
		
		
	}
	
	public static void swap(int[] a, int[] b) {
		int i = a[0];
		int j = a[1];
		
		a[0] = b[0];
		a[1] = b[1];
		b[0] = i;
		b[1] = j;
		
		return;
	}
	
	
	public static void moveFishes() {
		for (int i = 0; i<16; i++) { // 모든 물고기에 대해서
			out:
			while(true) {
				int dir = fishes[i][2];
				int r = fishes[i][0];
				int c = fishes[i][1];
				
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !(nr == shark[0] && nc == shark[1])) {
					fishes[i][0] = nr;
					fishes[i][1] = nc;
					for (int j = 0; j < 16; j++) {
						if (fishes[j][0] == nr && fishes[j][1] == nc) {
							swap(fishes[i], fishes[j]);
							break out;
						}
					}
					
				} else {
					fishes[i][2] = (dir +1) % 8;
				}
			}
		}
	}
	
	public 
	}

}
