import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 328ms
// 메모리 : 112972KB
public class BOJ_1436_영화감독숌_실버5 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int time = 1;
		int num = 666;
		while(true) {
			if((num+"").contains("666")) {
				if(time==N) break;
				else {
					time++;
				}
			}
			num++;
		}
		System.out.println(num);
	}

}
