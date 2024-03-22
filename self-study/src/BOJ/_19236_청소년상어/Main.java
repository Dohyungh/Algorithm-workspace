package BOJ._19236_청소년상어;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	
	static int answer = 0;
	

	
	public static void main(String[] args) {
		
		// 복잡시럽다
		
		Scanner sc = new Scanner (System.in);
		
		// 4by4 고정 사이즈
		// 16마리 물고기 고정
		
		int[][] fishes = new int[16][3]; // r, c, dir
		int[] shark = new int[3]; // r, c, dir
		
		int n = 0; // 이건 입력받는 순서이자, Map을 쭉 늘어뜨렸을때의 좌표가 됨
		int eaten = 0;
		while (n <16) { //16개를 입력받을 건데
			int i = sc.nextInt()-1; // 이게 물고기 번호 = fishes 배열에서 index
			
			fishes[i][0] = n /4; // 행번호로 변환
			fishes[i][1] = n %4; // 열번호로 변환
			fishes[i][2] = sc.nextInt()-1;
			
			if(n == 0) { 
				
				fishes[i][0] = -1; // -1로 이 물고기 (i 번째) 가 먹혔음을 나타내주자
				fishes[i][1] = -1;
				
				shark[2] = fishes[i][2]; // 방향은 저장하고!
				fishes[i][2] = -1; // 방향도 그냥 확실하게 -1로 바꿔주자
				eaten += i+1;
			}
			
			n++;
		}

		moveShark(fishes,shark,eaten);
		System.out.println(answer);
		sc.close();
	}
	

	
	
	public static int[][] moveFishes(int[][] fishes, int[] shark) {
		for (int i = 0; i<16; i++) { // 모든 물고기에 대해서
			
			if (fishes[i][0] == -1) continue; // 먹힌 물고기면 pass
			
			int cnt = 0; // 최대 8방향을 다 돌아야 갈 수 있는 자리가 나올 수 있음.
			out:
			while(cnt <=7) {
				int dir = fishes[i][2];
				int r = fishes[i][0];
				int c = fishes[i][1];
				
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !(nr == shark[0] && nc == shark[1])) {
					for (int j = 0; j < 16; j++) {
						//내가 가고 싶은 자리에 물고기가 있을 경우
						if (fishes[j][0] == nr && fishes[j][1] == nc) {
							
							// 자리만 스왑 (방향은 스왑하면 안됨!!)
							int tempI = fishes[j][0];
							int tempJ = fishes[j][1];
							
							fishes[j][0] = fishes[i][0];
							fishes[j][1] = fishes[i][1];
							
							fishes[i][0] = tempI;
							fishes[i][1] = tempJ;
							
							break out;
						}
					}
					//내가 가고 싶은 자리에 물고기가 없고, 빈 자리일 경우에는 그냥 가면 된다.
					fishes[i][0] = nr;
					fishes[i][1] = nc;
					break out;
					
				} else {
					// 경계를 벗어나거나 상어자리라면 방향을 반시계로 45도 회전
					fishes[i][2] = (dir +1) % 8;
					cnt++;
				}
			}
		}
		return fishes;
	}
	
	
	public static void moveShark(int[][] fishes, int[] shark, int eaten) {
		
		// 맵을 여러방향으로 갖고 내려가야 해서 non-static
		fishes = moveFishes(fishes, shark);

		int sharkR = shark[0];
		int sharkC = shark[1];
		int sharkDir = shark[2];
		
		List<Integer> candidates = new ArrayList<>();
		
		out:
		for (int k = 1; k <= 3; k++) { // 맵이 4by4라 전진 할 수 있는 칸은 최대 3칸!
			int nr = sharkR + k*dr[sharkDir];
			int nc = sharkC + k*dc[sharkDir];
			
			if(nr >= 0 && nr <4 && nc >= 0 && nc <4) {
				for (int i = 0; i <16; i++) {
					if (fishes[i][0] == nr && fishes[i][1] == nc) {
						// 그 자리에 물고기(i번째)가 있다면,
						// 후보에 추가
						candidates.add(i);
						continue out;
					}
				}
			}
		}
		
		if(candidates.size() == 0) { // 먹을 수 있는 물고기를 찾지 못했으면
			answer = Math.max(answer, eaten);
			return;
		}
		
		for (int i = 0; i < candidates.size(); i++) {
			
			// 물고기 배열을 복사해서 넘겨주거나
			int[][] tempFishes = new int[16][3];
			for(int j = 0; j < 16; j++) {
				tempFishes[j] = Arrays.copyOf(fishes[j], fishes[j].length);
			}
			
			shark[0] = tempFishes[candidates.get(i)][0];
			shark[1] = tempFishes[candidates.get(i)][1];
			shark[2] = tempFishes[candidates.get(i)][2];
			tempFishes[candidates.get(i)] = new int[] {-1,-1,-1};
			moveShark(tempFishes, shark, eaten+candidates.get(i)+1);
			
			// 이 밑에 다시 restore ( 안먹었지롱~) 해주거나.
		}
	}

}
