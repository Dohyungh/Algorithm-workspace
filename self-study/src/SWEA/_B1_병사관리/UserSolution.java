package SWEA._B1_병사관리;

import java.util.ArrayList;
import java.util.List;

class UserSolution
{
	
	int[][] soldiers;
	List<Integer>[] teams;
	
	public void init()
	{
		soldiers = new int[100001][3];
		
		teams = new ArrayList[6];
		for (int i =1; i< 6; i++) {
			teams[i] = new ArrayList<Integer>();
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		soldiers[mID][0] = mID;
		soldiers[mID][1] = mTeam;
		soldiers[mID][2] = mScore;
		
		teams[mTeam].add(mID);
		
	}
	
	public void fire(int mID)
	{
		int team = soldiers[mID][1]; 
		soldiers[mID][0] = 0;
		soldiers[mID][1] = 0;
		soldiers[mID][2] = 0;
		
		for (int i = 0; i < teams[team].size(); i++) {
			if (teams[team].get(i) == mID) {
				teams[team].remove(i);
//				System.out.println(mID+"번을 지웠습니다.");
				break;
			}
		}
	}

	public void updateSoldier(int mID, int mScore)
	{
		soldiers[mID][2] = mScore;
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		for (int i = 0; i < teams[mTeam].size(); i++) {
			
			int mID = teams[mTeam].get(i);
			
			int val = soldiers[mID][2] + mChangeScore;
			
			if (val > 5) val = 5;
			if (val < 1) val = 1;
			
			soldiers[mID][2] = val;
		}
	}
	
	public int bestSoldier(int mTeam)
	{
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;
		
		for (int i = 0; i < teams[mTeam].size(); i++) {
			int mID = teams[mTeam].get(i);
//			System.out.println(mID);
//			System.out.println(soldiers[mID][2]);
//			System.out.println();
			if (soldiers[mID][2] > max) {
				max = soldiers[mID][2];
				maxIdx = mID;
			} else if (soldiers[mID][2] == max && mID > maxIdx) {
				maxIdx = mID;
			}
 		}
//		System.out.println(maxIdx);
		
		return maxIdx;
	}
}