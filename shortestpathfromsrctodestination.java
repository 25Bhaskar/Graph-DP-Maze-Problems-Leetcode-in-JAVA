package Graph;
import java.util.*;

class shortestGraph
{
	int s;
	int d;
	shortestGraph(int s,int d)
	{
		this.s=s;
		this.d=d;
	}
}

public class shortestpathfromsrctodestination {
	
	public static void recursive(LinkedList<shortestGraph>[] graph,int src,int dest,boolean[] vis, String k, LinkedList<LinkedList<Integer>> com, LinkedList<Integer> c)
	{
		if (src==dest) { System.out.println(k);com.add(new LinkedList<>(c));}
		vis[src]=true;
		
		for(shortestGraph e: graph[src])
		{
			if (vis[e.d] !=true) {
				c.add(e.d);
				recursive(graph,e.d,dest,vis,k+e.d,com,c);
				c.remove(c.size()-1);
			}
		}
		vis[src]=false;
	}
	public static void main(String[] args) {
		int vtx=9;
		int edg=11;
		
		Scanner sc=new Scanner(System.in);
		LinkedList<shortestGraph>[] graph=new LinkedList[vtx];
		
		for(int i=0;i<vtx;i++) graph[i]=new LinkedList();
		
		for(int j=0;j<edg;j++)
		{
			int s=sc.nextInt();
			int d=sc.nextInt();
			graph[s].add(new shortestGraph(s,d));
			graph[d].add(new shortestGraph(d,s));
		}
		
		boolean[] vis=new boolean[vtx];
		int src=sc.nextInt();
		int dest=sc.nextInt();
		LinkedList<LinkedList<Integer>> com=new LinkedList<>();
		LinkedList<Integer> c=new LinkedList<>();
		c.add(src);
		recursive(graph,src,dest,vis,src+"",com,c);
		int min=Integer.MAX_VALUE;
		
		for(int k=0;k<com.size();k++)
		{
			min=Math.min(min, com.get(k).size());
		}
		System.out.println(min-1);
	}

}
