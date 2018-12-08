package advent2018;
import java.util.*;
public class day6q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [][] dist = new int[1000][1000];
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		ArrayList<Integer> infinite = new ArrayList<Integer>();
		infinite.add(0, -1);
		String input = sc.nextLine();
		while (!input.equals("0")) {
			String[] coord = input.split(", ");
			x.add(Integer.parseInt(coord[0]));
			y.add(Integer.parseInt(coord[1]));
			input = sc.nextLine();
		}
		System.out.println(x.get(40) + ", " + y.get(40));
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				int min = Integer.MAX_VALUE;
				boolean duplicate = false;
				int index = -1;
				for (int k = 0; k < x.size(); k++) {
					int distance = Math.abs(x.get(k) - i) + Math.abs(y.get(k) - j);
					if (distance < min) {
						min = distance;
						index = k;
						duplicate = false;
					}
					else if (distance == min) {
						duplicate = true;
					}
				}
				if (!duplicate) {
					dist[i][j] = index;
				}
				else {
					dist[i][j] = -1;
				}
			}
		}
		HashMap<Integer, Integer> area = new HashMap<Integer, Integer>();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (i == 0 || j == 0 || i == 999 || j == 999) {
					if (!infinite.contains(dist[i][j])) {
						infinite.add(dist[i][j]);
					}
				}
				else {
					if (area.containsKey(dist[i][j])) {
						area.put(dist[i][j], area.get(dist[i][j]) + 1);
					}
					else {
						area.put(dist[i][j], 1);
					}
				}
			}
		}
		int maxDist = 0;
		for (int i: area.keySet()) {
			if (!infinite.contains(i)) {
				if (area.get(i) > maxDist) {
					maxDist = area.get(i);
					System.out.println(i);
				}
			}
		}
		System.out.println(maxDist);
	}

}
