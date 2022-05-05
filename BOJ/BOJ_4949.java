import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 시간 : 160ms
// 메모리 : 17504KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		while(!((str = br.readLine()).equals("."))) {
			char[] set = str.toCharArray();
			if(check(set)) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean check(char[] set) {
		Stack<Character> que = new Stack<>();
		int N = set.length;
		for (int i=0; i<N; i++) {
			if(set[i]=='(') que.add('(');
			else if(set[i]=='[') que.add('[');
			else if(set[i]==')') {
				if(que.isEmpty()) return false;
				else if(que.peek() == '(') que.pop();
				else return false;
			}
			else if(set[i]==']') {
				if(que.isEmpty()) return false;
				else if(que.peek()=='[') que.pop();
				else return false;
			}
		}
		if(que.size()!=0) return false;
		return true;
	}

}
