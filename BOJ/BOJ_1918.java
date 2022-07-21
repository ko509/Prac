import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11532KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('*', 1);
		map.put('/', 1);
		map.put('+', 0);
		map.put('-', 0);
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (char c : str) {
			if(c >= 'A' && c <= 'Z') {
				sb.append(c);
			} else if(c==')') {
				while(true) {
					char tmp = stack.pop();
					if(tmp=='(') break;
					sb.append(tmp);
				}
			} else if(c=='(') {
				stack.push(c);
			} else {
				if(stack.isEmpty()) {
					stack.push(c);
					continue;
				} else  if(stack.peek() == '(') {
					stack.push(c);
				}  else {
					while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
						sb.append(stack.pop());
						if(!stack.isEmpty() && stack.peek()=='(') break;
					}
					stack.push(c);
				}
			}
		}
		while(!stack.isEmpty()) {
			char tmp = stack.pop();
			if(tmp=='(') continue;
			sb.append(tmp);
		}
		System.out.println(sb);
		
	}

}
