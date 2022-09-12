
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
        while ((input = br.readLine()) != null) {
            char str[] = input.toCharArray();
            int small = 0, capital = 0, num = 0, blank = 0;
            for (char ch : str) {
                if ('a' <= ch && ch <= 'z')
                    small++;
                else if ('A' <= ch && ch <= 'Z')
                    capital++;
                else if ('0' <= ch && ch <= '9')
                    num++;
                else
                    blank++;
            }
            System.out.printf("%d %d %d %d\n", small, capital, num, blank);
        }
    }
}
