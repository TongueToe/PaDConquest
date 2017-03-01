public class Monster{
	
	private final int id;
	private String name;
	private int rarity;
	private Element[] elem;
	private Type[] type;
	private double[] stats;
	private double[] ls;
	private int level;

	private double[] baseStats;
	private int experience;

	public Monster(int id, String name, int rarity, Element[] elem, Type[] type, double[] stats, double[] ls){
		this.id = id;
		this.name = name;
		this.rarity = rarity;
		this.elem = elem;
		this.type = type;
		this.stats = stats;
		this.ls = ls;
		level = 1;
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

	/**
	 * Calculates stat growth by accounting rarity and type.
	 */
	public void levelUp(){
		double baseStatGrowth = 0.8;
		double rareStat = rarity * 0.2;
		double statGrowth = baseStatGrowth + rareStat;
		
		double[] typeMultiplier = new double[] {1.0, 1.0, 1.0};
		for(Type t: type){
			switch(t){
				case DRAGON:
					typeMultiplier[0] += 0.05;
					typeMultiplier[1] += 0.05;
					typeMultiplier[2] += -0.10;
					break;
				case PHYSICAL:
					typeMultiplier[0] += 0.40;
					typeMultiplier[1] += -0.20;
					typeMultiplier[2] += -0.20;
					break;
				case HEALER:
					typeMultiplier[0] += -0.25;
					typeMultiplier[1] += -0.10;
					typeMultiplier[2] += 0.35;
					break;
				case ATTACKER:
					typeMultiplier[0] += -0.20;
					typeMultiplier[1] += 0.20;
					typeMultiplier[2] += 0.00;
					break;
				case GOD:
					typeMultiplier[0] += 0.05;
					typeMultiplier[1] += 0.05;
					typeMultiplier[2] += 0.05;
					break;
				case DEVIL:
					typeMultiplier[0] += -0.15;
					typeMultiplier[1] += 0.25;
					typeMultiplier[2] += 0.05;
					break;
				case MACHINE:
					typeMultiplier[0] += 0.30;
					typeMultiplier[1] += -0.15;
					typeMultiplier[2] += -0.15;
			}
		}

		for(int i = 0; i < stats.length; i++){
			stats[i] += baseStats[i] * typeMultiplier[i] * 0.1 * statGrowth;
		}
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
