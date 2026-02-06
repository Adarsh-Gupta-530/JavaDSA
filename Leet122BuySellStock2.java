public class Leet122BuySellStock2 {
    public static int totalMaxProfit(int[] prices) {
        // track buy price and totalMaxProfit
        int buyPrice = Integer.MAX_VALUE;
        int totalProfit = 0;
        // calculate the total maxProfit
        for(int i = 0; i<prices.length;i++){  
            int sellPrice = prices[i]; // get the selling price 
            if(buyPrice<sellPrice){ // if profit 
                int profit = sellPrice - buyPrice; //earned profit 
                totalProfit+=profit;  // add it into totalMaxProfit
            }
            // update the buy price if profit thealso if loss as well
            buyPrice = sellPrice; // update the buy price to claculate the next maxProfit
        }
        return totalProfit; // return the max profit   
    }
    public static void main(String[] args) {
        // int prices[] = {7,1,5,3,6,4};
        // int prices[] = {1,2,3,4,5};
        int prices[] = {7,6,4,3,1}; 
        System.out.println(totalMaxProfit(prices));
    }
}
