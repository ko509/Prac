import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] student = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < student.length; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		Long total = N*1l;
		
		for (int i = 0; i < N; i++) {
			student[i] -= B;
			if(student[i]<=0) continue;
			if(student[i]%C==0) total+=student[i]/C;
			else total+=student[i]/C+1;
		}
		System.out.println(total);
		
	}

}
