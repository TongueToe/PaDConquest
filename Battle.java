import java.util.ArrayList;
import java.util.Iterator;

public class Battle{
	
	private ArrayList<Enemy> enemies;
	private Team team;
	private int turnCount;

	public Battle(){
		enemies = new ArrayList<Enemy>();
	}

	public Battle(Team team){
		this();
		this.team = team;
	}
	
	public void addEnemy(Enemy enemy){
		enemies.add(enemy);
	}

	public void addEnemyList(ArrayList<Enemy> enemies){
		this.enemies.addAll(enemies);
	}

	public Team getTeam(){
		return team;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public int getTurnCount(){
		return turnCount;
	}

	/**
	 * Executes a turn.
	 * @return true if the battle is over.
	 */
	public boolean nextTurn(){
		Iterator<Enemy> it = enemies.iterator();
		Enemy currentEnemy = null;

		while(it.hasNext()){
			currentEnemy = it.next();
			if(currentEnemy.getCurrentHp() > 0)
				break;
		}

		if(currentEnemy != null){
			team.damage(currentEnemy.getAtk());
			if(currentEnemy.getCurrentHp() == 0)
				return true;
			
			currentEnemy.damage(team.getAtk());
			if(team.getCurrentHp() == 0)
				return true;

			return false;
		}
		
		return true;
	}


}
