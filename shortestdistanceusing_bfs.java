package Graph;

import java.util.*;

class shortestGraph_
{
	int s;
	int d;
	shortestGraph_(int s,int d)
	{
		this.s=s;
		this.d=d;
	}
}

class pairr implements Comparable<pairr>
{
	int v;
	int dis;
	pairr(int v,int dis)
	{
		this.v=v;
		this.dis=dis;
	}
	public int compareTo(pairr o)
	{
		return this.dis-o.dis;
	}
}


public class shortestdistanceusing_bfs {
	
	public static void main(String[] args) {
		int vtx=9;
		int edg=11;
		
		Scanner sc=new Scanner(System.in);
		
		LinkedList<shortestGraph_>[] graph=new LinkedList[vtx];
		
		for(int i=0;i<vtx;i++) graph[i]=new LinkedList();
		
		for(int j=0;j<edg;j++)
		{
			int s=sc.nextInt();
			int d=sc.nextInt();
			graph[s].add(new shortestGraph_(s,d));
			graph[d].add(new shortestGraph_(d,s));
		}
		
		boolean[] vis=new boolean[vtx];
		
		int src=sc.nextInt();
		int dest=sc.nextInt();
		
		Deque<pairr> q=new ArrayDeque<>();
		q.add(new pairr(src,0));
		int flag=0;
		int val=0;
		while(!q.isEmpty())
		{
			int sz=q.size();
			if (sz==0) break;
			while(sz-- >0) {
				pairr rem=q.remove();
				if (rem.v==dest) { val=rem.dis; flag=1; break; }
				for(shortestGraph_ e:graph[rem.v]) 
				{
				
					if (vis[rem.v] != true)
					{
						q.add(new pairr(e.d,rem.dis+1));
					}
				}
			}
			if (flag==1) break;
		}
		System.out.println(val);
		
	}

}
