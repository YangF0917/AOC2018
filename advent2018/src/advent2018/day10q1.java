package advent2018;
import java.util.*;
public class day10q1 {
	public static int getMaxX(LinkedList<Integer> a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.size(); i++) {
			if (i % 2 == 0 && a.get(i) > max) {
				max = i;
			}
		}
		return max;
	}
	public static int getMinX(LinkedList<Integer> a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.size(); i++) {
			if (i % 2 == 0 && a.get(i) < min) {
				min = i;
			}
		}
		return min;
	}
	public static int getMaxY(LinkedList<Integer> a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.size(); i++) {
			if (i % 2 == 1 && a.get(i) > max) {
				max = i;
			}
		}
		return max;
	}
	public static int getMinY(LinkedList<Integer> a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.size(); i++) {
			if (i % 2 == 1 && a.get(i) < min) {
				min = i;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		LinkedList<Integer> coord = new LinkedList<Integer>();
		LinkedList<Integer> vel = new LinkedList<Integer>();
		while (!input.equals("0")) {
			String temp = input.substring(input.indexOf("<") + 1, input.indexOf(">"));
			String t2 = input.substring(input.indexOf("y=<") + 3, input.length()-1);
			temp.replaceAll(" ", "");
			t2.replaceAll(" ", "");
			String [] t3 = temp.split(",");
			String [] t4 = t2.split(",");
			coord.add(Integer.parseInt(t3[0])); coord.add(Integer.parseInt(t3[1]));
			vel.add(Integer.parseInt(t4[0])); vel.add(Integer.parseInt(t4[1]));
			input = sc.nextLine();
		}
		int maxX = getMaxX(coord); int maxY = Integer.MIN_VALUE; int minX = Integer.MAX_VALUE; int minY = Integer.MAX_VALUE;
		while(maxX - minX < 200 && maxY - minY < 200) {
			
		}
		char [][] grid = new char[200][200];
		for (int i = 0; i < 200; i++) {
			for(int j = 0; j < 200; j++) {
				grid[i][j] = ' ';
			}
		}
	}

}
