package Graph;

import java.util.*;
class Topo_class
{
	int s;
	int d;
	Topo_class(int s,int d) {
		this.s=s;
		this.d=d;
	}
}

public class TopologicalSort_directedGraph {
	public static void topological(List<Topo_class>[] graph,boolean[] vis,int src,Stack<Integer> st)
	{
		vis[src]=true;
		for(Topo_class t: graph[src])
		{
			if (vis[t.d] != true)
			{
				topological(graph,vis,t.d,st);
			}
		}
		st.push(src);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();
		int edg=sc.nextInt();
		
		List<Topo_class>[] graph=new LinkedList[vtx];
		
		for(int i=0;i<vtx;i++) graph[i]=new LinkedList<>();
		
		for(int i=0;i<edg;i++) {
			int s=sc.nextInt();
			int d=sc.nextInt();
			graph[s].add(new Topo_class(s,d)); //1 D Directed graph
		}
		
		boolean[] vis=new boolean[vtx];
		Stack<Integer> st=new Stack<>();
		
		for(int i=0;i<vtx;i++) {
			if (vis[i]!=true) {
				topological(graph,vis,i,st);
			}
		}
		
		while(st.size() > 0)
		{
			System.out.println(st.pop());
		}
	}

}
