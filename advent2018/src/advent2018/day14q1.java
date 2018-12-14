package advent2018;
import java.util.*;
public class day14q1 {

	public static int reduce(int a, LinkedList<Integer> b) {
		if (a > b.size()-1) {
			while (a > b.size()-1) {
				a -= b.size();
			}
			return a;
		}
		else {
			return a;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 170641 recipes, Next 10 after 170641
		LinkedList<Integer> recipes = new LinkedList<Integer>();
		recipes.add(3); recipes.add(7);
		int elf1 = 0; int elf2 = 1;
		while (recipes.size() < 170651) {
			int sum = recipes.get(elf1) + recipes.get(elf2);
			if (sum / 10 > 0) {
				recipes.add(sum/10); recipes.add(sum%10);
				elf1 += 1 + recipes.get(elf1);
				elf2 += 1 + recipes.get(elf2);
				elf1 = reduce(elf1, recipes);
				elf2 = reduce(elf2, recipes);
			}
			else {
				recipes.add(sum%10);
				elf1 += 1 + recipes.get(elf1);
				elf2 += 1 + recipes.get(elf2);
				elf1 = reduce(elf1, recipes);
				elf2 = reduce(elf2, recipes);
			}
		}
		for (int i = 170641; i < recipes.size(); i++) {
			System.out.print(recipes.get(i));
		}
	}

}
