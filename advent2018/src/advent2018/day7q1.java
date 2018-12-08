package advent2018;
import java.util.*;
public class day7q1 {
	// 24 x 46 in
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [][] adjMatrix = new int [26][26];
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
		String order = "";
		int currentNode;
		while (!nextNodes.isEmpty()) {
		Collections.sort(nextNodes);
		currentNode = nextNodes.get(0);
		order += (char)(currentNode + 65);
		nextNodes.remove(0);
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
		}
		System.out.println(order);
	}

}
