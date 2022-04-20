package Graph;

import java.util.*;

class PA
{
	int s;
	int d;
	int w;
	PA(int s,int d, int w){
		this.s=s;
		this.d=d;
		this.w=w;
	}
}

class Pair1 implements Comparable<Pair1>
{
	int v;
	int ori;
	int w;
	Pair1(int v,int ori, int w){
		this.v=v;
		this.ori=ori;
		this.w=w;
	}
	public int compareTo(Pair1 o){
		return this.w-o.w;
	}
}
public class PrimsAlgorithm {	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();
		int edg=sc.nextInt();
		
		LinkedList<PA>[] gh=new LinkedList[vtx];
		for(int j=0;j<vtx;j++) gh[j]=new LinkedList<>();
		for(int i=0;i<edg;i++) {
			int s=sc.nextInt();
			int d=sc.nextInt();
			int w=sc.nextInt();
			gh[s].add(new PA(s,d,w));
			gh[d].add(new PA(d,s,w));
		}
		
		int src=sc.nextInt();
	
		PriorityQueue<Pair1> pq=new PriorityQueue();
		pq.add(new Pair1(src,-1,0));
		
		boolean[] vis=new boolean[vtx];
		
		while (!pq.isEmpty()) {
			Pair1 rem=pq.remove();
			
			if (vis[rem.v]== true) continue; 
			
			vis[rem.v]=true;
			
			System.out.println("vertex :"+rem.v+" : origin from : "+rem.ori+" : Weight : "+rem.w);
			
			for(PA e:gh[rem.v]) {
				if (vis[e.d]!=true) pq.add(new Pair1(e.d,rem.v,e.w));
			}
		}
		
	}

}
