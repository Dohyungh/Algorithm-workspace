package SWEA._모의_등산로조성;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
public class Solution {
    static int final_answer = 0;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for (int tc = 1; tc <=T; tc++) {
            final_answer = 0;
            int N = sc.nextInt();
            int K = sc.nextInt();
             
            int[][] map = new int[N][N];
             
            for (int i = 0 ; i<N; i++) {
                for (int j = 0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
             
            List<Integer> peaks = new ArrayList<Integer>();
            peaks = getPeak(map);
            
            if (peaks.size() ==1) {
            	
            	for (int i =0; i <=K; i++) {
                	
                    int[][] tmp = new int[N][N];
                    for (int j = 0; j < N; j++) {
                        tmp[j] = Arrays.copyOf(map[j], N);
                    }
                    
                    for (int a = 0; a< N; a++) {
                        for (int b = 0; b <N; b++) {
                        	
                            tmp[a][b] -= i;
                            if(peaks.get(0)==N*a +b) tmp[a][b] += i; 
                            
                            boolean[][] adj;
                            
                            adj = getAdj(N,tmp);
                            
                            
                             
                            boolean[] visited = new boolean[N*N];
                             
                            for (int j = 0; j < peaks.size(); j++) {
                                DFS(peaks.get(j), adj, 1, visited);
                            }

                            tmp[a][b] += i;
                            if(peaks.get(0)==N*a +b) tmp[a][b] -= i; 
                        }
                    }
                     
                     
                     
                     
                }
            	System.out.printf("#%d %d%n", tc, final_answer);
            	continue;
            	
            }
            else {
            	
            	for (int i =0; i <=K; i++) {
            		
            		int[][] tmp = new int[N][N];
            		for (int j = 0; j < N; j++) {
            			tmp[j] = Arrays.copyOf(map[j], N);
            		}
            		
            		for (int a = 0; a< N; a++) {
            			for (int b = 0; b <N; b++) {
            				tmp[a][b] -= i;
            				
            				boolean[][] adj;
            				
            				adj = getAdj(N,tmp);
            				
            				
            				
            				boolean[] visited = new boolean[N*N];
            				
            				for (int j = 0; j < peaks.size(); j++) {
            					DFS(peaks.get(j), adj, 1, visited);
            				}
            				
            				tmp[a][b] += i;
            			}
            		}
            	}
            	
            	System.out.printf("#%d %d%n", tc, final_answer);
            	continue;
            }
             
             
             
             
             
             
             
             
        }
         
    }
     
    public static List<Integer> getPeak (int[][] map) {
        int N = map.length;
        List<Integer> list = new ArrayList<Integer>();
        int max = 0;
        for (int i = 0; i< N; i++) {
            for (int j =0; j <N; j++) {
                if (map[i][j] > max) max = map[i][j];
            }
        }
        for (int i = 0; i< N; i++) {
            for (int j =0; j <N; j++) {
                if (map[i][j] == max) list.add(i*N+j);
            }
        }
         
        return list;
    }
     
    public static void DFS(int start, boolean[][] adj, int depth, boolean[] visited) {
        int N = visited.length;
        boolean end = true;
         
        for (int i = 0; i< N; i++) {
            if (adj[start][i] && !visited[i]) {
                end = false;
            }
        }
         
        if (end) {
            final_answer = Math.max(final_answer, depth);
            return;
        }
         
        if (!end) {
            for (int i = 0; i< N; i++) {
                if (adj[start][i] && !visited[i]) {
                    visited[i] = true;
                    DFS(i, adj, depth+1,visited);
                    visited[i] = false;
                }
            }   
        }
         
         
    }
     
    public static boolean[][] getAdj (int N, int[][] map) {
        boolean[][] adj = new boolean[N*N][N*N];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        // 인접행렬 업데이트
        
        for (int i = 0; i<N; i++) {
            for (int j = 0; j< N; j++) {
                int index = i*N +j;
                for (int d = 0; d < 4; d++) {
                    int nr = i +dr[d];
                    int nc = j +dc[d];
                    if (nr >=0 && nr <N && nc >=0 && nc <N) {
                         
                        if (map[i][j] > map[nr][nc]) {
                            if (d ==0) {
                                adj[index][index-N] = true;
                            }
                            if (d ==1) {
                                adj[index][index+N] = true;
                            }
                            if (d ==2) {
                                adj[index][index-1] = true;
                            }
                            if (d ==3) {
                                adj[index][index+1] = true;
                            }
                             
                        }
                    }
                }
                 
            }
        }
         
        return adj;
    }
 
}