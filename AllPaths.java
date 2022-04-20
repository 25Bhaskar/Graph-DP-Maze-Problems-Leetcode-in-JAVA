package Graph;
// shortest path from source to destination with distance and print all paths from source to destination
// using BFS
import java.util.*;

class Path
{
	int v;
	LinkedList<Integer>[] gh;
	Path(int node)
	{
		v=node;
		gh=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			gh[i]=new LinkedList<Integer>();
		}
	}
	
	void addEdg(int s,int d)
	{
		gh[s].add(d);
		gh[d].add(s);
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
		for(int i:gh[src])
		{
			if (vis[i] != true) allpaths(i,des,vis,pf+i);
		}
		vis[src]=false;
	}
	
	
	// shortest path with distance
	void pathprint(int src, int des,int[] dis, boolean[] vis, String pf, Deque<Integer> q)
	{
		Arrays.fill(dis, 0); // no need 
		dis[src]=-1;
		q.add(src);
		vis[src]=true;
		
		while(!q.isEmpty())
		{
			int rem=q.remove();	
			for(int i:gh[rem]) {
			if (vis[i] !=true ) { vis[i]=true; q.add(i); dis[i]=rem; }
			}
		}
		int i=des;
		int count=0;
		while( dis[i] !=-1)
		{
			pf=pf+i;
			i=dis[i];
			count++;
		}
		pf=pf+src;
		for(int j=pf.length()-1;j>=0;j--) {
			System.out.print(pf.charAt(j));
		}
		System.out.println(" ");
		System.out.println("distance in units :"+count);
	}
}
public class AllPaths 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();
		int edg=sc.nextInt();
		
		Path p=new Path(vtx);
		for(int i=0;i<edg;i++)
		{
			int s=sc.nextInt();
			int d=sc.nextInt();
			p.addEdg(s, d);
		}	
		int src=sc.nextInt();
		int des=sc.nextInt();
		p.show(vtx);		
		boolean[] vis=new boolean[vtx];
		int[] dis=new int[vtx];
		
		// printing shortest path with distance 
		Deque<Integer> q=new ArrayDeque<>();
		p.pathprint(src, des,dis,vis,"",q);
		
		// printing all paths from source to destination
		boolean[] vis1=new boolean[vtx];
		System.out.println("All PATHS FROM SOURCE TO DESTINATION ");
		p.allpaths(src,des,vis1,src+"");
	}
}

