package _1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SWEA_7701 {
	
	static class Name implements Comparable<Name>{
		String name;
		int len;
		public Name(String name) {
			super();
			this.name = name;
			this.len = name.length();
		}
		@Override
		public int compareTo(Name o) {
			if(this.len!=o.len) return Integer.compare(this.len, o.len);
			return this.name.compareTo(o.name);
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + len;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Name other = (Name) obj;
			if (len != other.len)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			Set<Name> str = new HashSet<>();
			for (int i = 0; i < N; i++) {
				str.add(new Name(br.readLine()));
			}
			Name[] str2 = str.toArray(new Name[0]);
			Arrays.sort(str2);
			System.out.println("#"+t);
			for (Name name : str2) {
				System.out.println(name.name);
			}
		}
	}

}
