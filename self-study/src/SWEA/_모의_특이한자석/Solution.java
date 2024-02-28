package SWEA._모의_특이한자석;

import java.util.Scanner;

public class Solution {
	
	static int[][] wheels = new int[8][8];
	static int[] twelve = {0,0,0,0};
	static int[] spin = {0,0,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			
			for (int i = 0; i<4; i++) {
				for (int j =0; j<8; j++) {
					wheels[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i<4; i++) {
				twelve[i] = 0;
			}
			
			int[][] orders = new int[K][2];
			
			for (int i = 0; i<K; i++) {
				orders[i][0] = sc.nextInt(); // wheel
				orders[i][1] = sc.nextInt(); // dir
			}
			
			for (int i = 0 ; i<K; i++) {
				for (int j = 0; j < 4; j++) {
					spin[j] = 0;
				}
				
				int wheel = orders[i][0] -1;
				int dir = orders[i][1];
				
				spining(wheel, dir);
				
				//spin 에 따라 twelve 업데이트
				
				for (int j = 0; j <4; j++) {
					if (spin[j] == 1) twelve[j] = (twelve[j]-1+8)%8;
					if (spin[j] == -1) twelve[j] = (twelve[j]+1)%8;
				}
			}
			
			int answer = 0;
			for (int i = 0; i <4; i++) {
				answer += wheels[i][twelve[i]] * Math.pow(2, i);
			}
			
			System.out.printf("#%d %d%n", tc, answer);

		}

	}
	
	//spining 함수
	
	//누가 누굴 돌리는지 함수
	
	public static void spin(int wheel, int dir, int passWheel) {
//		spin[wheel] = dir; 이건 spinning
		
		if (wheel < passWheel) {
			if(wheels[wheel][(twelve[wheel]+2)%8] != wheels[passWheel][(twelve[passWheel]-2+8)%8]) {
				spin[passWheel] = -dir;
			}  else {
				spin[passWheel] = 0;
			}
			
		}
		if (wheel > passWheel) {
			if(wheels[wheel][(twelve[wheel]-2+8)%8] != wheels[passWheel][(twelve[passWheel]+2)%8]) {
				spin[passWheel] = -dir;
			} else {
				spin[passWheel] = 0;
			}
			
		}
		
		
	}
	
	public static void spining(int wheel, int dir) {
		spin[wheel] = dir;
		
		if (wheel == 0) {
			spin(0,dir,1);
			spin(1,spin[1],2);
			spin(2,spin[2],3);
		}
		if (wheel == 1) {
			spin(1,dir,0);
			spin(1,dir,2);
			spin(2,spin[2],3);
		}
		if (wheel == 2) {
			spin(2,dir,1);
			spin(2,dir,3);
			spin(1,spin[1],0);
		}
		if (wheel == 3) {
			spin(3,dir,2);
			spin(2,spin[2],1);
			spin(1,spin[1],0);
		}

	}

}

