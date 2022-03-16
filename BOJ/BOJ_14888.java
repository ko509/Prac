import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 88ms
// 메모리 : 12540KB
public class BOJ_14888 {

	static int max;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] op = new int[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		perm(0, new int[N-1], num, op);
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		sb.append("\n");
		sb.append(min);
		System.out.println(sb.toString());
	}

	private static void perm(int cnt, int[] ops, int[] num, int[] op) {

		int M = ops.length;
		if(cnt==M) {
			int total = num[0];
			for (int i = 0; i < M; i++) {
				switch (ops[i]) {
				case 0:
					total+=num[i+1];
					break;
				case 1:
					total-=num[i+1];
					break;
				case 2:
					total *= num[i+1];
					break;
				case 3:
					total /= num[i+1];
					break;
				default:
					break;
				}
			}
			min = Math.min(min, total);
			max = Math.max(max, total);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i]==0) continue;
			op[i]--;
			ops[cnt] = i;
			perm(cnt+1, ops, num, op);
			op[i]++;
		}
	}

}
