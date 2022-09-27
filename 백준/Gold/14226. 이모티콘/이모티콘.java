
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 1.화면의 이모티콘을 모두 복사한다. 
 * 2.클립보드에 있는 이모티콘을 모두 넣는다.
 * 3.화면에 있는 이모티콘중 하나를 삭제한다.
 * 
 * 이미 만들었던 이모티콘 개수에 대해서는 체크를 하여 다시 못만들도록한다 -> 무한루프 방지
 */
public class Main {
	static class Emoticon {
		int count;
		int time;
		int buffer;

		public Emoticon(int count, int time, int buffer) {
			this.count = count;
			this.time = time;
			this.buffer = buffer;
		}
	}

	public static void main(String[] args) {

		Queue<Emoticon> queue = new LinkedList<>();
		boolean[][] visited = new boolean[1001][1001];
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		//visited[1][0] = true;
		queue.offer(new Emoticon(1, 0, 0));

		while (!queue.isEmpty()) {
			Emoticon emo = queue.poll();
			if (emo.count == S) {
				System.out.println(emo.time);
				break;
			}
			
			// 1.클립보드에 복사 -> 이전 내용은 사라짐
			if (emo.count != emo.buffer && visited[emo.count][emo.count] == false) {
				visited[emo.count][emo.count] = true;
				queue.offer(new Emoticon(emo.count, emo.time + 1, emo.count));
			}
			// 2.붙여넣기 -> 클립보드에 무언가 남아있을 경우에만..
			if (emo.buffer != 0 && emo.count + emo.buffer <= 1000 && visited[emo.count + emo.buffer][emo.buffer] == false) {
				visited[emo.count + emo.buffer][emo.buffer] = true;
				queue.offer(new Emoticon(emo.count + emo.buffer, emo.time + 1, emo.buffer));
			}
			// 3.이모티콘 하나 삭제	
			if (emo.count - 1 >= 0) {
				queue.offer(new Emoticon(emo.count - 1, emo.time + 1, emo.buffer));
			}
		}

	}
}
