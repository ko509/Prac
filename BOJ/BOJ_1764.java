import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 276ms
// 메모리 : 23792KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		String[] list = new String[N];
		for (int i = 0; i < N; i++) {
			list[i] = br.readLine();
		}
		
		Arrays.sort(list);
		
		List<String> same = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			int start = 0;
			int end = N-1;
			String tmp = br.readLine();
			
			int idx = -1;
			
			while(start<=end) {
				int mid = (start+end)/2;
				if(list[mid].compareTo(tmp) < 0) {
					start = mid + 1;
				} else if(list[mid].compareTo(tmp) > 0) {
					end = mid - 1;
				} else {
					idx = mid;
					break;
				}
			}
			
			if(idx!=-1) {
				same.add(tmp);
			}
		}
		same.sort(null);
		StringBuffer sb = new StringBuffer();
		sb.append(same.size()).append("\n");
		for (String string : same) {
			sb.append(string).append("\n");
		}
		System.out.println(sb);
	}

}
