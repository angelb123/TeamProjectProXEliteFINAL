
public class DungeonCharacterFactory
{
	public DungeonCharacter createSorceress(String name)
	{
		return (DungeonCharacter) new Sorceress(name);
		
	}//end createSorceress
	
	public DungeonCharacter createWarrior(String name)
	{
		return (DungeonCharacter) new Warrior(name);
		
	}//end createWarrior
	
	public DungeonCharacter createThief(String name)
	{
		return (DungeonCharacter) new Thief(name);
		
	}//end createThief
	
	public DungeonCharacter createOgre()
	{
		return new Ogre();
		
	}//end createOgre
	
	public DungeonCharacter createSkeleton()
	{
		return new Skeleton();
		
	}//end createSkeleton
	
	public DungeonCharacter createGremlin()
	{
		return new Gremlin();
		
	}//end createGremlin
	
}//end class
