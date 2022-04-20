package Graph2;
import java.util.*;
public class leetcode_322_coinchange {
	
	public static int call(int[] coins,int amount)
	{
		int [] dp=new int[amount+1];
		Arrays.fill(dp,amount+1);
        dp[0]=0;
        
		for(int i=0;i<coins.length;i++) {
			for(int j=coins[i]; j <= amount;j++) {
				dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
			}
		}
		
		return dp[amount] <=amount ? dp[amount] : -1;
		
    }
	
	public static void main(String[] args) {
		int [] arr= {1,2,5};
		int amt=11;
		int val=call(arr,amt);
		System.out.println(val);
	}

}
