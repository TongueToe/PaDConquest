public class Monster{
	
	private int id;
	private String name;
	private Element[] elem;
	private Type[] type;
	private double[] stats;
	private double[] ls;

	public Monster(int id, String name, Element[] elem, Type[] type, double[] stats, double[] ls){
		this.id = id;
		this.name = name;
		this.elem = elem;
		this.type = type;
		this.stats = stats;
		this.ls = ls;
	}

	/**
	 * Primary element in enum defined in Element
	 * @return primary attribute
	 */
	public Element getPrimaryElem(){
		return elem[0];
	}

	/**
	 * Secondary element in enum defined in Element
	 * @return secondary attribute
	 */
	public Element getSecondaryElem(){
		return elem[1];
	}
	
	/**
	 * Type(s) in enum defined in Type
	 * @return array of types
	 */
	public Type[] getType(){
		return type;
	}

	public double[] getLeaderSkill(){
		return ls;
	}

	public int getHp(){
		return (int)stats[0];
	}

	public int getAtk(){
		return (int)stats[1];
	}

	public int getRcv(){
		return (int)stats[2];
	}

	public double getWeightedStats(){
		return stats[0]/10 + stats[1]/5 + stats[2]/3;
	}

	public String toString(){
		return name;
	}
}
