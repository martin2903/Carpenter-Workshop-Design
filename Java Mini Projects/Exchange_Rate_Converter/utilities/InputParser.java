package Exchange_Rate_Converter.utilities;

import Exchange_Rate_Converter.datastructures.Pair;

public class InputParser {
    private Pair pairToCalculate;
    private Pair[] givenPairs;

    public InputParser(String input){
        this.pairToCalculate = parsePairToCalculate(input);
        this.givenPairs = parsePairs(input);
    }

    public static Pair parsePairToCalculate(String input){
        Pair toCalculate = new Pair();
        String [] pair = input.split("\\|");
        toCalculate.setBase(pair[1].substring(0,3));
        toCalculate.setQuote(pair[1].substring(3,6));
        return toCalculate;
    }

    public static Pair[] parsePairs(String input){
        String[] pairs = input.split("\\|")[0].split("\\;");
        Pair[] parsedPairs = new Pair[pairs.length];

        for(int i=0;i<pairs.length;i++){
            parsedPairs[i]=processPair(pairs[i]);
        }

        return parsedPairs;
    }

    public static Pair processPair(String pair){
        Pair pairToAdd = new Pair();
        String[] pairRate= pair.split("\\:");
        pairToAdd.setBase(pairRate[0].substring(0,3));
        pairToAdd.setQuote(pairRate[0].substring(3,6));
        pairToAdd.setRate(Double.parseDouble(pairRate[1]));

        return pairToAdd;
    }

    public Pair[] getGivenPairs(){
        return this.givenPairs;
    }

    public Pair getPairToCalculate(){
        return this.pairToCalculate;
    }
}
