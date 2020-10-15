package MeiTuan;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-22
 */
public class StockTrade {

    /**
     * 假设股票只能交易两次
     */
    public int maxProfit(int[] prices, int n) {
        // write code here
        int firstBuy = Integer.MIN_VALUE, firstSell = Integer.MIN_VALUE;
        int secondBuy = Integer.MIN_VALUE, secondSell = Integer.MIN_VALUE;
        for (int p : prices) {
            firstBuy = Math.max(firstBuy, -p);
            firstSell = Math.max(firstSell, firstBuy + p);
            secondBuy = Math.max(secondBuy, firstSell - p);
            secondSell = Math.max(secondSell, secondBuy + p);
        }
        return secondSell;
    }
}
