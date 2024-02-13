package SWEA._1230_암호문3;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			SinglyLinkedList list = new SinglyLinkedList();
			for (int i = 0; i < N; i++) {
				list.addLast(new Node(sc.nextInt()));
			}
			
			int O = sc.nextInt();
			for(int i = 0; i<O; i++) {
				char o = sc.next().charAt(0);
				if (o == 'I') {
					int idx = sc.nextInt();
					int num = sc.nextInt();
					for (int n = 0; n < num; n++) {
						list.add(idx, new Node(sc.nextInt()));
						idx++;
					}
				}
				if (o == 'D') {
					int idx = sc.nextInt();
					int num = sc.nextInt();
					for (int n = 0; n < num; n++) {
						list.remove(idx);
					}
					
				}
				if (o == 'A') {
					int num = sc.nextInt();
					for (int n = 0; n < num; n++) {
						list.addLast(new Node(sc.nextInt()));
					}
					
				}
			}
			System.out.printf("#%d",tc);
			list.print();
			System.out.println();
		}
		sc.close();
		
	}
	
	public static class SinglyLinkedList{
		
		Node head = new Node();
		
		int size=0;
		
		void add (int idx, Node newNode) { //추가하는 Node가 인자의 idx 자리에 오도록.
			if (!(0<=idx && idx <= size)) return;
			Node curr = head;
			for (int i =0; i<idx; i++) {
				curr = curr.link;
			}
			newNode.link = curr.link;
			curr.link = newNode;
			size++;	
		}
		
		void remove(int idx) { // 해당 인덱스에 있던 Node가 지워지도록
			if (!(0<=idx && idx < size)) return;
			Node curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.link;
			}
			curr.link = curr.link.link;
			size--;
		}
		
		void addLast(Node newNode) {
			add(size,newNode);
		}
		
		void print() {
			Node curr = head;
			for (int i = 0; i < 10; i++) {
				curr = curr.link;
				
				System.out.printf(" %d", curr.data);
			}
		}
		
		
		
	}
	
	public static class Node {
		int data;
		Node link;
		
		Node(){}
		Node(int data) {
			this.data = data;  
		}
	}

}