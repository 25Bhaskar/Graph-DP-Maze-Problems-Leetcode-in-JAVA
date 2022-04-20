package Graph;
import java.util.*;
/*
 * input format :
 7  
 5   
 0 1 
 2 3 
 4 5 
 5 6 
 4 6 
 */

class Components
{
	int s;
	int d;
	
	Components(int s, int d)
	{
		this.s=s;
		this.d=d;
	}
}
public class PerfectFriends {
	
	public static void pfriends(ArrayList<Components>[] graph,boolean[] vis,int v,ArrayList<Integer> com) 
	{
		vis[v]=true;
		com.add(v);
		for(Components cm : graph[v]) 
		{
			if (vis[cm.d] !=true){
				pfriends(graph,vis,cm.d,com);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner Sc=new Scanner(System.in);
		int vtx=Sc.nextInt();
		int edg=Sc.nextInt();
		
		ArrayList<Components>[] graph=new ArrayList[vtx];
		for (int i=0;i<vtx;i++) graph[i]=new ArrayList<>();
		for(int j=0;j<edg;j++)
		{
			int v1=Sc.nextInt();
			int v2=Sc.nextInt();
			graph[v1].add(new Components(v1,v2));
			//graph[v2].add(new Components(v2,v1));
		}
		
		boolean[] vis=new boolean[vtx];
		ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
		for(int v=0;v<vtx;v++)
		{
			if (vis[v] !=true) {
				ArrayList<Integer> com=new ArrayList<>();
				pfriends(graph,vis,v,com);
				comps.add(com);
			}
		}
		System.out.println(comps);
		int val=0;
		for(int k=0;k<comps.size();k++) {
			for(int p=k+1;p<comps.size();p++) {
				val=val+comps.get(k).size()*comps.get(p).size();
			}
		}
		System.out.println(val);
	}
}
