package Graph;
//leetcode 322
import java.util.*;

public class CoinChangePermutation {
	public static void main(String[] args) {
		int []arr= {2,3,5,6};
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter change value you want to made : ");
		int V=sc.nextInt();
		
		int []dp=new int[V+1];
		dp[0]=1;
		Arrays.sort(arr);
		
		for (int i=1 ;i<=V;i++) {
			for(int j=0;j<arr.length;j++) {
				if (arr[j] <= i) {
					dp[i]+=dp[i-arr[j]];
				}
			}
			
		}
		for(int k=0;k<dp.length;k++) System.out.print(k+"->"+dp[k]+" ");System.out.println(" ");
		System.out.println("combinations : "+dp[V]);

	}

}
