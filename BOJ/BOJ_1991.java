import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11596KB
public class Main {
	
	static class Node {
		char value;
		Node leftChild;
		Node rightChild;
		
		public Node(char value) {
			this.value = value;
		}
		
 	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Node[] tree = new Node[26];
		for (int i = 0; i < 26; i++) {
			tree[i] = new Node((char) ('A'+i));
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if(left!='.')tree[root-'A'].leftChild = tree[left-'A'];
			if(right!='.')tree[root-'A'].rightChild = tree[right-'A'];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 2; i++) {
			sb.append(order(i, 0, tree, new StringBuilder())).append('\n');
		}
		System.out.println(sb);
	}

	private static String order(int type, int root, Node[] tree, StringBuilder sb) {

		if(type==0) {			
			sb.append((char)('A'+root));
			if(tree[root].leftChild!=null) order(type, tree[root].leftChild.value-'A', tree, sb);
			if(tree[root].rightChild!=null) order(type, tree[root].rightChild.value-'A', tree, sb);
			return sb.toString();
		} else if(type==1) {
			if(tree[root].leftChild!=null) order(type, tree[root].leftChild.value-'A', tree, sb);
			sb.append((char)('A'+root));
			if(tree[root].rightChild!=null) order(type, tree[root].rightChild.value-'A', tree, sb);
			return sb.toString();
		} else {
			if(tree[root].leftChild!=null) order(type, tree[root].leftChild.value-'A', tree, sb);
			if(tree[root].rightChild!=null) order(type, tree[root].rightChild.value-'A', tree, sb);
			sb.append((char)('A'+root));
			return sb.toString();
		}
	}


}
