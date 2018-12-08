package advent2018;
import java.util.*;
public class day6q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [][] dist = new int[5000][5000];
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		String input = sc.nextLine();
		while (!input.equals("0")) {
			String[] coord = input.split(", ");
			x.add(Integer.parseInt(coord[0]));
			y.add(Integer.parseInt(coord[1]));
			input = sc.nextLine();
		}
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				int min = Integer.MAX_VALUE;
				boolean duplicate = false;
				int totD = 0;
				for (int k = 0; k < x.size(); k++) {
					totD += Math.abs(x.get(k) - i) + Math.abs(y.get(k) - j);
				}
				if (totD < 10000) {
					dist[i][j] = 1;
				}
				else {
					dist[i][j] = -1;
				}
			}
		}
		HashMap<Integer, Integer> area = new HashMap<Integer, Integer>();
		int Total = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (dist[i][j] == 1) {
					Total++;
				}
			}
		}
		System.out.println(Total);
	}

}
