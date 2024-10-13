package BOJ._1477_휴게소세우기;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Node implements Comparable<Node>{
        int length;
        int count;

        Node(int length, int count) {
            this.length = length;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.length == o.length) return o.count - this.count;
            return o.length - this.length;
        }

        @Override
        public String toString() {
            return "Node[ length: " + this.length + " count: " + this.count + " ] ";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        if (N != 0) {
            pq.add(new Node(arr[0], 0));
            pq.add(new Node(L - arr[N-1], 0));
        } else {
            System.out.println(L%(M+1) == 0 ? L/(M+1) : L/(M+1)+1);
            return;
        }

        for (int i = 1; i < N; i++) {
            pq.add(new Node(arr[i] - arr[i-1], 0));
        }
//        System.out.println(pq.poll().length);
//0 82 201 411 555 622 755 800
//        82 119 210 144 67 133 45

        for (int i = 0; i < M; i++) {
            Node temp = pq.poll();
            int cnt = temp.count;
            int lengthSum = temp.length;
//            System.out.println("temp: " + temp);
//            System.out.println(temp.length /2 );
//            System.out.println(temp.length - temp.length/2);
            for (int j = 0; j <cnt; j++) {
                lengthSum += pq.poll().length;
            }
//            System.out.println("lengthSum: " + lengthSum);
            for (int j = 0; j < lengthSum%(cnt+2); j++) {
                pq.offer(new Node(lengthSum/(cnt+2) + 1, cnt+1));
//                System.out.println("adding: " + (lengthSum/(cnt+2) + 1));

            }
            for (int j = 0; j <cnt + 2 - lengthSum%(cnt+2); j++) {
                pq.offer(new Node(lengthSum/(cnt+2), cnt+1));
//                System.out.println("adding: " + lengthSum/(cnt+2));

            }
//            pq.offer(new Node(lengthSum - (lengthSum/(cnt+2)) * (cnt+1), cnt+1));
//            System.out.println("adding rest: " + (lengthSum - (lengthSum/(cnt+2)) * (cnt+1)));
        }
        System.out.println(pq.poll().length);

    }
}
