package SWEA._모의_차량정비소;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			//시뮬
			//초단위
			
			//창구 번호 ,고객번호 1 부터
			
			// 0번 더미
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int[] a = new int[N+1];
			int[] b = new int[M+1];
			
			for (int i = 1; i<a.length; i++) {
				a[i] = sc.nextInt();
			}
			
			for (int i = 1; i<b.length; i++) {
				b[i] = sc.nextInt();
			}
			
			int[] arrival = new int[K+1];
			for (int i =1; i< K+1; i++) {
				arrival[i] = sc.nextInt();
			}
			
			
//			System.out.println(Arrays.toString(a)); // 0, 5
//			System.out.println(Arrays.toString(b)); // 0, 7
//			System.out.println(Arrays.toString(arrival)); // 7, 10
			
			int time = 0;
			
			Queue<Integer> recepQ = new LinkedList<>();
			Queue<Integer> repairQ = new LinkedList<>();
			
			int[] endTimeRecep = new int[N+1];
			int[] endTimeRepair = new int[M+1];
			
			int[] recep = new int[N+1];
			int[] repair = new int[M+1];
			
			int answer = -1;
			
			//문제를 잘못이해함
//			boolean[] found = new boolean[K+1];
			int[][] used = new int[K+1][2];
			
			
			while (true) {
				//break
//				System.out.println(recepQ);
//				System.out.println(repairQ);
				
				
				
				for (int i = 1; i < N+1; i++) {
					if (endTimeRecep[i] == time && time!=0) {
						repairQ.add(recep[i]);
//						System.out.println("add: " +recep[i]);
						recep[i] = 0;
						endTimeRecep[i] = 0;
					}
					
				}
				
				for (int i =1; i < M+1; i++) {
					if (endTimeRepair[i] == time) {
						repair[i] = 0;
						endTimeRepair[i] = 0;
					}
				}
				
				
				// 손님온 부분
				for (int i=1; i <K+1; i++) {
					if (time == arrival[i]) {
						recepQ.add(i);
//						System.out.println("손님왔다: " + time);
					}
				}
				
				while (!recepQ.isEmpty()) {
					boolean full = true;
					for (int i = 1; i < N+1; i++) { // i 가 창구번호
						if (recep[i] ==0) {
							int cusNum = recepQ.poll();
							recep[i] = cusNum; // 손님번호
							endTimeRecep[i] = time+a[i];
							used[cusNum][0] = i;
//							System.out.println(time+ " recep 입력:"+cusNum+" "+ i);
							full = false;
							break;
						}
						
					}
					if (full) break;
				}
				while (!repairQ.isEmpty()) {
					boolean full = true;
					for (int i = 1; i < M+1; i++) {
						if (repair[i] ==0) {
							int cusNum = repairQ.poll();
							repair[i] = cusNum; // 손님번호
							endTimeRepair[i] = time+b[i];
							used[cusNum][1] = i;
//							System.out.println(time+" repair 입력:"+cusNum+" "+ i);
							full = false;
							break;
						}
						
					}
					if (full) break;
				}
				
				time++;
				
				int sum = 0;
				for (int i = 1; i < N+1; i++) {
					sum += recep[i];
					
				}
				for (int j = 1; j < M+1; j++) {
					sum += recep[j];
				}
				if (time > arrival[K] && sum ==0 &&recepQ.isEmpty() && repairQ.isEmpty()) break;
			}
			
			
			for (int i = 0; i < used.length; i++) {
//				System.out.println(Arrays.toString(used[i]));
				if (used[i][0] == A && used[i][1] == B) {
					answer = Math.max(answer, 0);
					answer += i;
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
			
		}
		
	}

}
