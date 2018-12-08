package advent2018;
import java.util.*;
public class day3q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [][] fabric = new int[1001][1001];
		String input;
		String[] inputs = new String[1359];
		for (int i = 0; i < 1359; i++) {
			input = sc.nextLine();
			inputs[i] = input;
		}
		for (int k = 0; k < 1359; k++) {
		String coords = inputs[k].substring(inputs[k].indexOf("@") + 2, inputs[k].indexOf(":"));
		String size = inputs[k].substring(inputs[k].indexOf(":") + 2);
		String [] intcord = coords.split(",");
		String [] intsize = size.split("x");
		int sum = 0;
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
		}
		String ans = "";
		for (int k = 0; k < 1359; k++) {
			boolean a = true;
			String coords = inputs[k].substring(inputs[k].indexOf("@") + 2, inputs[k].indexOf(":"));
			String size = inputs[k].substring(inputs[k].indexOf(":") + 2);
			String [] intcord = coords.split(",");
			String [] intsize = size.split("x");
			int sum = 0;
			for (int i = Integer.parseInt(intcord[0]);i < Integer.parseInt(intcord[0]) + Integer.parseInt(intsize[0]); i++) {
				for (int j = Integer.parseInt(intcord[1]);j < Integer.parseInt(intcord[1]) + Integer.parseInt(intsize[1]); j++) {
					if (fabric[i][j] == 2) {
						a = false;
					}
					
				}
			}
			if (a) {
				ans += (k+1);
			}
		}
		System.out.println(ans);
	}

}
