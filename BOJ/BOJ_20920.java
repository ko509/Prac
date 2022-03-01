import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;


// 시간 : 788ms
// 메모리 : 41896KB

class English implements Comparable<English>{

	String word;
	int freq;
	int len;
	
	public English(String word) {
		super();
		this.word = word;
		this.freq = 0;
		this.len = word.length();
	}

	@Override
	public int compareTo(English o) {
		int n = Integer.compare(o.freq, this.freq);
		if(n==0) n = Integer.compare(o.len, this.len);
		if(n==0) n = this.word.compareTo(o.word);
		return n;
	}

	
}
public class BOJ_20920 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, English> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int len = str.length();
			if(len<M) continue;
			
			if(map.containsKey(str)) map.get(str).freq++;
			else map.put(str, new English(str));
		}
		
		List<Entry<String, English>> list_map = new ArrayList<>(map.entrySet());
		Collections.sort(list_map, new Comparator<Entry<String, English>>() {
			public int compare(Entry<String, English> o1, Entry<String, English> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list_map.size(); i++) {
			sb.append(list_map.get(i).getValue().word);
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
