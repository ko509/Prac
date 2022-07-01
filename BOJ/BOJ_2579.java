import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 84ms
// 메모리 : 11480KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stair = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		// map[i][0] 저번 계단 map[i][1] 저저번 계단
		int[][] map = new int[N+1][2];
		map[1][0] = map[1][1] = stair[1];
		for (int i = 2; i < N+1; i++) {
			map[i][0] = map[i-1][1]+stair[i];
			map[i][1] = Math.max(map[i-2][0], map[i-2][1]) + stair[i];
		}
		
		System.out.println(Math.max(map[N][0], map[N][1]));
	}

}
