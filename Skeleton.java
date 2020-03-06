
public class Skeleton implements DungeonCharacter
{
	private int hitPoints = 100;
	private int attackSpeed = 3;
	private double chanceToHit = 0.8;
	private double chanceToHeal = 0.3;
	private int minDamage = 30;
	private int maxDamage = 50;
	private double blockChance = 0;
	private final int MIN_ADD = 30;
	private final int MAX_ADD = 50;
	
	
	private SpecialMove heal = new Heal(this, MIN_ADD, MAX_ADD);
	
	public void doSpecialMove(DungeonCharacter opponent)
	{
		heal.doSpecialMove();
		
	}
	
	public String getName()
	{
		return "Orge";
		
	}
	
	public int getHitPoints()
	{
		return this.hitPoints;
		
	}
	
	public int getAttackSpeed()
	{
		return this.attackSpeed;
		
	}
	
	public void subtractHitPoints(int hitPoints)
	{
		this.hitPoints = this.hitPoints - hitPoints;
		
	}
	
	public void addHitPoints(int hitPoints)
	{
		this.hitPoints += hitPoints;
		
	}
	
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " slowly swings a club toward's " + opponent.getName() + ":");
		
		if (Math.random() <= chanceToHit)
		{
			int damage = (int)(Math.random() * (maxDamage - minDamage + 1)) + minDamage;
			opponent.subtractHitPoints(damage);
			System.out.println();
		}
		
		else
		{
			System.out.println(this.getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}
		
	}
	
	public boolean isAlive()
	{
		if(this.hitPoints <= 0)
			return false;
		
		return true;
		
	}
	
	public SpecialMove getSpecialMove()
	{
		return this.heal;
		
	}
	
}
