package Graph;
import java.util.*;
// Question
//---------------------------------------
/*
 * Uolevi has won a contest, and the prize is a free flight trip that can consist of one or more flights through cities. Of course, Uolevi wants to choose a trip that has as many cities as possible.

Uolevi wants to fly from Syrjälä to Lehmälä so that he visits the maximum number of cities. You are given the list of possible flights, and you know that there are no directed cycles in the flight network.

Input

The first input line has two integers n and m: the number of cities and flights. The cities are numbered 1,2,…,n. City 1 is Syrjälä, and city n is Lehmälä.

After this, there are m lines describing the flights. Each line has two integers a and b: there is a flight from city a to city b. Each flight is a one-way flight.

Output

First print the maximum number of cities on the route. After this, print the cities in the order they will be visited. You can print any valid solution.

If there are no solutions, print "IMPOSSIBLE".

Constraints
2≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
5 5
1 2
2 5
1 3
3 4
4 5

Output:
4
1 3 4 5
 */
//---------------------------------------


public class CSES_LongestFlightRoute 
{
	static List<List<Integer>> graph;
	public static void 	Lroute(List<List<Integer>> graph,int src,List<List<Integer>> com, List<Integer> c,int m,int count,boolean[] vis)
	{
		vis[src]=true;
		if (src==m) com.add(new LinkedList<>(c));

		for(int g:graph.get(src)) {
			if (vis[g] !=true) { 
				c.add(g);
				Lroute(graph,g,com,c,m,count++,vis);
				c.remove(c.size()-1);
			}
		}
		vis[src]=false;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int grid[][]=new int[200][2];
		for(int i=1;i<m+1;i++)
		{
			grid[i][0]=sc.nextInt();
			grid[i][1]=sc.nextInt();
		}
		
		graph=new LinkedList<>();
		
		for(int j=0;j<n+1;j++) graph.add(new LinkedList<>());
		
		for(int j=1;j<n+1;j++) graph.get(grid[j][0]).add(grid[j][1]);
		
	
		List<List<Integer>> com=new LinkedList<>();
		List<Integer> c=new LinkedList<>();
	    boolean[] vis=new boolean[m+1];
		c.add(1);
		
		Lroute(graph,1,com,c,m,1,vis);
		
		if (com.size()==0) System.out.println("Impossible");
		else 
		{
			int mx=Integer.MIN_VALUE;
			for(int i=0;i<com.size();i++) mx=Math.max(mx,com.get(i).size());
			int idx=0;
			for(int i=0;i<com.size();i++) if (mx==com.get(i).size()) { idx=i; break;}
			
			System.out.println(mx);
			System.out.println(com.get(idx));
		}
	}

}
