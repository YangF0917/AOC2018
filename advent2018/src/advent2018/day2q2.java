package advent2018;
import java.util.*;
public class day2q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ans = "";
		ArrayList<String> a = new ArrayList<String>();
		String b = sc.nextLine();
		while (!b.equals("z")) {
			a.add(b);
			b = sc.nextLine();
		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = i+1; j < a.size(); j++) {
				int diff = 0;
				for (int ind = 0; ind < 26; ind++) {
					if (a.get(i).charAt(ind) != a.get(j).charAt(ind)) {
						diff++;
					}
				}
				if (diff == 1) {
					for (int ind = 0; ind < 26; ind++) {
						if (a.get(i).charAt(ind) == a.get(j).charAt(ind)) {
							ans += a.get(i).charAt(ind);
						}
						else {
							ans += ind;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}
