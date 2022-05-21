import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 148ms
// 메모리 : 16304KB
public class Main {

	static class Node {
		int value;
		Node prev;
		Node next;
		
		public Node() {
			super();
		}
		public Node(int n) {
			this.value = n;
		}
	}
	static class _Deque {
		int size;
		Node front;
		Node back;
		public _Deque() {
			size = 0;
		}
		
		public int empty() {
			if(front==null && back==null) return 1;
			else return 0;
		}
		
		public void push_front(int n) {
			if(this.empty() == 1) {
				Node newNode = new Node(n);
				this.front = newNode;
				this.back = newNode;
			}else {
				Node newNode = new Node(n);
				newNode.next = this.front;
				this.front.prev = newNode;
				this.front = this.front.prev;
			}
			this.size++;
		}
		
		public void push_back(int n) {
			Node newNode = new Node(n);
			if(this.empty() == 1) {
				this.back = newNode;
				this.front = newNode;
			}
			this.back.next = newNode;
			newNode.prev = this.back;
			this.back = this.back.next;
			
			this.size++;
		}
		public int pop_front() {
			if(this.empty() == 1) {
				return -1;
			}
			Node tmp = this.front;
			this.front = this.front.next;
			this.size--;
			if(this.size==0) {
				this.front = null;
				this.back = null;
			}
			return tmp.value;
		}
		
		public int pop_back() {
			if(this.empty() == 1) {
				return -1;
			}
			Node tmp = this.back;
			this.back = this.back.prev;
			this.size--;
			if(this.size==0) {
				this.front = null;
				this.back = null;
			}
			return tmp.value;
		}
		
		public int getSize() {
			return this.size;
		}
		
		public int front() {
			if(this.empty()==1) return -1;
			return front.value;
		}
		
		public int back() {
			if(this.empty()==1) return -1;
			return back.value;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		_Deque dq = new _Deque();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			switch (op) {
			case "push_front":
				dq.push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				dq.push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				sb.append(dq.pop_front()).append("\n");
				break;
			case "pop_back":
				sb.append(dq.pop_back()).append("\n");
				break;
			case "size":
				sb.append(dq.getSize()).append("\n");
				break;
			case "empty":
				sb.append(dq.empty()).append("\n");
				break;
			case "front":
				sb.append(dq.front()).append("\n");
				break;
			case "back":
				sb.append(dq.back()).append("\n");
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
		
	}

}
