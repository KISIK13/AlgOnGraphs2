package lab3new;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;


public class graph_b 
{
//	static void dfs(int[][] graph,int s,Stack<Integer> stack,boolean[] Visit) 
//	{
//		ArrayList<Integer> result = new ArrayList<>();
//		boolean[] Visit = new boolean[graph.length];
//		DFS(graph,s,stack,Visit);
//		return stack;
//	}
//	
	static private void DFS(int[][] graph,int x,ArrayList<Integer> result,boolean[] Visit)
	{
		
		//System.out.println("here dfs");
		result.add(x);
		Visit[x] = true;
		for(int i = 0; i < graph.length;i++)
		{
			if(graph[x][i] != 0)
			{
				if(Visit[i] == false)
					DFS(graph,i,result,Visit);
			}
		}
	}
	
	static void dfs_inv(int[][] graph,int s,Stack<Integer> stack,boolean[] Visit)
	{
		//ArrayList<Integer> result = new ArrayList<>();
		//boolean[] Visit = new boolean[graph.length];
		DFS_INV(graph,s,stack,Visit);
		//return stack;
	}
	
	static private void DFS_INV(int[][] graph,int x, Stack<Integer> stack, boolean[] Visit)
	{
		//System.out.println("here dfs_inv");
		Visit[x] = true;
		for(int i = 0; i < graph.length; i++)
		{
			if(graph[x][i] != 0)
				if(Visit[i] == false)
					DFS_INV(graph,i,stack,Visit);	
		}
		stack.push(x);
		
	}
	static ArrayList<Integer> Euler(int[][] graph, int s)
	{
		
		ArrayList<Integer> result = new ArrayList<>();
		FindEulerPath(graph,result,s);
		return result;
		
	}
	private static void FindEulerPath(int[][] graph,ArrayList<Integer> result,int v)
	{
		for(int i = 0;i < graph.length;i++)
			if(graph[v][i] != 0)
			{
				graph[v][i] = 0;
				graph[i][v] = 0;
				FindEulerPath(graph,result,i);
			}
		result.add(v);			
	}
	
	static ArrayList<ArrayList<Integer>> Kosaray(int[][] graph) // высчитывает время выхода
	{
		Stack<Integer> stack = new Stack<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] Visit = new boolean[graph.length];
		forGT(graph,stack,Visit);
		forG(graph,stack,Visit,result,list);
		//stack.push(1);
		return result;
	}
	
	static private void forG(int[][] graph,Stack<Integer> stack,boolean[] Visit,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list)
	{
		int j = 0;
		for(int i = 0; i < graph.length;i++)
		{
			Visit[i] = false;
		}
		while(stack.empty() == false)
		{
			j = stack.pop();
			//stack.pop();
			if(Visit[j] == false)
			{
				DFS(Transponir(graph),j,list,Visit);
				ArrayList<Integer> temp = new ArrayList<>(list);
				result.add(temp);
				list.clear();
			}
			j++;
		}
	}
	
	static private void forGT(int[][] graph,Stack<Integer> stack,boolean[] Visit)
	{
		//graph = Transponir(graph);
		for(int i = 0;i < graph.length;i++)
		{
			Visit[i] = false;
		}
		for(int i = 0; i < graph.length;i++)
			if(Visit[i] == false)
				dfs_inv(graph,i,stack,Visit);
	}
	
	static private int[][] Transponir(int[][] graph)
	{
		int[][] graph1 = new int[graph.length][graph.length];
		int swap = 0;
		for(int i = 0; i < graph.length;i++)
			for(int j = 0; j < graph.length;j++)
			{
				graph1[i][j] = graph[j][i];
			}
		return graph1;
	}
	
	static Stack<Integer> Tarjan(int[][] graph)
	{
		boolean[] Visit = new boolean[graph.length];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < graph.length;i++)
			Visit[i] = false;
		for(int i = 0;i < graph.length;i++)
			if(Visit[i] == false)
				dfs_inv(graph,i,stack,Visit);
		Collections.reverse(stack);
		return stack;
	}
	
	static ArrayList<Edge> Fleri(int[][] graph1)
	{
		int[][] graph = new int[graph1.length][];
		for(int i = 0;i < graph1.length;i++)
			graph[i] = graph1[i].clone();
		ArrayList<Edge> result = new ArrayList<>();
		int s = 0;
		for(int i = 0; i < graph.length; i++)
			for(int j = 0; j < graph.length;j++)
				if (graph[s][j] > 0)                    //для всех смежных вершин текущей вершины
                    if (isRemovable(graph, s, j)) 
                    {
                        result.add(new Edge(graph[s][j], s, j));
                        graph[s][j] = 0;
                        graph[j][s] = 0;
                        s = j;
                    }
		return result;
	}
	
	private static boolean isRemovable(int[][] graph,int v1,int v2)
	{
		int count = 0;
		for(int i = 0; i < graph.length; i++)
			if(graph[v1][i] != 0)
				count++;
		if(count == 1)
			return true;
		else
		{
			int[][] graphCopy = new int[graph.length][];
			for(int i = 0; i < graph.length;i++)
				graphCopy[i] = graph[i].clone();
			graphCopy[v1][v2] = 0;
			graphCopy[v2][v1] = 0;
			boolean[] Visit = new boolean[graph.length];
            boolean[] VisitCopy = new boolean[graphCopy.length];
            if(dfsCount(graph,v1,Visit) > dfsCount(graphCopy,v1,VisitCopy))
            	return false;
            else
            	return true;
		}
				
	}
	
	private static int dfsCount(int[][] graph, int x, boolean[] Visit)
	{
		Visit[x] = true;
		int count = 1;
		for(int i = 0; i < graph.length;i++)
			if(Visit[i] == false)
				count = count + dfsCount(graph, i, Visit);
		return count;
				
	}
	
	
	
}
