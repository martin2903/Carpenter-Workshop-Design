package exchange_rate_converter;

import exchange_rate_converter.datastructures.PairGraph;

public class Test {
    public static void main(String[] args) {
        String quote = "EURUSD:1.20;USDGBP:0.78;JPYGBP:0.0064|USDJPY";
        PairGraph graph = new PairGraph(new InputParser(quote));
        RateCalculator rateCalc = new RateCalculator(graph,new InputParser(quote));
        rateCalc.getFormattedRate();
    }
}
