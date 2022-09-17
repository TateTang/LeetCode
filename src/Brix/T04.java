package Brix;

import java.util.*;

/**
 * @author tangmf
 * @date 2022年09月16日 18:37:​12
 * 金融分析师负责以数组表示的盈利股票投资组合。数组中的每一项代表村应股票的年利润。
 * 分析师收集所有达到目标利润的不同股票对。不同的火是至少在一个元素上不同的对。
 * 给定利润数组，找出每对利润之和正好等于目标利润的不同股票对的数量。
 * 例子
 * 股票利润=5， 7， 9，13， 11， 6，63 31
 * 目标=12利润的目标
 * 有4对股票的利润总和等于目标12。请注意，由于在stockProfit中有两个 3的实例，
 * 因此有两对匹配 (9， 3)： stockProfits索引2和7，以及索引2和 8，但只能包含一个。
 * 有3对不同的股票：(5，7）、(3、9)和(6 6)，返回值为3。
 */
public class T04 {
    public static void main(String[] args) {
        List<Integer> stocksProfit = new ArrayList<>();
        stocksProfit.add(5);
        stocksProfit.add(7);
        stocksProfit.add(9);
        stocksProfit.add(13);
        stocksProfit.add(11);
        stocksProfit.add(6);
        stocksProfit.add(6);
        stocksProfit.add(3);
        stocksProfit.add(3);
        long target = 12;

        //stocksProfit.add(1);
        //stocksProfit.add(3);
        //stocksProfit.add(46);
        //stocksProfit.add(1);
        //stocksProfit.add(3);
        //stocksProfit.add(9);
        //long target = 47;

        //stocksProfit.add(7);
        //stocksProfit.add(6);
        //stocksProfit.add(12);
        //stocksProfit.add(3);
        //stocksProfit.add(9);
        //stocksProfit.add(3);
        //stocksProfit.add(5);
        //stocksProfit.add(1);
        //long target = 12;
        System.out.println(stockPairs1(stocksProfit, target));
    }

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        // Write your code here
        Collections.sort(stocksProfit);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < stocksProfit.size(); i++) {
            for (int j = i + 1; j < stocksProfit.size(); j++) {
                if (stocksProfit.get(i) + stocksProfit.get(j) == target) {
                    //否则需要判断后才加入
                    if (!res.contains(stocksProfit.get(i))) {
                        res.add(stocksProfit.get(i));
                    }
                    if (!res.contains(stocksProfit.get(j))) {
                        res.add(stocksProfit.get(j));
                    }
                }
            }
        }
        System.out.println(res);
        //+1，是为了同参数，同时/ 会取整
        return (res.size() + 1) / 2;
    }

    public static int stockPairs1(List<Integer> stocksProfit, long target) {
        //双指针
        int left = 0;
        int right = stocksProfit.size() - 1;
        List<Integer> res = new ArrayList<>();
        while (left < right) {
            int sum = stocksProfit.get(left) + stocksProfit.get(right);
            if (sum > target) {
                //大于目标值，说明右指针指向的节点大了，right--
                right--;
            } else if (sum < target) {
                //小于目标值，说明左指针指向的节点小了，left++
                left++;
            } else {
                //等于目标值，记录，然后继续，直接返回该数组即可
                res.add(stocksProfit.get(left));
                res.add(stocksProfit.get(right));
                left++;
            }
        }
        System.out.println(res);
        return (res.size() + 1) / 2;
    }
}
