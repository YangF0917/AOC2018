package advent2018;
import java.util.*;
public class day13q1 {

	public static int x;
	public static int y;
	public static char d;
	public day13q1(int x, int y, char dir) {
		this.x = x;
		this.y = y;
		this.d = dir;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char [][] track = new char [150][150];
		LinkedList<day13q1> carts = new LinkedList<day13q1>();
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
					day13q1 a = new day13q1(i, j, 'd');
					carts.add(a);track[i][j] = '|';
				}
				else if(track[i][j] == '<') {
					day13q1 a = new day13q1(i, j, 'l');
					carts.add(a);track[i][j] = '-';
					
				}
				else if(track[i][j] == '>') {
					day13q1 a = new day13q1(i, j, 'r');
					carts.add(a);track[i][j] = '-';
				}
				else if(track[i][j] == '^') {
					day13q1 a = new day13q1(i, j, 'u');
					carts.add(a);track[i][j] = '|';
				}
			}
		}
		boolean hasCrashed = false;
		while (!hasCrashed) {
			for (day13q1 a: carts) {
				if (track[a.x][a.y] == '/') {
					if (a.d == 'u') {
						a.d = 'r';
					}
				}
				else if (track[a.x][a.y] == '\\') {
					
				}
				else if (track[a.x][a.y] == '+') {
					
				}
				else if (track[a.x][a.y] == '-') {
					
				}
				else {
					
				}
			}
		}
	}

}
