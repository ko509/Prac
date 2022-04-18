import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 76ms
// 메모리 : 11460KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String answer = "mixed";
		if(str.equals("1 2 3 4 5 6 7 8")) answer = "ascending";
		else if(str.equals("8 7 6 5 4 3 2 1")) answer = "descending";
		
		System.out.println(answer);
	}

}
