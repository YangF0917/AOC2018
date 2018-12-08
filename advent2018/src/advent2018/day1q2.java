package advent2018;
import java.util.*;
public class day1q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int sum = 0;
		int first = 0;
		ArrayList<Integer> b = new ArrayList<Integer>();
		int a = sc.nextInt();
		while (first == 0) {
			sum += a;
			a = sc.nextInt();
			if (b.indexOf(sum) != -1 && first == 0) {
				first = sum;
			}
			b.add(sum);
		}
		System.out.println(first);
	}

}

