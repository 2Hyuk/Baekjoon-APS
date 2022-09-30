
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static class Color {
		String color;
		int value, multi;

		public Color(String color, int value, int multi) {
			this.color = color;
			this.value = value;
			this.multi = multi;
		}

	}

	public static void main(String[] args) throws IOException {
		List<Color> list = new ArrayList<>();
		list.add(new Color("black", 0, 1));
		list.add(new Color("brown", 1, 10));
		list.add(new Color("red", 2, 100));
		list.add(new Color("orange", 3, 1000));
		list.add(new Color("yellow", 4, 10000));
		list.add(new Color("green", 5, 100000));
		list.add(new Color("blue", 6, 1000000));
		list.add(new Color("violet", 7, 10000000));
		list.add(new Color("grey", 8, 100000000));
		list.add(new Color("white", 9, 1000000000));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long result = 0;
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		int idx1 = 0, idx2 = 0, idx3 = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).color.equals(str1)){
				idx1 = i;
			}
			if(list.get(i).color.equals(str2)){
				idx2 = i;
			}
			if(list.get(i).color.equals(str3)){
				idx3 = i;
			}
		}
		
		result = ((long)(list.get(idx1).value * 10 + list.get(idx2).value) * (long)list.get(idx3).multi);
		System.out.println(result);
	}

}
