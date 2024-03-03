package SWEA._모의_점심식사시간;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static boolean[][] cases;
	static int final_answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <=T; tc++) {
			final_answer = Integer.MAX_VALUE;
			int N = sc.nextInt(); // 방 크기
			
			int[][] map = new int[N][N];
			
			for (int i =0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int numP = 0;
			int qs = 0;
			int[] queue1Coord = new int[2];
			int[] queue2Coord = new int[2];
			
			for (int i =0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					if (map[i][j] ==1) numP++;
					if (map[i][j] !=1 && map[i][j] != 0) {
						if (qs==0) {
							queue1Coord[0] = i;
							queue1Coord[1] = j;
							qs++;
						} else {
							queue2Coord[0] = i;
							queue2Coord[1] = j;
						}
					}
				}
			}
			
			int[][] people = new int[numP][2];
			int temp = 0;
			for (int i =0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					if (map[i][j] ==1) {
						people[temp][0] = i;
						people[temp][1] = j;
						temp++;
						
					}
				}
			}
			
			int[][] distMatrix = new int[2][numP]; // 0행 q1, 1행 q2
			for (int i = 0 ; i < numP; i++) {
				distMatrix[0][i] = getDistance(queue1Coord, people[i]);
			}
			for (int i = 0 ; i < numP; i++) {
				distMatrix[1][i] = getDistance(queue2Coord, people[i]);
			}
			
			Queue<Integer> queue1Arrival = new LinkedList<>();
			Queue<Integer> queue2Arrival = new LinkedList<>();
			
			
			int q1len = map[queue1Coord[0]][queue1Coord[1]];
			int q2len = map[queue2Coord[0]][queue2Coord[1]];
			
			
			for (int i = 0; i < (1<<numP); i++) {
				List<Integer> arrival1 = new ArrayList<>();
				List<Integer> arrival2 = new ArrayList<>();
				
				for (int j = 0; j < numP; j++) {
					if ((i & (1<<j)) >0) {
						arrival1.add(distMatrix[0][j]+1);
					} else {
						arrival2.add(distMatrix[1][j]+1);
						
					}
				}
				Collections.sort(arrival1);
				Collections.sort(arrival2);
				
				for (int k = 0; k <arrival1.size(); k++) {
					queue1Arrival.add(arrival1.get(k));
				}
				for (int k = 0; k <arrival2.size(); k++) {
					queue2Arrival.add(arrival2.get(k));
				}
				
				int q1End = getFinishTime(queue1Arrival, q1len);
				int q2End = getFinishTime(queue2Arrival, q2len);
				int finishtime = Math.max(q1End, q2End);
				
				final_answer = Math.min(final_answer, finishtime);
				
			}

			System.out.printf("#%d %d%n", tc, final_answer);

		}
		
		
		sc.close();
		
		
	}
	
	public static int getDistance(int[] queueCoord, int[] person) {
		return Math.abs(queueCoord[0]-person[0]) +Math.abs(queueCoord[1]-person[1]);
	}
	
	public static int getFinishTime(Queue<Integer> queueArrival, int qlen) {
		
		Queue<Integer> queue = new LinkedList<Integer>();

		int time = 0;
		while (true) {
			if (queueArrival.isEmpty()) break;
			while(!queue.isEmpty()&&time >= queue.peek()) {
				queue.poll();
			}
			while (!queueArrival.isEmpty() &&time >= queueArrival.peek()&& queue.size()<3) {		
				queueArrival.poll();
				queue.add(time+qlen);
				
			}

			time++;
		}
	
		int answer = 0;
		
		//점심 나갈거 같애
//		System.out.println(queue.size());
//		for (int i = 0; i < queue.size(); i++) {
//			answer = queue.poll();
//		}
		
		while(!queue.isEmpty()) {
			answer = queue.poll();
		}
		return answer;

	}

}

