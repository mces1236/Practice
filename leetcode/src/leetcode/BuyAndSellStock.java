package leetcode;

public class BuyAndSellStock {

	public static void main(String[] args) {
		int[] arr = {7, 6, 4, 3, 1};
		System.out.println(new BuyAndSellStock().maxProfit(arr));
	}

	public int maxProfit(int[] prices) {
		
		int len = prices.length, profit = 0;
		
		if(len == 0) return 0;
		
		int minSofar = prices[0];
		
		for(int i = 1; i < len; i++) {
			int cur = prices[i];
			
			if(cur < minSofar) minSofar = cur;
			else {
				int temp = cur - minSofar;
				if(temp > profit) profit = temp;
			}
		}
		
		return profit;
	}
}
