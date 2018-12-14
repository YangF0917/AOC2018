package advent2018;
import java.util.*;
public class day14q2 {

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
		int [] target = {1,7,0,6,4,1};
		LinkedList<Integer> recipes = new LinkedList<Integer>();
		recipes.add(3); recipes.add(7);
		int elf1 = 0; int elf2 = 1;
		boolean isDone = false;
		while (!isDone) {
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
			boolean isGood = true;
			if (recipes.size() > 6) {
				for (int i = recipes.size()-7; i < recipes.size()-2; i++) {
					if (recipes.get(i) != target[i-recipes.size()+7]) {
						isGood = false;
					}
				}
			}
			if (!isGood) {
				for (int i = recipes.size()-6; i < recipes.size()-1; i++) {
					if (recipes.get(i) != target[i-recipes.size()+6]) {
						isGood = false;
					}
				}
			}
			if (isGood && recipes.size() > 10) {
				isDone = true;
			}
		}
		System.out.print(recipes.size());
	}

}
