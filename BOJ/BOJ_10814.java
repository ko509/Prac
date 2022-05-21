import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 524ms
// 메모리 : 46924
public class Main {

	static class Person implements Comparable<Person>{
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.age, o.age);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Person[] person = new Person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(person);
		StringBuilder sb = new StringBuilder();
		for (Person p : person) {
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}
		System.out.println(sb);
	}

}
