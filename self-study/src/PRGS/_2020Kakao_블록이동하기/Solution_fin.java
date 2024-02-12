package PRGS._2020Kakao_블록이동하기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_fin {
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}};
		System.out.println(solution(board));
		
	}
	
    public static int solution(int[][] board) {
    	int answer = 0;
    	
        int N = board.length;
        
        int numNodes = N*N - N;
        
        int[][] hor_nodes = new int[N][N-1]; 
        int[][] ver_nodes = new int[N-1][N]; 
        
        int[][] adj = new int[2*numNodes][2*numNodes];
        
        
        
        
        // 노드 생성
        for (int i = 0; i<N; i++) { 
        	for (int j = 0; j<N-1; j++) {
        		if (board[i][j]==0 && board[i][j+1]==0) hor_nodes[i][j] = 1;
        	}
        }
        for (int i = 0; i<N-1; i++) { 
        	for (int j = 0; j<N; j++) {
        		if (board[i][j]==0 && board[i+1][j]==0) ver_nodes[i][j] = 1;
        	}
        }
        
        
        
        
        // 인접행렬 생성
        for (int i = 0 ; i<N; i++) { 
        	for (int j = 0; j<N-1; j++) { 
        		if (hor_nodes[i][j] ==1) { 
        			
	        		int adjIndex = (N-1)*i + j; 
	        		
	        		if (i>0 && hor_nodes[i-1][j]==1) adj[adjIndex][adjIndex-(N-1)] = 1; 
	        		if (i<N-1 && hor_nodes[i+1][j]==1) adj[adjIndex][adjIndex+(N-1)] = 1;
	        		if (j>0 && hor_nodes[i][j-1]==1) adj[adjIndex][adjIndex-1] =1; 
	        		if (j<N-2 && hor_nodes[i][j+1]==1) adj[adjIndex][adjIndex+1] = 1; 
	        		
	        		
	        		if (i>0 && ver_nodes[i-1][j+1]==1) adj[adjIndex][numNodes+(i-1)*N+j] = 1; 
	        		if (i>0 && ver_nodes[i-1][j]==1) adj[adjIndex][numNodes+(i-1)*N+j+1] = 1; 
	        		if (i<N-1 && ver_nodes[i][j+1]==1) adj[adjIndex][numNodes+i*N+j] = 1; 
	        		if (i<N-1 && ver_nodes[i][j]==1) adj[adjIndex][numNodes+i*N+j+1] = 1; 
        		}
        	}
        }
        
        for (int i = 0 ; i<N-1; i++) {
        	for (int j = 0; j<N; j++) { 
        		if (ver_nodes[i][j] ==1) {
        			
	        		int adjIndex = numNodes + N*i + j;
	        		
	        		if (i>0 && ver_nodes[i-1][j]==1) adj[adjIndex][adjIndex-N] = 1;
	        		if (i<N-2 && ver_nodes[i+1][j]==1) adj[adjIndex][adjIndex+N] = 1; 
	        		if (j>0 && ver_nodes[i][j-1]==1) adj[adjIndex][adjIndex-1] =1; 
	        		if (j<N-1 && ver_nodes[i][j+1]==1) adj[adjIndex][adjIndex+1] = 1; 
	        		

        		}	
        	}
        }
        
        //대칭성!
        for(int i = numNodes; i<adj.length; i++) { 
        	for (int j = 0; j<numNodes; j++) {
        		adj[i][j] = adj[j][i];
        	}
        }
        
        // BFS
        answer = BFS(0,adj,numNodes);
    
        return answer;
    }
    

    public static int BFS(int start, int[][] adj, int numNodes) { 
    	Queue<Integer> queue = new LinkedList<>();
    	int pNode = start;
    	int depth = 1;
    	
    	// visited 배열 필요 없음!!

    	boolean[] added = new boolean[adj.length]; 
    	added[start] = true; 
    	for (int j = 0; j<adj.length; j++) {
    		if (adj[pNode][j] == 1) {
    			queue.add(j);
    			added[j] = true;
    		}
    	}

    	int sz = queue.size(); 

    	out:
    	while (!queue.isEmpty()) { 
    		
    		for (int num = 0; num<sz; num++) { 
    			
    			pNode = queue.poll();  
    			
    			for (int j = 0; j < adj.length; j++) { 
    				
    				if (adj[pNode][j] ==1 && !added[j]) {
    					queue.add(j); 
    					added[j] = true;
    				}
    				if (adj[pNode][j] == 1 && (j == numNodes-1 || j == 2*numNodes-1)) { 
    					depth++;
    					break out;
    				}
    			}
    		}
    		
    		sz = queue.size(); 
    		depth++;
    	
    	}
    	return depth;

    	
    }
    
}

