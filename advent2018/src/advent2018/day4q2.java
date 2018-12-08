package advent2018;
import java.util.*;
public class day4q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> fns = new ArrayList<String>();
		String a = sc.nextLine();
		while(!a.equals("0")) {
			fns.add(a);
			a = sc.nextLine();
		}
		Collections.sort(fns);
		int[][] sleep = new int[10000][60];
		int guardId = 0;
		int min = 0;
		for (String b: fns) {
			if (b.indexOf("Guard #") != -1) {
				System.out.println(Arrays.toString(sleep[guardId]));
				guardId = Integer.parseInt(b.substring(b.indexOf("#") + 1, b.indexOf(" b")));
			}
			else if (b.indexOf("falls asleep") != -1) {
				min = Integer.parseInt(b.substring(b.indexOf(":") + 1, b.indexOf("]")));
			}
			else {
				int end = Integer.parseInt(b.substring(b.indexOf(":") + 1, b.indexOf("]")));
				for (int i = min; i < end; i++) {
					sleep[guardId][i] += 1;
				}
			}
		}
		int ansMax = 0;
		int minute = 0;
		int theGuard = 0;
		for (int i = 0; i < 10000; i++) {
			int sum = 0;
			int localMax = 0;
			int index = 0;
			for (int j = 0; j < 60; j++) {
				if (sleep[i][j] > ansMax) {
					ansMax = sleep[i][j];
					minute = j;
					theGuard = i;
				}
			}
		}
		System.out.println(theGuard * minute);
	}

}
