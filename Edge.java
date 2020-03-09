package lab3new;



public class Edge implements Comparable<Edge>
{
	private int i;
	private int j;
	private int weight;
	
	Edge(int i, int j, int weight)
	{
		this.i = i;
		this.j = j;
		this.weight = weight;	
	}
	
	int getI()
	{
		return i;
	}
	
	int getJ()
	{
		return j;
	}
	
	public int compareTo(Edge o)
	{
		return Integer.compare(this.weight,o.weight);
	}
	
	@Override
	public String toString()
	{
		return "" + i + "->" + j + "=" + weight;
	}
}
