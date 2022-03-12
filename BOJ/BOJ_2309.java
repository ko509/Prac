import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시간 : 76ms
// 메모리 : 11508KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		int total = -100;
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			total+=dwarf[i];
		}
		outer :for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(i==j) continue;
				if(dwarf[i]+dwarf[j]==total) {
					dwarf[i]=0;
					dwarf[j]=0;
					break outer;
				}
			}
		}
		Arrays.sort(dwarf);
		for (int i : dwarf) {
			if(i!=0) System.out.println(i);
		}
	}

}
