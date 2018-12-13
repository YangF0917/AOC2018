package advent2018;	
import java.util.*;
public class day12q2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// - 3, Starts at -3
		// 3478 too low
		String init = ".......#........#.#.#...###..###..###.#..#....###.###.#.#...####..##..##.#####..##...#.#.....#...###.#.####.....";
		String myString = "..";
		LinkedList<String> inputs = new LinkedList<String>();
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
			for (int m = 0; m < 500; m++) {
			for (int j = 2; j < init.length()-2; j++) {
				String temp = init.substring(j-2, j+3);
				if (good.indexOf(temp) != -1) {
					myString += "#";
				}
				else {
					myString += ".";
				}
			}
			init = myString + "...";
			System.out.println(init);
			myString = "..";
			}
		long sum = 0;
		for (int i = 0; i < init.length(); i++) {
			if (init.charAt(i) == '#') {
				sum += (i - 7);
			}
		}
		System.out.println(sum);
	}

}
