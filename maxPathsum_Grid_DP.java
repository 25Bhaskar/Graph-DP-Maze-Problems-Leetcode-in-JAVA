package DP_GridProbs;

import java.util.*;
public class maxPathsum_Grid_DP 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		int[][] grid=new int[r][c];
		int[][] dp=new int[r][c];
		
		for(int k=0;k<r;k++) {
			for(int p=0;p<c;p++) {
				grid[k][p]=sc.nextInt();
			}
		}
		
		int i,j;
		
		dp[0][0]=grid[0][0];
		
		for( i=1;i<r;i++)
		{
			dp[i][0]=dp[i-1][0]+grid[i][0];
		}
		for( j=1;j<c;j++)
		{
			dp[0][j]=dp[0][j-1]+grid[0][j];
		}
		
		for(i=1;i<r;i++)
		{
			for(j=1;j<c;j++)
			{
				dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
			}
		}
		System.out.println(dp[r-1][c-1]);
	}
}
