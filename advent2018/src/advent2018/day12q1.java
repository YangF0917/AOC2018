package advent2018;
import java.util.*;
public class day12q1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// - 7, Starts at -7
		// 2268 too low
		// 3217
		// 3478 too high
		String init = ".......#........#.#.#...###..###..###.#..#....###.###.#.#...####..##..##.#####..##...#.#.....#...###.#.####............................................................";
		String myString = "..";
		LinkedList<String> empty = new LinkedList<String>();
		LinkedList<String> good = new LinkedList<String>();
		String input = sc.nextLine();
		while (!input.equals("0")){
			if (input.charAt(input.length()-1) == '#') {
				good.add(input.substring(0, 5));
			}
			else {
				empty.add(input.substring(0, 5));
			}
			input = sc.nextLine();
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 2; j < init.length()-2; j++) {
				String temp = init.substring(j-2, j+3);
				if (empty.indexOf(temp) != -1) {
					myString += ".";
				}
				else {
					myString += "#";
				}
			}
			init = myString + "..";
			System.out.println(init);
			myString = "..";
		}
		int sum = 0;
		for (int i = 0; i < init.length(); i++) {
			if (init.charAt(i) == '#') {
				sum += (i - 7);
			}
		}
		System.out.println(sum);
	}

}
