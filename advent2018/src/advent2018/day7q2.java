package advent2018;
import java.util.*;
public class day7q2 {
	// 24 x 46 in
	public static int[]workTime = new int[5];
	public static int[]task = new int[5];
	public static int[][] adjMatrix = new int[26][26];
	public static String order = "";
	public static void solve(int currentNode, ArrayList<Integer> nextNodes) {
		for (int i = 0; i < 26; i++) {
			if (adjMatrix[currentNode][i] == 1) {
				if (!order.contains((char)(i+65) + "")){
					if (nextNodes.indexOf(i) == -1) {
						boolean canAdd = true;
						for (int j = 0; j < 26; j++) {
							if (adjMatrix[j][i] == 1) {
								if (!order.contains(((char)(j+65) + ""))) {
									canAdd = false;
								}
							}
						}
						if (canAdd) {
							nextNodes.add(i);
						}
					}
				}
			}
		}
		for (int a: nextNodes) {
			for (int b: task) {
				if (b == a+61) {
					nextNodes.remove(nextNodes.indexOf(b));
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			task[i] = -1;
		}
		String input = sc.nextLine();
		while (!input.equals("0")) {
			char current = input.charAt(input.indexOf(" ") + 1);
			char next = input.charAt(input.indexOf(" can") - 1);
			int intC = (int)current - 65;
			int intN = (int)next - 65;
			adjMatrix[intC][intN] = 1;
			input = sc.nextLine();
		}
		ArrayList<Integer> nextNodes = new ArrayList<Integer>();
		int startNode = -1;
		for (int i = 0; i < 26; i++) {
			boolean isnotParent = false;
			for (int j = 0; j < 26; j++) {
				if (adjMatrix[j][i] == 1) {
					isnotParent = true;
				}
			}
			if (!isnotParent) {
				nextNodes.add(i);
			}
		}
		int currentNode;
		int totTime = 0;
		while (order.length() != 26) {
		Collections.sort(nextNodes);
		for (int i = 4; i > 0; i--) {
				if (task[i] == -1 && !nextNodes.isEmpty()) {
					task[i] = nextNodes.get(nextNodes.size()-1)+61;
					nextNodes.remove(nextNodes.size()-1);
				}
		}
		System.out.println(Arrays.toString(task));
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			if (task[i] - workTime[i] < min && task[i] != -1) {
				min = task[i] - workTime[i];
			}
		}
		totTime += min;
		for (int i = 0; i < 5; i++) {
			if (task[i] != -1) {
				workTime[i] += min;
			}
			if (workTime[i] == task[i] && task[i] != -1) {
				order += (char)(task[i]+4);
				solve((task[i] - 61), nextNodes);
				workTime[i] = 0;
				task[i] = -1;
			}
		}
		}
		System.out.println(totTime);
	}

}
