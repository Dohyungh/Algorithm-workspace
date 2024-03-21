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
		int[] shark = new int[3];
		
		int idx = 0;
		int eaten = 0;
		while (idx <16) {
			int i = sc.nextInt()-1;
			
			
			fishes[i][0] = idx /4;
			fishes[i][1] = idx %4;
			fishes[i][2] = sc.nextInt()-1;
			
			if(idx == 0) {
				
				fishes[i][0] = -1;
				fishes[i][1] = -1;
				
				shark[2] = fishes[i][2];
				fishes[i][2] = -1;
				eaten += i+1;
			}
			
			idx++;
		}
		
		
		
		moveShark(fishes,shark,1);
		System.out.println(answer);
	}
	

	
	
	public static int[][] moveFishes(int[][] fishes, int[] shark) {
		for (int i = 0; i<16; i++) { // 모든 물고기에 대해서
			if (fishes[i][0] == -1) continue; 
			int cnt = 0;
			out:
			while(cnt <=7) {
//				System.out.println("여기요");
//				System.out.println(i);
				int dir = fishes[i][2];
				int r = fishes[i][0];
				int c = fishes[i][1];
				
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !(nr == shark[0] && nc == shark[1])) {
					for (int j = 0; j < 16; j++) {
						if (fishes[j][0] == nr && fishes[j][1] == nc) {
							int tempI = fishes[j][0];
							int tempJ = fishes[j][1];
							int tempDir = fishes[j][2];
							
							fishes[j][0] = fishes[i][0];
							fishes[j][1] = fishes[i][1];
							fishes[j][2] = fishes[i][2];
							
							fishes[i][0] = tempI;
							fishes[i][1] = tempJ;
							fishes[i][2] = tempDir;
							
							
							break out;
						}
					}
					fishes[i][0] = nr;
					fishes[i][1] = nc;
					break out;
					
				} else {
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
		
		int[][] tempFishes = new int[16][3];
		for(int i = 0; i < 16; i++) {
			tempFishes[i] = Arrays.copyOf(fishes[i], fishes[i].length);
		}
		
		for(int i = 0; i < 16; i++) {
			System.out.println(Arrays.toString(tempFishes[i]));
		}
		System.out.println();
		
		System.out.println(Arrays.toString(shark));
		System.out.println();
		System.out.println(answer);
		int sharkR = shark[0];
		int sharkC = shark[1];
		int sharkDir = shark[2];
		
		List<Integer> candidates = new ArrayList<>();
		
		out:
		for (int k = 1; k <= 3; k++) {
			int nr = sharkR + dr[sharkDir];
			int nc = sharkC + dc[sharkDir];
			
			if(nr >= 0 && nr <4 && nc >= 0 && nc <4) {
				for (int i = 0; i <16; i++) {
					if (tempFishes[i][0] == nr && tempFishes[i][1] == nc) {
						candidates.add(i);
						continue out;
					}
				}
			}
			
		}
		
		if(candidates.size() == 0) {
			answer = Math.max(answer, eaten);
			return;
		}
		
		for (int i = 0; i < candidates.size(); i++) {
			shark[0] = tempFishes[candidates.get(i)][0];
			shark[1] = tempFishes[candidates.get(i)][1];
			shark[2] = tempFishes[candidates.get(i)][2];
			tempFishes[candidates.get(i)] = new int[] {-1,-1,-1};
			moveShark(tempFishes, shark, eaten+candidates.get(i)+1);
			
			
		}
		
		
		
		
	}

}
