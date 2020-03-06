
public class Thief implements DungeonCharacter
{
	private int hitPoints = 75;
	private int attackSpeed = 5;
	private double chanceToHit = 0.7;
	private int minDamage = 25;
	private int maxDamage = 50;
	private double blockChance = 0.3;
	private String cName;
	
	SpecialMove SurpriseAttack;
	
	public void doSpecialMove(DungeonCharacter monster)
	{
		SurpriseAttack = new SurpriseAttack(this, monster);
		SurpriseAttack.doSpecialMove();
		
	}//end doSpecialMove
	
	public Thief(String cName)
	{
		this.cName = cName;
		
	}//end Thief
	
	public String getName()
	{
		return this.cName;
		
	}//end getName
	
	public int getHitPoints()
	{
		return this.hitPoints;
		
	}//getHitPoints
	
	public int getAttackSpeed()
	{
		return this.attackSpeed;
		
	}//end getAttackSpeed
	
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
		
	}//end subtractHitsPoints
	
	public void addHitPoints(int hitPoints)
	{
		this.hitPoints += hitPoints;
		
	}//end addHitPoints
	
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " slashes with a swift dagger at " + opponent.getName() + ":");

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
	
	public boolean isAlive()
	{
		if(this.hitPoints <= 0)
			return false;
		
		return true;
		
	}//end isAlive

	public String getSpecialMove()
	{
		return " Surprise Attack ";
		
	}//end getSpecialMove

}//end class