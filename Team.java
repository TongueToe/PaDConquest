public class Team{

	private Monster[] monsters;
	private double currentHp;

	public Team(Monster[] monsters){
		this.monsters = monsters;
		currentHp = getHp();
	}

	public double[] getLeaderSkill(){
		return monsters[0].getLeaderSkill();
	}

	public double getHp(){
		double hp = 0;
		for(Monster m: monsters)
			if(m != null)
				hp += m.getHp();
	
		return hp * getLeaderSkill()[0];
	}

	public double getCurrentHp(){
		return currentHp;
	}

	public double[] getAtk(){
		double[] atk = new double[6] ;
		for(Monster m: monsters)
			if(m != null){
				atk[m.getPrimaryElem().getValue()] += m.getAtk();
				if(m.getSecondaryElem() != null)
					atk[m.getSecondaryElem().getValue()] += m.getAtk() * 0.3;
			}

		return atk;
	}

	public double getRcv(){
		double rcv = 0;
		for(Monster m: monsters)
			if(m != null)
				rcv += m.getRcv();

		return rcv;
	}

	public void heal(double health){
		currentHp += health;
		if(currentHp > getHp())
			currentHp = getHp();
	}

	public void damage(double damage){
		currentHp -= damage;
		if(currentHp < 0)
			currentHp = 0;
	}
	
}
