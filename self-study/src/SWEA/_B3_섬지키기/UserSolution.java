package SWEA._B3_섬지키기;

import java.util.LinkedList;
import java.util.Queue;

class UserSolution
{
	static int[][] map;
	static int N;
	static int[] dr = {1, 0,-1,0};
	static int[] dc = {0, 1,0,-1};
	public void init(int N, int mMap[][])
	{
		this.N = N;
		this.map = mMap;
		
	}
	
	public boolean isCandidate(int M, int mStructure[], int dir, int inverse,  int i, int j) {
		int val = 0; 
		if (inverse == 0) {
			val = map[i][j] + mStructure[0];
		} else {
			val = map[i][j] + mStructure[M-1];
		}
		int dx = dr[dir];
		int dy = dc[dir];

		for (int s = 0; s < M; s++) {
			int nr = i + dx * s;
			int nc = j + dy * s;
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) return false;
			if (inverse == 0) {
				if (map[nr][nc] + mStructure[s] != val) return false;				
			}
			if (inverse == 1) {
				if (map[nr][nc] + mStructure[M-1-s] != val) return false;
			}
		}

		return true;
		
	}

	public int numberOfCandidate(int M, int mStructure[])
	{
		int answer = 0;
		for (int i = 0; i < N; i++) {	
			for (int j = 0; j < N; j++) {
				
				for (int dir = 0; dir < 2; dir++) {
					if(isCandidate(M, mStructure, dir,0, i, j) || isCandidate(M, mStructure, dir,1, i, j)) {
//						System.out.println(" i: " + i + " j: " + j + " dir: " + dir);
						answer++;
					}
				}
			}
		}
		if (M == 1) {
//			System.out.println("numberOfCandidate: " + answer/2);
			return answer/2;
		}
//		System.out.println("numberOfCandidate: " + answer);
		return answer;
	}

	public int getArea(int M, int mStructure[], int mSeaLevel)
	{
		int answer = 0;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			if (i == 0 || i == N-1) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] < mSeaLevel) queue.add(new int[] {i,j});
					visited[i][j] = true;
				}
				continue;
			}
			
			if (map[i][0] < mSeaLevel) queue.add(new int[] {i,0});
			if (map[i][N-1] < mSeaLevel) queue.add(new int[] {i,N-1});
			visited[i][0] = true;
			visited[i][N-1] = true;
			
		}
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			
			for(int dir = 0; dir < 4; dir ++) {
				int nr = node[0] + dr[dir];
				int nc = node[1] + dc[dir];
				
				if (nr >= 0 && nr <= N-1 && nc >=0 && nc <= N-1 && !visited[nr][nc] && map[nr][nc] < mSeaLevel) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
				
			}
			answer++;
		}
		return N*N - answer;
	}
	public int maxArea(int M, int mStructure[], int mSeaLevel) {
		int answer = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int dir = 0; dir < 2; dir++) {
					for (int inverse = 0; inverse < 2; inverse++) {
						
						if (isCandidate(M, mStructure, dir,inverse, i, j)) {
							flag = true;
//							System.out.println("candidate: " + " i: " + i + " j: " + j + " dir: " + dir);
							
							if (inverse == 0) {
								
								for (int s = 0; s < M; s++) {
									map[i+s*dr[dir]][j+s*dc[dir]] = map[i+s*dr[dir]][j+s*dc[dir]] + mStructure[s];
//									System.out.println(map[i+s*dr[dir]][j+s*dc[dir]]);
								}
								answer = Math.max(answer, getArea(M, mStructure, mSeaLevel));
								
								for (int s = 0; s < M; s++) {
									map[i+s*dr[dir]][j+s*dc[dir]] = map[i+s*dr[dir]][j+s*dc[dir]] - mStructure[s];
								}
							} else {
								for (int s = 0; s < M; s++) {
									map[i+s*dr[dir]][j+s*dc[dir]] = map[i+s*dr[dir]][j+s*dc[dir]] + mStructure[M-1-s];
//									System.out.println(map[i+s*dr[dir]][j+s*dc[dir]]);
								}
								answer = Math.max(answer, getArea(M, mStructure, mSeaLevel));
								
								for (int s = 0; s < M; s++) {
									map[i+s*dr[dir]][j+s*dc[dir]] = map[i+s*dr[dir]][j+s*dc[dir]] - mStructure[M-1-s];
								}
							}
							
						}
					}
				}
			}
		}
		if (flag) {
//			System.out.println("maxArea: " + answer);			
		} else {
//			System.out.println("후보가 없었습니다.");
		}
		return flag? answer : -1;
	}
}