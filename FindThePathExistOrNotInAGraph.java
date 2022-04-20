package Graph;
import java.util.*;
/*
 * [input format]
 * --> All integer <--
 * vertex
 * edges
 * source destination weight
 * ...
 * ...
 * ...
 * Path_search_source
 * Path_search_destination
 * 
 * 
 * [Output format]
 * true / false (depending upon the inputs provided by the user)
 * 
 * example:
 * 7
 * 8
 * 0 1 10
 * 1 2 10
 * 2 3 10
 * 0 3 40
 * 3 4 2
 * 4 5 3
 * 5 6 3
 * 4 6 8
 * 0
 * 6
 * 
 * 
 * true
 */

class Edge
{
	int s; int d; int w;
	Edge(int s,int d,int w)
	{
		this.s=s; this.d=d; this.w=w;
	}
}

public class FindThePathExistOrNotInAGraph {	
	
	public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] vis,int s,int d)
	{
		if (s==d) return true;		
		vis[s]=true;
		for (Edge e : graph[s])
		{
			if (vis[e.d] != true)
			{
				boolean hP=hasPath(graph,vis,e.d,d);
				if (hP) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt(); //vertex in a graph
		int edg=sc.nextInt(); //edges in a graph
		
		ArrayList<Edge>[] graph=new ArrayList[vtx];
		
		for(int i=0; i<vtx; i++) { graph[i]=new ArrayList<>(); }
		
		for(int j=0;j<edg;j++){
			int v1=sc.nextInt(); 
			int v2=sc.nextInt();
			int w=sc.nextInt();
			graph[v1].add(new Edge(v1,v2,w));
			graph[v2].add(new Edge(v2,v1,w));
		}
		
		int s=sc.nextInt(); //source
		int d=sc.nextInt(); //destination
		
		boolean[] vis=new boolean[vtx];
		boolean path=hasPath(graph,vis,s,d);
		System.out.println("Path exist between source "+s+" and"+" destination "+d+" - > "+path);
	}

}
