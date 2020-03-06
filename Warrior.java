
public class Warrior implements DungeonCharacter
{
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	
	private int hitPoints = 125;
	private int attackSpeed = 4;
	private double chanceToHit = 0.8;
	private int minDamage = 35;
	private int maxDamage = 60;
	private double blockChance = 0.2;
	private String cName;
	
	SpecialMove CrushingBlow;
	
	public void doSpecialMove(DungeonCharacter monster)
	{
		CrushingBlow = new CrushingBlow(this, monster);
		CrushingBlow.doSpecialMove();
	}//end doSpecialMove
	
	public Warrior(String cName)
	{
		this.cName = cName;
		
	}//end Warrior
	
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
		System.out.println(this.getName() + " swings a mighty sword at" + opponent.getName() + ":");

		if (Math.random() <= chanceToHit)
		{
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
	
	public String getSpecialMove()
	{
		
		return " Crushing Blow ";
	}//end getSpecialMove
	
	public boolean isAlive()
	{
		if(this.hitPoints <= 0)
			return false;
		
		return true;
		
	}//end isAlive
	
}//end class
