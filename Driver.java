import java.util.*;
import java.util.Arrays;

public class Driver{
	
	public static void main(String[] args){
		int id = 2812;
		String name = "Beautiful and Intelligent Scholarship Student, Isis";
		Element[] elem = new Element[] {Element.WATER, Element.DARK};
		Type[] type = new Type[] {Type.ATTACKER, Type.HEALER};
		double[] stats = new double[] {2538, 1655, 673};
		double[] ls = new double[] {1.3, 6.5, 1.3};

		Monster isis = new Monster(id, name, elem, type, stats, ls);

		Team team = new Team( new Monster[] {
			new Monster(id, name, elem, type, stats, ls),
			new Monster(id, name, elem, type, stats, ls),
			new Monster(id, name, elem, type, stats, ls),
			new Monster(id, name, elem, type, stats, ls),
			new Monster(id, name, elem, type, stats, ls),
			new Monster(id, name, elem, type, stats, ls),
		});

		System.out.println(Arrays.toString(team.getAtk()));			

	}

}
