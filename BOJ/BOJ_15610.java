import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 84ms
// 메모리 : 11636KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		System.out.println(Math.sqrt(N)*4);
	}

}
