import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Person {
		int age;
		String name;

		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Person> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Person(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		
		Collections.sort(list, new Comparator<Person>() {
					@Override
					public int compare(Person o1, Person o2) {
						return o1.age - o2.age;
					}
		});
		
		
		for(int i = 0; i < N; i++) {
			sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
		}
		System.out.println(sb);
		
	}
}
