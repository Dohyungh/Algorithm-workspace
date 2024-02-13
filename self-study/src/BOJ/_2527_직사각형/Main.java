package BOJ._2527_직사각형;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc<=4; tc++ ) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			
			System.out.println(solution(x1,y1,x2,y2,p1,q1,p2,q2));
		
		}
			

	}
	
	

	public static char solution(int x1,int y1,int x2,int y2,int p1,int q1,int p2,int q2) {
		char answer =' ';
		int minx = Math.min(x1,p1);
		int maxx = Math.max(x2, p2);
		
		int miny = Math.min(y1, q1);
		int maxy = Math.max(y2, q2);
		
		int[][] map = new int[maxx+1][maxy+1];
		
		x1 -= minx;
		y1 -= miny;
		x2 -= minx;
		y2 -= miny;
		p1 -= minx;
		q1 -= miny;
		p2 -= minx;
		q2 -= miny;
		
		
		for (int i = x1; i <=x2; i++) {
			for (int j = y1; j <= y2; j++) {
				map[i][j]++;
			}
		}
		for (int i = p1; i <= p2; i++) {
			for (int j = q1; j <= q2; j++) {
				map[i][j]++;
			}
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		boolean notLine = false;
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 2) {
					cnt++;
					int cnt2 = 0;
					for(int d = 0; d<4; d++) {
						if(map[i+dx[d]][j+dy[d]] ==2) {
							cnt2++;
						}
					}
					if (cnt2!=2) notLine = true;
					
				}
			}
		}
		
		for (int i = 0; i<map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		if (cnt ==0) answer = 'd';
		if (cnt ==1) answer = 'c';
		if (cnt >1 && notLine) answer = 'a';
		if (cnt >1 && !notLine ) answer = 'b';
		return answer;
		
		
		
	}
		

}
