package advent2018;
import java.util.*;
public class day9q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ppl = sc.nextInt();
		int marbles = sc.nextInt();
		int []p = new int[ppl];
		// 476 71657
		// Too high: 32280105
		// Too low: 371915
		ArrayList<Integer> marbleCircle = new ArrayList<Integer>();
		marbleCircle.add(0);
		marbleCircle.add(1);
		int current = 1;
		for (int i = 2; i < marbles; i++) {
			if (i % 23 == 0) {
				p[i%ppl] += i;
				current -= 7;
				if (current < 0) {
					current += marbleCircle.size();
				}
				p[i%ppl] += marbleCircle.get(current);
				marbleCircle.remove(current);
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
			// System.out.println(marbleCircle + " " + current);
		}
		Arrays.sort(p);
		System.out.println(p[p.length-1]);
	}

}
