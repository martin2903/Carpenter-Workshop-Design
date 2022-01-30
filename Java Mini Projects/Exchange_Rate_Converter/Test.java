package Exchange_Rate_Converter;

import Exchange_Rate_Converter.datastructures.PairGraph;
import Exchange_Rate_Converter.utilities.InputParser;
import Exchange_Rate_Converter.utilities.RateCalculator;

public class Test {
    public static void main(String[] args) {
        String quote = "EURUSD:1.20;USDGBP:0.78;JPYGBP:0.0064|USDJPY";
        PairGraph graph = new PairGraph(new InputParser(quote));
        RateCalculator rateCalc = new RateCalculator(graph,new InputParser(quote));
        rateCalc.getFormattedRate();
    }
}
