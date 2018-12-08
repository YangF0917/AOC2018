package advent2018;
import java.util.*;
public class day3q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [][] fabric = new int[1000][1000];
		String input = sc.nextLine();
		// #123 @ 3,2: 5x4
		while (!input.equals("0")) {
			String coords = input.substring(input.indexOf("@") + 2, input.indexOf(":"));
			String size = input.substring(input.indexOf(":") + 2);
			String [] intcord = coords.split(",");
			String [] intsize = size.split("x");
			for (int i = Integer.parseInt(intcord[0]);i < Integer.parseInt(intcord[0]) + Integer.parseInt(intsize[0]); i++) {
				for (int j = Integer.parseInt(intcord[1]);j < Integer.parseInt(intcord[1]) + Integer.parseInt(intsize[1]); j++) {
					if (fabric[i][j] == 2) {}
					else if (fabric[i][j] == 1) {
						fabric[i][j]++;
					}
					else {
						fabric[i][j] = 1;
					}
				}
			}
			input = sc.nextLine();
		}
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (fabric[i][j] == 2) {
					sum += 1;
				}
			}
		}
		System.out.println(sum);
	}

}
