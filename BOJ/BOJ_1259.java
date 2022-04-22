import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 76ms
// 메모리 : 11444KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			int len = str.length();
			boolean flag = true;
			for (int i = 0; i < len/2; i++) {
				if(str.charAt(i)!=str.charAt(len-i-1)) {
					flag = false;
					break;
				}
			}
			if(!flag)System.out.println("no");
			else System.out.println("yes");
		}
	}

}
