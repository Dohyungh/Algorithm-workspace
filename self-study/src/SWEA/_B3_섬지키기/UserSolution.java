package SWEA._B3_섬지키기;

class UserSolution
{
	static int[][] map;
	static int N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public void init(int N, int mMap[][])
	{
		System.out.print(N + "\n");
		this.N = N;
		this.map = mMap;
		
	}
	
	public boolean isCandidate(int M, int mStructure[]) {
		
	}

	public int numberOfCandidate(int M, int mStructure[])
	{
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				dir:
				for (int dir = 0; dir < 4; dir++) {
					int val = map[i][j] + mStructure[0]; 
					int dx = dr[dir];
					int dy = dc[dir];
					for (int s = 0; s < M; s++) {
						int nr = i + dx * s;
						int nc = j + dy * s;
						if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue dir;
						if (map[nr][nc] + mStructure[s] != val) continue dir;
					}
					answer++;
					
					
				}
			}
		}
		return answer;
	}

	public int maxArea(int M, int mStructure[], int mSeaLevel)
	{
		
		return 0;
	}
}