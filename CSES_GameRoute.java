package Graph;
// Question
/*
 * A game has n levels, connected by m teleporters, and your task is to get from level 1 to level n. The game has been designed so that there are no directed cycles in the underlying graph. In how many ways can you complete the game?

Input

The first input line has two integers n and m: the number of levels and teleporters. The levels are numbered 1,2,…,n.

After this, there are m lines describing the teleporters. Each line has two integers a and b: there is a teleporter from level a to level b.

Output

Print one integer: the number of ways you can complete the game. Since the result may be large, print it modulo 109+7.

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
4 5
1 2
2 4
1 3
3 4
1 4

Output:
3
 */
import java.util.*;
class game
{
	int s;
	int d;
	game(int s,int d) {
		this.s=s;
		this.d=d;
	}
}
public class CSES_GameRoute 
{
	public static int 	groute(List<game>[] graph,int src,int des,boolean[] vis,int count)
	{
		
		if (src==des) { count++;return 0; }
		vis[src]=true;
		for(game g:graph[src]) {
			if (vis[g.d] !=true) { 
				groute(graph,g.d,des,vis,count++);
			}
		}
	    vis[src]=false;
	    return count;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vtx=sc.nextInt();//vertices
		int ed=sc.nextInt();//edges
		
		int grid[][]=new int[200][2];
		for(int i=0;i<ed;i++)
		{
			grid[i][0]=sc.nextInt();
			grid[i][1]=sc.nextInt();
		}
		
		List<game>[] graph=new LinkedList[vtx+1];
		
		for(int j=0;j<vtx+1;j++) graph[j]=new LinkedList<>();
		
		for(int j=0;j<ed;j++) graph[grid[j][0]].add(new game(grid[j][0],grid[j][1]));
		
		boolean[] vis=new boolean[vtx+1];

		int src=1;
		int des=vtx;
		
		int count=groute(graph,src,des,vis,0);
		System.out.println(count);
	}
}

