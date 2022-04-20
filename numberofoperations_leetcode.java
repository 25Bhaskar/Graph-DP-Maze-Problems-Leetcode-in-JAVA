package Graph2;
import java.util.*;

class node {
	int s;
	int d;
	node(int s,int d){
		this.s=s;
		this.d=d;
	}
}
public class numberofoperations_leetcode {
	public static void components(LinkedList<node>[] graph,int k,LinkedList<Integer> c, boolean[] vis) {
		vis[k]=true;
		c.add(k);
		for(node e: graph[k]) {
			if (vis[e.d] != true) {
				components(graph,e.d,c,vis);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int[][] conn= {{1,4},{0,3},{1,3},{3,7},{2,7},{0,1},{2,4},{3,6},{5,6},{6,7},{4,7},{0,7},{5,7}};
		int n=11;
		int edges=conn.length;
		
		if ((n-1) > edges) { System.out.println(" -1 "); }
		
		LinkedList<node>[] graph=new LinkedList[n];
		for(int i=0;i<n;i++) graph[i]=new LinkedList<>();
		
		for(int j=0;j<edges;j++) {
			graph[conn[j][0]].add(new node(conn[j][0],conn[j][1]));
			graph[conn[j][1]].add(new node(conn[j][1],conn[j][0]));
		}
		
		//------------ finding connected components
		boolean[] vis=new boolean[n];
		List<List<Integer>> com=new LinkedList<>();
		
		for(int k=0;k<n;k++) {
			if (vis[k] !=true) {
				LinkedList<Integer> c=new LinkedList<>();
				components(graph,k,c,vis);
				com.add(c);
			}
		}
		int p=com.size()-1;
		System.out.println("Operation Required : "+p);
	}
}

