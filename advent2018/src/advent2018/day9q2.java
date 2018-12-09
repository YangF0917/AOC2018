package advent2018;
import java.util.*;
public class day9q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ppl = sc.nextInt();
		int marbles = sc.nextInt();
		long []p = new long[ppl];
		// 476 7165700
		// Too low: 32280105
		LinkedList<Integer> marbleCircle = new LinkedList<Integer>();
		marbleCircle.add(0);
		marbleCircle.add(0,1);
		Iterator<Integer> it = marbleCircle.iterator();
		int current = 1;
		for (int i = 2; i < marbles; i++) {
			if (i % 23 == 0) {
				p[i%ppl] += i;
				for (int j = 0; j < 7; j++) {
					int a = marbleCircle.getLast();
					marbleCircle.removeLast();
					marbleCircle.addFirst(a);
				}
				p[i%ppl] += marbleCircle.getFirst();
				marbleCircle.removeFirst();
			}
			else{
				for (int j = 0; j < 2; j++) {
					int a = marbleCircle.getFirst();
					marbleCircle.removeFirst();
					marbleCircle.addLast(a);
				}
				marbleCircle.addFirst(i);
			}
		}
		Arrays.sort(p);
		System.out.println(p[p.length-1]);
	}

}
