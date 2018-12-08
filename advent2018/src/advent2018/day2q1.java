package advent2018;
import java.util.*;
public class day2q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int twotimes = 0; int threetimes = 0;
		String a = sc.nextLine();
		while (!a.equals("z")) {
			HashMap <Character,Integer> d = new HashMap<>();
			for (int i = 0; i < a.length(); i++) {
				if (d.containsKey(a.charAt(i))) {
					d.put(a.charAt(i), d.get(a.charAt(i)) + 1);
				}
				else {
					d.put(a.charAt(i), 1);
				}
			}
			a = sc.nextLine();
			boolean d1 = false; boolean t = false;
			for (int k : d.values()) {
				if (k == 2 && !d1) {
					twotimes++;
					d1 = true;
				}
				if (k == 3) {
					threetimes++;
					t = true;
				}
			}
			d.clear();
		}
		System.out.println(twotimes * threetimes);
	}

}
