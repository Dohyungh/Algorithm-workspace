package SWEA._모의_점심식사시간;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {
	
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <=T; tc++) {
			int N = sc.nextInt();
			answer = Integer.MAX_VALUE;
			int numP = 0;
			int[][] map = new int[N][N];
			
			int[] queueTime = new int[2];
			int[][] queueLoc = new int[2][2];
			int idx = 0;
			
			for (int i = 0 ; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt(); 
					if (map[i][j]==1) numP++;
					if (map[i][j]>1) {
						queueTime[idx] = map[i][j];
						queueLoc[idx][0] = i;
						queueLoc[idx][1] = j;
						idx++;
					}
					
				}
			}
			
			int[][] people = new int[numP][2];
			idx = 0;
			for (int i = 0 ; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] ==1) {
						people[idx][0] = i;
						people[idx][1] = j;
						idx++;
					}
				}
			}
			
			int[][] arrival = getArrival(people,queueLoc);
			
			solve(arrival, queueTime);
			System.out.printf("#%d %d%n", tc, answer);
			
		}
		
	}
	
	private static void solve(int[][] arrival, int[] queueTime) {
		
		// 모든 경우에 대해
		for (int i = 0; i< (1<<arrival.length); i++) {
			// 각 사람이
			List<Integer> arrivalTime = new ArrayList<Integer>();
			List<Integer> arrivalTime2 = new ArrayList<Integer>();
			
			for (int j = 0; j < arrival.length; j++) {
				if ((i & 1<<j) > 0) {
					arrivalTime.add(arrival[j][0]);
				} else {
					arrivalTime2.add(arrival[j][1]);
				}
			}
			
			int ans1 = getEndTime(arrivalTime, queueTime[0]);
			int ans2 = getEndTime(arrivalTime2, queueTime[1]);
			
			answer = Math.min(answer, Math.max(ans1, ans2));
			
		}
		
	}

	private static int[][] getArrival(int[][] people, int[][] queueLoc) {
		
		int[][] arrival = new int [people.length][2];
		
		for (int q = 0; q < 2; q++) {
			for (int i = 0; i < people.length; i++) {
				arrival[i][q] = Math.abs(people[i][0] - queueLoc[q][0]) + Math.abs(people[i][1] - queueLoc[q][1]) +1;
			}
			
		}
		return arrival;
		
	}

	// 1추가해서 받아라
	public static int getEndTime(List<Integer> arrivalTime, int K) {
		Collections.sort(arrivalTime);
		
		int numP = arrivalTime.size();
		if (numP == 0) return 0;
		
		Queue<Integer> queue = new LinkedList<>();
		int tiktok = arrivalTime.get(0);
		
		while(true) {
			
			
			while(!queue.isEmpty() &&(queue.peek() <= tiktok)) queue.poll();

			while(!arrivalTime.isEmpty()&& arrivalTime.get(0) <= tiktok && queue.size() <3) {
				queue.add(tiktok + K);
				arrivalTime.remove(0);
			}		
			if (arrivalTime.isEmpty()) break;
			tiktok++;
		}
		
		int endTime = 0;
		while(!queue.isEmpty()) endTime = queue.poll();
		
		return endTime;
	};

}
