package advent2018;
import java.util.*;
import java.util.regex.PatternSyntaxException;
public class day5q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String po = sc.nextLine();
		System.out.println(po.length());
		int [] alpha = new int[26];
		for (int i = 0; i < 26; i++) {
			int counter = 0;
			char a = (char)(i+65);
			String b = a+"";
			String c = (char)(i+97)+"";
			String co = po;
			co = co.replaceAll(b, "");
			co = co.replaceAll(c, "");
			while(counter < co.length()-1) {
				if (counter <0) {counter = 0;}
				if (co.charAt(counter) != co.charAt(counter + 1)) {
					if ((int)co.charAt(counter) == (int)co.charAt(counter + 1)+32) {
						co = co.substring(0, counter) + co.substring(counter+2);
						counter-=2;
					}
					else if ((int)co.charAt(counter) == (int)co.charAt(counter + 1)-32) {
						co = co.substring(0, counter) + co.substring(counter+2);
						counter-=2;
					}
				}
					counter++;
				}
				alpha[i] = co.length();
		}
		int min = Integer.MAX_VALUE;
		for (int a: alpha) {
			if (a < min) {
				min = a;
			}
		}
		System.out.println(min);
		}
	}
