package advent2018;
import java.util.*;
public class day13q2 {

	public static int x;
	public static int y;
	public static char d;
	public day13q2(int x, int y, char dir) {
		this.x = x;
		this.y = y;
		this.d = dir;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char [][] track = new char [150][150];
		LinkedList<Integer> x = new LinkedList<Integer>();
		LinkedList<Integer> y = new LinkedList<Integer>();
		LinkedList<Character> d = new LinkedList<Character>();
		LinkedList<day13q2> carts = new LinkedList<day13q2>();
		String input = sc.nextLine();
		for (int i = 0; i < 150; i++) {
			for (int j = 0; j < 150; j++) {
				track[i][j] = input.charAt(j);
			}
			input = sc.nextLine();
		}
		for (int i = 0; i < 150; i++) {
			for (int j = 0; j < 150; j++) {
				if (track[i][j] == 'v') {
					x.add(i);y.add(j);d.add('d');
				}
				else if(track[i][j] == '<') {
					x.add(i);y.add(j);d.add('l');
				}
				else if(track[i][j] == '>') {
					x.add(i);y.add(j);d.add('r');
				}
				else if(track[i][j] == '^') {
					x.add(i);y.add(j);d.add('u');
				}
			}
		}
		boolean hasCrashed = false;
		while (!hasCrashed) {
			
		}
	}

}
