package advent2018;
import java.util.*;
public class day11q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int gId = 8868;
		int [][]fuel = new int [301][301];
		for (int i = 1; i < 301; i++) {
			for (int j = 1; j < 301; j++) {
				fuel[i][j] = ((i + 10) * j + gId)*(i+10);
				fuel[i][j] %= 1000; fuel[i][j] /= 100; fuel[i][j]-=5;
			}
		}
		int maxSum = Integer.MIN_VALUE;
		String ans = "0,0,0";
		for (int i = 1; i < 301; i++) {
			for (int j = 1; j < 301; j++) {
				int min = 300-i; //299
				int min2 = 300-j;
				if (min2 < min) {
					min = min2;
				}
				for (int m = 0; m <= min; m++) {
				int sum = 0;
				for(int k = 0; k <= m; k++) {
					for (int l = 0; l <= m; l++) {
						sum += fuel[i+k][j+l];
					}
				}
				if (sum > maxSum) {
					maxSum = sum; ans = i + "," + j + "," + m;
				}
				sum = 0;
				}
			}
		}
		System.out.println(ans);
	}
}
