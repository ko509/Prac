/*

아이디어 :

두 막대의 차이는 큰쪽의 순서번호와 같다

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12742 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int n = b-a;
			int beforerain = 0;
//			for (int i = 0; i < n; i++) {
//				beforerain+=i;
//			}
			beforerain = n*(n-1)/2;
			int after = beforerain-a;
			System.out.println("#"+t+" "+after);
		}
		
	}

}
