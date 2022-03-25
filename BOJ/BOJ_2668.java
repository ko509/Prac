import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;

// 시간 : 80ms
// 메모리 : 11564KB
public class Main {

	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		boolean[] pos = new boolean[N];
		boolean[] answer = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine())-1;
			pos[arr[i]] = true;
		}
		min = 0;
		for (int i = 0; i < N; i++) {
			if(!pos[i] || answer[i]) continue;
			go(arr, pos, i, answer);
		}
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append("\n");
		for (int i = 0; i < N; i++) {
			if(answer[i]) {
                sb.append(i+1);
                sb.append("\n");
            }
		}
        System.out.println(sb.toString());
	}

	private static void go(int[] arr, boolean[] pos, int num, boolean[] answer) {
		int start = num;
		int N = arr.length;
		int cnt = 0;
		boolean flag = false;
		Stack<Integer> que = new Stack<>();
		que.add(start);
		while(true) {
			start = arr[start];
			que.add(start);
			cnt++;
			if(start==num) {
				flag = true;
				que.pop();
				break;
			}
			if(cnt==N) break;
		}
		if(flag) {
			min +=cnt;
			for (Integer integer : que) {
				answer[integer] = true;
			}
		}
	}

}
