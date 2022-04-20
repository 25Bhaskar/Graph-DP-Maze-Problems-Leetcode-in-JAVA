package Graph;
import java.util.*;

class graphEdge
{
	int v;
	LinkedList<Integer>[] graph;
	graphEdge(int node)
	{
		v=node;
		graph=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			graph[i]=new LinkedList<Integer>();
		}
	}
	void addEdges(int s,int d)
	{
		graph[s].add(d);
		//graph[d].add(s);
	}
	void show(int v)
	{
		for(int i=0;i<v;i++)
		{
			System.out.println(graph[i]);
		}
	}
	
}


public class GraphCreation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();
		int edg=sc.nextInt();
	
		graphEdge gh=new graphEdge(vtx);
		for(int j=0;j<edg;j++)
		{
			int src=sc.nextInt();
			int des=sc.nextInt();
			gh.addEdges(src,des);
		}
		gh.show(vtx);
	}
}


// Another way of representation of graph
/*
class graphEdge
 
{
	int s;
	int d;
	graphEdge(int s,int d)
	{
		this.s=s;
		this.d=d;
	}
}
public class GraphCreation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();
		int edg=sc.nextInt();
		
		ArrayList<graphEdge>[] graph=new ArrayList[vtx];
		
		for(int i=0;i<vtx;i++)
		{
			graph[i]=new ArrayList<>();
		}
		
		for(int j=0;j<edg;j++)
		{
			int src=sc.nextInt();
			int des=sc.nextInt();
			graph[src].add(new graphEdge(src,des));
			graph[des].add(new graphEdge(des,src));
		}
	
	}
}
*/