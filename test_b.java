package lab3new;



public class test_b {
	public static void main(String[] args) 
	{
		
		int[][] graph1 = {
                {0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {1	, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0}
        };
		
		int[][] graph2 = {
				{0, 0, 0, 1, 0, 0, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 0, 1, 0},
				{1, 0, 0, 0, 1, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 1, 0, 0, 0},
				{0, 1, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 1, 0},
		};
		
		int[][] graph3 = {
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };
		
		int[][] graph4 = {
                {0, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0}
        };
		
		System.out.println(graph_b.Fleri(graph4));
		System.out.println(graph_b.Tarjan(graph3));
		System.out.println(graph_b.Euler(graph1, 5));
		System.out.println(graph_b.Kosaray(graph2));
		
	}

}
