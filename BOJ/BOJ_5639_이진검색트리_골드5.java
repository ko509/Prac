import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 588ms
// 메모리 : 17516KB
public class Main {

	static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		public void print() {
			if(left != null) left.print();
			if(right != null) right.print();
			System.out.println(value);
		}
	}
	
	static class Tree {
		Node root;
		
		public Tree(int value) {
			root = new Node(value);
		}
		
		public void add(int value) {
			Node cur = root;
			while(true) {
				if(value > cur.value) {
					if(cur.right == null) {
						cur.right = new Node(value);
						break;
					} else {
						cur = cur.right;
					}
				} else {
					if(cur.left == null) {
						cur.left = new Node(value);
						break;
					} else {
						cur = cur.left;
					}
				}
			}
		}
		
		public void print() {
			root.print();
		}
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Tree tree = new Tree(Integer.parseInt(str));
		str = br.readLine();
		while(str != null) {
			int n = Integer.parseInt(str);
			tree.add(n);
			str = br.readLine();
		}
		tree.print();
	}

}
