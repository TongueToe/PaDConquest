import java.util.*;
import java.util.Arrays;

public class Driver{
	
	public static void main(String[] args){
		int id = 1237;
		String name = "Da Qiao & Xiao Qiao";
		int rarity = 5;
		Element[] elem = new Element[] {Element.LIGHT, Element.WATER};
		Type[] type = new Type[] {Type.GOD, Type.HEALER};
		double[] stats = new double[] {100, 100, 100};
		double[] ls = new double[] {1.0, 4.0, 1.0};

		Monster dqxq = new Monster(id, name, rarity, elem, type, stats, ls);

		Team team = new Team( new Monster[] {dqxq, dqxq, dqxq, dqxq, dqxq});

		System.out.println(Arrays.toString(team.getAtk()));	

	}

}
