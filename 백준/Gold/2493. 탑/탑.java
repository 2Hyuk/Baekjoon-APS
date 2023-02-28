import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static class Tower{
		int height;
		int index;

		public Tower(int height, int index){
			this.height = height;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<Tower> stack1 = new Stack<>();
		Stack<Tower> stack2 = new Stack<>();

		// 타워에 대한 높이와 순서를 스택에 순서대로 넣는다.
		for(int i = 0; i < N; i++){
			int height = Integer.parseInt(st.nextToken());
			stack1.push(new Tower(height, i + 1));
		}

		// 정답을 적어 놓을 배열
		int[] answerArr = new int[N];

		// 가장 마지막 타워를 2번 스택에 넣어놓는다.
		Tower currTower = stack1.pop();
		stack2.push(currTower);

		while(!stack1.empty()){
			// 1번스택의 타워를 꺼낸다.
			currTower = stack1.pop();

			// 2번 스택이 비어있지 않다면?
			while(!stack2.empty()){
				// 마지막 스택을 확인한다.
				Tower nextTower = stack2.peek();

				// 만약 1번 스택에서 꺼낸 타워가 2번 스택의 마지막 타워보다 높다면 2번 스택의 신호는 현재 타워에 막히므로 배열에 현재타워의 인덱스를 입력해준다.
				if(currTower.height > nextTower.height){
					answerArr[nextTower.index - 1] = currTower.index;
					stack2.pop();
				}
				// 그렇지 않는 경우는 반복문에서 나간다.
				else{
					break;
				}
			}
			// 현재타워를 2번 스택에 넣어준다.
			stack2.push(currTower);
		}

		for(int answer : answerArr){
			System.out.print(answer + " ");
		}
	}
}
