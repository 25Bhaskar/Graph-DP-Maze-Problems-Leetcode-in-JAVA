package Graph;
import java.util.*;
/*
 *  Spreading Infection Problem :
 *  In this problem one source and time is given, you need find out how many nodes of graph gets infected if given node is infected
 *  at time t=1 within the given time span.
7 //vetex
8 //edges
0 1
1 2
2 3
3 0
3 4
4 5
5 6
6 4
6 //source
3 // at time t=3 how any nodes gets affected if infection starts from source given to you as input.
 *  
 */


class infection
{
	int v;
	LinkedList<Integer>[] gh;
	infection(int node)
	{
		v=node;
		gh=new LinkedList[v];
		for(int i=0;i<v;i++) {
			gh[i]=new LinkedList();
		}
	}
	
	void addEdges(int s,int d)
	{
		gh[s].add(d);
		gh[d].add(s);
	}
	
	void show(int n) {
		for(int i=0;i<n;i++)
		{
			System.out.println("NODE : "+i+" "+gh[i]);
		}
	}
	void countPerson(int src, int t,int count, boolean[] vis,Queue<Integer> Q) {
		while(Q.size()>0)
		{
			int rem=Q.remove();
			if (vis[rem]==true) continue;
			else vis[rem]=true;
			
			for(int j:gh[rem]) {
				if (vis[j] != true) Q.add(j);
			}
			if (count>t) { System.out.println(count); return ; }
			count++;
		}
		
	}
}

public class SpreadInfection 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();
		int edg=sc.nextInt();
		infection inf=new infection(vtx);
		for(int i=0;i<edg;i++) {
			int s=sc.nextInt();
			int d=sc.nextInt();
			inf.addEdges(s,d);
		}
		
		int src=sc.nextInt();
		int t=sc.nextInt();
		inf.show(vtx);
		boolean[] vis=new boolean[vtx];
		Deque <Integer> Q=new ArrayDeque <>();
		Q.add(src);
		inf.countPerson(src,t,0,vis,Q);
	}
}
