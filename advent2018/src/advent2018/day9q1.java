package advent2018;
import java.util.*;
public class day9q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int []p = new int[476];
		// 71657 marbles
		ArrayList<Integer> marbleCircle = new ArrayList<Integer>();
		marbleCircle.add(0);
		int current = 0;
		for (int i = 1; i < 71658; i++) {
			if (i % 23 == 0) {
				p[i%476] += i;
				current -= 7;
				if (current < 0) {
					current += marbleCircle.size();
				}
				p[i%23] += marbleCircle.get(current);
				if (current > marbleCircle.size()) {
					current = 0;
				}
			}
			else{
				current += 2;
				if (current > marbleCircle.size()) {
					current -= marbleCircle.size();
				}
				marbleCircle.add(current, i);
			}
		}
		Arrays.sort(p);
		System.out.println(p[475]);
	}

}
