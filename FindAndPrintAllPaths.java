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
 * 
 * Path_search_source
 * Path_search_destination
 * 
 * [output format]
 * all possible paths in between Path_search_source to Path_search_destination
 * 
 * example:
  7
  8
  0 1 10
  1 2 10
  2 3 10
  0 3 40
  3 4 2
  4 5 3
  5 6 3
  4 6 8
  0
  6
 * -0123456-
 * -012346-
 * -03456-
 * -0346-
 */
class Edge_1
{
	int s; 
	int d;
	int w;
	Edge_1(int s,int d,int w) {
		this.s=s;
		this.d=d;
		this.w=w;
	}
}

public class FindAndPrintAllPaths {	
	public static void hasPath(ArrayList<Edge_1>[] graph, boolean[] vis,int s,int d,String pf)
	{
		if (s==d) { System.out.println("-"+pf+"-"); return; } //base		
		
		vis[s]=true;
		for (Edge_1 e : graph[s])
		{
			if (vis[e.d] == false)
			 {
				hasPath(graph,vis,e.d,d,pf+e.d); //source change to neighbour.
			}
		}
		vis[s]=false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt(); //vertex in a graph
		int edg=sc.nextInt(); //edges in a graph
		
		ArrayList<Edge_1>[] graph=new ArrayList[vtx];
		
		for(int i=0; i<vtx; i++) { graph[i]=new ArrayList<>(); }
		
		for(int j=0;j<edg;j++){
			int v1=sc.nextInt(); 
			int v2=sc.nextInt();
			int w=sc.nextInt();
			graph[v1].add(new Edge_1(v1,v2,w));
			graph[v2].add(new Edge_1(v2,v1,w));
		}
		
		int s=sc.nextInt(); //source
		int d=sc.nextInt(); //destination
		
		boolean[] vis=new boolean[vtx];
		hasPath(graph,vis,s,d,"0");
	}
}
