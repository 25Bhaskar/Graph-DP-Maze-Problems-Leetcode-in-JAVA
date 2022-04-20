package Graph;
import java.util.*;

class graphconnection
{
	int v;
	LinkedList<Integer>[] gh;
	graphconnection(int node)
	{
		v=node;
		gh=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			gh[i]=new LinkedList<Integer>();
		}
	}
	
	void addEdg(int s, int d)
	{
		gh[s].add(d);
		//gh[d].add(s);
	}
	void show(int v)
	{
		for(int i=0;i<v;i++)
		{
			System.out.println("node "+i+" "+gh[i]);
		}
	}
	
	boolean isCyclic(int v,boolean[] vis,int cc)
	{
		for(int i=0;i<v;i++){
			vis[i]=true;
			if (gh[i].isEmpty()) continue;
			for(int j:gh[i]){
				if (vis[j] == true) { cc++;}
				}
			
			if (i==v-1) { System.out.println(cc); return true; }
			}
		
		
		return false;
	}
	
}
public class isGraphCyclic {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();
		graphconnection gh=new graphconnection(vtx);
		int edg=sc.nextInt();
		
		for(int i=0;i<edg;i++){
			int s=sc.nextInt();
			int d=sc.nextInt();
			gh.addEdg(s, d);
		}
		gh.show(vtx);
		boolean[] vis= new boolean[vtx];
		boolean res=gh.isCyclic(vtx,vis,0);
		System.out.println(res);
		
		
		
	}

}
