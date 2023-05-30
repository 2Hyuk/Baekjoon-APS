import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> extension = new TreeMap<>(Comparator.naturalOrder());

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			String[] fileName = br.readLine().split("\\.");
			if(extension.containsKey(fileName[1])){
				extension.put(fileName[1], extension.get(fileName[1]) + 1);
			}
			else{
				extension.put(fileName[1], 1);
			}
		}

		for(String key : extension.keySet()){
			System.out.println(key + " " + extension.get(key));
		}
	}
}
