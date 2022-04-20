package Graph;
/*
 * Get connected components in a graph also show whether a graph is connected or not.
 * 
 * [ Connected graph : when there is only one component in a graph then it is called as connected graph ]..
 * 
 * input format :
 * 7   //vertices
 * 5   //edges
 * 0 1 10  //source destination weight
 * 2 3 10
 * 4 5 10
 * 5 6 10
 * 4 6 10
 * 
 * output : 3  //total number of individually connected components in a graph
 */

import java.util.*;
class Edg
{
	int s;
	int d;
	int w;
	Edg(int s,int d,int w)
	{
		this.s=s;
		this.d=d;
		this.w=w;
	}
}

public class GetConnectedComponentsInAGraph 
{	
	public static void hasPath(ArrayList<Edg>[] graph, boolean[] vis,int i,ArrayList<Integer> com)
	{
		vis[i]=true;
		com.add(i);
		for (Edg e : graph[i])
		{
			if (vis[e.d] != true)
			{
				hasPath(graph,vis,e.d,com);
			}
		}
	}
	
	public static void main(String[] args) { 
		//-----------------Input format design-----------------
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt(); //vertex in a graph
		int edg=sc.nextInt(); //edges in a graph
		
		ArrayList<Edg>[] graph=new ArrayList[vtx];
		
		for(int i=0; i<vtx; i++) { graph[i]=new ArrayList<>(); }  //initialization of each and every vertex
		
		for(int j=0;j<edg;j++)
		{
			int v1=sc.nextInt();  // source 
			int v2=sc.nextInt();  // destination
			int w=sc.nextInt();   // weight
			graph[v1].add(new Edg(v1,v2,w));
			graph[v2].add(new Edg(v2,v1,w));
		}
		
		//-------------------Problem specific-------------------
		ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
		boolean[] vis=new boolean[vtx];
		for(int i=0;i<vtx;i++)
		{
			if (vis[i] !=true){ 
				ArrayList<Integer> com=new ArrayList<>(); //gets individual connected components from the whole
				hasPath(graph,vis,i,com);
				comps.add(com);  // added into final arraylist
			}
		}
		if (comps.size()> 1 ) System.out.println("Graph Is Not Connected");
		else System.out.println("Connected Graph");
		System.out.println("number of components :"+comps.size()+"   "+comps);
	}
}
