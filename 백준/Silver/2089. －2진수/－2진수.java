
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if(num == 0) {
        	System.out.println(0);
        }
        
        while(num != 0) {
        	sb.append((int)Math.abs(num % (-2)));
        	num = Math.ceil(num / -2);
        }
        System.out.println(sb.reverse());
    }
}