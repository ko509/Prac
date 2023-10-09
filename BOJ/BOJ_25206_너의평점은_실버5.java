import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 : 84ms
// 메모리 : 11708KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Map<String, Double> map = new HashMap<>();
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		
		
		double total = 0d;
		double jeongong = 0d;
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			double cost = Double.parseDouble(st.nextToken());
			String score = st.nextToken();
			if(map.containsKey(score)) {				
				jeongong += cost;
				total += cost * map.get(score);
			}
		}
		
		System.out.println(total / jeongong);
	}

}
