import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 88ms
// 메모리 : 13180KB
public class Main {
	
	static class Food {
		int dan;
		int ji;
		int tan;
		int bi;
		int price;
		
		public Food(int dan, int ji, int tan, int bi, int price) {
			super();
			this.dan = dan;
			this.ji = ji;
			this.tan = tan;
			this.bi = bi;
			this.price = price;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		Food[] food = new Food[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dan = Integer.parseInt(st.nextToken());
			int ji = Integer.parseInt(st.nextToken());
			int tan = Integer.parseInt(st.nextToken());
			int bi = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			food[i] = new Food(dan, ji, tan, bi, price);
		}
		
		min = Integer.MAX_VALUE;
		eat = new boolean[N];
		dfs(0, food, new boolean[N], a, b, c, d, 0);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
		StringBuilder sb = new StringBuilder();
		sb.append(min).append("\n");
		for (int i = 0; i < N; i++) {
			if(eat[i]) sb.append(i+1).append(" ");
		}
		System.out.println(sb);
	}

	static int min;
	static boolean[] eat;
	private static void dfs(int cnt, Food[] food, boolean[] v, int a, int b, int c, int d, int price) {

		int N = food.length;
		if(price > min) return;
		if(a <= 0 && b <= 0 && c <= 0 && d <= 0) {
			if(min > price) {
				min = price;
				for (int i = 0; i < N; i++) {
					eat[i] = v[i];
				}
			} else if(min == price) {
				if(check(v)) {
					for (int i = 0; i < N; i++) {
						eat[i] = v[i];
					}
				}
			}
			return;
		}
		if(cnt == N) {
			return;
		}
		
		v[cnt] = true;
		dfs(cnt+1, food, v, a - food[cnt].dan, b - food[cnt].ji, c - food[cnt].tan, d - food[cnt].bi, price + food[cnt].price);
		v[cnt] = false;
		dfs(cnt+1, food, v, a, b, c, d, price);
	}
	private static boolean check(boolean[] v) {

		int N = v.length;
		for (int i = 0; i < N; i++) {
			if(v[i] && !eat[i]) return true;
			else if(!v[i] && eat[i]) return false;
		}
		return false;
	}

}
