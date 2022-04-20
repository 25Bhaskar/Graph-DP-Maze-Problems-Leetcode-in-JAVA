package DP_GridProbs;

import java.util.*;
public class KnightTour_recursion_pepcoding {
	public static void dis(int[][] vis,int r,int c) {
	
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(vis[i][j]+" ");
			}
			System.out.println(" ");
		}
	
	}
	public static void Ktour(int i,int j,int r,int c,int[][] vis,int sum,int k,List<Integer> com) {
		
		if(i<0 || j<0 || i>=r || j>=c || vis[i][j] >0) { return; } 
		else if (sum==r*c)
		{ 
			vis[i][j]=sum;
			//com.add(++k);
			dis(vis,r,c);
			
			vis[i][j]=0;
			return  ;
		}
	
		vis[i][j]=sum;
		Ktour(i-2,j+1,r,c,vis,sum+1,k,com);
		Ktour(i-1,j+2,r,c,vis,sum+1,k,com);
		Ktour(i+1,j+2,r,c,vis,sum+1,k,com);
		Ktour(i+2,j+1,r,c,vis,sum+1,k,com);
		Ktour(i+2,j-1,r,c,vis,sum+1,k,com);
		Ktour(i+1,j-2,r,c,vis,sum+1,k,com);
		Ktour(i-1,j-2,r,c,vis,sum+1,k,com);
		Ktour(i-2,j-1,r,c,vis,sum+1,k,com);
		vis[i][j]=0;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt(); // row
		int c=sc.nextInt(); // col
		
		int[][] vis=new int[r][c];
		
		int i=sc.nextInt(); // starting index row
		int j=sc.nextInt(); // starting index col
		
		List<Integer> com=new ArrayList<>();
		Ktour(i,j,r,c,vis,1,0,com);
		System.out.println(com);
		
	}

}
