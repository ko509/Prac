import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 시간 : 424ms
// 메모리 : 47796KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] count = new int[8002];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			count[arr[i]+4000]++;
			if(max<arr[i]) max = arr[i];
			if(min>arr[i]) min = arr[i];
		}
		Arrays.sort(arr);
		System.out.println(Math.round(1d*sum/N));
		
		System.out.println(arr[N/2]);
		int maxcnt = -1;
		for (int i = 0; i < 8002; i++) {
			if(maxcnt<count[i]) {
				maxcnt = count[i];
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 8002; i++) {
			if(count[i]==maxcnt) {
				list.add(i);
			}
		}
		if(list.size()>=2) System.out.println(list.get(1)-4000);
		else System.out.println(list.get(0)-4000);
		System.out.println(max-min);
	}

}
