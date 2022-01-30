package exchange_rate_converter.datastructures;
import exchange_rate_converter.InputParser;
import java.util.HashMap;
import java.util.Map;

public class PairGraph {
    private Map<String, Map<String,Double>> graph;

    public PairGraph(InputParser parser){
        graph = buildGraph(parser);
    }

    public Map<String, Map<String,Double>> buildGraph(InputParser parser){
        Map<String,Map<String,Double>> graph = new HashMap();
        for(Pair pair:parser.getGivenPairs()){
            if(!graph.containsKey(pair.getBase()))
                graph.put(pair.getBase(),new HashMap());
            graph.get(pair.getBase()).put(pair.getQuote(),pair.getRate());
            if(!graph.containsKey(pair.getQuote()))
                graph.put(pair.getQuote(),new HashMap());
            graph.get(pair.getQuote()).put(pair.getBase(),1.0/pair.getRate());
        }
        return graph;
    }

    public Map<String, Map<String,Double>> getGraph(){
        return this.graph;
    }

    public boolean contains(String base){
        return this.getGraph().containsKey(base);
    }

    public Map<String,Double> get(String key){
        return this.getGraph().get(key);
    }
}
