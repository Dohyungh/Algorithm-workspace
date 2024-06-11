package BOJ._11437_LCA;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int parent;
        List<Node> child = new ArrayList<Node>();

        void setParent(int node) {
            this.parent = node;
        }

        int getParent() {
            return parent;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] tree = new Node[N+1];

        List[] adjList = new List[N+1];
        for (int i = 1; i < N+1; i++) {
            adjList[i] = new ArrayList<Integer>();
            tree[i] = new Node();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int de = Integer.parseInt(st.nextToken());
            adjList[no].add(de);
            adjList[de].add(no);
        }

        boolean[] visited = new boolean[N+1];

        BFS(tree, adjList, visited);

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int de = Integer.parseInt(st.nextToken());
            System.out.println(LCA(no,de,tree));

        }

    }

    private static void BFS(Node[] tree, List[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for(int i = 0; i < adjList[nowNode].size(); i++) {

                int nextNode = (int) adjList[nowNode].get(i);
                if(!visited[nextNode]) {
                    tree[nextNode].setParent(nowNode);
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }

            }
        }

    }

    private static int LCA(int no, int de, Node[] tree) {
        List<Integer> noList = getAncestors(no,tree);
        List<Integer> deList = getAncestors(de,tree);
        int noSize = noList.size();
        int deSize = deList.size();
        int answer = 1;

        for (int i = noSize-1, j = deSize-1; i>=0 || j>=0; i--,j--) {

            int noSide = i<0? noList.get(0) : noList.get(i);
            int deSide = j<0? deList.get(0) : deList.get(j);

            if (noSide != deSide) break;

            answer = noList.get(i);

        }
        return answer;
    }

    private static List<Integer> getAncestors(int node, Node[] tree) {
        List<Integer> ancestList = new ArrayList<Integer>();
        ancestList.add(node);
        while(node != 1) {
            int parent = tree[node].getParent();
            ancestList.add(parent);
            node = parent;
        }

        return ancestList;
    }
}
