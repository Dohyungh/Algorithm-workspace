package SWEA._모의_원자소멸시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	// 시간 초과..
	
	static int[][] numMap;
	static int[][] energyMap;
	static int[][] dirMap;
	
	static int energy;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <=T; tc++) {
			numMap = new int[4001][4001];
			energyMap = new int[4001][4001];
			dirMap = new int[4001][4001];
			
			for (int i = 0; i < dirMap.length; i++) {
				for (int j = 0; j <dirMap.length; j++) {
					dirMap[i][j] = -1;
				}
			}
			
			energy = 0;
			int N = sc.nextInt();
			int[][] atoms = new int[N][4]; //x,y,dir,K(energy)
			
			for (int i = 0; i<N; i++) {
				atoms[i][1] = 2000 + 2 * sc.nextInt();
				atoms[i][0] = 2000 - 2 * sc.nextInt();
				atoms[i][2] = sc.nextInt();
				atoms[i][3] = sc.nextInt();
			}
//			for (int i = 0; i < N; i++) {
//				
//				System.out.println(Arrays.toString(atoms[i]));
//			}
			
			for (int i = 0; i <N; i++) {
				int r = atoms[i][0];
				int c = atoms[i][1];
				numMap[r][c] = 1;
				energyMap[r][c] = atoms[i][3];
				dirMap[r][c] = atoms[i][2];
			}
			
			
			while (sum(numMap) != 0) {
				move();
				crash();
				
			}
			
			System.out.printf("#%d %d%n", tc, energy);
			
			
			
		}
		
		
	}
	
	public static int sum(int[][] map) {
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
				
			}
		}
		return sum;
	}
	
	public static void move() {
		int N = numMap.length;
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int[][] tempnumMap = new int[N][N];
		int[][] tempdirMap = new int[N][N];
		int[][] tempenergyMap = new int[N][N]
				;
		for (int i = 0; i <4001 ; i++) {
			for (int j = 0; j <4001; j++) {
				if (numMap[i][j] ==1) {
					int d = dirMap[i][j];
					int nr = i +dr[d];
					int nc = j +dc[d];
					if (!(nr >4000 || nr <0 || nc <0 || nc >4000)) {
						tempnumMap[nr][nc]++;
						
						tempdirMap[nr][nc] = dirMap[i][j];
						
						tempenergyMap[nr][nc] += energyMap[i][j];
					}					
				}
			}
			
		}
		numMap = tempnumMap;
		dirMap = tempdirMap;
		energyMap = tempenergyMap;
	}
	
	public static void crash() {
		for (int i = 0; i <4001 ; i++) {
			for (int j = 0; j <4001; j++) {
				if (numMap[i][j] >=2) {
					energy += energyMap[i][j];
					numMap[i][j] = 0;
					dirMap[i][j] = -1;
					energyMap[i][j] = 0;
					
				}
				
			}
		}
		
	}
	


	


}
