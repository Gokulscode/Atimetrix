package Neetcode;

public class MaxProfit {
    static void main() {
        int [] graph = {7,1,5,3,6,4};

        System.out.println(findMaxProfit(graph));
    }

    private static int findMaxProfit(int[] graph) {
        int profit = 0;
        int min = graph[0];

        for(int i =0 ; i<graph.length; i++){
            if(graph[i]<min){
                min = graph[i];
            }
            profit = Math.max(profit,graph[i]-min);
        }
        return profit;
    }
}
