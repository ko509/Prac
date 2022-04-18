import java.io.IOException;

// 시간 : 80ms
// 메모리 : 11396KB
public class Main {

	public static void main(String[] args) throws IOException {

		 int total = 0;
		 for (int i = 0; i < 5; i++) {
			int n = System.in.read()-'0';
			System.in.read();
			total += n*n%10;
		}
		System.out.println(total%10);
	}

}
