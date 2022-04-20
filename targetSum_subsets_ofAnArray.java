package DP_GridProbs;
//Question
//https://www.youtube.com/watch?v=zNxDJJW40_k&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=48
import java.util.*;
public class targetSum_subsets_ofAnArray {
	public static void targetsum(int[] arr,int i,int sum,String str,int tar)
	{
		if (i==arr.length)  
		{
			if (sum==tar) 
			{ 
				System.out.println(str+" "); 
			}
			return;
		}
		targetsum(arr,i+1,sum+arr[i],str+arr[i]+" ",tar);
		targetsum(arr,i+1,sum,str,tar);
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int sz=sc.nextInt();
		int[] arr=new int[sz];
		for(int i=0;i<sz;i++) arr[i]=sc.nextInt();
		
		int tar=sc.nextInt();
		targetsum(arr,0,0," ",tar);
		

	}

}
