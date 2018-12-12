package advent2018;
import java.util.*;
public class day11q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int gId = sc.nextInt();
		int [][]fuel = new int [301][301];
		for (int i = 1; i < 301; i++) {
			for (int j = 1; j < 301; j++) {
				fuel[i][j] = ((i + 10) * j + gId)*(i+10);
				fuel[i][j] %= 1000; fuel[i][j] /= 100 - 5;
			}
		}
		int maxSum = Integer.MIN_VALUE;
		String ans = "0,0";
		for (int i = 1; i < 301; i++) {
			for (int j = 1; j < 301; j++) {
				int sum = 0;
				int min = 300-i;
				for(int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						sum += fuel[i+k][j+l];
					}
				}
				if (sum > maxSum) {
					maxSum = sum; ans = i + "," + j;
				}
			}
		}
		System.out.println(ans);
	}
}
