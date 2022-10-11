
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[] arr;
	static boolean[] ch;
	static long max;
	static Queue<Long> qNum = new LinkedList<>();
	static Queue<Character> qOper = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		ch = new boolean[arr.length];
		max = Long.MIN_VALUE;
		if (N == 1 || N == 2) {
			max = arr[0] - '0';
		} else {
			dfs(0);
		}
		System.out.println(max);
	}

	static void dfs(int idx) {
		if (idx >= arr.length) {
			check();
			max = Math.max(max, calc2());
			qNum.clear();
			qOper.clear();
			return;
		}

		for (int i = idx; i < arr.length; i += 2) {
			if (ch[i] == false && i + 2 < arr.length) {
				ch[i] = true;
				ch[i + 2] = true;
				dfs(i + 2);
				ch[i] = false;
				ch[i + 2] = false;
			}
			if(i == arr.length - 1) {
				dfs(i + 1);
			}
		}

	}

	static void check() {
		int idx = 0;
		while (idx < arr.length) {
			long tmp = 0;
			if (idx % 2 == 0 && ch[idx] == true) {
				tmp = calc1(arr[idx] - '0', arr[idx + 2] - '0', arr[idx + 1]);
				qNum.offer(tmp);
				idx += 3;
			} else if (idx % 2 == 1) {
				qOper.offer(arr[idx]);
				idx++;
			} else {
				tmp = arr[idx] - '0';
				qNum.offer(tmp);
				idx++;
			}
		}

	}

	static long calc1(long a, long b, char ch) {
		long result = 0;
		switch (ch) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		}
		return result;
	}

	static long calc2() {
		long a = 0;
		if(qNum.size() > 0) {
			a = qNum.poll();
		}
		while (!qOper.isEmpty()) {
			char ch = qOper.poll();
			long b = qNum.poll();
			a = calc1(a, b, ch);
		}
		return a;
	}
}
