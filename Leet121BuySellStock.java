public class Leet121BuySellStock {
    public static int maxPrice(int prices[]){  //TC-> O(n)
        //steps 
        // 1. track minBuyPrice and maxProfit 
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        // calculate max profit 
        for(int i=0;i<prices.length;i++){
            // case1 -> profit
            int sellPrice = prices[i];
            if(buyPrice<sellPrice){
                int profit = sellPrice - buyPrice; // todays profit calculated
                maxProfit = Math.max(profit, maxProfit); // if max store in max profit
            }else{ //case ->2 -> loss 
                buyPrice = sellPrice;
            }
        }
        return maxProfit; // return the maximum profit.
    }

    public static void main(String[] args) {
        // int prices[] = {7,1,5,3,6,4};
        int prices[] = {7,6,4,3,1};
        System.out.println(maxPrice(prices));
    }
}
