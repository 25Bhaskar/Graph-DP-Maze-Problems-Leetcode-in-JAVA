package Graph;
//leetcode 518
import java.util.*;
// with dp
public class CoinChangeCombination 
{
	public static void main(String[] args)
	{
		int []arr= {2,3,5};
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter change value you want to made : ");
		int V=sc.nextInt();
		
		int []dp=new int[V+1];
		dp[0]=1;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) 
		{
			for (int j=arr[i];j<dp.length;j++) 
			{ 
				dp[j]=dp[j] + dp[j-arr[i]];
				
			}
		}
		for(int k=0;k<dp.length;k++) System.out.print(k+"->"+dp[k]+" ");System.out.println(" ");
		System.out.println("combinations : "+dp[V]);
	}
}


/* Without dp
		Arrays.sort(arr);
		int i=arr.length-1,sum=0,count=0;
		while(i>=0)
		{
			if ( arr[i] <= V )
				{ count++;sum+=arr[i]; V=V-arr[i];}
			i--; 
		}
		System.out.println(count);
	}
}
*/