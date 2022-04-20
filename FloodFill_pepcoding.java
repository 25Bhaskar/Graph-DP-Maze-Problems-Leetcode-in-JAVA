package DP_GridProbs;

import java.util.*;
// Question Link
// https://www.youtube.com/watch?v=FkkgY7qQF_s&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs
// also store result in a List of string type
public class FloodFill_pepcoding {
	public static void floodfill(int[][] grid,int i,int j, int r, int c, boolean[][] vis,String pf,List<String> com)
	{
		if (i<0 || i>=r || j<0 || j>=c || vis[i][j]==true || grid[i][j]==1) return;
		if (i==r-1 && j==c-1)  { System.out.println(pf); com.add(pf); } 
		vis[i][j]=true;
		floodfill(grid,i+1,j,r,c,vis,pf+"D",com);
		floodfill(grid,i,j+1,r,c,vis,pf+"R",com);
		floodfill(grid,i-1,j,r,c,vis,pf+"U",com);
		floodfill(grid,i,j-1,r,c,vis,pf+"L",com);
		vis[i][j]=false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		
		int[][] grid=new int[r][c];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				grid[i][j]=sc.nextInt();
			}
		}
		
		boolean[][] vis=new boolean[r][c];
		// Source : Top Left Corner
		// Destination : Bottom Right Corner
		List<String> com=new LinkedList<>();
		floodfill(grid,0,0,r,c,vis," ",com);
		System.out.println(com);
	}

}
