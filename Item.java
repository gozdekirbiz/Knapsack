package knapsack;

public class Item 
{
	public int weight;
	public int value;
	public Item(int weight, int value, int capacity)
	{
		if(weight<=capacity&&weight>=1)
			this.weight=weight;
		if(value<=25&&value>=1)
			this.value=value;
	}

}
