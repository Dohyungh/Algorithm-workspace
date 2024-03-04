package SWEA._모의_2;

import java.util.Scanner;

public class Solution2 {
	static boolean[][] alreadyBuilt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for (int tc =1; tc <=T; tc++) {
			int N = sc.nextInt(); // N�� ���� ����!!!!
			// map �� 31 by 31
			
			int[][] homes = new int[N][3]; // x, y, �����ұ��� �Ÿ�
			
			for (int i = 0; i <N; i++) {
				homes[i][1] = sc.nextInt()+15;
				homes[i][0] = 15 - sc.nextInt();
				homes[i][2] = sc.nextInt();
			}
			
			alreadyBuilt = new boolean[31][31];
			
			for (int i = 0; i <N; i++) {
				alreadyBuilt[homes[i][0]][homes[i][1]] = true;
			}
			
			boolean found_1 = false;
			
			int case1_answer = Integer.MAX_VALUE;
			for (int i =0; i< 31; i++) {
				out:
				for (int j =0; j < 31; j++) {
					if (alreadyBuilt[i][j] == true) continue out;
					int sum = 0;
					
					int[] bc = {i,j};
					
					for (int h = 0; h <N; h++) {
						int dist = getDistance(homes[h], bc);
						if (dist > homes[h][2]) continue out;
						sum += dist;
						
					}
					case1_answer = Math.min(case1_answer, sum);
					if (case1_answer == 75) {
						System.out.println("i: "+i);
						System.out.println("j: "+j);
						break;
					}
					found_1 = true;
				}
			}
			
			if (found_1) {
				System.out.printf("#%d %d%n", tc, case1_answer);
			}
			
			
			if (!found_1) {
				boolean found_2 = false;
				int case2_answer = Integer.MAX_VALUE;
				int[][] bcs = new int[2][2];
				start :
				for (int i = 0; i <31; i++) {
					out1:
					for (int j = 0; j <31; j++) {
						if (alreadyBuilt[i][j] == true) continue out1;
						bcs[0][0] = i;
						bcs[0][1] = j;
						for (int k = 0; k <31; k++) {
							out:
							for (int l = 0; l<31; l++) {
								if (alreadyBuilt[k][l] == true) continue out;
								if (k*31+l <=i*31+j) continue out;
								int sum = 0;
								bcs[1][0] = k;
								bcs[1][1] = l;
								
								for (int h = 0; h <N; h++) {
									int dist = getNearestDistance(homes[h], bcs);
									if (dist > homes[h][2]) continue out;
									sum += dist;
								}
								case2_answer = Math.min(case2_answer, sum);
								found_2 = true;
								if (sum == 75) {
									System.out.println("i: "+i);
									System.out.println("j: "+j);
									System.out.println("k: "+k);
									System.out.println("l: "+l);
									
								}
							}
						}
						
					}
				}
				
				if (!found_2) {
					System.out.printf("#%d %d%n", tc,-1);
				}
				if (found_2) {
					System.out.printf("#%d %d%n", tc, case2_answer);
				}
				
			}

		}
		sc.close();
		
	}
	
	
	public static int getDistance(int[] home, int[] bc) {
		return Math.abs(home[0] - bc[0]) + Math.abs(home[1] - bc[1]);
	}
	
	public static int getNearestDistance(int[] home, int[][]bcs) {
		int dist = Integer.MAX_VALUE;
		
		for (int i = 0; i < bcs.length; i++) {
			dist = Math.min(dist, getDistance(home,new int[] {bcs[i][0], bcs[i][1]}));
		}
		
		return dist;
	}
	
	
	

}
