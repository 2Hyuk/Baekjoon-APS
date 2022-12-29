import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] monthOfDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int year = 2019;
		int month = 1;
		int day = 1;
		int week = 2; //1:월, 2:화, 3:수 ... 7:일
		GregorianCalendar gc = new GregorianCalendar();
		boolean isLeapYear = gc.isLeapYear(year);
		
		int answer = 0;
		while(true) {
			
			if(day == 13 && week == 5) {
				answer++;
			}
			
			if(year == N && month == 12 && day == 31) {
				break;
			}
			
			day++;
			week = week + 1 == 8 ? 1 : week + 1;
			
			if(day > monthOfDay[month]) {
				month++;
				day = 1;
				if(month > 12) {
					year++;
					month = 1;
					isLeapYear = gc.isLeapYear(year);
					if(isLeapYear) {
						monthOfDay[2] = 29;
					}
					else {
						monthOfDay[2] = 28;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
