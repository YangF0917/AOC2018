package advent2018;
import java.util.*;
public class day10q1 {
	public static int getMaxX(LinkedList<Integer> a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.size(); i+=2) {
			if (a.get(i) > max) {
				max = a.get(i);
			}
		}
		return max;
	}
	public static int getMinX(LinkedList<Integer> a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.size(); i+=2) {
			if (a.get(i) < min) {
				min = a.get(i);
			}
		}
		return min;
	}
	public static int getMaxY(LinkedList<Integer> a) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < a.size(); i+=2) {
			if (a.get(i) > max) {
				max = a.get(i);
			}
		}
		return max;
	}
	public static int getMinY(LinkedList<Integer> a) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < a.size(); i+=2) {
			if (a.get(i) < min) {
				min = a.get(i);
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
			for(int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == ' ') {
					temp = temp.substring(0, i) + temp.substring(i+1);
					i--;
				}
			}
			for(int i = 0; i < t2.length(); i++) {
				if (t2.charAt(i) == ' ') {
					t2 = t2.substring(0, i) + t2.substring(i+1);
					i--;
				}
			}
			String [] t3 = temp.split(",");
			String [] t4 = t2.split(",");
			coord.add(Integer.parseInt(t3[0])); coord.add(Integer.parseInt(t3[1]));
			vel.add(Integer.parseInt(t4[0])); vel.add(Integer.parseInt(t4[1]));
			input = sc.nextLine();
		}
		int maxX = getMaxX(coord); int maxY = getMaxY(coord); int minX = getMinX(coord); int minY = getMinY(coord);
		int dX = Integer.MAX_VALUE; int dY = Integer.MAX_VALUE;
		// 10947
		int counter = 0;
		// while((maxX - minX) <= dX && (maxY - minY) <= dY) {
		while (counter < 10946) {
			for (int i = 0; i < coord.size(); i++) {
				coord.set(i, coord.get(i) + vel.get(i));
			}
			counter++;
			dX = maxX - minX; dY = maxY - minY;
			maxX = getMaxX(coord);maxY = getMaxY(coord);minX = getMinX(coord);minY = getMinY(coord);
		}
		System.out.println(dX + " " + dY);
		System.out.println(counter);
		char [][] grid = new char[200][200];
		for (int i = 0; i < dX; i++) {
			for(int j = 0; j < dY; j++) {
				grid[i][j] = ' ';
			}
		}
		for (int i = 0; i < coord.size(); i+=2) {
			grid[coord.get(i)-minX][coord.get(i + 1) - minY] = '*';
		}
		for (int i = 0; i < 200; i++) {
			for (int j = 0; j < 200; j++) {
				System.out.print((grid[i][j]));
			}
			System.out.println("");
		}
	}
}
