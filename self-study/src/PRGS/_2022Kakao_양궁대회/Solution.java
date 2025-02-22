package PRGS._2022Kakao_양궁대회;


class Solution {
	static int[] answer;
	static boolean found = false;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        
        boolean[] toRian = new boolean[11];
        
        solve(n, info, toRian, 0);
        
        
        if (!found) return new int[] {-1};
        return answer;
    }
    static int maxGap = -1;
    void solve(int n, int[] info, boolean[] toRian, int idx) {
    	
    	if (idx == 11) {
    		int cnt = 0;
    		
    		for (int i = 0; i < 11; i++) {
    			if (toRian[i]) {
    				if (info[i] == 0) cnt++;
    				else cnt += info[i] +1;
    			}
    		}
    		

    		int rian = 0;
    		int apeache = 0;
    		
    		if (cnt <= n) {
    			for (int i = 0; i < 11; i++) {
    				if (toRian[i]) rian += 10 - i;
    				else if (info[i] != 0) apeache += 10 - i;
    			}
    			
    			if (rian > apeache && rian- apeache >= maxGap) {
    				if (rian- apeache == maxGap) {
    					
	    				int firstAnswer = 11;
	    				int firstRian = 11;
	    				for (int i = 10; i >= 0; i--) {
	    					if (answer[i] != 0) {
	    						firstAnswer = i;
	    						break;
	    					}    					
	    				}
	    				
	    				for (int i = 10; i >= 0; i--) {
	    					if (toRian[i]) {
	    						firstRian = i;
	    						break;
	    					}
	    				}
	    				if (firstRian < firstAnswer) return;
    				}
    				

    				found = true;
    				for (int i = 0; i < 11; i++) {
    					if (toRian[i] && info[i] == 0) {
    						answer[i] = 1;
    					}
    					if (toRian[i] && info[i] != 0) {
    						answer[i] = info[i] + 1;
    					}
    					if (!toRian[i]) {
    						answer[i] = 0;
    					}
    					if (cnt < n && i == 10) {
    						answer[i] = n - cnt;
    					}
    				}
    				maxGap = rian - apeache;
    			}
    			
    		}
    		
    		return;
    	}
    	

    	toRian[idx] = true;
    	solve(n,info,toRian, idx+1);
    	
    	
    	toRian[idx] = false;
    	solve(n,info,toRian, idx+1);
    }
}