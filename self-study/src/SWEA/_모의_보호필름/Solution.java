package SWEA._모의_보호필름;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
public class Solution {
     
    // 이게 어떻게 시간초과야
     
    static List<int[]> cases;
    static int answer;
    static int K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1;  tc <= T; tc++) {
            int D = sc.nextInt();
            int W = sc.nextInt();
            K = sc.nextInt();
             
            int[][] map = new int[D][W];
             
            for (int i = 0; i<D; i++) {
                for (int j = 0; j<W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            if (check(map, K)) {
                System.out.printf("#%d %d%n", tc, 0);
                continue;
            }
            cases = new ArrayList<int[]>();
            boolean[] visit = new boolean[D];
            answer = K;
            for (int i = K; i>=1; i--) {
            	
            	getCases(0, i, D, visit, 0,map);
            }
             
             
 
            System.out.printf("#%d %d%n", tc, answer);
        }
    }
     
    private static int[][] fill(int[] aCase, int[][] tempMap) {
         
         
        for (int i = 0; i < aCase.length; i++) {
            if (aCase[i] != -1) {
                for (int j = 0; j <tempMap[0].length; j++) {
                    tempMap[i][j] = aCase[i];
                }
                 
            }
        }
        return tempMap;
    }
 
    public static boolean check(int[][] map, int K) {
        int D = map.length;
        int W = map[0].length;
         
        boolean answer = true;
        for (int i = 0; i <W; i++) {
            boolean found = false;
            out:
            for (int j = 0; j <=D-K; j++) {
                int now = map[j][i];
                for (int k = 0; k <K; k++) {
                    if (map[j+k][i] != now) continue out;
                }
                found = true;
            }
            if (!found) {
                answer = false;
                break;
            }
        }
         
        return answer;
         
             
    }
     
    public static void getCases(int depth,int r,int D, boolean[] visit, int start, int[][] map) {
        if (depth ==r && depth <answer) {
        	int[] indexes = new int[r];
        	int idx = 0;
        	for (int i = 0; i < visit.length; i++) {
        		if (visit[i]) {
        			indexes[idx] = i;
        			idx++;
        		}
        	}
        	


            int[] output = new int[visit.length];
            for (int i = 0; i < output.length; i++) {
                output[i] = -1;
            }
            getDetailCases(0,output,map,indexes);
            return;
                 

        }
        //visit은 D사이즈
        for (int i = start; i <D; i++) {
            if (!visit[i] && depth <answer) {
                visit[i] = true;
                getCases(depth+1,r,D,visit,start+1,map);
                visit[i] = false;
            }
        }
        
         
         
    }
 
    private static void getDetailCases(int idx, int[] output, int[][] map, int[] indexes) {
        if (idx >= indexes.length && indexes.length < answer) {
             
            int[][] tempMap = new int[map.length][];
            for (int i = 0;i<map.length; i++) {
                tempMap[i] = Arrays.copyOf(map[i], map[i].length);
            }
             
            tempMap = fill(output, tempMap);
//        	System.out.println(Arrays.toString(output));
        	
            if (check(tempMap,K)) {
                int cnt = 0;
                for (int x = 0; x < output.length; x++) {
                    if (output[x] != -1) cnt++;
                }
                answer = Math.min(answer, cnt);
                 
            }
            return;
        }
         
        if (indexes.length < answer) {
        	
        	output[indexes[idx]] = 1;
        	getDetailCases(idx+1,output,map,indexes);
        	output[indexes[idx]] = 0;
        	getDetailCases(idx+1,output,map,indexes);
        }

        

         
         
         
         
    }
 
}