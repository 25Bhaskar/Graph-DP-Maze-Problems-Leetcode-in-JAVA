package Graph;

import java.util.*;

class Dijkstra
{
	int s; //source 
	int d; //destination
	int w; //weight
	Dijkstra(int s, int d, int w)
	{
		this.s=s;
		this.d=d;
		this.w=w;
	}
}

class Pair implements Comparable<Pair>
{
	int v;
	String psf;  //path so far : to print path
	int wsf;     //weight so fat : to add weight 
	Pair(int v,String psf, int wsf)
	{
		this.v=v;
		this.psf=psf;
		this.wsf=wsf;
	}
	
	public int compareTo(Pair o)
	{
		return this.wsf - o.wsf ;
	}
	
}

public class DijkstraAlgorithm 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		int vtx=sc.nextInt();
		int edg=sc.nextInt();
		
		LinkedList<Dijkstra>[] graph=new LinkedList[vtx];
		
		for(int j=0;j<vtx;j++) graph[j]=new LinkedList<>();
		
		for(int i=0;i<edg;i++) {
			int s=sc.nextInt();
			int d=sc.nextInt();
			int w=sc.nextInt();
			graph[s].add(new Dijkstra(s,d,w));
			//graph[d].add(new Dijkstra(d,s,w));	
		}
		int src=sc.nextInt();
		
	PriorityQueue<Pair> PQ=new PriorityQueue<>();
	PQ.add(new Pair(src,src+" ",0));
	
	boolean[] vis=new boolean[vtx];
	
	while(PQ.size() >0)
	{
		Pair rem=PQ.remove();
		if (vis[rem.v]==true) continue;
		vis[rem.v]=true;
		
		System.out.println(rem.psf +" "+ rem.wsf);
		
		for( Dijkstra e :graph[rem.v])
		{
			if (vis[e.d] ==false) PQ.add(new Pair(e.d,rem.psf+e.d,rem.wsf+e.w));
		}
	}
	
	}
}
