package advent2018;
import java.util.*;
public class day8q2 {
	public static int sum = 0;
	public static Scanner sc = new Scanner(System.in);
	public static int nodes(int a, int b) {
		ArrayList<Integer> nNV = new ArrayList<Integer>();
		int value = 0;
		for (int i = 0; i < a; i++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			nNV.add(nodes(c,d));
		}
		if (a == 0) {
			for (int i = 0; i < b; i++) {
				value += sc.nextInt();
			}
			return value;
		}
		else {
			for (int i = 0; i < b; i++) {
				int index = sc.nextInt();
				if (index-1 < nNV.size() && index-1 > -1) {
					value += nNV.get(index-1);
				}
			}
			return value;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(nodes(a,b));
	}

}
