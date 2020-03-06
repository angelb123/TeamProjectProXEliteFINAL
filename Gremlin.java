
public class Gremlin implements DungeonCharacter
{
	private int hitPoints = 70;
	private int attackSpeed = 5;
	private double chanceToHit = 0.8;
	private double chanceToHeal = 0.4;
	private int minDamage = 15;
	private int maxDamage = 30;
	private double blockChance = 0;
	private final int MIN_ADD = 20;
	private final int MAX_ADD = 40;
	
	
	private SpecialMove heal = new Heal(this, MIN_ADD, MAX_ADD);
	
	public void doSpecialMove(DungeonCharacter opponent)
	{
		heal.doSpecialMove();
		
	}//end doSpeicalMove
	
	public String getName()
	{
		return "Gremlin";
		
	}//end getName
	
	public int getHitPoints()
	{
		return this.hitPoints;
		
	}//end getHitPoints
	
	public int getAttackSpeed()
	{
		return this.attackSpeed;
		
	}//end getAttackSpeed
	
	public void subtractHitPoints(int hitPoints)
	{
		this.hitPoints = this.hitPoints - hitPoints;
		
	}//end subtractHitPoints
	
	public void addHitPoints(int hitPoints)
	{
		this.hitPoints += hitPoints;
		
	}//end addHitPoints
	
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " flails their scimitar at the hero " + opponent.getName() + ":");
		
		if (Math.random() <= chanceToHit)
		{
			int damage = (int)(Math.random() * (maxDamage - minDamage + 1)) + minDamage;
			opponent.subtractHitPoints(damage);
			System.out.println(damage + " damage was dealt!");
			System.out.println();
		}
		
		else
		{
			System.out.println(this.getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}
		
	}//end attack
	
	public boolean isAlive()
	{
		if(this.hitPoints <= 0)
			return false;
		
		return true;
		
	}//end isAlive
	
	public String getSpecialMove()
	{
		return " Healed ";
		
	}//end getSpecialMove
	
}//end class
