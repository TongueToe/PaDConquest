import java.util.ArrayList;

public class Enemy{

	private double hp;
	private double currentHp;
	private double atk;
	private Element elem[];
	private Type type[];

	public Enemy(double hp, double atk, Element elem[], Type type[]){
		this.hp = hp;
		currentHp = hp;
		this.atk = atk;
		this.elem = elem;
		this.type = type;
	}

	public double getCurrentHp(){
		return currentHp;
	}

	public double getAtk(){
		return atk;
	}

	public void damage(double[] damages){
		Element currentElement = (hp/2 < currentHp) ? elem[0] : elem[1];
		Element superType = null;
		Element weakType = null;

		switch(currentElement){
			case FIRE:
				superType = Element.WATER;
				weakType = Element.WOOD;
				break;
			case WATER:
				superType = Element.WOOD;
				weakType = Element.FIRE;
				break;
			case WOOD:
				superType = Element.FIRE;
				weakType = Element.WATER;
				break;
			case LIGHT:
				superType = Element.DARK;
				weakType = null;
				break;
			case DARK:
				superType = Element.LIGHT;
				weakType = null;
				break;
		}

		double dmg = 0;

		for(int i = 0; i < damages.length; i++){
			if(superType.getValue() == i)
				dmg += 2 * damages[i];
			else if(weakType.getValue() ==i)
				dmg += 0.5 * damages[i];
			else
				dmg += damages[i];
		}

		this.currentHp -= dmg;
		if(this.currentHp < 0)
			this.currentHp = 0;

	}

	
}
