package Graph;

import java.util.*;

/*
Input format
4         //vertex
4         //edges
0 1          
0 2
2 3
1 3
0        //source
3        //destination
output
013
023
*/

class Paths
{
	int v;
	LinkedList<Integer>[] gh;
	Paths(int node)
	{
		v=node;
		gh=new LinkedList[v];
		for(int i=0;i<v;i++){
			gh[i]=new LinkedList<Integer>();
		}
	}
	void addEdg(int s,int d){
		gh[s].add(d);
	}
	
	void show(int node) {
		for(int i=0;i<node;i++)
		{
			System.out.println("node: "+i+" "+gh[i]);
		}
	}
	
	// all path printing
	void allpaths(int src, int des,boolean[] vis,String pf)
	{
		
		if (src==des) { System.out.println(pf); return; }
		vis[src]=true;
		for(int i:gh[src]) {
			if (vis[i] != true) { allpaths(i,des,vis,pf+i); }
		}
		vis[src]=false;
		
		
	}
}

public class Path_In_ADGraph {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();
		int edg=sc.nextInt();
		
		Paths p=new Paths(vtx);
		for(int i=0;i<edg;i++)
		{
			int s=sc.nextInt();
			int d=sc.nextInt();
			p.addEdg(s, d);
		}	
		int src=sc.nextInt();
		int des=sc.nextInt();
		
		boolean[] vis=new boolean[vtx];
		System.out.println("All PATHS FROM SOURCE TO DESTINATION ");
		int[][] arr=new int[2][3];
		p.allpaths(src,des,vis,src+"");
	}
}
