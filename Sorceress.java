
public class Sorceress implements DungeonCharacter
{
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	
	private int hitPoints = 75;
	private int attackSpeed = 5;
	private double chanceToHit = 0.7;
	private int minDamage = 25;
	private int maxDamage = 50;
	private double blockChance = 0.3;
	private String cName;
	
	
	SpecialMove heal = new Heal(this, MIN_ADD, MAX_ADD);

	public double getMinADD()
	{
		return this.MIN_ADD;
		
	}//end getMinADD
	
	public double getMaxADD()
	{
		return this.MAX_ADD;
		
	}//end getMaxADD
	
	public void doSpecialMove(DungeonCharacter opponent)
	{
		heal.doSpecialMove();
		
	}//end doSpecialMove
	
	public Sorceress(String cName)
	{
		this.cName = cName;
		
	}//end Sorceress
	
	public String getName()
	{
		return this.cName;
		
	}//end getName
	
	public int getHitPoints()
	{
		return this.hitPoints;
		
	}//end getHitPoints
	
	public int getAttackSpeed()
	{
		return this.attackSpeed;
		
	}//end getAttackSpeed
	
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " casts a spell of fireball at " + opponent.getName() + ":");

		if (Math.random() <= chanceToHit){
			
			int damage = (int)(Math.random() * (minDamage - maxDamage + 1))+ minDamage;
			opponent.subtractHitPoints(damage);
			System.out.println(damage + " damage was dealt!");
			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}
		
	}//end attack
	
	public void subtractHitPoints(int hitPoints)
	{
		if(Math.random() <= blockChance)
		{
			System.out.println(this.getName() + " BLOCKED the attack!");
		}
		else
		{
			this.hitPoints = this.hitPoints - hitPoints;
		}
		
	}//end subtractHitPoints
	
	public void addHitPoints(int hitPoints)
	{
		this.hitPoints += hitPoints;
		
	}//end addHitPoints
	
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
