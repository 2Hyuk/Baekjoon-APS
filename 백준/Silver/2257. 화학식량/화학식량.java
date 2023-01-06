import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);

            if(ch == ')'){
                int num = 0;
                while(true){
                    if(stack.peek() == 0){
                        stack.pop();
                        stack.push(num);
                        break;
                    }
                    num += stack.pop();
                }
            }
            else if(ch == 'C'){
                stack.push(12);
            }
            else if(ch == 'H'){
                stack.push(1);
            }
            else if(ch == 'O'){
                stack.push(16);
            }
            else if(ch >= '0' && ch <= '9'){
                stack.push(stack.pop() * (ch - '0'));
            }
            else{
                stack.push(0);
            }

        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        System.out.println(ans);
    }
}