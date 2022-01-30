package exchange_rate_converter;


import exchange_rate_converter.datastructures.Pair;
import exchange_rate_converter.datastructures.PairGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RateCalculator {
    Pair toCalculate;
    PairGraph pairGraph;
    private final int CANNOT_BE_CALCULATED = -1;

    public RateCalculator(PairGraph pairGraph,InputParser parser){
        this.toCalculate = parser.getPairToCalculate();
        this.pairGraph = pairGraph;
    }

    // Use BFS and treat the pairs as a graph with vertices - the currencies and edges- the rates between them.
    public double calculateRate(){
        if(toCalculate.getBase().equals(toCalculate.getQuote()))
            return 1.0;
        Queue<String> frontier = new LinkedList();
        Queue<Double> path = new LinkedList();
        HashSet<String> visited = new HashSet();
        path.offer(1.0);
        frontier.offer(toCalculate.getBase());

        while(!frontier.isEmpty()){
            String currVal =frontier.poll();
            if(visited.contains(currVal))
                continue;
            visited.add(currVal);
            double currPathNum = path.poll();

            if(pairGraph.getGraph().containsKey(currVal)){
                Map<String,Double> quoteRate = pairGraph.get(currVal);
                for(String s: quoteRate.keySet()){
                    if(!visited.contains(s)){
                        frontier.offer(s);
                        if(s.equals(toCalculate.getQuote()))
                            return currPathNum*quoteRate.get(s);
                        path.offer(currPathNum*quoteRate.get(s));
                    }
                }
            }
        }
        return CANNOT_BE_CALCULATED;
    }

    public void getFormattedRate(){
        double rate = this.calculateRate();
        String currencyPair =toCalculate.getBase()+toCalculate.getQuote();
        if(rate==CANNOT_BE_CALCULATED){
            System.out.println("Unable to determine rate for "+currencyPair);
            return;
        }

        System.out.println(currencyPair+":"+String.format("%.2f",rate));
    }
}
